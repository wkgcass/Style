package net.cassite.style;

import net.cassite.style.interfaces.RFunc0;
import net.cassite.style.interfaces.VFunc0;

public class SwitchBlock<T, R> extends Style {
	private final T toSwitch;
	private final def<Boolean> method;
	private R res;
	private boolean found = false;

	SwitchBlock(T t, def<Boolean> method) {
		this.toSwitch = t;
		this.method = method;
	}

	public SwitchBlock<T, R> Case(T ca, def<R> func) {
		if (!found) {
			if (method.apply(toSwitch, ca)) {
				res = func.apply();
				found = true;
			}
		}
		return this;
	}

	public SwitchBlock<T, R> Case(T ca, R res) {
		return Case(ca, () -> res);
	}

	@SuppressWarnings("unchecked")
	public SwitchBlock<T, R> Case(T ca, VFunc0 func) {
		return Case(ca, (def<R>) $(func));
	}

	public SwitchBlock<T, R> Case(T ca, RFunc0<R> func) {
		return Case(ca, (def<R>) $(func));
	}

	public R Default(def<R> func) {
		if (found) {
			return res;
		} else {
			return func.apply();
		}
	}

	@SuppressWarnings("unchecked")
	public R Default(VFunc0 func) {
		return Default((def<R>) $(func));
	}

	public R Default(RFunc0<R> func) {
		return Default((def<R>) $(func));
	}
}