package net.cassite.style;

import java.util.LinkedHashMap;

/**
 * Provide a way of forming up a map in the way looks like JSON
 * 
 * @author wkgcass
 *
 * @param <K>
 *                key
 * @param <V>
 *                value
 */
public class JSONLike<K, V> extends LinkedHashMap<K, V> {

        /**
         * 
         */
        private static final long serialVersionUID = 7448591337510287830L;

        /**
         * set first entry
         * 
         * @param key
         *                key
         * @param value
         *                value
         */
        public JSONLike(K key, V value) {
                put(key, value);
        }

        /**
         * put an entry into the map
         * 
         * @param key
         *                key
         * @param value
         *                value
         * @return <code>this</code>
         */
        public JSONLike<K, V> $(K key, V value) {
                put(key, value);
                return this;
        }
}