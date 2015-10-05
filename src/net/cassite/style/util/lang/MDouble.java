package net.cassite.style.util.lang;

public class MDouble extends MNumber<MDouble, Double> {

        /**
         * 
         */
        private static final long serialVersionUID = 8810348667492321852L;

        public MDouble(Double d) {
                super(d);
        }

        @Override
        public int compareTo(MDouble o) {
                return n.compareTo(o.n);
        }

        @Override
        public MDouble inc(Number inc) {
                this.n += inc.doubleValue();
                return this;
        }

        @Override
        public MDouble mul(Number mul) {
                this.n *= mul.doubleValue();
                return this;
        }

}
