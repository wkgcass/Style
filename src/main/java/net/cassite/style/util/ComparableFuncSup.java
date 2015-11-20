package net.cassite.style.util;

/**
 * Supporter of Comparable objects.<br>
 * Usually we don't need to know how much larger or smaller one object is than
 * another<br>
 * We only need to know whether one is larger or smaller than the other.<br>
 * Readable methods are provided to determine larger/smaller/equal
 *
 * @param <T> comparable object type
 * @author wkgcass
 */
public class ComparableFuncSup<T> {
        private Comparable<T> comparable;

        ComparableFuncSup(Comparable<T> comparable) {
                this.comparable = comparable;
        }

        /**
         * Greater than
         *
         * @param o compared obj
         * @return true if greater, false otherwise
         */
        public boolean gt(T o) {
                return comparable.compareTo(o) > 0;
        }

        /**
         * Littler than
         *
         * @param o compared obj
         * @return true if littler, false otherwise
         */
        public boolean lt(T o) {
                return comparable.compareTo(o) < 0;
        }

        /**
         * Greater than or equal to
         *
         * @param o compared obj
         * @return true if greater or equal, false otherwise
         */
        public boolean ge(T o) {
                return comparable.compareTo(o) >= 0;
        }

        /**
         * Greater than or equal to
         *
         * @param o compared obj
         * @return true if greater or equal, false otherwise
         */
        public boolean gte(T o) {
                return ge(o);
        }

        /**
         * Littler than or equal to
         *
         * @param o compared obj
         * @return true if litter or equal, false otherwise
         */
        public boolean le(T o) {
                return comparable.compareTo(o) <= 0;
        }

        /**
         * Littler than or equal to
         *
         * @param o compared obj
         * @return true if litter or equal, false otherwise
         */
        public boolean lte(T o) {
                return le(o);
        }

        /**
         * equal to
         *
         * @param o compared obj
         * @return true if equal, false otherwise
         */
        public boolean eq(T o) {
                return comparable.compareTo(o) == 0;
        }

        /**
         * not equal
         *
         * @param o compared obj
         * @return true if not equal, false otherwise
         */
        public boolean ne(T o) {
                return !eq(o);
        }

        /**
         * not equal
         *
         * @param o compared obj
         * @return true if not equal, false otherwise
         */
        public boolean neq(T o) {
                return ne(o);
        }

        /**
         * Simply invokes {@link Comparable#compareTo(Object)}
         *
         * @param o compared obj
         * @return comparasion result
         * @see Comparable#compareTo(Object)
         */
        public int compareTo(T o) {
                return comparable.compareTo(o);
        }
}
