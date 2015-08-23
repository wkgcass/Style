package net.cassite.style;

import java.lang.reflect.InvocationTargetException;

public class StyleRuntimeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3062353717153173710L;

	public StyleRuntimeException(Throwable t) {
		super(t);
	}

	public void throwIn(@SuppressWarnings("unchecked") Class<? extends Throwable>... classes) {
		for (Class<? extends Throwable> cls : classes) {
			if (cls.isInstance(getCause())) {
				throw this;
			}
		}
	}

	public void throwNotIn(@SuppressWarnings("unchecked") Class<? extends Throwable>... classes) {
		boolean toThrow = true;
		for (Class<? extends Throwable> cls : classes) {
			if (cls.isInstance(getCause())) {
				toThrow = false;
				break;
			}
		}
		if (toThrow) {
			throw this;
		}
	}

	public Throwable origin() {
		return super.getCause();
	}

	@Override
	public Throwable getCause() {
		Throwable target = super.getCause();
		if (target instanceof InvocationTargetException) {
			return ((InvocationTargetException) target).getTargetException();
		} else {
			return target.getCause();
		}
	}
}