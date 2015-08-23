package net.cassite.style;

public class ComparableFuncSup<T> {
	private Comparable<T> comparable;

	ComparableFuncSup(Comparable<T> comparable) {
		this.comparable = comparable;
	}

	public boolean gt(T o) {
		return comparable.compareTo(o) > 0;
	}

	public boolean lt(T o) {
		return comparable.compareTo(o) < 0;
	}

	public boolean ge(T o) {
		return comparable.compareTo(o) >= 0;
	}

	public boolean gte(T o) {
		return ge(o);
	}

	public boolean le(T o) {
		return comparable.compareTo(o) <= 0;
	}

	public boolean lte(T o) {
		return le(o);
	}

	public boolean eq(T o) {
		return comparable.compareTo(o) == 0;
	}

	public boolean ne(T o) {
		return !eq(o);
	}

	public boolean neq(T o) {
		return ne(o);
	}

	public int compareTo(T o) {
		return comparable.compareTo(o);
	}
}
