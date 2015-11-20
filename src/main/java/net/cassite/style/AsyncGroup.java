package net.cassite.style;

import java.util.Arrays;

import net.cassite.style.interfaces.*;
import net.cassite.style.util.Utils;

/**
 * Joins results of a group of Async process.
 *
 * @author wkgcass
 */
public class AsyncGroup {
        private Async<?>[] group;

        private boolean inProcess = false;

        private StyleRuntimeException err;
        private def<Void> handler;
        private final Object lock = new Object();

        AsyncGroup(def<Void> asyncHandler, Async<?>... group) {
                if (group.length == 0)
                        throw new IllegalArgumentException("at least one Async object should be passed in");
                this.group = Arrays.copyOf(group, group.length);
                if (null != asyncHandler) {
                        for (Async<?> a : group) {
                                if (!a.hasErrHandler()) {
                                        a.onError(asyncHandler);
                                }
                        }
                }
        }

        /**
         * The given lambda will be invoked when all async operations are
         * finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return asyncGroup object
         */
        public AsyncGroup callback(VFunc0 func) {
                return callback(Style.$(func));
        }

        /**
         * The given lambda will be invoked on a new thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callback(VFunc1<?> func) {
                return callback(Style.$(func));
        }

        /**
         * The given lambda will be invoked on a new thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callback(VFunc2<?, ?> func) {
                return callback(Style.$(func));
        }

        /**
         * The given lambda will be invoked on a new thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callback(VFunc3<?, ?, ?> func) {
                return callback(Style.$(func));
        }

        /**
         * The given lambda will be invoked on a new thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callback(VFunc4<?, ?, ?, ?> func) {
                return callback(Style.$(func));
        }

        /**
         * The given lambda will be invoked on a new thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callback(VFunc5<?, ?, ?, ?, ?> func) {
                return callback(Style.$(func));
        }

        /**
         * The given lambda will be invoked on a new thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callback(VFunc6<?, ?, ?, ?, ?, ?> func) {
                return callback(Style.$(func));
        }

        /**
         * The given lambda will be invoked on a new thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callback(VFunc7<?, ?, ?, ?, ?, ?, ?> func) {
                return callback(Style.$(func));
        }

        /**
         * The given lambda will be invoked on a new thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callback(def<Void> func) {
                Utils.run(() -> callbackSync(func));
                return this;
        }

        /**
         * The given lambda will be invoked on current thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callbackSync(VFunc0 func) {
                return callbackSync(Style.$(func));
        }

        /**
         * The given lambda will be invoked on current thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callbackSync(VFunc1<?> func) {
                return callbackSync(Style.$(func));
        }

        /**
         * The given lambda will be invoked on current thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callbackSync(VFunc2<?, ?> func) {
                return callbackSync(Style.$(func));
        }

        /**
         * The given lambda will be invoked on current thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callbackSync(VFunc3<?, ?, ?> func) {
                return callbackSync(Style.$(func));
        }

        /**
         * The given lambda will be invoked on current thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callbackSync(VFunc4<?, ?, ?, ?> func) {
                return callbackSync(Style.$(func));
        }

        /**
         * The given lambda will be invoked on current thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callbackSync(VFunc5<?, ?, ?, ?, ?> func) {
                return callbackSync(Style.$(func));
        }

        /**
         * The given lambda will be invoked on current thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callbackSync(VFunc6<?, ?, ?, ?, ?, ?> func) {
                return callbackSync(Style.$(func));
        }

        /**
         * The given lambda will be invoked on current thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callbackSync(VFunc7<?, ?, ?, ?, ?, ?, ?> func) {
                return callbackSync(Style.$(func));
        }

        /**
         * The given lambda will be invoked on current thread when all async
         * operations are finished or thrown with an exception.<br>
         * Arguments would be filled with result of the Asyncs in the order of
         * async operations were added.
         *
         * @param func function to call when all async operations are
         *             finished.
         * @return <code>this</code>.
         */
        public AsyncGroup callbackSync(def<Void> func) {
                inProcess = true;
                try {
                        Object[] awaits = new Object[group.length];
                        int i = 0;
                        for (Async<?> async : group) {
                                awaits[i] = async.await();
                                ++i;
                        }
                        func.apply(awaits);
                } catch (Throwable e) {
                        synchronized (lock) {
                                err = Style.$(e);
                                if (handler != null) {
                                        handler.apply(err);
                                }
                        }
                }
                return this;
        }

        /**
         * Handle exceptions that callback function thrown.<br>
         * if there's already an exception thrown when this method invoked, the
         * handling process would be taken in current thread.<br>
         * Otherwise, the process would be taken at callback thread when
         * exception occurred.
         *
         * @param handler a function takes in StyleRuntimeException<br>
         *                for all Throwable caught from the callback function
         *                would be packed into StyleRuntimeException
         * @see StyleRuntimeException
         */
        public void onError(VFunc1<StyleRuntimeException> handler) {
                onError(Style.$(handler));
        }

        /**
         * Handle exceptions that callback function thrown.<br>
         * if there's already an exception thrown when this method invoked, the
         * handling process would be taken in current thread.<br>
         * Otherwise, the process would be taken at callback thread when
         * exception occurred.
         *
         * @param handler a function to invoke when occurred an exception<br>
         *                for all Throwable caught from the callback function
         *                would be packed into StyleRuntimeException
         * @see StyleRuntimeException
         */
        public void onError(def<Void> handler) {
                while (!inProcess) {
                        // block
                }
                synchronized (lock) {
                        this.handler = handler;
                        if (err != null) {
                                handler.apply(err);
                        }
                }
        }

        /**
         * retrieve exception that this supporter occurred.<br>
         * the method will only return exception that's already found. It will
         * not guarantee exception won't occur after invoking this method.
         *
         * @return occurred exception.
         */
        public StyleRuntimeException getErr() {
                return err;
        }
}