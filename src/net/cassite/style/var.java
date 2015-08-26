package net.cassite.style;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import net.cassite.style.control.Break;
import net.cassite.style.control.Continue;
import net.cassite.style.control.Remove;
import net.cassite.style.interfaces.*;
import net.cassite.style.reflect.ClassSup;
import net.cassite.style.reflect.ProxyHandler;

/**
 * All functions in <b>Style tool box</b> are provided both in <b>Style</b> and
 * here.<br/>
 * They are excatly the same.<br/>
 * However sometimes you may not able to <code>extends Style</code>, then try
 * <code>implements var</code> to get full support.<br/>
 * But in this way, you are still not able to invoke methods directly from
 * static methods.<br/>
 * Anyway <code>implements var</code> still works in most cases.<br/>
 * Also you may write code like this:
 * 
 * <pre>
 *  class X implements var{...}
 *  var x=new X();
 * </pre>
 * 
 * @author wkgcass
 *
 */
public interface var {

        // ┌─────────────────────────────────┐
        // │............function.............│
        // └─────────────────────────────────┘

        // void functions

        /**
         * define a function with 0 input and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 0 input and void output
         */
        default def<Object> function(VFunc0 body) {
                return Style.function(body);
        }

        /**
         * define a function with 1 input and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 1 input and void output
         */
        default def<Object> function(VFunc1<?> body) {
                return Style.function(body);
        }

        /**
         * define a function with 2 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 2 inputs and void output
         */
        default def<Object> function(VFunc2<?, ?> body) {
                return Style.function(body);
        }

        /**
         * define a function with 3 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 3 inputs and void output
         */
        default def<Object> function(VFunc3<?, ?, ?> body) {
                return Style.function(body);
        }

        /**
         * define a function with 4 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 4 inputs and void output
         */
        default def<Object> function(VFunc4<?, ?, ?, ?> body) {
                return Style.function(body);
        }

        /**
         * define a function with 5 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 5 inputs and void output
         */
        default def<Object> function(VFunc5<?, ?, ?, ?, ?> body) {
                return Style.function(body);
        }

        /**
         * define a function with 6 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 6 inputs and void output
         */
        default def<Object> function(VFunc6<?, ?, ?, ?, ?, ?> body) {
                return Style.function(body);
        }

        /**
         * define a function with 7 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 7 inputs and void output
         */
        default def<Object> function(VFunc7<?, ?, ?, ?, ?, ?, ?> body) {
                return Style.function(body);
        }

        // functions with return value

        /**
         * define a function with 0 input and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 0 input and an output
         */
        default <R> def<R> function(RFunc0<R> body) {
                return Style.function(body);
        }

        /**
         * define a function with 1 input and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 1 input and an output
         */
        default <R> def<R> function(RFunc1<R, ?> body) {
                return Style.function(body);
        }

        /**
         * define a function with 2 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 2 inputs and an output
         */
        default <R> def<R> function(RFunc2<R, ?, ?> body) {
                return Style.function(body);
        }

        /**
         * define a function with 3 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 3 inputs and an output
         */
        default <R> def<R> function(RFunc3<R, ?, ?, ?> body) {
                return Style.function(body);
        }

        /**
         * define a function with 4 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 4 inputs and an output
         */
        default <R> def<R> function(RFunc4<R, ?, ?, ?, ?> body) {
                return Style.function(body);
        }

        /**
         * define a function with 5 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 5 inputs and an output
         */
        default <R> def<R> function(RFunc5<R, ?, ?, ?, ?, ?> body) {
                return Style.function(body);
        }

        /**
         * define a function with 6 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 6 inputs and an output
         */
        default <R> def<R> function(RFunc6<R, ?, ?, ?, ?, ?, ?> body) {
                return Style.function(body);
        }

        /**
         * define a function with 7 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 7 inputs and an output
         */
        default <R> def<R> function(RFunc7<R, ?, ?, ?, ?, ?, ?, ?> body) {
                return Style.function(body);
        }

        // void functions

        /**
         * define a function with 0 input and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 0 input and void output
         */
        default def<Object> $(VFunc0 body) {
                return Style.$(body);
        }

        /**
         * define a function with 1 input and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 1 input and void output
         */
        default def<Object> $(VFunc1<?> body) {
                return Style.$(body);
        }

        /**
         * define a function with 2 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 2 inputs and void output
         */
        default def<Object> $(VFunc2<?, ?> body) {
                return Style.$(body);
        }

        /**
         * define a function with 3 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 3 inputs and void output
         */
        default def<Object> $(VFunc3<?, ?, ?> body) {
                return Style.$(body);
        }

        /**
         * define a function with 4 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 4 inputs and void output
         */
        default def<Object> $(VFunc4<?, ?, ?, ?> body) {
                return Style.$(body);
        }

        /**
         * define a function with 5 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 5 inputs and void output
         */
        default def<Object> $(VFunc5<?, ?, ?, ?, ?> body) {
                return Style.$(body);
        }

        /**
         * define a function with 6 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 6 inputs and void output
         */
        default def<Object> $(VFunc6<?, ?, ?, ?, ?, ?> body) {
                return Style.$(body);
        }

        /**
         * define a function with 7 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 7 inputs and void output
         */
        default def<Object> $(VFunc7<?, ?, ?, ?, ?, ?, ?> body) {
                return Style.$(body);
        }

        // functions with return value

        /**
         * define a function with 0 input and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 0 input and an output
         */
        default <R> def<R> $(RFunc0<R> body) {
                return Style.$(body);
        }

        /**
         * define a function with 1 input and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 1 input and an output
         */
        default <R> def<R> $(RFunc1<R, ?> body) {
                return Style.$(body);
        }

        /**
         * define a function with 2 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 2 inputs and an output
         */
        default <R> def<R> $(RFunc2<R, ?, ?> body) {
                return Style.$(body);
        }

        /**
         * define a function with 3 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 3 inputs and an output
         */
        default <R> def<R> $(RFunc3<R, ?, ?, ?> body) {
                return Style.$(body);
        }

        /**
         * define a function with 4 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 4 inputs and an output
         */
        default <R> def<R> $(RFunc4<R, ?, ?, ?, ?> body) {
                return Style.$(body);
        }

        /**
         * define a function with 5 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 5 inputs and an output
         */
        default <R> def<R> $(RFunc5<R, ?, ?, ?, ?, ?> body) {
                return Style.$(body);
        }

        /**
         * define a function with 6 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 6 inputs and an output
         */
        default <R> def<R> $(RFunc6<R, ?, ?, ?, ?, ?, ?> body) {
                return Style.$(body);
        }

        /**
         * define a function with 7 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 7 inputs and an output
         */
        default <R> def<R> $(RFunc7<R, ?, ?, ?, ?, ?, ?, ?> body) {
                return Style.$(body);
        }

        // function support

        /**
         * generate a pointer pointed to given object<br/>
         * A <b>pointer</b> here means a container contains an object with
         * initial type<br/>
         * Type of the pointer is guaranteed by Generic System.<br/>
         * You can access it's contained value using <b>ptr.item</b>, <br/>
         * Or using {@link #$(ptr)} and {@link #$(ptr, Object)}.
         * 
         * @param o
         *                the object to be pointed to
         * @return a new pointer points to given object
         */
        default <T> ptr<T> ptr(T o) {
                return Style.ptr(o);
        }

        /**
         * Retrieve pointed value from a pointer.
         * 
         * @param store
         *                a pointer created using {@link #ptr(Object)}
         * @return pointed value
         */
        default <T> T $(ptr<T> store) {
                return Style.$(store);
        }

        /**
         * Change pointed value of a pointer.
         * 
         * @param ptr
         *                a pointer created using {@link #ptr(Object)}
         * @param newItem
         * @return
         */
        default <T> ptr<T> $(ptr<T> ptr, T newItem) {
                return Style.$(ptr, newItem);
        }

        // ┌─────────────────────────────────┐
        // │...........async&await...........│
        // └─────────────────────────────────┘

        /**
         * Join async objects for further usage.
         * 
         * @param asyncs
         *                Async objects to be joined.
         * @return a group of async objects
         */
        default AsyncGroup $(Async<?>... asyncs) {
                return Style.$(asyncs);
        }

        /**
         * Join async objects for further usage and attach each of them with
         * given exception handler.<br/>
         * see {@link Async#onError(def)}, {@link Async#awaitError(def)} for
         * more info about exception handling.
         * 
         * @param handler
         *                exception handler attached to every one of these async
         *                objects
         * @param asyncs
         *                Async objects to be joined.
         * @return a group of async objects with exception handler
         * 
         * @see Async#onError(def)
         * @see Async#awaitError(def)
         */
        default AsyncGroup $(def<Object> handler, Async<?>... asyncs) {
                return Style.$(handler, asyncs);
        }

        /**
         * Join async objects for further usage and attach each of them with
         * given exception handler.<br/>
         * see {@link Async#onError(def)}, {@link Async#awaitError(def)} for
         * more info about exception handling.<br/>
         * <br/>
         * This method simply invoke {@link #$(def, Async...)} with $(handler)
         * 
         * @param handler
         *                exception handler attached to every one of these async
         *                objects
         * @param asyncs
         *                Async objects to be joined.
         * @return a group of async objects with exception handler
         * 
         * @see Async#onError(def)
         * @see Async#awaitError(def)
         * @see #$(def, Async...)
         * @see #$(VFunc1)
         */
        default AsyncGroup $(VFunc1<StyleRuntimeException> handler, Async<?>... asyncs) {
                return Style.$(handler, asyncs);
        }

        /**
         * Block current thread and wait for a Async call to return its value.
         * <br/>
         * This method simply invokes {@link Async#await()}
         * 
         * @param async
         *                The Async object representing an async call.
         * @return return value from Async call. If an exception occurred, null
         *         would be returned.
         * @see Async#await()
         */
        default <R> R await(Async<R> async) {
                return Style.await(async);
        }

        /**
         * Create a new thread and invoke start on it.
         * 
         * @param runnable
         *                function run on the new thread
         * @return created thread
         * 
         * @see #run(def)
         */
        default Thread run(VFunc0 runnable) {
                return Style.run(runnable);
        }

        /**
         * Create a new thread and invoke start on it.
         * 
         * @param runnable
         *                function run on the new thread
         * @return created thread
         */
        default Thread run(def<Object> toRun) {
                return Style.run(toRun);
        }

        /**
         * Make current thread sleep for designated milliseconds
         * 
         * @param millis
         *                milliseconds to sleep
         */
        default void sleep(long millis) {
                Style.sleep(millis);
        }

        // ┌─────────────────────────────────┐
        // │........iteration control........│
        // └─────────────────────────────────┘

        /**
         * Break a loop
         * 
         * @return
         * @throws Break
         */
        default <T> T Break() throws Break {
                return Style.Break();
        }

        /**
         * Remove an object from current iterator.<br/>
         * Only works for loops on Iterators and Maps
         * 
         * @return
         * @throws Remove
         */
        default <T> T Remove() throws Remove {
                return Style.Remove();
        }

        /**
         * Jump to next loop
         * 
         * @return
         * @throws Continue
         */
        default <T> T Continue() throws Continue {
                return Style.Continue();
        }

        /**
         * Break the loop before setting 'last loop result' Check
         * <a href="https://github.com/wkgcass/Style/">tutorial</a> to see more
         * info about 'last loop result'.
         * 
         * 
         * @param res
         * @return
         */
        default <T> T BreakWithResult(T res) {
                return Style.BreakWithResult(res);
        }

        /**
         * Add the value to ListIterator<br/>
         * Only works for loops on ListIterators
         * 
         * @param toAdd
         * @return
         */
        default <T> T Add(T toAdd) {
                return Style.Add(toAdd);
        }

        /**
         * Set the value to ListIterator<br/>
         * Only works for loops on ListIterators
         * 
         * @param toSet
         * @return
         */
        default <T> T Set(T toSet) {
                return Style.Set(toSet);
        }

        // ┌─────────────────────────────────┐
        // │...collections, maps and arrays..│
        // └─────────────────────────────────┘

        /**
         * Create an array supporter with int[]<br/>
         * This method converts int[] into a new array:Integer[]<br/>
         * and invoke {@link #$(Object[])}
         * 
         * @param array
         *                the array to support
         * @return Integer[] array supporter
         */
        default ArrayFuncSup<Integer> $(int[] array) {
                return Style.$(array);
        }

        /**
         * Create an array supporter with double[]<br/>
         * This method converts double[] into a new array:Double[]<br/>
         * and invoke {@link #$(Object[])}
         * 
         * @param array
         *                the array to support
         * @return Double[] array supporter
         */
        default ArrayFuncSup<Double> $(double[] array) {
                return Style.$(array);
        }

        /**
         * Create an array supporter with float[]<br/>
         * This method converts float[] into a new array:Float[]<br/>
         * and invoke {@link #$(Object[])}
         * 
         * @param array
         *                the array to support
         * @return Float[] array supporter
         */
        default ArrayFuncSup<Float> $(float[] array) {
                return Style.$(array);
        }

        /**
         * Create an array supporter with boolean[]<br/>
         * This method converts boolean[] into a new array:Boolean[]<br/>
         * and invoke {@link #$(Object[])}
         * 
         * @param array
         *                the array to support
         * @return Boolean[] array supporter
         */
        default ArrayFuncSup<Boolean> $(boolean[] array) {
                return Style.$(array);
        }

        /**
         * Create an array supporter with char[]<br/>
         * This method converts char[] into a new array:char[]<br/>
         * and invoke {@link #$(Object[])}
         * 
         * @param array
         *                the array to support
         * @return Character[] array supporter
         */
        default ArrayFuncSup<Character> $(char[] array) {
                return Style.$(array);
        }

        /**
         * Create an array supporter with byte[]<br/>
         * This method converts byte[] into a new array:Byte[]<br/>
         * and invoke {@link #$(Object[])}
         * 
         * @param array
         *                the array to support
         * @return Byte[] array supporter
         */
        default ArrayFuncSup<Byte> $(byte[] array) {
                return Style.$(array);
        }

        /**
         * Create an array supporter with long[]<br/>
         * This method converts long[] into a new array:Long[]<br/>
         * and invoke {@link #$(Object[])}
         * 
         * @param array
         *                the array to support
         * @return Long[] array supporter
         */
        default ArrayFuncSup<Long> $(long[] array) {
                return Style.$(array);
        }

        /**
         * Create an array supporter with short[]<br/>
         * This method converts short[] into a new array:Short[]<br/>
         * and invoke {@link #$(Object[])}
         * 
         * @param array
         *                the array to support
         * @return Short[] array supporter
         */
        default ArrayFuncSup<Short> $(short[] array) {
                return Style.$(array);
        }

        /**
         * Create an array supporter with T[]<br/>
         * 
         * @param array
         *                the array to support
         * @return Short[] array supporter
         */
        default <T> ArrayFuncSup<T> $(T[] array) {
                return Style.$(array);
        }

        /**
         * Create an iterable supporter
         * 
         * @param it
         *                the iterable object to support
         * @return Iterable supporter
         */
        default <T> IterableFuncSup<T> $(Iterable<T> it) {
                return Style.$(it);
        }

        /**
         * Create a collection supporter
         * 
         * @param coll
         *                the collection to support
         * @return Collection supporter
         */
        default <T> CollectionFuncSup<T> $(Collection<T> coll) {
                return Style.$(coll);
        }

        /**
         * Create a list supporter
         * 
         * @param coll
         *                the list to support
         * @return List supporter
         */
        default <T> ListFuncSup<T> $(List<T> list) {
                return Style.$(list);
        }

        /**
         * add these elements into given collection.<br/>
         * usually used when initializing a collection.<br/>
         * however you can also add elements into already existed collections.
         * 
         * @param collection
         *                the collection to add elements into
         * @param elements
         *                elements to add
         * @return param collection
         */
        default <E, Coll extends Collection<E>> Coll $(Coll collection, @SuppressWarnings("unchecked") E... elements) {
                return Style.$(collection, elements);
        }

        /**
         * Create a map supporter
         * 
         * @param map
         *                the map to support
         * @return Map supporter
         */
        default <K, V> MapFuncSup<K, V> $(Map<K, V> map) {
                return Style.$(map);
        }

        /**
         * put entries into the given map.<br/>
         * usually used when initializing a map.<br/>
         * however you can also put entries into already existed maps.
         * 
         * @param map
         *                the map to put entries into
         * @param entries
         *                entries to put, in the form of a JSONLike object.<br/>
         *                a JSONLike object can be created with
         *                {@link #map(Object, Object)}<br/>
         *                and can put in entries using
         *                {@link JSONLike#$(Object, Object)}<br/>
         *                e.g.
         * 
         *                <pre>
         *                map("cass", 1995).$("john", 1994).$("cassie", 1996)
         *                </pre>
         * 
         * @return param map
         * @see JSONLike
         * @see #map(Object, Object)
         */
        default <K, V, M extends Map<K, V>> M $(M map, JSONLike<K, V> entries) {
                return Style.$(map, entries);
        }

        // ┌─────────────────────────────────┐
        // │......basic grammar enhance......│
        // └─────────────────────────────────┘
        // for

        /**
         * Enhanced for expression.<br/>
         * For with return value: returns 'last loop value'.<br/>
         * Check <a href="https://github.com/wkgcass/Style">tutorial</a> for
         * more info about 'last loop value'
         * 
         * @param i
         *                init value
         * @param condition
         *                only proceed when this return true
         * @param increment
         *                let i=increment.apply() after echo loop finishes
         * @param loop
         *                the loop to run
         * @return last not null loop value
         */
        default <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, def<R> loop) {
                return Style.For(i, condition, increment, loop);
        }

        /**
         * Enhanced for expression.<br/>
         * For with return value: returns 'last loop value'.<br/>
         * Check <a href="https://github.com/wkgcass/Style">tutorial</a> for
         * more info about 'last loop value'<br/>
         * This method simply invokes
         * {@link #For(Object, Predicate, UnaryOperator, def)}
         * 
         * @param i
         *                init value
         * @param condition
         *                only proceed when this return true
         * @param increment
         *                let i=increment.apply() after echo loop finishes
         * @param loop
         *                the loop takes in i and run without results
         * @return last not null loop value
         * @see #For(Object, Predicate, UnaryOperator, def)
         */
        default <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, VFunc1<T> loop) {
                return Style.For(i, condition, increment, loop);
        }

        /**
         * Enhanced for expression.<br/>
         * For with return value: returns 'last loop value'.<br/>
         * Check <a href="https://github.com/wkgcass/Style">tutorial</a> for
         * more info about 'last loop value'<br/>
         * This method simply invokes
         * {@link #For(Object, Predicate, UnaryOperator, def)}
         * 
         * @param i
         *                init value
         * @param condition
         *                only proceed when this return true
         * @param increment
         *                let i=increment.apply() after echo loop finishes
         * @param loop
         *                the loop takes in i and run and return a result
         * @return last not null loop value
         * @see #For(Object, Predicate, UnaryOperator, def)
         */
        default <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, RFunc1<R, T> loop) {
                return Style.For(i, condition, increment, loop);
        }

        /**
         * Enhanced for expression.<br/>
         * For with return value: returns 'last loop value'.<br/>
         * Check <a href="https://github.com/wkgcass/Style">tutorial</a> for
         * more info about 'last loop value'<br/>
         * This method simply invokes
         * {@link #For(Object, Predicate, UnaryOperator, def)}
         * 
         * @param i
         *                init value
         * @param condition
         *                only proceed when this return true
         * @param increment
         *                let i=increment.apply() after echo loop finishes
         * @param loop
         *                the loop takes in i and loop info and run without
         *                results
         * @return last not null loop value
         * @see #For(Object, Predicate, UnaryOperator, def)
         */
        default <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, VFunc2<T, LoopInfo<R>> loop) {
                return Style.For(i, condition, increment, loop);
        }

        /**
         * Enhanced for expression.<br/>
         * For with return value: returns 'last loop value'.<br/>
         * Check <a href="https://github.com/wkgcass/Style">tutorial</a> for
         * more info about 'last loop value'<br/>
         * This method simply invokes
         * {@link #For(Object, Predicate, UnaryOperator, def)}
         * 
         * @param i
         *                init value
         * @param condition
         *                only proceed when this return true
         * @param increment
         *                let i=increment.apply() after echo loop finishes
         * @param loop
         *                the loop takes in i and loop info and run and return a
         *                result
         * @return last not null loop value
         * @see #For(Object, Predicate, UnaryOperator, def)
         */
        default <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, RFunc2<R, T, LoopInfo<R>> loop) {
                return Style.For(i, condition, increment, loop);
        }

        /**
         * Entrance of For-to-step loop<br/>
         * See ForSupport for more info
         * 
         * @param start
         *                the start number
         * @return loop result
         * @see ForSupport
         */
        default <N extends Number> ForSupport<N> For(N start) {
                return Style.For(start);
        }

        /**
         * Entrance of For-to-step loop<br/>
         * See ForSupport for more info<br/>
         * It's an alias of For(Number)
         * 
         * @param start
         *                the start number
         * @return loop result
         * @see ForSupport
         * @see #For(Number)
         */
        default <N extends Number> ForSupport<N> from(N start) {
                return Style.For(start);
        }

        // while

        /**
         * Enhanced While expression with return value
         * 
         * @param condition
         *                only when conditon return true, the loop goes on
         * @param loop
         *                the loop to run
         * @return loop result
         */
        default <R> R While(BooleanSupplier condition, def<R> loop) {
                return Style.While(condition, loop);
        }

        /**
         * Enhanced While expression with return value<br/>
         * It simply invokes {@link #While(BooleanSupplier, def)}
         * 
         * @param condition
         *                only when conditon return true, the loop goes on
         * @param loop
         *                the loop to run without results
         * @return loop result
         * @see #While(BooleanSupplier, def)
         */
        default <R> R While(BooleanSupplier condition, VFunc0 loop) {
                return Style.While(condition, loop);
        }

        /**
         * Enhanced While expression with return value<br/>
         * It simply invokes {@link #While(BooleanSupplier, def)}
         * 
         * @param condition
         *                only when conditon return true, the loop goes on
         * @param loop
         *                the loop to run and return a result
         * @return loop result
         * @see #While(BooleanSupplier, def)
         */
        default <R> R While(BooleanSupplier condition, RFunc0<R> loop) {
                return Style.While(condition, loop);
        }

        /**
         * Enhanced While expression with return value<br/>
         * It simply invokes {@link #While(BooleanSupplier, def)}
         * 
         * @param condition
         *                only when conditon return true, the loop goes on
         * @param loop
         *                the loop takes in loop info and run without results
         * @return loop result
         * @see #While(BooleanSupplier, def)
         */
        default <R> R While(BooleanSupplier condition, VFunc1<LoopInfo<R>> loop) {
                return Style.While(condition, loop);
        }

        /**
         * Enhanced While expression with return value<br/>
         * It simply invokes {@link #While(BooleanSupplier, def)}
         * 
         * @param condition
         *                only when conditon return true, the loop goes on
         * @param loop
         *                the loop takes in loop info and run and return a
         *                result
         * @return loop result
         * @see #While(BooleanSupplier, def)
         */
        default <R> R While(BooleanSupplier condition, RFunc1<R, LoopInfo<R>> loop) {
                return Style.While(condition, loop);
        }

        // switch

        /**
         * Entrance of enhanced Switch with return value<br/>
         * java switch only support few number types and String,<br/>
         * with enhanced Switch, you can switch any type.<br/>
         * This entrance see the type to switch as return type.<br/>
         * Check SwitchBlock for more info
         * 
         * @param t
         *                the object to switch
         * @return switch result, the value in Case or Default block.
         * @see SwitchBlock
         */
        default <T> SwitchBlock<T, T> Switch(T t) {
                return Style.Switch(t);
        }

        /**
         * Entrance of enhanced Switch with return value<br/>
         * java switch only support few number types and String,<br/>
         * with enhanced Switch, you can switch any type.<br/>
         * This entrance see the type to switch as return type.<br/>
         * Check SwitchBlock for more info
         * 
         * @param t
         *                the object to switch
         * @param method
         *                replace {@link Object#equals(Object)} with the given
         *                match method
         * 
         * @return switch result, the value in Case or Default block.
         * @see SwitchBlock
         */
        default <T> SwitchBlock<T, T> Switch(T t, RFunc2<Boolean, T, T> method) {
                return Style.Switch(t, method);
        }

        /**
         * Entrance of enhanced Switch with return value<br/>
         * java switch only support few number types and String,<br/>
         * with enhanced Switch, you can switch any type.<br/>
         * This entrance see the type to switch as return type.<br/>
         * Check SwitchBlock for more info
         * 
         * @param t
         *                the object to switch
         * @param method
         *                replace {@link Object#equals(Object)} with the given
         *                match method
         * 
         * @return switch result, the value in Case or Default block.
         * @see SwitchBlock
         */
        default <T> SwitchBlock<T, T> Switch(T t, def<Boolean> method) {
                return Style.Switch(t, method);
        }

        /**
         * Entrance of enhanced Switch with return value<br/>
         * java switch only support few number types and String,<br/>
         * with enhanced Switch, you can switch any type.<br/>
         * This entrance specifies Switch's return type<br/>
         * Check SwitchBlock for more info
         * 
         * @param t
         *                the object to switch
         * @param cls
         *                return type
         * @return switch result, the value in Case or Default block.
         * @see SwitchBlock
         */
        default <T, R> SwitchBlock<T, R> Switch(T t, Class<R> cls) {
                return Style.Switch(t, cls);
        }

        /**
         * Entrance of enhanced Switch with return value<br/>
         * java switch only support few number types and String,<br/>
         * with enhanced Switch, you can switch any type.<br/>
         * This entrance specifies Switch's return type<br/>
         * Check SwitchBlock for more info
         * 
         * @param t
         *                the object to switch
         * @param cls
         *                return type
         * @param method
         *                replace {@link Object#equals(Object)} with the given
         *                match method
         * @return switch result, the value in Case or Default block.
         * @see SwitchBlock
         */
        default <T, R> SwitchBlock<T, R> Switch(T t, Class<R> cls, RFunc2<Boolean, T, T> method) {
                return Style.Switch(t, cls, method);
        }

        /**
         * Entrance of enhanced Switch with return value<br/>
         * java switch only support few number types and String,<br/>
         * with enhanced Switch, you can switch any type.<br/>
         * This entrance specifies Switch's return type<br/>
         * Check SwitchBlock for more info
         * 
         * @param t
         *                the object to switch
         * @param cls
         *                return type
         * @param method
         *                replace {@link Object#equals(Object)} with the given
         *                match method
         * @return switch result, the value in Case or Default block.
         * @see SwitchBlock
         */
        default <T, R> SwitchBlock<T, R> Switch(T t, Class<R> cls, def<Boolean> method) {
                return Style.Switch(t, cls, method);
        }

        // if

        /**
         * Enhanced If expression with return value
         * 
         * @param init
         *                an object or boolean value, init==null ||
         *                init.equals(false) will be considered <b>false</b> in
         *                traditional if expression. in other cases, considered
         *                true
         * @param val
         *                return val if init is considered true
         * @return values or function results defined in the 2nd param of
         *         {@link #If(RFunc0, def)} or the 2nd param of
         *         {@link IfBlock#ElseIf(RFunc0, def)} or the 1st param of
         *         {@link IfBlock#Else(def)}
         * @see IfBlock
         */
        default <T, INIT> IfBlock<T, INIT> If(INIT init, T val) {
                return Style.If(init, val);
        }

        /**
         * Enhanced If expression with return value
         * 
         * @param init
         *                an object or boolean value, init==null ||
         *                init.equals(false) will be considered <b>false</b> in
         *                traditional if expression. in other cases, considered
         *                true
         * @param body
         *                takes in INIT value, and return body's return value if
         *                init is considered true
         * @return values or function results defined in the 2nd param of
         *         {@link #If(RFunc0, def)} or the 2nd param of
         *         {@link IfBlock#ElseIf(RFunc0, def)} or the 1st param of
         *         {@link IfBlock#Else(def)}
         * @see IfBlock
         */
        default <T, INIT> IfBlock<T, INIT> If(INIT init, RFunc1<T, INIT> body) {
                return Style.If(init, body);
        }

        /**
         * Enhanced If expression with return value
         * 
         * @param init
         *                an object or boolean value, init==null ||
         *                init.equals(false) will be considered <b>false</b> in
         *                traditional if expression. in other cases, considered
         *                true
         * @param body
         *                takes in INIT value, and return null if init is
         *                considered true
         * @return values or function results defined in the 2nd param of
         *         {@link #If(RFunc0, def)} or the 2nd param of
         *         {@link IfBlock#ElseIf(RFunc0, def)} or the 1st param of
         *         {@link IfBlock#Else(def)}
         * @see IfBlock
         */
        default <T, INIT> IfBlock<T, INIT> If(INIT init, VFunc1<INIT> body) {
                return Style.If(init, body);
        }

        /**
         * Enhanced If expression with return value
         * 
         * @param init
         *                an object or boolean value, init==null ||
         *                init.equals(false) will be considered <b>false</b> in
         *                traditional if expression. in other cases, considered
         *                true
         * @param body
         *                return body's return value if init is considered true
         * @return values or function results defined in the 2nd param of
         *         {@link #If(RFunc0, def)} or the 2nd param of
         *         {@link IfBlock#ElseIf(RFunc0, def)} or the 1st param of
         *         {@link IfBlock#Else(def)}
         * @see IfBlock
         */
        default <T, INIT> IfBlock<T, INIT> If(INIT init, RFunc0<T> body) {
                return Style.If(init, body);
        }

        /**
         * Enhanced If expression with return value
         * 
         * @param init
         *                an object or boolean value, init==null ||
         *                init.equals(false) will be considered <b>false</b> in
         *                traditional if expression. in other cases, considered
         *                true
         * @param body
         *                return null if init is considered true
         * @return values or function results defined in the 2nd param of
         *         {@link #If(RFunc0, def)} or the 2nd param of
         *         {@link IfBlock#ElseIf(RFunc0, def)} or the 1st param of
         *         {@link IfBlock#Else(def)}
         * @see IfBlock
         */
        default <T, INIT> IfBlock<T, INIT> If(INIT init, VFunc0 body) {
                return Style.If(init, body);
        }

        /**
         * Enhanced If expression with return value
         * 
         * @param init
         *                an object or boolean value, init==null ||
         *                init.equals(false) will be considered <b>false</b> in
         *                traditional if expression. in other cases, considered
         *                true
         * @param body
         *                return body's return value if init is considered true
         * @return values or function results defined in the 2nd param of
         *         {@link #If(RFunc0, def)} or the 2nd param of
         *         {@link IfBlock#ElseIf(RFunc0, def)} or the 1st param of
         *         {@link IfBlock#Else(def)}
         * @see IfBlock
         */
        default <T, INIT> IfBlock<T, INIT> If(INIT init, def<T> body) {
                return Style.If(init, body);
        }

        /**
         * Enhanced If expression with return value
         * 
         * @param init
         *                lambda expression returns an object or boolean value,
         *                init==null || init.equals(false) will be considered
         *                <b>false</b> in traditional if expression. in other
         *                cases, considered true
         * @param val
         *                return val if init is considered true
         * @return values or function results defined in the 2nd param of
         *         {@link #If(RFunc0, def)} or the 2nd param of
         *         {@link IfBlock#ElseIf(RFunc0, def)} or the 1st param of
         *         {@link IfBlock#Else(def)}
         * @see IfBlock
         */
        default <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, T val) {
                return Style.If(init, val);
        }

        /**
         * Enhanced If expression with return value
         * 
         * @param init
         *                lambda expression returns an object or boolean value,
         *                init==null || init.equals(false) will be considered
         *                <b>false</b> in traditional if expression. in other
         *                cases, considered true
         * @param body
         *                takes in INIT value, and return body's return value if
         *                init is considered true
         * @return values or function results defined in the 2nd param of
         *         {@link #If(RFunc0, def)} or the 2nd param of
         *         {@link IfBlock#ElseIf(RFunc0, def)} or the 1st param of
         *         {@link IfBlock#Else(def)}
         * @see IfBlock
         */
        default <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, RFunc1<T, INIT> body) {
                return Style.If(init, body);
        }

        /**
         * Enhanced If expression with return value
         * 
         * @param init
         *                lambda expression returns an object or boolean value,
         *                init==null || init.equals(false) will be considered
         *                <b>false</b> in traditional if expression. in other
         *                cases, considered true
         * @param body
         *                takes in INIT value, and return null if init is
         *                considered true
         * @return values or function results defined in the 2nd param of
         *         {@link #If(RFunc0, def)} or the 2nd param of
         *         {@link IfBlock#ElseIf(RFunc0, def)} or the 1st param of
         *         {@link IfBlock#Else(def)}
         * @see IfBlock
         */
        default <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, VFunc1<INIT> body) {
                return Style.If(init, body);
        }

        /**
         * Enhanced If expression with return value
         * 
         * @param init
         *                lambda expression returns an object or boolean value,
         *                init==null || init.equals(false) will be considered
         *                <b>false</b> in traditional if expression. in other
         *                cases, considered true
         * @param body
         *                return body's return value if init is considered true
         * @return values or function results defined in the 2nd param of
         *         {@link #If(RFunc0, def)} or the 2nd param of
         *         {@link IfBlock#ElseIf(RFunc0, def)} or the 1st param of
         *         {@link IfBlock#Else(def)}
         * @see IfBlock
         */
        default <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, RFunc0<T> body) {
                return Style.If(init, body);
        }

        /**
         * Enhanced If expression with return value
         * 
         * @param init
         *                lambda expression returns an object or boolean value,
         *                init==null || init.equals(false) will be considered
         *                <b>false</b> in traditional if expression. in other
         *                cases, considered true
         * @param body
         *                takes in INIT value, and return null if init is
         *                considered true
         * @return values or function results defined in the 2nd param of
         *         {@link #If(RFunc0, def)} or the 2nd param of
         *         {@link IfBlock#ElseIf(RFunc0, def)} or the 1st param of
         *         {@link IfBlock#Else(def)}
         * @see IfBlock
         */
        default <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, VFunc0 body) {
                return Style.If(init, body);
        }

        /**
         * Enhanced If expression with return value
         * 
         * @param init
         *                lambda expression returns an object or boolean value,
         *                init==null || init.equals(false) will be considered
         *                <b>false</b> in traditional if expression. in other
         *                cases, considered true
         * @param body
         *                return body's return value if init is considered true
         * @return values or function results defined in the 2nd param of
         *         {@link #If(RFunc0, def)} or the 2nd param of
         *         {@link IfBlock#ElseIf(RFunc0, def)} or the 1st param of
         *         {@link IfBlock#Else(def)}
         * @see IfBlock
         */
        default <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, def<T> body) {
                return Style.If(init, body);
        }

        // ┌─────────────────────────────────┐
        // │............throwable............│
        // └─────────────────────────────────┘

        /**
         * Generate a StyleRuntimeException with 'cause' of given Throwable
         * object.<br/>
         * if t instanceof StyleRuntimeException, the method would return t
         * itself
         * 
         * @param t
         *                the Throwable object to be transformed into
         *                StyleRuntimeException
         * @return StyleRuntimeException
         * @see StyleRuntimeException
         */
        default StyleRuntimeException $(Throwable t) {
                return Style.$(t);
        }

        // ┌─────────────────────────────────┐
        // │..............other..............│
        // └─────────────────────────────────┘
        // json like

        /**
         * Create a JSONLike object.<br/>
         * it helps you create a map with similar method as how JSON initializes
         * 
         * @param key
         *                first key of the map
         * @param value
         *                first value of the map
         * @return a new JSONLike object
         * @see JSONLike
         */
        default <K, V> JSONLike<K, V> map(K key, V value) {
                return Style.map(key, value);
        }

        /**
         * Create a JSONLike object from an array similar to JSON
         * 
         * @param json
         *                an array look like JSON.<br/>
         *                e.g.
         * 
         *                <pre>
         * new Object["name" ,"cass",
         *           "age", 20,
         *           "sex", "male"]
         *                </pre>
         * 
         * @return a new JSONLike object
         * @see JSONLike
         */
        default JSONLike<String, Object> map(Object[] json) {
                return Style.map(json);
        }

        // date

        /**
         * Create a date supporter
         * 
         * @param date
         *                the date to support
         * @return Date supporter
         * @see DateFuncSup
         */
        default DateFuncSup $(Date date) {
                return Style.$(date);
        }

        // regex

        /**
         * Create a simplified regex tool from a string.
         * 
         * @param regex
         *                a string assembled in the form of regex in JavaScript
         * @return new RegEx object helps you work with regex
         * @see RegEx
         */
        default RegEx regex(String regex) {
                return Style.regex(regex);
        }

        // comparable

        /**
         * Enables you to compare two comparable objects with more readable
         * coding.<br/>
         * e.g.
         * 
         * <pre>
         *  lt, gt, le, lte, ge, gte, eq, ne, neq
         * </pre>
         * 
         * @param comparable
         *                the first comparable object to be compared
         * @return ComparableFuncSup
         * @see ComparableFuncSup
         */
        default <T> ComparableFuncSup<T> $(Comparable<T> comparable) {
                return Style.$(comparable);
        }

        // rand

        /**
         * get an integer randomly from start (inclusive) to end (inclusive)
         * 
         * @param start
         * @param end
         * @return random integer
         */
        default int rand(int start, int end) {
                return Style.rand(start, end);
        }

        /**
         * get a double randomly from start (inclusive) to end (exclusive)
         * 
         * @param start
         * @param end
         * @return random double
         */
        default double rand(double start, double end) {
                return Style.rand(start, end);
        }

        /**
         * get an integer littler than max (inclusive)
         * 
         * @param max
         * @return random integer
         */
        default int rand(int max) {
                return Style.rand(max);
        }

        /**
         * get a double littler than max
         * 
         * @param max
         * @return random double
         */
        default double rand(double max) {
                return Style.rand(max);
        }

        /**
         * generate a random string serial with characters from $chooseFrom and
         * given length.
         * 
         * @param chooseFrom
         *                characters to choose from
         * @param length
         *                generated serial length
         * @param unrepeatable
         *                true if the serial doesn't contain repeating
         *                characters. false otherwise.
         * @param ignoreCase
         *                true if the serial doesn't contain repeating
         *                case-ignored characters. false otherwise.<br/>
         *                Only consider this argument when $unrepeatable is true
         * @return random string serial
         */
        default String rand(String chooseFrom, int length, boolean unrepeatable, boolean ignoreCase) {
                return Style.rand(chooseFrom, length, unrepeatable, ignoreCase);
        }

        /**
         * generate a random string serial with characters from $chooseFrom and
         * given length.
         * 
         * @param chooseFrom
         *                characters to choose from
         * @param length
         *                generated serial length
         * @param unrepeatable
         *                true if the serial doesn't contain repeating
         *                characters. false otherwise.
         * @return random string serial
         */
        default String rand(String chooseFrom, int length, boolean unrepeatable) {
                return Style.rand(chooseFrom, length, unrepeatable);
        }

        /**
         * generate a random string serial with characters from $chooseFrom and
         * given length.
         * 
         * @param chooseFrom
         *                characters to choose from
         * @param length
         *                generated serial length
         * @return random string serial
         */
        default String rand(String chooseFrom, int length) {
                return Style.rand(chooseFrom, length);
        }

        /**
         * retrieve LoopInfo.currentIndex
         * 
         * @param info
         * @return
         * @see LoopInfo
         */
        default int $(IteratorInfo<?> info) {
                return Style.$(info);
        }

        /**
         * create a string supporter
         * 
         * @param base
         *                the string to be supported
         * @return String supporter
         * @see StringFuncSup
         */
        default StringFuncSup $(String base) {
                return Style.$(base);
        }

        /**
         * Implicit Type Conversion.<br/>
         * To achieve implicit type conversion,<br/>
         * the class to be converted to may contain methods like this:<br/>
         * <code>static R from(T o)</code><br/>
         * <b>OR</b> the class of the object (param 'o') to convert may contain
         * methods like this:<br/>
         * <code>toT</code><br/>
         * e.g.<br/>
         * The following definition means you can convert String to User or
         * convert User to String with this method.
         * 
         * <pre>
         * static User from(String s)...
         * String toString()...
         * </pre>
         * 
         * @param o
         *                original object
         * @param cls
         *                the type to convert to
         * @return object of converted type
         */
        default <T> T imp(Object o, Class<T> cls) {
                return Style.imp(o, cls);
        }

        /**
         * get object in real type<br/>
         * if you defined object using <code>var v=...</code>
         * 
         * @return object in real type
         */
        @SuppressWarnings("unchecked")
        default <TYPE> TYPE $() {
                return (TYPE) this;
        }

        /**
         * get object in targeted type<br/>
         * if you defined object using <code>var v=...</code>
         * 
         * @param cls
         *                target type
         * @return object in targeted type
         */
        @SuppressWarnings("unchecked")
        default <TYPE> TYPE $(Class<TYPE> cls) {
                return (TYPE) this;
        }

        /**
         * Avoid null values.<br/>
         * firstly check the first argument, if it's null, invoke the the second
         * argument (lambda expression), otherwise return the first argument.
         * 
         * @param t
         *                the value to be checked
         * @param Default
         *                return its value if $t is null
         * @return value of which null has been avoided
         */
        default <T> T avoidNull(T t, RFunc0<T> Default) {
                return Style.avoidNull(t, Default);
        }

        // ┌─────────────────────────────────┐
        // │...........reflection............│
        // └─────────────────────────────────┘

        /**
         * create a class supporter with given class
         * 
         * @param cls
         *                the class object to be supported
         * @return Class supporter
         * @see ClassSup
         */
        default <T> ClassSup<T> cls(Class<T> cls) {
                return Style.cls(cls);
        }

        /**
         * create a class supporter with given class name
         * 
         * @param clsName
         *                full name of the class to be supported
         * @return Class supporter
         * @see ClassSup
         */
        default ClassSup<?> cls(String clsName) {
                return Style.cls(clsName);
        }

        /**
         * create a class supporter with given object
         * 
         * @param obj
         *                instance of the class to be supported
         * @return Class supporter
         * @see ClassSup
         */
        default ClassSup<Object> cls(Object obj) {
                return Style.cls(obj);
        }

        /**
         * generate proxy object with given InvocationHandler and the object to
         * do proxy
         * 
         * @param handler
         *                InvocationHandler instance
         * @param toProxy
         *                the object to do proxy
         * @return proxy object generated with Proxy.newProxyInstance(...)
         * @see InvocationHandler
         * @see Proxy#newProxyInstance(ClassLoader, Class[], InvocationHandler)
         */
        default <P> P proxy(ProxyHandler<P> proxyHandler) {
                return Style.proxy(proxyHandler);
        }

        /**
         * generate proxy object with given ProxyHandler<br/>
         * ProxyHandler is an abstract class with a constructor taking in the
         * object to do proxy<br/>
         * see ProxyHandler or
         * <a href="https://github.com/wkgcass/Style/">tutorial</a> for more
         * info on how to use.
         * 
         * @param proxyHandler
         * @return proxy object generated with Proxy.newProxyInstance(...)
         * @see ProxyHandler
         * @see Proxy#newProxyInstance(ClassLoader, Class[], InvocationHandler)
         */
        default <T> T proxy(InvocationHandler handler, T toProxy) {
                return Style.proxy(handler, toProxy);
        }

        /**
         * Make an object which has interfaces to a read-only one.<br/>
         * When an invocation comes, the InvocatinHandler will check the method.
         * 
         * <pre>
         if methodName.contains elements in $.readOnlyToSearch
                Check whether the method has ReadOnly annotation
                        if has
                            do invoking
                        else
                            throw an exception(ModifyReadOnlyException)
        else
                Check whether the method has Writable annotation
                        if has
                            throw an exception(ModifyReadOnlyException)
                        else
                            do invoking
         * </pre>
         * 
         * @param toReadOnly
         *                the object to be readonly
         * @return read-only object(dynamic proxy supported)
         */
        default <R> R readOnly(R toReadOnly) {
                return Style.readOnly(toReadOnly);
        }

}
