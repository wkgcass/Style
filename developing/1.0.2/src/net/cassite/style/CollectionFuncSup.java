package net.cassite.style;

import java.util.Collection;

public class CollectionFuncSup<T> extends IterableFuncSup<T> {
	CollectionFuncSup(Collection<T> collection) {
		super(collection);
	}

	@SuppressWarnings("unchecked")
	public <Coll extends CollectionFuncSup<T>> Coll add(T t) {
		Collection<T> coll = (Collection<T>) iterable;
		coll.add(t);
		return (Coll) this;
	}

	@Override
	public int size() {
		return ((Collection<T>) iterable).size();
	}
}