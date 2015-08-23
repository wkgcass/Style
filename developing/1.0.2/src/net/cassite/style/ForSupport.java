package net.cassite.style;

import net.cassite.style.interfaces.*;

public class ForSupport<N extends Number> extends Style {
	private N start;

	ForSupport(N start) {
		this.start = start;
	}

	public ToSupport<N> to(N end) {
		return new ToSupport<>(start, end);
	}

	public static class ToSupport<N extends Number> {
		private N start;
		private N end;
		private N step;

		ToSupport(N start, N end) {
			this.start = start;
			this.end = end;
		}

		public ToSupport<N> step(N s) {
			this.step = s;
			return this;
		}

		@SuppressWarnings("unchecked")
		public <R, T extends N> R loop(VFunc1<T> doLoop) {
			return (R) loop($(doLoop));
		}

		public <R, T extends N> R loop(RFunc1<R, T> doLoop) {
			return loop($(doLoop));
		}

		@SuppressWarnings("unchecked")
		public <R, T extends N> R loop(VFunc2<T, LoopInfo<R>> doLoop) {
			return (R) loop($(doLoop));
		}

		public <R, T extends N> R loop(RFunc2<R, T, LoopInfo<R>> doLoop) {
			return loop($(doLoop));
		}

		@SuppressWarnings("unchecked")
		public <R> R loop(def<R> doLoop) {
			if (start instanceof Integer) {
				if (((Integer) start).compareTo((Integer) end) > 0) {
					if (null == step) {
						step = (N) new Integer(-1);
					}
					return For((Integer) start, i -> i.compareTo((Integer) end) >= 0, i -> i + (Integer) step, doLoop);
				} else {
					if (null == step) {
						step = (N) new Integer(1);
					}
					return For((Integer) start, i -> i.compareTo((Integer) end) <= 0, i -> i + (Integer) step, doLoop);
				}
			} else if (start instanceof Double) {
				if (((Double) start).compareTo((Double) end) > 0) {
					if (null == step) {
						step = (N) new Double(-1);
					}
					return For((Double) start, i -> i.compareTo((Double) end) >= 0, i -> i + (Double) step, doLoop);
				} else {
					if (null == step) {
						step = (N) new Double(1);
					}
					return For((Double) start, i -> i.compareTo((Double) end) <= 0, i -> i + (Double) step, doLoop);
				}
			} else if (start instanceof Long) {
				if (((Long) start).compareTo((Long) end) > 0) {
					if (null == step) {
						step = (N) new Long(-1);
					}
					return For((Long) start, i -> i.compareTo((Long) end) >= 0, i -> i + (Long) step, doLoop);
				} else {
					if (null == step) {
						step = (N) new Long(1);
					}
					return For((Long) start, i -> i.compareTo((Long) end) <= 0, i -> i + (Long) step, doLoop);
				}
			} else if (start instanceof Short) {
				if (((Short) start).compareTo((Short) end) > 0) {
					if (null == step) {
						step = (N) new Short((short) -1);
					}
					return For((Short) start, i -> i.compareTo((Short) end) >= 0,
							i -> (short) (i.shortValue() + step.shortValue()), doLoop);
				} else {
					if (null == step) {
						step = (N) new Short((short) 1);
					}
					return For((Short) start, i -> i.compareTo((Short) end) <= 0,
							i -> (short) (i.shortValue() + step.shortValue()), doLoop);
				}
			} else if (start instanceof Float) {
				if (((Float) start).compareTo((Float) end) > 0) {
					if (null == step) {
						step = (N) new Float(-1);
					}
					return For((Float) start, i -> i.compareTo((Float) end) >= 0, i -> i + (Float) step, doLoop);
				} else {
					if (null == step) {
						step = (N) new Float(1);
					}
					return For((Float) start, i -> i.compareTo((Float) end) <= 0, i -> i + (Float) step, doLoop);
				}
			} else if (start instanceof Byte) {
				if (((Byte) start).compareTo((Byte) end) > 0) {
					if (null == step) {
						step = (N) new Byte((byte) -1);
					}
					return For((Byte) start, i -> i.compareTo((Byte) end) >= 0,
							i -> (byte) (i.byteValue() + step.byteValue()), doLoop);
				} else {
					if (null == step) {
						step = (N) new Byte((byte) 1);
					}
					return For((Byte) start, i -> i.compareTo((Byte) end) <= 0,
							i -> (byte) (i.byteValue() + step.byteValue()), doLoop);
				}
			} else {
				throw new IllegalArgumentException();
			}
		}
	}
}