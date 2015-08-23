package net.cassite.style;

import java.util.ArrayList;
import java.util.Collection;

import net.cassite.style.interfaces.RFunc1;
import net.cassite.style.interfaces.RFunc2;
import net.cassite.style.interfaces.VFunc1;
import net.cassite.style.interfaces.VFunc2;

public interface A1FuncSup<T> extends var {
	@SuppressWarnings("unchecked")
	default <R> R forEach(VFunc1<T> func) {
		return (R) forEach($(func));
	}

	@SuppressWarnings("unchecked")
	default <R> R forEach(VFunc2<T, IteratorInfo<R>> func) {
		return (R) forEach($(func));
	}

	default <R> R forEach(RFunc1<R, T> func) {
		return forEach($(func));
	}

	default <R> R forEach(RFunc2<R, T, IteratorInfo<R>> func) {
		return forEach($(func));
	}

	default <R> R forEach(def<R> func) {
		return forThose($.alwaysTrue(), func);
	}

	@SuppressWarnings("unchecked")
	default <R> R forThose(RFunc1<Boolean,T> predicate, VFunc1<T> func) {
		return (R) forThose(predicate, $(func));
	}

	@SuppressWarnings("unchecked")
	default <R> R forThose(RFunc1<Boolean,T> predicate, VFunc2<T, IteratorInfo<R>> func) {
		return (R) forThose(predicate, $(func));
	}

	default <R> R forThose(RFunc1<Boolean,T> predicate, RFunc1<R, T> func) {
		return forThose(predicate, $(func));
	}

	default <R> R forThose(RFunc1<Boolean,T> predicate, RFunc2<R, T, IteratorInfo<R>> func) {
		return forThose(predicate, $(func));
	}

	<R> R forThose(RFunc1<Boolean, T> predicate, def<R> func);

	T first();

	default T findOne(RFunc1<Boolean, T> filter) {
		return findOne($(filter));
	}

	default T findOne(def<Boolean> filter) {
		return $(findAll(filter, new ArrayList<>(1), 1)).first();
	}

	default Collection<T> findAll(RFunc1<Boolean, T> filter) {
		return findAll($(filter));
	}

	default Collection<T> findAll(def<Boolean> filter) {
		return findAll(filter, new ArrayList<>());
	}

	default <Coll extends Collection<T>> Coll findAll(RFunc1<Boolean, T> filter, Coll toColl) {
		return findAll($(filter), toColl);
	}

	default <Coll extends Collection<T>> Coll findAll(def<Boolean> filter, Coll toColl) {
		return findAll(filter, toColl, 0);
	}

	default <Coll extends Collection<T>> Coll findAll(RFunc1<Boolean, T> filter, Coll toColl, int limit) {
		return findAll($(filter), toColl, limit);
	}

	<Coll extends Collection<T>> Coll findAll(def<Boolean> filter, Coll toColl, int limit);

	<R, Coll extends Collection<R>> A1Transformer<R, T, Coll> to(Coll collection);

	<R> A1ArrTransformer<R, T> to(R[] arr);

	int size();
}
