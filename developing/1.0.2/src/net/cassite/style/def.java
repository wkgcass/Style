package net.cassite.style;

import net.cassite.style.interfaces.*;

public class def<R> {
	private final int argCount;
	private final boolean hasReturnValue;

	public int argCount() {
		return argCount;
	}

	public boolean hasReturnValue() {
		return hasReturnValue;
	}

	private VFunc0 void0;
	private VFunc1<Object> void1;
	private VFunc2<Object, Object> void2;
	private VFunc3<Object, Object, Object> void3;
	private VFunc4<Object, Object, Object, Object> void4;
	private VFunc5<Object, Object, Object, Object, Object> void5;
	private VFunc6<Object, Object, Object, Object, Object, Object> void6;
	private VFunc7<Object, Object, Object, Object, Object, Object, Object> void7;

	private RFunc0<R> body0;
	private RFunc1<R, Object> body1;
	private RFunc2<R, Object, Object> body2;
	private RFunc3<R, Object, Object, Object> body3;
	private RFunc4<R, Object, Object, Object, Object> body4;
	private RFunc5<R, Object, Object, Object, Object, Object> body5;
	private RFunc6<R, Object, Object, Object, Object, Object, Object> body6;
	private RFunc7<R, Object, Object, Object, Object, Object, Object, Object> body7;

	def(VFunc0 body) {
		argCount = 0;
		this.void0 = body;
		this.hasReturnValue = false;
	}

	@SuppressWarnings("unchecked")
	def(VFunc1<?> body) {
		argCount = 1;
		this.void1 = (VFunc1<Object>) body;
		this.hasReturnValue = false;
	}

	@SuppressWarnings("unchecked")
	def(VFunc2<?, ?> body) {
		argCount = 2;
		this.void2 = (VFunc2<Object, Object>) body;
		this.hasReturnValue = false;
	}

	@SuppressWarnings("unchecked")
	def(VFunc3<?, ?, ?> body) {
		argCount = 3;
		this.void3 = (VFunc3<Object, Object, Object>) body;
		this.hasReturnValue = false;
	}

	@SuppressWarnings("unchecked")
	def(VFunc4<?, ?, ?, ?> body) {
		argCount = 4;
		this.void4 = (VFunc4<Object, Object, Object, Object>) body;
		this.hasReturnValue = false;
	}

	@SuppressWarnings("unchecked")
	def(VFunc5<?, ?, ?, ?, ?> body) {
		argCount = 5;
		this.void5 = (VFunc5<Object, Object, Object, Object, Object>) body;
		this.hasReturnValue = false;
	}

	@SuppressWarnings("unchecked")
	def(VFunc6<?, ?, ?, ?, ?, ?> body) {
		argCount = 6;
		this.void6 = (VFunc6<Object, Object, Object, Object, Object, Object>) body;
		this.hasReturnValue = false;
	}

	@SuppressWarnings("unchecked")
	def(VFunc7<?, ?, ?, ?, ?, ?, ?> body) {
		argCount = 7;
		this.void7 = (VFunc7<Object, Object, Object, Object, Object, Object, Object>) body;
		this.hasReturnValue = false;
	}

	def(RFunc0<R> body) {
		argCount = 0;
		this.body0 = body;
		this.hasReturnValue = true;
	}

	@SuppressWarnings("unchecked")
	def(RFunc1<R, ?> body) {
		argCount = 1;
		this.body1 = (RFunc1<R, Object>) body;
		this.hasReturnValue = true;
	}

	@SuppressWarnings("unchecked")
	def(RFunc2<R, ?, ?> body) {
		argCount = 2;
		this.body2 = (RFunc2<R, Object, Object>) body;
		this.hasReturnValue = true;
	}

	@SuppressWarnings("unchecked")
	def(RFunc3<R, ?, ?, ?> body) {
		argCount = 3;
		this.body3 = (RFunc3<R, Object, Object, Object>) body;
		this.hasReturnValue = true;
	}

	@SuppressWarnings("unchecked")
	def(RFunc4<R, ?, ?, ?, ?> body) {
		argCount = 4;
		this.body4 = (RFunc4<R, Object, Object, Object, Object>) body;
		this.hasReturnValue = true;
	}

	@SuppressWarnings("unchecked")
	def(RFunc5<R, ?, ?, ?, ?, ?> body) {
		argCount = 5;
		this.body5 = (RFunc5<R, Object, Object, Object, Object, Object>) body;
		this.hasReturnValue = true;
	}

	@SuppressWarnings("unchecked")
	def(RFunc6<R, ?, ?, ?, ?, ?, ?> body) {
		argCount = 6;
		this.body6 = (RFunc6<R, Object, Object, Object, Object, Object, Object>) body;
		this.hasReturnValue = true;
	}

	@SuppressWarnings("unchecked")
	def(RFunc7<R, ?, ?, ?, ?, ?, ?, ?> body) {
		argCount = 7;
		this.body7 = (RFunc7<R, Object, Object, Object, Object, Object, Object, Object>) body;
		this.hasReturnValue = true;
	}

	public R apply(Object... args) {
		try {
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
