package net.cassite.style;

import net.cassite.style.interfaces.RFunc0;
import net.cassite.style.interfaces.RFunc1;
import net.cassite.style.interfaces.VFunc0;
import net.cassite.style.interfaces.VFunc1;

public class IfBlock<T, INIT> extends Style {
	private def<T> body;
	private final boolean procceed;
	private T val;

	private INIT initVal;

	IfBlock(RFunc0<INIT> initVal, def<T> body) {
		try {
			this.initVal = initVal.apply();
		} catch (Throwable e) {
			throw $(e);
		}
		this.body = body;
		procceed = true;
	}

	private IfBlock(T val) {
		this.val = val;
		procceed = false;
	}

	public T Else(T value) {
		return Else(() -> value);
	}

	@SuppressWarnings("unchecked")
	public T Else(VFunc0 func) {
		return Else((def<T>) $(func));
	}

	public T Else(RFunc0<T> func) {
		return Else($(func));
	}

	public T Else(def<T> func) {
		if (procceed)
			if (initVal != null && !initVal.equals(false)) {
				return body.apply(initVal);
			} else {
				return func.apply();
			}
		else
			return this.val;
	}

	public IfBlock<T, INIT> ElseIf(INIT init, T val) {
		return ElseIf(() -> init, () -> val);
	}

	@SuppressWarnings("unchecked")
	public IfBlock<T, INIT> ElseIf(INIT init, VFunc1<INIT> body) {
		return ElseIf(() -> init, (def<T>) $(body));
	}

	public IfBlock<T, INIT> ElseIf(INIT init, RFunc1<T, INIT> body) {
		return ElseIf(() -> init, $(body));
	}

	@SuppressWarnings("unchecked")
	public IfBlock<T, INIT> ElseIf(INIT init, VFunc0 body) {
		return ElseIf(() -> init, (def<T>) $(body));
	}

	public IfBlock<T, INIT> ElseIf(INIT init, RFunc0<T> body) {
		return ElseIf(() -> init, $(body));
	}

	public IfBlock<T, INIT> ElseIf(RFunc0<INIT> init, T val) {
		return ElseIf(init, () -> val);
	}

	@SuppressWarnings("unchecked")
	public IfBlock<T, INIT> ElseIf(RFunc0<INIT> init, VFunc1<INIT> body) {
		return ElseIf(init, (def<T>) $(body));
	}

	public IfBlock<T, INIT> ElseIf(RFunc0<INIT> init, RFunc1<T, INIT> body) {
		return ElseIf(init, $(body));
	}

	@SuppressWarnings("unchecked")
	public IfBlock<T, INIT> ElseIf(RFunc0<INIT> init, VFunc0 body) {
		return ElseIf(init, (def<T>) $(body));
	}

	public IfBlock<T, INIT> ElseIf(RFunc0<INIT> init, RFunc0<T> body) {
		return ElseIf(init, $(body));
	}

	public IfBlock<T, INIT> ElseIf(RFunc0<INIT> init, def<T> body) {
		if (procceed)
			if (initVal != null && !initVal.equals(false)) {
				return new IfBlock<T, INIT>(this.body.apply(initVal));
			} else {
				return new IfBlock<T, INIT>(init, body);
			}
		else
			return new IfBlock<T, INIT>(this.val);
	}

	public T End() {
		if (procceed)
			if (initVal != null && !initVal.equals(false)) {
				return body.apply(initVal);
			} else {
				return null;
			}
		else
			return this.val;
	}

}