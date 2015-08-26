package net.cassite.style.readonly;

import java.lang.reflect.Method;

public class ModifyReadOnlyException extends UnsupportedOperationException {
        /**
         * 
         */
        private static final long serialVersionUID = 4083257542991301604L;

        public ModifyReadOnlyException(Object obj, Method method) {
                super("Illegal modifying attempt on readonly object : " + obj + " with method : " + method);
        }
}
