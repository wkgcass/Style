package net.cassite.style;

/**
 * Supporter of Comparable objects.<br>
 * Usually we don't need to know how much larger or smaller one object is than
 * another<br>
 * We only need to know whether one is larger or smaller than the other.<br>
 * Readable methods are provided to determine larger/smaller/equal
 * 
 * @author wkgcass
 *
 * @param <T>
 *                comparable object type
 */
public class ComparableFuncSup<T> {
        private Comparable<T> comparable;

        ComparableFuncSup(Comparable<T> comparable) {
                this.comparable = comparable;
        }

        /**
         * Greater than
         * 
         * @param o
         * @return
         */
        public boolean gt(T o) {
                return comparable.compareTo(o) > 0;
        }

        /**
         * Littler than
         * 
         * @param o
         * @return
         */
        public boolean lt(T o) {
                return comparable.compareTo(o) < 0;
        }

        /**
         * Greater than or equal to
         * 
         * @param o
         * @return
         */
        public boolean ge(T o) {
                return comparable.compareTo(o) >= 0;
        }

        /**
         * Greater than or equal to
         * 
         * @param o
         * @return
         */
        public boolean gte(T o) {
                return ge(o);
        }

        /**
         * Littler than or equal to
         * 
         * @param o
         * @return
         */
        public boolean le(T o) {
                return comparable.compareTo(o) <= 0;
        }

        /**
         * Littler than or equal to
         * 
         * @param o
         * @return
         */
        public boolean lte(T o) {
                return le(o);
        }

        /**
         * equal to
         * 
         * @param o
         * @return
         */
        public boolean eq(T o) {
                return comparable.compareTo(o) == 0;
        }

        /**
         * not equal
         * 
         * @param o
         * @return
         */
        public boolean ne(T o) {
                return !eq(o);
        }

        /**
         * not equal
         * 
         * @param o
         * @return
         */
        public boolean neq(T o) {
                return ne(o);
        }

        /**
         * Simply invokes {@link Comparable#compareTo(Object)}
         * 
         * @param o
         * @return
         * @see Comparable#compareTo(Object)
         */
        public int compareTo(T o) {
                return comparable.compareTo(o);
        }
}
