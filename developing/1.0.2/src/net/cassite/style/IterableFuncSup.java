package net.cassite.style;

import java.util.Collection;
import java.util.Iterator;

import net.cassite.style.control.*;
import net.cassite.style.interfaces.RFunc1;

/**
 * Supporter of iterables
 * 
 * @author wkgcass
 *
 * @param <T>
 *                element type of the iterable
 */
public class IterableFuncSup<T> implements A1FuncSup<T> {
        protected final Iterable<T> iterable;

        IterableFuncSup(Iterable<T> iterable) {
                this.iterable = iterable;
        }

        public <R> R forThose(RFunc1<Boolean, T> predicate, def<R> func) {
                Iterator<T> it = iterable.iterator();
                ptr<Integer> i = ptr(0);
                IteratorInfo<R> info = new IteratorInfo<R>();
                return While(() -> it.hasNext(), (loopInfo) -> {
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
                return new ArrTransformer<R, T>(iterable, arr);
        }

        @Override
        public int size() {
                return forEach((e, i) -> {
                        return i.currentIndex;
                });
        }
}