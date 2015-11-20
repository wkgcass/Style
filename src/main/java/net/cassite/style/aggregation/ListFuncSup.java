package net.cassite.style.aggregation;

import java.util.List;
import java.util.ListIterator;

import net.cassite.style.interfaces.*;
import net.cassite.style.$;
import net.cassite.style.StyleRuntimeException;
import net.cassite.style.def;
import net.cassite.style.control.*;

import static net.cassite.style.Core.*;
import static net.cassite.style.aggregation.Aggregation.*;

/**
 * Supporter of lists
 * 
 * @author wkgcass
 *
 * @param <T>
 *                element type of the collection
 */
public class ListFuncSup<T> extends CollectionFuncSup<T> {
        ListFuncSup(List<T> collection) {
                super(collection);
        }

        /**
         * change elements in the list
         * 
         * @param func
         *                function takes in each element in the list and returns
         *                an element to replace current element
         */
        public void toSelf(RFunc1<T, T> func) {
                toSelf($(func));
        }

        /**
         * change elements in the list
         * 
         * @param func
         *                function returns an element to replace current element
         */
        public void toSelf(def<T> func) {
                $((List<T>) iterable).forEach(e -> {
                        return Set(func.apply(e));
                });
        }

        /**
         * define a function to deal with each element in the list with given
         * start index
         * 
         * @param func
         *                a function takes in each element from list
         * @param index
         *                the index where to start iteration
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         */
        @SuppressWarnings("unchecked")
        public <R> R forEach(VFunc1<T> func, int index) {
                return (R) forEach($(func), index);
        }

        /**
         * define a function to deal with each element in the list with given
         * start index
         * 
         * @param func
         *                a function takes in each element from list and
         *                iterator info
         * @param index
         *                the index where to start iteration
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         * @see IteratorInfo
         */
        @SuppressWarnings("unchecked")
        public <R> R forEach(VFunc2<T, IteratorInfo<R>> func, int index) {
                return (R) forEach($(func), index);
        }

        /**
         * define a function to deal with each element in the list with given
         * start index
         * 
         * @param func
         *                a function takes in each element from list and returns
         *                last loop value
         * @param index
         *                the index where to start iteration
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         */
        public <R> R forEach(RFunc1<R, T> func, int index) {
                return forEach($(func), index);
        }

        /**
         * define a function to deal with each element in the list with given
         * start index
         * 
         * @param func
         *                a function takes in each element from list and
         *                iterator info<br>
         *                and returns last loop value
         * @param index
         *                the index where to start iteration
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         * @see IteratorInfo
         */
        public <R> R forEach(RFunc2<R, T, IteratorInfo<R>> func, int index) {
                return forEach($(func), index);
        }

        /**
         * define a function to deal with each element in the list with given
         * start index
         * 
         * @param func
         *                a function returns 'last loop value'
         * @param index
         *                the index where to start iteration
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         */
        public <R> R forEach(def<R> func, int index) {
                return forThose($.alwaysTrue(), func, index);
        }

        /**
         * define a function to deal with each element in the list with given
         * start index
         * 
         * @param predicate
         *                a function takes in each element from list and returns
         *                true or false(or null)
         * @param func
         *                a function takes in each element from list
         * @param index
         *                the index where to start iteration
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         */
        @SuppressWarnings("unchecked")
        public <R> R forThose(RFunc1<Boolean, T> predicate, VFunc1<T> func, int index) {
                return (R) forThose(predicate, $(func), index);
        }

        /**
         * define a function to deal with each element in the list with given
         * start index
         * 
         * @param predicate
         *                a function takes in each element from list and returns
         *                true or false(or null)
         * @param func
         *                a function takes in each element from list and
         *                iterator info
         * @param index
         *                the index where to start iteration
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         * @see IteratorInfo
         */
        @SuppressWarnings("unchecked")
        public <R> R forThose(RFunc1<Boolean, T> predicate, VFunc2<T, IteratorInfo<R>> func, int index) {
                return (R) forThose(predicate, $(func), index);
        }

        /**
         * define a function to deal with each element in the list with given
         * start index
         * 
         * @param predicate
         *                a function takes in each element from list and returns
         *                true or false(or null)
         * @param func
         *                a function takes in each element from list and returns
         *                'last loop result'
         * @param index
         *                the index where to start iteration
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         */
        public <R> R forThose(RFunc1<Boolean, T> predicate, RFunc1<R, T> func, int index) {
                return (R) forThose(predicate, $(func), index);
        }

        /**
         * define a function to deal with each element in the list with given
         * start index
         * 
         * @param predicate
         *                a function takes in each element from list and returns
         *                true or false(or null)
         * @param func
         *                a function takes in each element from list and
         *                iterator info<br>
         *                and returns 'last loop result'
         * @param index
         *                the index where to start iteration
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         * @see IteratorInfo
         */
        public <R> R forThose(RFunc1<Boolean, T> predicate, RFunc2<R, T, IteratorInfo<R>> func, int index) {
                return forThose(predicate, $(func), index);
        }

        @Override
        public <R> R forThose(RFunc1<Boolean, T> predicate, def<R> func) {
                return forThose(predicate, func, 0);
        }

        /**
         * define a function to deal with each element in the list with given
         * start index
         * 
         * @param predicate
         *                a function takes in each element from list and returns
         *                true or false(or null)
         * @param func
         *                a function returns 'last loop result'
         * @param index
         *                the index where to start iteration
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         */
        public <R> R forThose(RFunc1<Boolean, T> predicate, def<R> func, int index) {
                ListIterator<T> it = ((List<T>) iterable).listIterator(index);
                IteratorInfo<R> info = new IteratorInfo<>();
                return While(it::hasNext, (loopInfo) -> {
                        int previousIndex = it.previousIndex();
                        int nextIndex = it.nextIndex();
                        boolean hasPrevious = it.hasPrevious();
                        boolean hasNext = it.hasNext();
                        T t = it.next();
                        try {
                                return If(predicate.apply(t), () -> {
                                        return func.apply(t, info.setValues(previousIndex, nextIndex, hasPrevious, hasNext, loopInfo.currentIndex,
                                                        loopInfo.effectiveIndex, loopInfo.lastRes));
                                }).Else(() -> null);
                        } catch (Throwable err) {
                                StyleRuntimeException sErr = $(err);
                                Throwable throwable = sErr.origin();
                                if (throwable instanceof Add) {
                                        it.add(((Add) throwable).getAdd());
                                } else if (throwable instanceof $Set) {
                                        it.set((($Set) throwable).getSet());
                                } else if (throwable instanceof Remove) {
                                        it.remove();
                                } else {
                                        throw sErr;
                                }
                        }
                        return null;
                });
        }
}