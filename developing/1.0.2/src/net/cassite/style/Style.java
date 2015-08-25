package net.cassite.style;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import net.cassite.style.control.*;
import net.cassite.style.control.$Set;
import net.cassite.style.interfaces.*;
import net.cassite.style.readonly.ModifyReadOnlyException;
import net.cassite.style.readonly.ReadOnly;
import net.cassite.style.readonly.Writable;
import net.cassite.style.reflect.ClassSup;
import net.cassite.style.reflect.FieldSupport;
import net.cassite.style.reflect.MethodSupport;
import net.cassite.style.reflect.ProxyHandler;

/**
 * All functions in <b>Style tool box</b> are provided here.<br/>
 * Let your class <code>extends Style</code> to avoid retyping
 * <code>Style.</code> which makes your coding prettier
 * 
 * @author wkgcass
 *
 */
public abstract class Style {

        protected Style() {
        }

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
        public static def<Object> function(VFunc0 body) {
                return $(body);
        }

        /**
         * define a function with 1 input and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 1 input and void output
         */
        public static def<Object> function(VFunc1<?> body) {
                return $(body);
        }

        /**
         * define a function with 2 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 2 inputs and void output
         */
        public static def<Object> function(VFunc2<?, ?> body) {
                return $(body);
        }

        /**
         * define a function with 3 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 3 inputs and void output
         */
        public static def<Object> function(VFunc3<?, ?, ?> body) {
                return $(body);
        }

        /**
         * define a function with 4 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 4 inputs and void output
         */
        public static def<Object> function(VFunc4<?, ?, ?, ?> body) {
                return $(body);
        }

        /**
         * define a function with 5 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 5 inputs and void output
         */
        public static def<Object> function(VFunc5<?, ?, ?, ?, ?> body) {
                return $(body);
        }

        /**
         * define a function with 6 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 6 inputs and void output
         */
        public static def<Object> function(VFunc6<?, ?, ?, ?, ?, ?> body) {
                return $(body);
        }

        /**
         * define a function with 7 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 7 inputs and void output
         */
        public static def<Object> function(VFunc7<?, ?, ?, ?, ?, ?, ?> body) {
                return $(body);
        }

        // functions with return value

        /**
         * define a function with 0 input and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 0 input and an output
         */
        public static <R> def<R> function(RFunc0<R> body) {
                return $(body);
        }

        /**
         * define a function with 1 input and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 1 input and an output
         */
        public static <R> def<R> function(RFunc1<R, ?> body) {
                return $(body);
        }

        /**
         * define a function with 2 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 2 inputs and an output
         */
        public static <R> def<R> function(RFunc2<R, ?, ?> body) {
                return $(body);
        }

        /**
         * define a function with 3 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 3 inputs and an output
         */
        public static <R> def<R> function(RFunc3<R, ?, ?, ?> body) {
                return $(body);
        }

        /**
         * define a function with 4 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 4 inputs and an output
         */
        public static <R> def<R> function(RFunc4<R, ?, ?, ?, ?> body) {
                return $(body);
        }

        /**
         * define a function with 5 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 5 inputs and an output
         */
        public static <R> def<R> function(RFunc5<R, ?, ?, ?, ?, ?> body) {
                return $(body);
        }

        /**
         * define a function with 6 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 6 inputs and an output
         */
        public static <R> def<R> function(RFunc6<R, ?, ?, ?, ?, ?, ?> body) {
                return $(body);
        }

        /**
         * define a function with 7 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 7 inputs and an output
         */
        public static <R> def<R> function(RFunc7<R, ?, ?, ?, ?, ?, ?, ?> body) {
                return $(body);
        }

        // void functions

        /**
         * define a function with 0 input and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 0 input and void output
         */
        public static def<Object> $(VFunc0 body) {
                return new def<Object>(body);
        }

        /**
         * define a function with 1 input and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 1 input and void output
         */
        public static def<Object> $(VFunc1<?> body) {
                return new def<Object>(body);
        }

        /**
         * define a function with 2 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 2 inputs and void output
         */
        public static def<Object> $(VFunc2<?, ?> body) {
                return new def<Object>(body);
        }

        /**
         * define a function with 3 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 3 inputs and void output
         */
        public static def<Object> $(VFunc3<?, ?, ?> body) {
                return new def<Object>(body);
        }

        /**
         * define a function with 4 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 4 inputs and void output
         */
        public static def<Object> $(VFunc4<?, ?, ?, ?> body) {
                return new def<Object>(body);
        }

        /**
         * define a function with 5 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 5 inputs and void output
         */
        public static def<Object> $(VFunc5<?, ?, ?, ?, ?> body) {
                return new def<Object>(body);
        }

        /**
         * define a function with 6 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 6 inputs and void output
         */
        public static def<Object> $(VFunc6<?, ?, ?, ?, ?, ?> body) {
                return new def<Object>(body);
        }

        /**
         * define a function with 7 inputs and void output
         * 
         * @param body
         *                the function to generate
         * @return a function with 7 inputs and void output
         */
        public static def<Object> $(VFunc7<?, ?, ?, ?, ?, ?, ?> body) {
                return new def<Object>(body);
        }

        // functions with return value

        /**
         * define a function with 0 input and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 0 input and an output
         */
        public static <R> def<R> $(RFunc0<R> body) {
                return new def<R>(body);
        }

        /**
         * define a function with 1 input and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 1 input and an output
         */
        public static <R> def<R> $(RFunc1<R, ?> body) {
                return new def<R>(body);
        }

        /**
         * define a function with 2 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 2 inputs and an output
         */
        public static <R> def<R> $(RFunc2<R, ?, ?> body) {
                return new def<R>(body);
        }

        /**
         * define a function with 3 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 3 inputs and an output
         */
        public static <R> def<R> $(RFunc3<R, ?, ?, ?> body) {
                return new def<R>(body);
        }

        /**
         * define a function with 4 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 4 inputs and an output
         */
        public static <R> def<R> $(RFunc4<R, ?, ?, ?, ?> body) {
                return new def<R>(body);
        }

        /**
         * define a function with 5 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 5 inputs and an output
         */
        public static <R> def<R> $(RFunc5<R, ?, ?, ?, ?, ?> body) {
                return new def<R>(body);
        }

        /**
         * define a function with 6 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 6 inputs and an output
         */
        public static <R> def<R> $(RFunc6<R, ?, ?, ?, ?, ?, ?> body) {
                return new def<R>(body);
        }

        /**
         * define a function with 7 inputs and an output
         * 
         * @param body
         *                the function to generate
         * @return a function with 7 inputs and an output
         */
        public static <R> def<R> $(RFunc7<R, ?, ?, ?, ?, ?, ?, ?> body) {
                return new def<R>(body);
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
        public static <T> ptr<T> ptr(T o) {
                return new ptr<T>(o);
        }

        /**
         * Retrieve pointed value from a pointer.
         * 
         * @param store
         *                a pointer created using {@link #ptr(Object)}
         * @return pointed value
         */
        public static <T> T $(ptr<T> store) {
                return store.item;
        }

        /**
         * Change pointed value of a pointer.
         * 
         * @param ptr
         *                a pointer created using {@link #ptr(Object)}
         * @param newItem
         * @return
         */
        public static <T> ptr<T> $(ptr<T> ptr, T newItem) {
                ptr.item = newItem;
                return ptr;
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
        public static AsyncGroup $(Async<?>... asyncs) {
                return new AsyncGroup(null, asyncs);
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
        public static AsyncGroup $(def<Object> handler, Async<?>... asyncs) {
                return new AsyncGroup(handler, asyncs);
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
        public static AsyncGroup $(VFunc1<StyleRuntimeException> handler, Async<?>... asyncs) {
                return new AsyncGroup($(handler), asyncs);
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
        public static <R> R await(Async<R> async) {
                return async.await();
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
        public static Thread run(VFunc0 runnable) {
                return run($(runnable));
        }

        /**
         * Create a new thread and invoke start on it.
         * 
         * @param runnable
         *                function run on the new thread
         * @return created thread
         */
        public static Thread run(def<Object> toRun) {
                Thread t = new Thread(() -> {
                        toRun.apply();
                });
                t.start();
                return t;
        }

        /**
         * Make current thread sleep for designated milliseconds
         * 
         * @param millis
         *                milliseconds to sleep
         */
        public static void sleep(long millis) {
                try {
                        Thread.sleep(millis);
                } catch (InterruptedException e) {
                        throw $(e);
                }
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
        public static <T> T Break() throws Break {
                throw $.Control_Break;
        }

        /**
         * Remove an object from current iterator.<br/>
         * Only works for loops on Iterators and Maps
         * 
         * @return
         * @throws Remove
         */
        public static <T> T Remove() throws Remove {
                throw $.Control_Remove;
        }

        /**
         * Jump to next loop
         * 
         * @return
         * @throws Continue
         */
        public static <T> T Continue() throws Continue {
                throw $.Control_Continue;
        }

        /**
         * Set the value to ListIterator<br/>
         * Only works for loops on ListIterators
         * 
         * @param toSet
         * @return
         */
        public static <T> T Set(T toSet) {
                throw new $Set(toSet);
        }

        /**
         * Add the value to ListIterator<br/>
         * Only works for loops on ListIterators
         * 
         * @param toAdd
         * @return
         */
        public static <T> T Add(T toAdd) {
                throw new Add(toAdd);
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
        public static <T> T BreakWithResult(T res) {
                throw new BreakWithResult(res);
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
        public static ArrayFuncSup<Integer> $(int[] array) {
                Integer[] arr = new Integer[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
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
        public static ArrayFuncSup<Double> $(double[] array) {
                Double[] arr = new Double[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
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
        public static ArrayFuncSup<Float> $(float[] array) {
                Float[] arr = new Float[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
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
        public static ArrayFuncSup<Boolean> $(boolean[] array) {
                Boolean[] arr = new Boolean[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
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
        public static ArrayFuncSup<Character> $(char[] array) {
                Character[] arr = new Character[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
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
        public static ArrayFuncSup<Byte> $(byte[] array) {
                Byte[] arr = new Byte[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
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
        public static ArrayFuncSup<Long> $(long[] array) {
                Long[] arr = new Long[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
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
        public static ArrayFuncSup<Short> $(short[] array) {
                Short[] arr = new Short[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
        }

        /**
         * Create an array supporter with T[]<br/>
         * 
         * @param array
         *                the array to support
         * @return Short[] array supporter
         */
        public static <T> ArrayFuncSup<T> $(T[] array) {
                return new ArrayFuncSup<T>(array);
        }

        /**
         * Create an iterable supporter
         * 
         * @param it
         *                the iterable object to support
         * @return Iterable supporter
         */
        public static <T> IterableFuncSup<T> $(Iterable<T> it) {
                return new IterableFuncSup<>(it);
        }

        /**
         * Create a collection supporter
         * 
         * @param coll
         *                the collection to support
         * @return Collection supporter
         */
        public static <T> CollectionFuncSup<T> $(Collection<T> coll) {
                return new CollectionFuncSup<>(coll);
        }

        /**
         * Create a list supporter
         * 
         * @param coll
         *                the list to support
         * @return List supporter
         */
        public static <T> ListFuncSup<T> $(List<T> coll) {
                return new ListFuncSup<T>(coll);
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
        @SafeVarargs
        public static <E, Coll extends Collection<E>> Coll $(Coll collection, E... elements) {
                for (E e : elements) {
                        collection.add(e);
                }
                return collection;
        }

        /**
         * Create a map supporter
         * 
         * @param map
         *                the map to support
         * @return Map supporter
         */
        public static <K, V> MapFuncSup<K, V> $(Map<K, V> map) {
                return new MapFuncSup<>(map);
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
        public static <K, V, M extends Map<K, V>> M $(M map, JSONLike<K, V> entries) {
                for (K key : entries.keySet()) {
                        map.put(key, entries.get(key));
                }
                return map;
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
        public static <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, def<R> loop) {
                R res = null;
                LoopInfo<R> info = new LoopInfo<R>();
                int cursor = 0;
                int effctiveCursor = 0;
                for (T ii = i; condition.test(ii); ii = increment.apply(ii)) {
                        try {
                                R tmpRes;
                                tmpRes = loop.apply(ii, info.setValues(cursor, effctiveCursor, res));
                                if (tmpRes != null) {
                                        res = tmpRes;
                                        ++effctiveCursor;
                                }
                        } catch (Throwable e) {
                                if (e instanceof StyleRuntimeException) {
                                        Throwable origin = ((StyleRuntimeException) e).origin();
                                        if (origin instanceof Break) {
                                                break;
                                        } else if (origin instanceof Continue) {
                                                continue;
                                        } else if (origin instanceof BreakWithResult) {
                                                res = ((BreakWithResult) origin).getRes();
                                                break;
                                        } else {
                                                throw ((StyleRuntimeException) e);
                                        }
                                } else {
                                        throw $(e);
                                }
                        } finally {
                                ++cursor;
                        }
                }
                return res;
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
        @SuppressWarnings("unchecked")
        public static <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, VFunc1<T> loop) {
                return (R) For(i, condition, increment, $(loop));
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
        public static <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, RFunc1<R, T> loop) {
                return (R) For(i, condition, increment, $(loop));
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
        @SuppressWarnings("unchecked")
        public static <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, VFunc2<T, LoopInfo<R>> loop) {
                return (R) For(i, condition, increment, $(loop));
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
        public static <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, RFunc2<R, T, LoopInfo<R>> loop) {
                return (R) For(i, condition, increment, $(loop));
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
        public static <N extends Number> ForSupport<N> For(N start) {
                return new ForSupport<N>(start);
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
        public static <N extends Number> ForSupport<N> from(N start) {
                return new ForSupport<N>(start);
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
        public static <R> R While(BooleanSupplier condition, def<R> loop) {
                R res = null;
                LoopInfo<R> info = new LoopInfo<>();
                int currentIndex = 0;
                int effectiveIndex = 0;
                while (condition.getAsBoolean()) {
                        try {
                                R tmpRes;
                                tmpRes = loop.apply(info.setValues(currentIndex, effectiveIndex, res));
                                if (tmpRes != null) {
                                        res = tmpRes;
                                        ++effectiveIndex;
                                }
                        } catch (Throwable e) {
                                if (e instanceof StyleRuntimeException) {
                                        Throwable origin = ((StyleRuntimeException) e).origin();
                                        if (origin instanceof Break) {
                                                break;
                                        } else if (origin instanceof Continue) {
                                                continue;
                                        } else if (origin instanceof BreakWithResult) {
                                                res = ((BreakWithResult) origin).getRes();
                                                break;
                                        } else {
                                                throw ((StyleRuntimeException) e);
                                        }
                                } else {
                                        throw $(e);
                                }
                        } finally {
                                ++currentIndex;
                        }
                }
                return res;
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
        @SuppressWarnings("unchecked")
        public static <R> R While(BooleanSupplier condition, VFunc0 loop) {
                return While(condition, (def<R>) $(loop));
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
        public static <R> R While(BooleanSupplier condition, RFunc0<R> loop) {
                return While(condition, $(loop));
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
        @SuppressWarnings("unchecked")
        public static <R> R While(BooleanSupplier condition, VFunc1<LoopInfo<R>> loop) {
                return While(condition, (def<R>) $(loop));
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
        public static <R> R While(BooleanSupplier condition, RFunc1<R, LoopInfo<R>> loop) {
                return While(condition, $(loop));
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
        public static <T> SwitchBlock<T, T> Switch(T t) {
                return Switch(t, $.eqlFunc);
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
        public static <T> SwitchBlock<T, T> Switch(T t, RFunc2<Boolean, T, T> method) {
                return Switch(t, $(method));
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
        public static <T> SwitchBlock<T, T> Switch(T t, def<Boolean> method) {
                return new SwitchBlock<T, T>(t, method);
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
        public static <T, R> SwitchBlock<T, R> Switch(T t, Class<R> cls) {
                return Switch(t, cls, $.eqlFunc);
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
        public static <T, R> SwitchBlock<T, R> Switch(T t, Class<R> cls, RFunc2<Boolean, T, T> method) {
                return Switch(t, cls, $(method));
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
        public static <T, R> SwitchBlock<T, R> Switch(T t, Class<R> cls, def<Boolean> method) {
                return new SwitchBlock<T, R>(t, method);
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
        public static <T, INIT> IfBlock<T, INIT> If(INIT init, T val) {
                return If(init, () -> val);
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
        public static <T, INIT> IfBlock<T, INIT> If(INIT init, RFunc1<T, INIT> body) {
                return If(init, $(body));
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
        @SuppressWarnings("unchecked")
        public static <T, INIT> IfBlock<T, INIT> If(INIT init, VFunc1<INIT> body) {
                return (IfBlock<T, INIT>) If(init, $(body));
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
        public static <T, INIT> IfBlock<T, INIT> If(INIT init, RFunc0<T> body) {
                return If(init, $(body));
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
        @SuppressWarnings("unchecked")
        public static <T, INIT> IfBlock<T, INIT> If(INIT init, VFunc0 body) {
                return (IfBlock<T, INIT>) If(init, $(body));
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
        public static <T, INIT> IfBlock<T, INIT> If(INIT init, def<T> body) {
                return new IfBlock<>(() -> init, body);
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
        public static <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, T val) {
                return If(init, () -> val);
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
        public static <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, RFunc1<T, INIT> body) {
                return If(init, $(body));
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
        @SuppressWarnings("unchecked")
        public static <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, VFunc1<INIT> body) {
                return (IfBlock<T, INIT>) If(init, $(body));
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
        public static <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, RFunc0<T> body) {
                return If(init, $(body));
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
        @SuppressWarnings("unchecked")
        public static <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, VFunc0 body) {
                return (IfBlock<T, INIT>) If(init, $(body));
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
        public static <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, def<T> body) {
                return new IfBlock<>(init, body);
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
        public static StyleRuntimeException $(Throwable t) {
                if (t instanceof StyleRuntimeException) {
                        return (StyleRuntimeException) t;
                } else {
                        return new StyleRuntimeException(t);
                }
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
        public static <K, V> JSONLike<K, V> map(K key, V value) {
                return new JSONLike<K, V>(key, value);
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
        public static JSONLike<String, Object> map(Object[] json) {
                if (json.length % 2 != 0 || json.length == 0) {
                        throw new RuntimeException("Wrong json format");
                }
                JSONLike<String, Object> map = new JSONLike<String, Object>(json[0].toString(), json[1]);
                for (int i = 2; i < json.length; i += 2) {
                        String key = json[i].toString();
                        Object value = json[i + 1];
                        map.$(key, value);
                }
                return map;
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
        public static DateFuncSup $(Date date) {
                return new DateFuncSup(date);
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
        public static RegEx regex(String regex) {
                return new RegEx(regex);
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
        public static <T> ComparableFuncSup<T> $(Comparable<T> comparable) {
                return new ComparableFuncSup<>(comparable);
        }

        // rand

        /**
         * get an integer randomly from start (inclusive) to end (inclusive)
         * 
         * @param start
         * @param end
         * @return random integer
         */
        public static int rand(int start, int end) {
                return (int) (Math.random() * (end - start + 1)) + start;
        }

        /**
         * get a double randomly from start (inclusive) to end (exclusive)
         * 
         * @param start
         * @param end
         * @return random double
         */
        public static double rand(double start, double end) {
                return Math.random() * (end - start) + start;
        }

        /**
         * get an integer littler than max (inclusive)
         * 
         * @param max
         * @return random integer
         */
        public static int rand(int max) {
                return (int) (Math.random() * (max + 1));
        }

        /**
         * get a double littler than max
         * 
         * @param max
         * @return random double
         */
        public static double rand(double max) {
                return Math.random() * max;
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
        public static String rand(String chooseFrom, int length, boolean unrepeatable, boolean ignoreCase) {
                if (length > chooseFrom.length() && unrepeatable) {
                        throw new RuntimeException("unrepeatable but length > chooseFrom.length");
                }
                StringBuilder sb = new StringBuilder();
                ptr<String> $chooseFrom = ptr(chooseFrom);
                For(1).to(length).loop(i -> {
                        char c = $chooseFrom.item.charAt(rand($chooseFrom.item.length() - 1));
                        while (sb.indexOf("" + c) != -1 && unrepeatable) {
                                c = $chooseFrom.item.charAt(rand(chooseFrom.length() - 1));
                        }
                        sb.append(c);
                        if (unrepeatable) {
                                if (ignoreCase) {
                                        $chooseFrom.item = $chooseFrom.item.replace(("" + c).toLowerCase(), "");
                                        $chooseFrom.item = $chooseFrom.item.replace(("" + c).toUpperCase(), "");
                                } else {
                                        $chooseFrom.item = $chooseFrom.item.replace(("" + c), "");
                                }
                        }
                });
                return sb.toString();
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
        public static String rand(String chooseFrom, int length, boolean unrepeatable) {
                return rand(chooseFrom, length, unrepeatable, false);
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
        public static String rand(String chooseFrom, int length) {
                return rand(chooseFrom, length, false, false);
        }

        /**
         * retrieve LoopInfo.currentIndex
         * 
         * @param info
         * @return
         * @see LoopInfo
         */
        public static int $(LoopInfo<?> info) {
                return info.currentIndex;
        }

        /**
         * create a string supporter
         * 
         * @param base
         *                the string to be supported
         * @return String supporter
         * @see StringFuncSup
         */
        public static StringFuncSup $(String base) {
                return new StringFuncSup(base);
        }

        /**
         * Type Conversion.<br/>
         * In order to use Style's type conversion,<br/>
         * the class <b>to be converted to</b> may contain methods like this:
         * <br/>
         * <code>static R from(T o)</code><br/>
         * <b>OR</b> the class of the object (param 'o') <b>to convert</b> may
         * contain methods like this:<br/>
         * <code>toT</code><br/>
         * e.g.<br/>
         * The following definition means you can convert String to User or
         * convert User to String.
         * 
         * <pre>
         * class User{
         * static User from(String s)...
         * String toString()...
         * }
         * </pre>
         * 
         * @param o
         *                original object
         * @param cls
         *                the type to convert to
         * @return object of converted type
         */
        @SuppressWarnings("unchecked")
        public static <T> T imp(Object o, Class<T> cls) {
                Method m;
                try {
                        m = o.getClass().getMethod("to" + cls.getSimpleName(), new Class[0]);
                        if (m.getReturnType() != cls) {
                                throw new RuntimeException("Invalid implicit type conversion definition. Return type mismatch");
                        }
                        m.setAccessible(true);
                        return (T) m.invoke(o, new Object[0]);
                } catch (NoSuchMethodException e) {
                        try {
                                m = cls.getMethod("from", o.getClass());
                                if (m.getReturnType() != cls) {
                                        throw new RuntimeException("Invalid implicit type conversion definition. Return type mismatch");
                                } else if (!Modifier.isStatic(m.getModifiers())) {
                                        throw new RuntimeException(
                                                        "Invalid implicit type conversion definition. Method starts with 'from' should be static.");
                                }
                                m.setAccessible(true);
                                return (T) m.invoke(null, o);
                        } catch (NoSuchMethodException e1) {
                                throw new RuntimeException("No implicit type conversion definition.");
                        } catch (Exception e1) {
                                throw $(e1);
                        }
                } catch (Exception e) {
                        throw $(e);
                }
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
        public static <T> T avoidNull(T t, RFunc0<T> Default) {
                if (t == null)
                        try {
                                return Default.apply();
                        } catch (Throwable throwable) {
                                throw $(throwable);
                        }
                else
                        return t;
        }

        /**
         * Swap two values in an un-traditional way<br/>
         * The two values should be the same type
         * (a.getClass().equals(b.getClass())) and are not primitives <br/>
         * or they are same kind of array and length are the same.
         * 
         * @param a
         * @param b
         */
        public static void swap(Object a, Object b) {
                if (!a.getClass().equals(b.getClass())) {
                        throw new RuntimeException();
                }
                if (a.getClass().isArray() && Array.getLength(a) == Array.getLength(b)) {
                        for (int i = 0; i < Array.getLength(a); ++i) {
                                Object tmp = Array.get(a, i);
                                Array.set(a, i, Array.get(b, i));
                                Array.set(b, i, tmp);
                        }
                } else {
                        List<FieldSupport<?, Object>> fields = cls(a).allFields();
                        $(fields).forEach(f -> {
                                if (!f.isStatic()) {
                                        Object tmp = f.get(a);
                                        f.set(a, f.get(b));
                                        f.set(b, tmp);
                                }
                        });
                }
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
        public static <T> ClassSup<T> cls(Class<T> cls) {
                return new ClassSup<>(cls);
        }

        /**
         * create a class supporter with given class name
         * 
         * @param clsName
         *                full name of the class to be supported
         * @return Class supporter
         * @see ClassSup
         */
        @SuppressWarnings("unchecked")
        public static <T> ClassSup<T> cls(String clsName) {
                try {
                        return (ClassSup<T>) cls(Class.forName(clsName));
                } catch (Exception e) {
                        throw $(e);
                }
        }

        /**
         * create a class supporter with given object
         * 
         * @param obj
         *                instance of the class to be supported
         * @return Class supporter
         * @see ClassSup
         */
        @SuppressWarnings("unchecked")
        public static <T> ClassSup<T> cls(T obj) {
                return (ClassSup<T>) cls(obj.getClass());
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
        @SuppressWarnings("unchecked")
        public static <T> T proxy(InvocationHandler handler, T toProxy) {
                return (T) Proxy.newProxyInstance(toProxy.getClass().getClassLoader(), toProxy.getClass().getInterfaces(), handler);
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
        @SuppressWarnings("unchecked")
        public static <P> P proxy(ProxyHandler<P> proxyHandler) {
                List<MethodSupport<?, ProxyHandler<P>>> methods = cls(proxyHandler).allMethods();
                P toProxy = proxyHandler.target;

                return (P) Proxy.newProxyInstance(toProxy.getClass().getClassLoader(), toProxy.getClass().getInterfaces(), (p, m, args) -> {
                        return If($(methods).forEach(e -> {
                                if (e.name().equals(m.getName()) && e.argCount() == m.getParameterCount()
                                                && avoidNull($(m.getParameterTypes()).forEach((pt, i) -> {
                                        if (!pt.isAssignableFrom(e.argTypes()[$(i)]))
                                                return BreakWithResult(false);
                                        else
                                                return true;
                                }), () -> true))
                                        return BreakWithResult(e);
                                else
                                        return null;
                        }), res -> (Object) res.invoke(proxyHandler, args)).Else(() -> m.invoke(toProxy, args));
                });
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
        public static <R> R readOnly(R toReadOnly) {
                return proxy((p, m, args) -> {
                        return If($($.readOnlyToSearch).forEach(s -> {
                                if (m.getName().contains(s))
                                        return BreakWithResult(m);
                                else
                                        return null;
                        }), rm -> {
                                if (rm.isAnnotationPresent(ReadOnly.class))
                                        return m.invoke(toReadOnly, args);
                                else
                                        throw new ModifyReadOnlyException(toReadOnly, m);
                        }).Else(() -> {
                                if (m.isAnnotationPresent(Writable.class))
                                        throw new ModifyReadOnlyException(toReadOnly, m);
                                else
                                        return m.invoke(toReadOnly, args);
                        });
                } , toReadOnly);
        }

}
