package net.cassite.style;

import java.util.List;
import java.util.ListIterator;

import net.cassite.style.interfaces.*;
import net.cassite.style.control.*;

public class ListFuncSup<T> extends CollectionFuncSup<T> {
	ListFuncSup(List<T> collection) {
		super(collection);
	}

	public void toSelf(RFunc1<T, T> func) {
		toSelf($(func));
	}

	public void toSelf(def<T> func) {
		$((List<T>) iterable).forEach(e -> {
			return Set(func.apply(e));
		});
	}

	@SuppressWarnings("unchecked")
	public <R> R forEach(VFunc1<T> func, int index) {
		return (R) forEach($(func), index);
	}

	@SuppressWarnings("unchecked")
	public <R> R forEach(VFunc2<T, IteratorInfo<R>> func, int index) {
		return (R) forEach($(func), index);
	}

	public <R> R forEach(RFunc1<R, T> func, int index) {
		return forEach($(func), index);
	}

	public <R> R forEach(RFunc2<R, T, IteratorInfo<R>> func, int index) {
		return forEach($(func), index);
	}

	public <R> R forEach(def<R> func, int index) {
		return forThose($.alwaysTrue(), func, index);
	}

	@SuppressWarnings("unchecked")
	public <R> R forThose(RFunc1<Boolean, T> predicate, VFunc1<T> func, int index) {
		return (R) forThose(predicate, $(func), index);
	}

	@SuppressWarnings("unchecked")
	public <R> R forThose(RFunc1<Boolean, T> predicate, VFunc2<T, IteratorInfo<R>> func, int index) {
		return (R) forThose(predicate, $(func), index);
	}

	public <R> R forThose(RFunc1<Boolean, T> predicate, RFunc1<R, T> func, int index) {
		return (R) forThose(predicate, $(func), index);
	}

	public <R> R forThose(RFunc1<Boolean, T> predicate, RFunc2<R, T, IteratorInfo<R>> func, int index) {
		return (R) forThose(predicate, $(func), index);
	}

	@Override
	public <R> R forThose(RFunc1<Boolean, T> predicate, def<R> func) {
		return (R) forThose(predicate, func, 0);
	}

	public <R> R forThose(RFunc1<Boolean, T> predicate, def<R> func, int index) {
		ListIterator<T> it = ((List<T>) iterable).listIterator(index);
		IteratorInfo<R> info = new IteratorInfo<R>();
		return While(() -> it.hasNext(), (loopInfo) -> {
			int previousIndex = it.previousIndex();
			int nextIndex = it.nextIndex();
			boolean hasPrevious = it.hasPrevious();
			boolean hasNext = it.hasNext();
			T t = it.next();
			try {
				return If(predicate.apply(t), () -> {
					if (func.argCount() == 2)
						return func.apply(t,
								info.setValues(previousIndex, nextIndex, hasPrevious,
										hasNext, loopInfo.currentIndex, loopInfo.effectiveIndex, loopInfo.lastRes));
					else
						return func.apply(t);
				}).Else(() -> null);
			} catch (Throwable err) {
				StyleRuntimeException sErr = $(err);
				Throwable throwable = sErr.origin();
				if (throwable instanceof Add) {
					it.add(((Add) throwable).getAdd());
				} else if (throwable instanceof $Set) {
					it.set((($Set) throwable).getSet());
				} else if (throwable instanceof Remove) {
					it.remove();
				} else {
					throw sErr;
				}
			}
			return null;
		});
	}
}