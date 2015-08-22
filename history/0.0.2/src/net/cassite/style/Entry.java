package net.cassite.style;

public class Entry<K2, V2> {
	public Entry() {
	}

	public Entry(K2 key, V2 value) {
		this.key = key;
		this.value = value;
	}

	public K2 key;
	public V2 value;
}