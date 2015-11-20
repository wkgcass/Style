package net.cassite.style.aggregation;

import java.util.ArrayList;
import java.util.Collection;

import net.cassite.style.$;
import net.cassite.style.def;

import static net.cassite.style.Core.*;
import static net.cassite.style.aggregation.Aggregation.*;

import net.cassite.style.interfaces.RFunc1;
import net.cassite.style.interfaces.RFunc2;
import net.cassite.style.interfaces.VFunc1;
import net.cassite.style.interfaces.VFunc2;

/**
 * Supporter of arrays and iterables
 *
 * @param <T> element type of the array or iterable
 * @author wkgcass
 */
public interface A1FuncSup<T> {
        /**
         * define a function to deal with each element in the array/iterable
         *
         * @param func a function takes in each element from array/iterable
         * @return return 'last loop value'.<br>
         * check
         * <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         * more info about 'last loop value'
         */
        @SuppressWarnings("unchecked")
        default <R> R forEach(VFunc1<T> func) {
                return (R) forEach($(func));
        }

        /**
         * define a function to deal with each element in the array/iterable
         *
         * @param func a function takes in each element from array/iterable
         *             and iterator info
         * @return return 'last loop value'.<br>
         * check
         * <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         * more info about 'last loop value'
         * @see IteratorInfo
         */
        @SuppressWarnings("unchecked")
        default <R> R forEach(VFunc2<T, IteratorInfo<R>> func) {
                return (R) forEach($(func));
        }

        /**
         * define a function to deal with each element in the array/iterable
         *
         * @param func a function takes in each element from array/iterable
         *             <br>
         *             and returns 'last loop value'
         * @return return 'last loop value'.<br>
         * check
         * <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         * more info about 'last loop value'
         */
        default <R> R forEach(RFunc1<R, T> func) {
                return forEach($(func));
        }

        /**
         * define a function to deal with each element in the array/iterable
         *
         * @param func a function takes in each element from array/iterable
         *             and iterator info<br>
         *             and returns 'last loop value'
         * @return return 'last loop value'.<br>
         * check
         * <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         * more info about 'last loop value'
         * @see IteratorInfo
         */
        default <R> R forEach(RFunc2<R, T, IteratorInfo<R>> func) {
                return forEach($(func));
        }

        /**
         * define a function to deal with each element in the array/iterable
         *
         * @param func a function returns 'last loop value'
         * @return return 'last loop value'.<br>
         * check
         * <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         * more info about 'last loop value'
         */
        default <R> R forEach(def<R> func) {
                return forThose($.alwaysTrue(), func);
        }

        /**
         * define a function to deal with each element in the array/iterable
         *
         * @param predicate a function takes in each element from array/iterable
         *                  and returns true or false(or null)
         * @param func      a function takes in each element from array/iterable
         * @return return 'last loop value'.<br>
         * check
         * <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         * more info about 'last loop value'
         */
        @SuppressWarnings("unchecked")
        default <R> R forThose(RFunc1<Boolean, T> predicate, VFunc1<T> func) {
                return (R) forThose(predicate, $(func));
        }

        /**
         * define a function to deal with each element in the array/iterable
         *
         * @param predicate a function takes in each element from array/iterable
         *                  and returns true or false(or null)
         * @param func      a function takes in each element from array/iterable
         *                  and iterator info
         * @return return 'last loop value'.<br>
         * check
         * <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         * more info about 'last loop value'
         * @see IteratorInfo
         */
        @SuppressWarnings("unchecked")
        default <R> R forThose(RFunc1<Boolean, T> predicate, VFunc2<T, IteratorInfo<R>> func) {
                return (R) forThose(predicate, $(func));
        }

        /**
         * define a function to deal with each element in the array/iterable
         *
         * @param predicate a function takes in each element from array/iterable
         *                  and iterator info and returns true or false(or null)
         * @param func      a function takes in each element from array/iterable
         *                  <br>
         *                  and returns 'last loop result'
         * @return return 'last loop value'.<br>
         * check
         * <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         * more info about 'last loop value'
         */
        default <R> R forThose(RFunc1<Boolean, T> predicate, RFunc1<R, T> func) {
                return forThose(predicate, $(func));
        }

        /**
         * define a function to deal with each element in the array/iterable
         *
         * @param predicate a function takes in each element from array/iterable
         *                  and returns true or false(or null)
         * @param func      a function takes in each element from array/iterable
         *                  and iterator info<br>
         *                  and returns 'last loop info'
         * @return return 'last loop value'.<br>
         * check
         * <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         * more info about 'last loop value'
         * @see IteratorInfo
         */
        default <R> R forThose(RFunc1<Boolean, T> predicate, RFunc2<R, T, IteratorInfo<R>> func) {
                return forThose(predicate, $(func));
        }

        /**
         * define a function to deal with each element in the array/iterable
         *
         * @param predicate a function takes in each element from array/iterable
         *                  and returns true or false(or null)
         * @param func      a function returns 'last loop info'
         * @return return 'last loop value'.<br>
         * check
         * <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         * more info about 'last loop value'
         * @see IteratorInfo
         */
        <R> R forThose(RFunc1<Boolean, T> predicate, def<R> func);

        /**
         * Return first element in the array/iterable or null if not found
         *
         * @return
         */
        T first();

        /**
         * find the first matched element
         *
         * @param filter matching function,<br>
         *               which takes in each element in array/iterable and
         *               returns true/false/null
         * @return first matched element
         */
        default T findOne(RFunc1<Boolean, T> filter) {
                return findOne($(filter));
        }

        /**
         * find the first matched element
         *
         * @param filter matching function,<br>
         *               which returns true/false/null
         * @return first matched element
         */
        default T findOne(def<Boolean> filter) {
                return $(findAll(filter, new ArrayList<>(1), 1)).first();
        }

        /**
         * find all matched elements
         *
         * @param filter matching function,<br>
         *               which takes in each element in array/iterable and
         *               returns true/false/null
         * @return all matched elements in an ArrayList
         */
        default Collection<T> findAll(RFunc1<Boolean, T> filter) {
                return findAll($(filter));
        }

        /**
         * find all matched elements
         *
         * @param filter matching function,<br>
         *               which returns true/false/null
         * @return all matched elements in an ArrayList
         */
        default Collection<T> findAll(def<Boolean> filter) {
                return findAll(filter, new ArrayList<>());
        }

        /**
         * add all matched elements into given collection
         *
         * @param filter matching function,<br>
         *               which takes in each element in array/iterable and
         *               returns true/false/null
         * @param toColl the collection to add elements in
         * @return add all matched elements into given collection
         */
        default <Coll extends Collection<T>> Coll findAll(RFunc1<Boolean, T> filter, Coll toColl) {
                return findAll($(filter), toColl);
        }

        /**
         * add all matched elements into given collection
         *
         * @param filter matching function,<br>
         *               which returns true/false/null
         * @param toColl the collection to add elements in
         * @return add all matched elements into given collection
         */
        default <Coll extends Collection<T>> Coll findAll(def<Boolean> filter, Coll toColl) {
                return findAll(filter, toColl, 0);
        }

        /**
         * add limited number of matched elements into given collection
         *
         * @param filter matching function,<br>
         *               which takes in each element in array/iterable and
         *               returns true/false/null
         * @param toColl the collection to add elements in
         * @param limit  add $limit elements at most, any value littler or
         *               equal than 0 means no limit
         * @return add all matched elements into given collection
         */
        default <Coll extends Collection<T>> Coll findAll(RFunc1<Boolean, T> filter, Coll toColl, int limit) {
                return findAll($(filter), toColl, limit);
        }

        /**
         * add limited number of matched elements into given collection
         *
         * @param filter matching function,<br>
         *               which returns true/false/null
         * @param toColl the collection to add elements in
         * @param limit  add $limit elements at most, any value littler or
         *               equal than 0 means no limit
         * @return add all matched elements into given collection
         */
        <Coll extends Collection<T>> Coll findAll(def<Boolean> filter, Coll toColl, int limit);

        /**
         * Entrance of transformer
         *
         * @param collection the collection to support
         * @return new A1Transformer
         * @see A1Transformer
         */
        <R, Coll extends Collection<R>> A1Transformer<R, T, Coll> to(Coll collection);

        /**
         * Entrance of transformer
         *
         * @param arr the array to support
         * @return new A1Transformer
         * @see A1ArrTransformer
         */
        <R> A1ArrTransformer<R, T> to(R[] arr);

        /**
         * @return number of elements in the array/iterable
         */
        int size();
}
