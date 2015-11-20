package net.cassite.style.aggregation;

import java.util.Collection;
import java.util.Iterator;

import net.cassite.style.StyleRuntimeException;
import net.cassite.style.def;
import net.cassite.style.ptr;
import net.cassite.style.control.*;
import net.cassite.style.interfaces.RFunc1;

import static net.cassite.style.Style.*;
import static net.cassite.style.aggregation.Aggregation.*;

/**
 * Supporter of iterables
 *
 * @param <T> element type of the iterable
 * @author wkgcass
 */
public class IterableFuncSup<T> implements A1FuncSup<T> {
        protected final Iterable<T> iterable;

        IterableFuncSup(Iterable<T> iterable) {
                this.iterable = iterable;
        }

        public <R> R forThose(RFunc1<Boolean, T> predicate, def<R> func) {
                Iterator<T> it = iterable.iterator();
                ptr<Integer> i = ptr(0);
                IteratorInfo<R> info = new IteratorInfo<>();
                return While(it::hasNext, (loopInfo) -> {
                        T t = it.next();
                        try {
                                return If(predicate.apply(t), () -> {
                                        return func.apply(t, info.setValues(i.item - 1, i.item + 1, i.item == 0, it.hasNext(), loopInfo.currentIndex,
                                                loopInfo.effectiveIndex, loopInfo.lastRes));
                                }).Else(() -> null);
                        } catch (Throwable err) {
                                StyleRuntimeException sErr = $(err);
                                Throwable throwable = sErr.origin();
                                if (throwable instanceof Remove) {
                                        it.remove();
                                } else {
                                        throw sErr;
                                }
                        } finally {
                                i.item += 1;
                        }
                        return null;
                });
        }

        @Override
        public T first() {
                return iterable.iterator().next();
        }

        public <R, Coll extends Collection<R>> Transformer<R, T, Coll> to(Coll collection) {
                return new Transformer<>(iterable, collection);
        }

        /**
         * Transformer which transforms an iterable into a collection
         *
         * @param <R>    element type of collection to transform to
         * @param <T>    element type of the iterable
         * @param <Coll> collection
         * @author wkgcass
         */
        public static class Transformer<R, T, Coll extends Collection<R>> implements A1Transformer<R, T, Coll> {
                protected final Coll collection;
                protected final Iterable<T> iterable;

                Transformer(Iterable<T> iterable, Coll collection) {
                        this.iterable = iterable;
                        this.collection = collection;
                }

                @Override
                public Coll via(def<R> method) {
                        $(iterable).forEach(e -> {
                                collection.add(method.apply(e));
                        });
                        return collection;
                }
        }

        @Override
        public <Coll extends Collection<T>> Coll findAll(def<Boolean> filter, Coll toColl, int limit) {
                return $(iterable).to(toColl).via(e -> {
                        Boolean ret = filter.apply(e);
                        if (null == ret || ret.equals(false))
                                Continue();
                        if (limit > 0 && limit <= toColl.size()) {
                                Break();
                        }
                        return e;
                });
        }

        /**
         * Interface of classes to transform an iterable object into another
         * array
         *
         * @param <R> returned array type
         * @param <T> input iterable type
         * @author wkgcass
         */
        public static class ArrTransformer<R, T> implements A1ArrTransformer<R, T> {
                protected final R[] retArr;
                protected final Iterable<T> iterable;

                ArrTransformer(Iterable<T> iterable, R[] retArr) {
                        this.iterable = iterable;
                        this.retArr = retArr;
                }

                @Override
                public R[] via(def<R> method) {
                        $(iterable).forEach((e, i) -> {
                                if (retArr.length == i.effectiveIndex) {
                                        Break();
                                } else {
                                        retArr[i.effectiveIndex] = method.apply(e);
                                }
                        });
                        return retArr;
                }
        }

        @Override
        public <R> A1ArrTransformer<R, T> to(R[] arr) {
                return new ArrTransformer<>(iterable, arr);
        }

        @Override
        public int size() {
                return forEach((e, i) -> i.currentIndex);
        }
}