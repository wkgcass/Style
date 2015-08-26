package net.cassite.style;

import java.lang.reflect.InvocationTargetException;

/**
 * A RuntimeException to simplify exception handling.<br/>
 * it is recommended to create this exception using {@link Style#$(Throwable)}
 * 
 * @author wkgcass
 *
 */
public class StyleRuntimeException extends RuntimeException {
        /**
         * 
         */
        private static final long serialVersionUID = 3062353717153173710L;

        public StyleRuntimeException(Throwable t) {
                super(t);
        }

        /**
         * Throw <code>this</code> if packed exception instanceof among given
         * classes
         * 
         * @param classes
         *                throw when matches these classes
         */
        public void throwIn(@SuppressWarnings("unchecked") Class<? extends Throwable>... classes) {
                for (Class<? extends Throwable> cls : classes) {
                        if (cls.isInstance(getCause())) {
                                throw this;
                        }
                }
        }

        /**
         * Throw <code>this</code> if packed exception is not instanceof among
         * given classes
         * 
         * @param classes
         *                throw when doesn't matches all these classes
         */
        public void throwNotIn(@SuppressWarnings("unchecked") Class<? extends Throwable>... classes) {
                boolean toThrow = true;
                for (Class<? extends Throwable> cls : classes) {
                        if (cls.isInstance(getCause())) {
                                toThrow = false;
                                break;
                        }
                }
                if (toThrow) {
                        throw this;
                }
        }

        /**
         * get packed exception
         * 
         * @return
         */
        public Throwable origin() {
                return super.getCause();
        }

        @Override
        public Throwable getCause() {
                Throwable target = super.getCause();
                if (target instanceof InvocationTargetException) {
                        return ((InvocationTargetException) target).getTargetException();
                } else {
                        return target.getCause();
                }
        }
}