package net.cassite.style;

import net.cassite.style.interfaces.VFunc1;

/**
 * Async supporter. <br>
 * the given function will start to run as soon as its constructed.
 *
 * @param <R> function's return type
 * @author wkgcass
 */
public class Async<R> {
        private final Container<R> container;
        private Thread t;

        private StyleRuntimeException throwable = null;
        private def<Void> handler = null;
        private final Object lock = new Object();

        private static class Container<R> {
                R ret = null;
                boolean inProcess = false;

                Container() {
                }
        }

        private class AsyncRunnable<T> implements Runnable {
                private final Container<T> container;
                private final def<T> func;
                private final Object[] args;

                AsyncRunnable(Container<T> container, def<T> func, Object... args) {
                        this.container = container;
                        this.func = func;
                        this.args = args;
                }

                @Override
                public void run() {
                        synchronized (container) {
                                container.inProcess = true;
                                try {
                                        container.ret = func.apply(args);
                                } catch (Throwable t) {
                                        synchronized (lock) {
                                                throwable = Style.$(t);
                                                if (handler != null) {
                                                        handler.apply(Style.$(throwable));
                                                }
                                        }
                                }
                        }
                }
        }

        Async(def<R> func, Object... args) {
                this.container = new Container<>();
                t = new Thread(new AsyncRunnable<>(container, func, args));
                t.start();
        }

        /**
         * block current thread and wait until the async task was finished or
         * thrown with an exception.
         *
         * @return the result of the finished async.<br>
         * When an exception occurred inside the async task, the result
         * will always be null.
         */
        public R await() {
                while (!container.inProcess) {
                        // block
                }
                synchronized (container) {
                        return container.ret;
                }
        }

        /**
         * retrieve the async thread
         *
         * @return the thread that async task run on.
         */
        public Thread getThread() {
                return t;
        }

        /**
         * Handle exceptions that async task thrown.<br>
         * if there's already an exception thrown when this method invoked, the
         * handling process would be taken in current thread.<br>
         * Otherwise, the process would be taken at async thread when exception
         * occurred.<br>
         * use {@link #awaitError(VFunc1)} if you need to force the handling
         * process taken on current thread.
         *
         * @param handler a function takes in StyleRuntimeException<br>
         *                for all Throwable caught from the async task would be
         *                packed into StyleRuntimeException
         * @see #awaitError(VFunc1)
         * @see StyleRuntimeException
         */
        public void onError(VFunc1<StyleRuntimeException> handler) {
                onError(Style.$(handler));
        }

        /**
         * Handle exceptions that async task thrown.<br>
         * if there's already an exception thrown when this method invoked, the
         * handling process would be taken in current thread.<br>
         * Otherwise, the process would be taken at async thread when exception
         * occurred.<br>
         * use {@link #awaitError(def)} if you need to force the handling
         * process taken on current thread.
         *
         * @param handler a function to invoke when occurred an exception<br>
         *                for all Throwable caught from the async task would be
         *                packed into StyleRuntimeException
         * @see #awaitError(def)
         * @see StyleRuntimeException
         */
        public void onError(def<Void> handler) {
                this.handler = handler;
                while (!container.inProcess) {
                        // block
                }
                synchronized (lock) {
                        if (null != throwable) {
                                handler.apply(Style.$(throwable));
                        }
                }
        }

        /**
         * Handle exceptions that async task thrown.<br>
         * the method would block current thread until async task finished or
         * thrown with an exception, the handling process would be taken in
         * current thread.<br>
         *
         * @param handler a function takes in StyleRuntimeException<br>
         *                for all Throwable caught from the async task would be
         *                packed into StyleRuntimeException
         * @see StyleRuntimeException
         */
        public void awaitError(VFunc1<StyleRuntimeException> handler) {
                awaitError(Style.$(handler));
        }

        /**
         * Handle exceptions that async task thrown.<br>
         * the method would block current thread until async task finished or
         * thrown with an exception, the handling process would be taken in
         * current thread.<br>
         *
         * @param handler a function to invoke when occurred an exception<br>
         *                for all Throwable caught from the async task would be
         *                packed into StyleRuntimeException
         * @see StyleRuntimeException
         */
        public void awaitError(def<Void> handler) {
                while (!container.inProcess) {
                        // block
                }
                synchronized (container) {
                        if (null != throwable) {
                                handler.apply(Style.$(throwable));
                        }
                }
        }

        /**
         * check whether this async supporter has an exception handler
         *
         * @return true if this async supporter has an exception handler, false
         * otherwise
         */
        public boolean hasErrHandler() {
                return handler != null;
        }

        /**
         * retrieve exception that this supporter occurred.<br>
         * the method will only return exception that's already found. It will
         * not guarantee exception won't occur after invoking this method.
         *
         * @return occurred exception.
         */
        public StyleRuntimeException getErr() {
                return throwable;
        }
}