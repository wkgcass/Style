package net.cassite.style;

public class ptr<T> {
	public T item;

	ptr(T o) {
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
