package net.cassite.style.util.lang;

public class MShort extends MNumber<MShort, Short> {

        /**
         * 
         */
        private static final long serialVersionUID = 1317740954577467790L;

        public MShort(Short n) {
                super(n);
        }

        @Override
        public int compareTo(MShort o) {
                return n.compareTo(o.n);
        }

        @Override
        public MShort inc(Number inc) {
                n = (short) (n + inc.shortValue());
                return this;
        }

        @Override
        public MShort mul(Number mul) {
                n = (short) (n * mul.shortValue());
                return this;
        }

}
