package net.cassite.style.util.lang;

public class MLong extends MNumber<MLong, Long> {

        /**
         * 
         */
        private static final long serialVersionUID = -6076695278733738596L;

        public MLong(Long l) {
                super(l);
        }

        @Override
        public int compareTo(MLong o) {
                return n.compareTo(o.n);
        }

        @Override
        public MLong inc(Number inc) {
                n += inc.longValue();
                return this;
        }

        @Override
        public MLong mul(Number mul) {
                n *= mul.longValue();
                return this;
        }

}
