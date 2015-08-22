package net.cassite.style;

import net.cassite.style.interfaces.R0ArgInterface;
import net.cassite.style.interfaces.R1ArgInterface;
import net.cassite.style.interfaces.R2ArgsInterface;
import net.cassite.style.interfaces.R3ArgsInterface;
import net.cassite.style.interfaces.R4ArgsInterface;
import net.cassite.style.interfaces.R5ArgsInterface;
import net.cassite.style.interfaces.R6ArgsInterface;
import net.cassite.style.interfaces.R7ArgsInterface;
import net.cassite.style.interfaces.RNArgsInterface;
import net.cassite.style.interfaces.Void0ArgInterface;
import net.cassite.style.interfaces.Void1ArgInterface;
import net.cassite.style.interfaces.Void2ArgInterface;
import net.cassite.style.interfaces.Void3ArgInterface;
import net.cassite.style.interfaces.Void4ArgInterface;
import net.cassite.style.interfaces.Void5ArgInterface;
import net.cassite.style.interfaces.Void6ArgInterface;
import net.cassite.style.interfaces.Void7ArgInterface;
import net.cassite.style.interfaces.VoidNArgInterface;

public abstract class def<R> {
	public static final int ARG_UNDEFINED = -1;
	private final int argCount;
	private final boolean hasReturnValue;

	public int argCount() {
		return argCount;
	}

	public boolean hasReturnValue() {
		return hasReturnValue;
	}

	private VoidNArgInterface voidN;
	private Void0ArgInterface void0;
	private Void1ArgInterface<Object> void1;
	private Void2ArgInterface<Object, Object> void2;
	private Void3ArgInterface<Object, Object, Object> void3;
	private Void4ArgInterface<Object, Object, Object, Object> void4;
	private Void5ArgInterface<Object, Object, Object, Object, Object> void5;
	private Void6ArgInterface<Object, Object, Object, Object, Object, Object> void6;
	private Void7ArgInterface<Object, Object, Object, Object, Object, Object, Object> void7;

	private RNArgsInterface<R> body;
	private R0ArgInterface<R> body0;
	private R1ArgInterface<R, Object> body1;
	private R2ArgsInterface<R, Object, Object> body2;
	private R3ArgsInterface<R, Object, Object, Object> body3;
	private R4ArgsInterface<R, Object, Object, Object, Object> body4;
	private R5ArgsInterface<R, Object, Object, Object, Object, Object> body5;
	private R6ArgsInterface<R, Object, Object, Object, Object, Object, Object> body6;
	private R7ArgsInterface<R, Object, Object, Object, Object, Object, Object, Object> body7;

	def(VoidNArgInterface body) {
		argCount = ARG_UNDEFINED;
		this.voidN = body;
		this.hasReturnValue = false;
	}

	def(Void0ArgInterface body) {
		argCount = 0;
		this.void0 = body;
		this.hasReturnValue = false;
	}

	@SuppressWarnings("unchecked")
	def(Void1ArgInterface<?> body) {
		argCount = 1;
		this.void1 = (Void1ArgInterface<Object>) body;
		this.hasReturnValue = false;
	}

	@SuppressWarnings("unchecked")
	def(Void2ArgInterface<?, ?> body) {
		argCount = 2;
		this.void2 = (Void2ArgInterface<Object, Object>) body;
		this.hasReturnValue = false;
	}

	@SuppressWarnings("unchecked")
	def(Void3ArgInterface<?, ?, ?> body) {
		argCount = 3;
		this.void3 = (Void3ArgInterface<Object, Object, Object>) body;
		this.hasReturnValue = false;
	}

	@SuppressWarnings("unchecked")
	def(Void4ArgInterface<?, ?, ?, ?> body) {
		argCount = 4;
		this.void4 = (Void4ArgInterface<Object, Object, Object, Object>) body;
		this.hasReturnValue = false;
	}

	@SuppressWarnings("unchecked")
	def(Void5ArgInterface<?, ?, ?, ?, ?> body) {
		argCount = 5;
		this.void5 = (Void5ArgInterface<Object, Object, Object, Object, Object>) body;
		this.hasReturnValue = false;
	}

	@SuppressWarnings("unchecked")
	def(Void6ArgInterface<?, ?, ?, ?, ?, ?> body) {
		argCount = 6;
		this.void6 = (Void6ArgInterface<Object, Object, Object, Object, Object, Object>) body;
		this.hasReturnValue = false;
	}

	@SuppressWarnings("unchecked")
	def(Void7ArgInterface<?, ?, ?, ?, ?, ?, ?> body) {
		argCount = 7;
		this.void7 = (Void7ArgInterface<Object, Object, Object, Object, Object, Object, Object>) body;
		this.hasReturnValue = false;
	}

	def(RNArgsInterface<R> body) {
		argCount = ARG_UNDEFINED;
		this.body = body;
		this.hasReturnValue = true;
	}

	def(R0ArgInterface<R> body) {
		argCount = 0;
		this.body0 = body;
		this.hasReturnValue = true;
	}

	@SuppressWarnings("unchecked")
	def(R1ArgInterface<R, ?> body) {
		argCount = 1;
		this.body1 = (R1ArgInterface<R, Object>) body;
		this.hasReturnValue = true;
	}

	@SuppressWarnings("unchecked")
	def(R2ArgsInterface<R, ?, ?> body) {
		argCount = 2;
		this.body2 = (R2ArgsInterface<R, Object, Object>) body;
		this.hasReturnValue = true;
	}

	@SuppressWarnings("unchecked")
	def(R3ArgsInterface<R, ?, ?, ?> body) {
		argCount = 3;
		this.body3 = (R3ArgsInterface<R, Object, Object, Object>) body;
		this.hasReturnValue = true;
	}

	@SuppressWarnings("unchecked")
	def(R4ArgsInterface<R, ?, ?, ?, ?> body) {
		argCount = 4;
		this.body4 = (R4ArgsInterface<R, Object, Object, Object, Object>) body;
		this.hasReturnValue = true;
	}

	@SuppressWarnings("unchecked")
	def(R5ArgsInterface<R, ?, ?, ?, ?, ?> body) {
		argCount = 5;
		this.body5 = (R5ArgsInterface<R, Object, Object, Object, Object, Object>) body;
		this.hasReturnValue = true;
	}

	@SuppressWarnings("unchecked")
	def(R6ArgsInterface<R, ?, ?, ?, ?, ?, ?> body) {
		argCount = 6;
		this.body6 = (R6ArgsInterface<R, Object, Object, Object, Object, Object, Object>) body;
		this.hasReturnValue = true;
	}

	@SuppressWarnings("unchecked")
	def(R7ArgsInterface<R, ?, ?, ?, ?, ?, ?, ?> body) {
		argCount = 7;
		this.body7 = (R7ArgsInterface<R, Object, Object, Object, Object, Object, Object, Object>) body;
		this.hasReturnValue = true;
	}

	public R apply(Object... args) {
		try {
			if (body != null) {
				return body.invoke(args);
			}
			if (voidN != null) {
				voidN.accept(args);
				return null;
			}
			if (args.length == 0) {
				if (body0 == null) {
					void0.invoke();
					return null;
				} else {
					return body0.apply();
				}
			} else if (args.length == 1) {
				if (body1 == null) {
					void1.accept(args[0]);
					return null;
				} else {
					return body1.apply(args[0]);
				}
			} else if (args.length == 2) {
				if (body2 == null) {
					void2.accept(args[0], args[1]);
					return null;
				} else {
					return body2.apply(args[0], args[1]);
				}
			} else if (args.length == 3) {
				if (body3 == null) {
					void3.accept(args[0], args[1], args[2]);
					return null;
				} else {
					return body3.apply(args[0], args[1], args[2]);
				}
			} else if (args.length == 4) {
				if (body4 == null) {
					void4.accept(args[0], args[1], args[2], args[3]);
					return null;
				} else {
					return body4.apply(args[0], args[1], args[2], args[3]);
				}
			} else if (args.length == 5) {
				if (body5 == null) {
					void5.accept(args[0], args[1], args[2], args[3], args[4]);
					return null;
				} else {
					return body5.apply(args[0], args[1], args[2], args[3], args[4]);
				}
			} else if (args.length == 6) {
				if (body6 == null) {
					void6.accept(args[0], args[1], args[2], args[3], args[4], args[5]);
					return null;
				} else {
					return body6.apply(args[0], args[1], args[2], args[3], args[4], args[5]);
				}
			} else if (args.length == 7) {
				if (body7 == null) {
					void7.accept(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
					return null;
				} else {
					return body7.apply(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
				}
			} else {
				throw new IllegalArgumentException();
			}
		} catch (Throwable t) {
			throw Style.$(t);
		}
	}

	public Async<R> async(Object... args) {
		return new Async<R>(this, args);
	}
}
