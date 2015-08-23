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
		return o == null ? false
				: (o instanceof Entry) ? (key.equals(((Entry<?, ?>) o).key) && value.equals(((Entry<?, ?>) o).value))
						: false;
	}
}