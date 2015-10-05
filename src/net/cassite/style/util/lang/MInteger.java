package net.cassite.style.util.lang;

public class MInteger extends MNumber<MInteger, Integer> {
        /**
         * 
         */
        private static final long serialVersionUID = 6332281232135422321L;

        public MInteger(Integer i) {
                super(i);
        }

        @Override
        public int compareTo(MInteger o) {
                return n.compareTo(o.n);
        }

        @Override
        public MInteger inc(Number inc) {
                n += inc.intValue();
                return this;
        }

        @Override
        public MInteger mul(Number inc) {
                n *= inc.intValue();
                return this;
        }
}
