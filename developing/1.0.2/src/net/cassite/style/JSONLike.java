package net.cassite.style;

import java.util.LinkedHashMap;

public class JSONLike<K, V> extends LinkedHashMap<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7448591337510287830L;

	public JSONLike(K key, V value) {
		put(key, value);
	}

	public JSONLike<K, V> $(K key, V value) {
		put(key, value);
		return this;
	}
}