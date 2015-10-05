package net.cassite.style.util.lang;

public class MByte extends MNumber<MByte, Byte> {

        /**
         * 
         */
        private static final long serialVersionUID = -5930129805421940016L;

        public MByte(Byte n) {
                super(n);
        }

        @Override
        public int compareTo(MByte o) {
                return n.compareTo(o.n);
        }

        @Override
        public MByte inc(Number inc) {
                n = (byte) (n + inc.byteValue());
                return this;
        }

        @Override
        public MByte mul(Number mul) {
                n = (byte) (n * mul.byteValue());
                return this;
        }

}
