package net.cassite.style.util.lang;

import java.util.ArrayList;
import java.util.List;

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

        /**
         * generate a list containing values from integer represented by this object<br>
         * to given integer (inclusive)<br>
         * e.g. <code>$(0).to(20)</code> means list(0,1,2,...,20)
         *
         * @param end end integer (inclusive)
         * @return a list
         */
        public List<Integer> to(int end) {
                List<Integer> list = new ArrayList<>();
                for (int i = this.n; i <= end; ++i) {
                        list.add(i);
                }
                return list;
        }

        /**
         * generate a list containing values from integer represented by this object<br>
         * to given integer (exclusive)<br>
         * e.g. <code>$(0).until(20)</code> means list(0,1,2,...,19)
         *
         * @param end end integer (exclusive)
         * @return a list
         */
        public List<Integer> until(int end) {
                List<Integer> list = new ArrayList<>();
                for (int i = this.n; i < end; ++i) {
                        list.add(i);
                }
                return list;
        }
}
