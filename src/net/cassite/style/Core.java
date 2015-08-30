package net.cassite.style;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.UnaryOperator;

import net.cassite.style.control.$Set;
import net.cassite.style.control.Add;
import net.cassite.style.control.Break;
import net.cassite.style.control.BreakWithResult;
import net.cassite.style.control.Continue;
import net.cassite.style.control.Remove;
import net.cassite.style.interfaces.*;

public abstract class Core {
        protected Core() {
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
         * generate a pointer pointed to given object<br>
         * A <b>pointer</b> here means a container contains an object with
         * initial type<br>
         * Type of the pointer is guaranteed by Generic System.<br>
         * You can access it's contained value using <b>ptr.item</b>, <br>
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
         * given exception handler.<br>
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
         * given exception handler.<br>
         * see {@link Async#onError(def)}, {@link Async#awaitError(def)} for
         * more info about exception handling.<br>
         * <br>
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
         * <br>
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
         * Remove an object from current iterator.<br>
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
         * Set the value to ListIterator<br>
         * Only works for loops on ListIterators
         * 
         * @param toSet
         * @return
         */
        public static <T> T Set(T toSet) {
                throw new $Set(toSet);
        }

        /**
         * Add the value to ListIterator<br>
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
        // │............throwable............│
        // └─────────────────────────────────┘

        /**
         * Generate a StyleRuntimeException with 'cause' of given Throwable
         * object.<br>
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
        // │......basic grammar enhance......│
        // └─────────────────────────────────┘
        // for

        /**
         * Enhanced for expression.<br>
         * For with return value: returns 'last loop value'.<br>
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
        public static <T, R> R For(T i, RFunc1<Boolean, T> condition, UnaryOperator<T> increment, def<R> loop) {
                R res = null;
                LoopInfo<R> info = new LoopInfo<R>();
                int cursor = 0;
                int effctiveCursor = 0;
                for (T ii = i; $(condition).applyCheckPrimitive(boolean.class, ii); ii = increment.apply(ii)) {
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
         * Enhanced for expression.<br>
         * For with return value: returns 'last loop value'.<br>
         * Check <a href="https://github.com/wkgcass/Style">tutorial</a> for
         * more info about 'last loop value'<br>
         * This method simply invokes
         * {@link #For(Object, RFunc1, UnaryOperator, def)}
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
         * @see #For(Object, RFunc1, UnaryOperator, def)
         */
        @SuppressWarnings("unchecked")
        public static <T, R> R For(T i, RFunc1<Boolean, T> condition, UnaryOperator<T> increment, VFunc1<T> loop) {
                return (R) For(i, condition, increment, $(loop));
        }

        /**
         * Enhanced for expression.<br>
         * For with return value: returns 'last loop value'.<br>
         * Check <a href="https://github.com/wkgcass/Style">tutorial</a> for
         * more info about 'last loop value'<br>
         * This method simply invokes
         * {@link #For(Object, RFunc1, UnaryOperator, def)}
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
         * @see #For(Object, RFunc1, UnaryOperator, def)
         */
        public static <T, R> R For(T i, RFunc1<Boolean, T> condition, UnaryOperator<T> increment, RFunc1<R, T> loop) {
                return (R) For(i, condition, increment, $(loop));
        }

        /**
         * Enhanced for expression.<br>
         * For with return value: returns 'last loop value'.<br>
         * Check <a href="https://github.com/wkgcass/Style">tutorial</a> for
         * more info about 'last loop value'<br>
         * This method simply invokes
         * {@link #For(Object, RFunc1, UnaryOperator, def)}
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
         * @see #For(Object, RFunc1, UnaryOperator, def)
         */
        @SuppressWarnings("unchecked")
        public static <T, R> R For(T i, RFunc1<Boolean, T> condition, UnaryOperator<T> increment, VFunc2<T, LoopInfo<R>> loop) {
                return (R) For(i, condition, increment, $(loop));
        }

        /**
         * Enhanced for expression.<br>
         * For with return value: returns 'last loop value'.<br>
         * Check <a href="https://github.com/wkgcass/Style">tutorial</a> for
         * more info about 'last loop value'<br>
         * This method simply invokes
         * {@link #For(Object, RFunc1, UnaryOperator, def)}
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
         * @see #For(Object, RFunc1, UnaryOperator, def)
         */
        public static <T, R> R For(T i, RFunc1<Boolean, T> condition, UnaryOperator<T> increment, RFunc2<R, T, LoopInfo<R>> loop) {
                return (R) For(i, condition, increment, $(loop));
        }

        /**
         * Entrance of For-to-step loop<br>
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
         * Entrance of For-to-step loop<br>
         * See ForSupport for more info<br>
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
        public static <R> R While(RFunc0<Boolean> condition, def<R> loop) {
                R res = null;
                LoopInfo<R> info = new LoopInfo<>();
                int currentIndex = 0;
                int effectiveIndex = 0;
                while ($(condition).applyCheckPrimitive(boolean.class)) {
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
         * Enhanced While expression with return value<br>
         * It simply invokes {@link #While(RFunc0, def)}
         * 
         * @param condition
         *                only when conditon return true, the loop goes on
         * @param loop
         *                the loop to run without results
         * @return loop result
         * @see #While(RFunc0, def)
         */
        @SuppressWarnings("unchecked")
        public static <R> R While(RFunc0<Boolean> condition, VFunc0 loop) {
                return While(condition, (def<R>) $(loop));
        }

        /**
         * Enhanced While expression with return value<br>
         * It simply invokes {@link #While(RFunc0, def)}
         * 
         * @param condition
         *                only when conditon return true, the loop goes on
         * @param loop
         *                the loop to run and return a result
         * @return loop result
         * @see #While(RFunc0, def)
         */
        public static <R> R While(RFunc0<Boolean> condition, RFunc0<R> loop) {
                return While(condition, $(loop));
        }

        /**
         * Enhanced While expression with return value<br>
         * It simply invokes {@link #While(RFunc0, def)}
         * 
         * @param condition
         *                only when conditon return true, the loop goes on
         * @param loop
         *                the loop takes in loop info and run without results
         * @return loop result
         * @see #While(RFunc0, def)
         */
        @SuppressWarnings("unchecked")
        public static <R> R While(RFunc0<Boolean> condition, VFunc1<LoopInfo<R>> loop) {
                return While(condition, (def<R>) $(loop));
        }

        /**
         * Enhanced While expression with return value<br>
         * It simply invokes {@link #While(RFunc0, def)}
         * 
         * @param condition
         *                only when conditon return true, the loop goes on
         * @param loop
         *                the loop takes in loop info and run and return a
         *                result
         * @return loop result
         * @see #While(RFunc0, def)
         */
        public static <R> R While(RFunc0<Boolean> condition, RFunc1<R, LoopInfo<R>> loop) {
                return While(condition, $(loop));
        }

        // switch

        /**
         * Entrance of enhanced Switch with return value<br>
         * java switch only support few number types and String,<br>
         * with enhanced Switch, you can switch any type.<br>
         * This entrance see the type to switch as return type.<br>
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
         * Entrance of enhanced Switch with return value<br>
         * java switch only support few number types and String,<br>
         * with enhanced Switch, you can switch any type.<br>
         * This entrance see the type to switch as return type.<br>
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
         * Entrance of enhanced Switch with return value<br>
         * java switch only support few number types and String,<br>
         * with enhanced Switch, you can switch any type.<br>
         * This entrance see the type to switch as return type.<br>
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
         * Entrance of enhanced Switch with return value<br>
         * java switch only support few number types and String,<br>
         * with enhanced Switch, you can switch any type.<br>
         * This entrance specifies Switch's return type<br>
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
         * Entrance of enhanced Switch with return value<br>
         * java switch only support few number types and String,<br>
         * with enhanced Switch, you can switch any type.<br>
         * This entrance specifies Switch's return type<br>
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
         * Entrance of enhanced Switch with return value<br>
         * java switch only support few number types and String,<br>
         * with enhanced Switch, you can switch any type.<br>
         * This entrance specifies Switch's return type<br>
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
         *                return null if init is considered true
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
         * Type Conversion.<br>
         * In order to use Style's type conversion,<br>
         * the class <b>to be converted to</b> may contain methods like this:
         * <br>
         * <code>static R from(T o)</code><br>
         * <b>OR</b> the class of the object (param 'o') <b>to convert</b> may
         * contain methods like this:<br>
         * <code>toT</code><br>
         * e.g.<br>
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
         * Avoid null values.<br>
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
         * Avoid null values.<br>
         * firstly check the first argument, if it's null, invoke the the second
         * argument (lambda expression), otherwise return the first argument.
         * 
         * @param t
         *                the value to be checked
         * @param Default
         *                return its value if $t is null
         * @return value of which null has been avoided
         */
        public static <T> T avoidNull(T t, T Default) {
                if (t == null)
                        return Default;
                else
                        return t;
        }
}
