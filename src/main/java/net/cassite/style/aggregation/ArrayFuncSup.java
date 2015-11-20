package net.cassite.style.aggregation;

import net.cassite.style.$;
import net.cassite.style.def;
import net.cassite.style.interfaces.*;

import static net.cassite.style.Core.*;
import static net.cassite.style.aggregation.Aggregation.*;

import java.util.Collection;

/**
 * Supporter of arrays
 *
 * @param <T> element type of the array
 * @author wkgcass
 */
public class ArrayFuncSup<T> implements A1FuncSup<T> {
        private final T[] array;

        ArrayFuncSup(T[] array) {
                this.array = array;
        }

        public <R> R forEach(RFunc1<R, T> func) {
                return forEach($(func));
        }

        public <R> R forEach(RFunc2<R, T, IteratorInfo<R>> func) {
                return forEach($(func));
        }

        @SuppressWarnings("unchecked")
        public <R> R forEach(VFunc1<T> func) {
                return forEach((def<R>) $(func));
        }

        @SuppressWarnings("unchecked")
        public <R> R forEach(VFunc2<T, IteratorInfo<R>> func) {
                return forEach((def<R>) $(func));
        }

        public <R> R forEach(def<R> func) {
                return forThose($.alwaysTrue(), func);
        }

        /**
         * change elements in the array
         *
         * @param func function takes in each element in the array and
         *             returns an element to replace current element
         */
        public void toSelf(RFunc1<T, T> func) {
                toSelf($(func));
        }

        /**
         * change elements in the array
         *
         * @param func function returns an element to replace current element
         */
        public void toSelf(def<T> func) {
                $(array).forEach((e, i) -> {
                        array[$(i)] = func.apply(e);
                });
        }

        public <R> R forThose(RFunc1<Boolean, T> predicate, RFunc1<R, T> func) {
                return forThose(predicate, $(func));
        }

        public <R> R forThose(RFunc1<Boolean, T> predicate, RFunc2<R, T, IteratorInfo<R>> func) {
                return forThose(predicate, $(func));
        }

        @SuppressWarnings("unchecked")
        public <R> R forThose(RFunc1<Boolean, T> predicate, VFunc1<T> func) {
                return (R) forThose(predicate, $(func));
        }

        @SuppressWarnings("unchecked")
        public <R> R forThose(RFunc1<Boolean, T> predicate, VFunc2<T, IteratorInfo<R>> func) {
                return (R) forThose(predicate, $(func));
        }

        public <R> R forThose(RFunc1<Boolean, T> predicate, def<R> func) {
                if (array.length == 0)
                        return null;
                IteratorInfo<R> info = new IteratorInfo<R>();
                return For(0).to(array.length - 1).loop((i, loopInfo) -> {
                        return If(predicate.apply(array[i]), () -> {
                                return func.apply(array[i], info.setValues(i - 1, i + 1, i != 0, i != array.length - 1, loopInfo.currentIndex,
                                        loopInfo.effectiveIndex, loopInfo.lastRes));
                        }).Else(() -> null);
                });
        }

        public T first() {
                return array[0];
        }

        public <R, Coll extends Collection<R>> Transformer<R, T, Coll> to(Coll collection) {
                return new Transformer<>(array, collection);
        }

        /**
         * Transformer which transforms the array into a collection
         *
         * @param <R>    element type of collection to transform to
         * @param <T>    element type of the array
         * @param <Coll> collection
         * @author wkgcass
         * @see A1Transformer
         */
        public static class Transformer<R, T, Coll extends Collection<R>> implements A1Transformer<R, T, Coll> {
                private final Coll collection;
                private final T[] array;

                Transformer(T[] array, Coll collection) {
                        this.array = array;
                        this.collection = collection;
                }

                public Coll via(def<R> method) {
                        $(array).forEach(e -> {
                                collection.add(method.apply(e));
                        });
                        return collection;
                }
        }

        public <Coll extends Collection<T>> Coll findAll(def<Boolean> filter, Coll toColl, int limit) {
                return $(array).to(toColl).via(e -> {
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
         * Interface of classes to transform the array into another array
         *
         * @param <R> returned array type
         * @param <T> input array type
         * @author wkgcass
         */
        public static class ArrTransformer<R, T> implements A1ArrTransformer<R, T> {
                private final R[] retArr;
                private final T[] array;

                ArrTransformer(T[] array, R[] retArr) {
                        this.array = array;
                        this.retArr = retArr;
                }

                public R[] via(def<R> method) {
                        $(array).forEach((e, i) -> {
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
        public <R> ArrTransformer<R, T> to(R[] arr) {
                return new ArrTransformer<R, T>(array, arr);
        }

        @Override
        public int size() {
                return array.length;
        }
}