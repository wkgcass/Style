package net.cassite.style.util.lang;

public class MFloat extends MNumber<MFloat, Float> {

        /**
         * 
         */
        private static final long serialVersionUID = -1051899389996212923L;

        public MFloat(Float n) {
                super(n);
        }

        @Override
        public int compareTo(MFloat o) {
                return n.compareTo(o.n);
        }

        @Override
        public MFloat inc(Number inc) {
                n += inc.floatValue();
                return this;
        }

        @Override
        public MFloat mul(Number mul) {
                n *= mul.floatValue();
                return this;
        }

}
