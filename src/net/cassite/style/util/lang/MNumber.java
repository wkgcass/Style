package net.cassite.style.util.lang;

public abstract class MNumber<M extends MNumber<M, N>, N extends Number> extends Number implements Comparable<M> {

        /**
         * 
         */
        private static final long serialVersionUID = 7152073371332208165L;

        protected N n;

        public MNumber(N n) {
                this.n = n;
        }

        @Override
        public int intValue() {
                return n.intValue();
        }

        @Override
        public long longValue() {
                return n.longValue();
        }

        @Override
        public float floatValue() {
                return n.floatValue();
        }

        @Override
        public double doubleValue() {
                return n.doubleValue();
        }

        public M inc() {
                return inc(1);
        }

        public abstract M inc(Number inc);

        public abstract M mul(Number mul);

        @SuppressWarnings("unchecked")
        public M assign(N n) {
                this.n = n;
                return (M) this;
        }

        public N toNumber() {
                return n;
        }

        @Override
        public String toString() {
                return n.toString();
        }

        @Override
        public boolean equals(Object o) {
                return n.equals(o);
        }

        @Override
        public int hashCode() {
                return n.hashCode();
        }
}
