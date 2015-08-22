package net.cassite.style;

public abstract class val<T> {
	public T item;

	val(T o) {
		this.item = o;
	}

	@Override
	public int hashCode() {
		return item.hashCode();
	}

	@Override
	public String toString() {
		return item.toString();
	}

	@Override
	public boolean equals(Object another) {
		return item.equals(another);
	}
}
