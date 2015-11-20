package net.cassite.style;

/**
 * Entry which formats a map from key to value
 * 
 * @author wkgcass
 *
 * @param <K2>
 *                Key type
 * @param <V2>
 *                Value type
 */
public class Entry<K2, V2> {
        /**
         * Construct an Entry with no key and value
         */
        public Entry() {
        }

        /**
         * Construct an Entry with no key and value
         * 
         * @param key
         *                key
         * @param value
         *                value
         */
        public Entry(K2 key, V2 value) {
                this.key = key;
                this.value = value;
        }

        /**
         * key of the entry
         */
        public K2 key;
        /**
         * value of the entry
         */
        public V2 value;

        @Override
        public String toString() {
                return key + "=" + value;
        }

        @Override
        public int hashCode() {
                return key.hashCode() + value.hashCode();
        }

        @Override
        public boolean equals(Object o) {
                return o != null && ((o instanceof Entry) && (key.equals(((Entry<?, ?>) o).key) && value.equals(((Entry<?, ?>) o).value)));
        }
}