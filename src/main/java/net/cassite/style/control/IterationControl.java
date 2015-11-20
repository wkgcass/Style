package net.cassite.style.control;

public class IterationControl extends RuntimeException {
        /**
         * 
         */
        private static final long serialVersionUID = -8094983073491511595L;

        public IterationControl() {
                super();
        }

        public IterationControl(Throwable t) {
                super(t);
        }

        public IterationControl(String msg) {
                super(msg);
        }

        public IterationControl(String msg, Throwable t) {
                super(msg, t);
        }
}
