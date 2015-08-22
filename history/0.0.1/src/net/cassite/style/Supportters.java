package net.cassite.style;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.function.Predicate;

import net.cassite.style.control.Add;
import net.cassite.style.control.Break;
import net.cassite.style.control.Continue;
import net.cassite.style.control.Previous;
import net.cassite.style.control.Remove;
import net.cassite.style.control.$Set;
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

public class Supportters extends Style {
	public static class ArrayFuncSup<T> {
		private final T[] array;

		ArrayFuncSup(T[] array) {
			this.array = array;
		}

		public void forEach(Void1ArgInterface<T> func) {
			forEach($(func));
		}

		public void forEach(function<Object> func) {
			for (T t : array) {
				try {
					func.apply(t);
				} catch (Throwable throwable) {
					if (throwable instanceof StyleRuntimeException) {
						Throwable origin = ((StyleRuntimeException) throwable).origin();
						if (origin instanceof Break) {
							break;
						} else if (origin instanceof Continue) {
							continue;
						} else {
							throw ((StyleRuntimeException) throwable);
						}
					} else {
						throw $(throwable);
					}
				}
			}
		}

		public void toSelf(R1ArgInterface<T, T> func) {
			toSelf($(func));
		}

		public void toSelf(function<T> func) {
			for (int i = 0; i < array.length; ++i) {
				try {
					array[i] = func.apply(array[i]);
				} catch (Throwable throwable) {
					if (throwable instanceof StyleRuntimeException) {
						Throwable origin = ((StyleRuntimeException) throwable).origin();
						if (origin instanceof Break) {
							break;
						} else if (origin instanceof Continue) {
							continue;
						} else {
							throw ((StyleRuntimeException) throwable);
						}
					} else {
						throw $(throwable);
					}
				}
			}
		}

		public void forThose(Predicate<T> predicate, Void1ArgInterface<T> func) {
			forThose(predicate, $(func));
		}

		public void forThose(Predicate<T> predicate, function<Object> func) {
			for (T t : array) {
				try {
					if (predicate.test(t))
						func.apply(t);
				} catch (Throwable throwable) {
					if (throwable instanceof StyleRuntimeException) {
						Throwable origin = ((StyleRuntimeException) throwable).origin();
						if (origin instanceof Break) {
							break;
						} else if (origin instanceof Continue) {
							continue;
						} else {
							throw ((StyleRuntimeException) throwable);
						}
					} else {
						throw $(throwable);
					}
				}
			}
		}

		public T first() {
			return array[0];
		}

		public <R, Coll extends Collection<R>> Tramsformer<R, T, Coll> to(Coll collection) {
			return new Tramsformer<>(array, collection);
		}

		public static class Tramsformer<R, T, Coll extends Collection<R>> {
			private final Coll collection;
			private final T[] array;

			Tramsformer(T[] array, Coll collection) {
				this.array = array;
				this.collection = collection;
			}

			public Coll via(R1ArgInterface<R, T> method) {
				return via($(method));
			}

			public Coll via(function<R> method) {
				for (T t : array) {
					R ret;
					try {
						ret = method.apply(t);
					} catch (Throwable e) {
						if (e instanceof StyleRuntimeException) {
							Throwable origin = ((StyleRuntimeException) e).origin();
							if (origin instanceof Break) {
								break;
							} else if (origin instanceof Continue) {
								continue;
							} else {
								throw ((StyleRuntimeException) e);
							}
						} else {
							throw $(e);
						}
					}
					collection.add(ret);
				}
				return collection;
			}
		}
	}

	public static class IterableFuncSup<T> {
		public final Iterable<T> iterable;

		IterableFuncSup(Iterable<T> iterable) {
			this.iterable = iterable;
		}

		public void forEach(Void1ArgInterface<T> func) {
			forEach($(func));
		}

		public void forEach(function<Object> func) {
			forThose($.alwaysTrue(), func);
		}

		public void forThose(Predicate<T> predicate, Void1ArgInterface<T> func) {
			forThose(predicate, $(func));
		}

		public void forThose(Predicate<T> predicate, function<Object> func) {
			Iterator<T> it = iterable.iterator();
			while (it.hasNext()) {
				try {
					T t = it.next();
					if (predicate.test(t))
						func.apply(t);
				} catch (Throwable throwable) {
					if (throwable instanceof StyleRuntimeException) {
						Throwable origin = ((StyleRuntimeException) throwable).origin();
						if (origin instanceof Break) {
							break;
						} else if (origin instanceof Continue) {
							continue;
						} else if (origin instanceof Remove) {
							it.remove();
						} else {
							throw ((StyleRuntimeException) throwable);
						}
					} else {
						throw $(throwable);
					}
				}
			}
		}

		public T first() {
			return iterable.iterator().next();
		}

		public <R, Coll extends Collection<R>> Tramsformer<R, T, Coll> to(Coll collection) {
			return new Tramsformer<>(iterable, collection);
		}

		public static class Tramsformer<R, T, Coll extends Collection<R>> {
			protected final Coll collection;
			protected final Iterable<T> iterable;

			Tramsformer(Iterable<T> iterable, Coll collection) {
				this.iterable = iterable;
				this.collection = collection;
			}

			public Coll via(R1ArgInterface<R, T> method) {
				return via($(method));
			}

			public Coll via(function<R> method) {
				for (T t : iterable) {
					R ret;
					try {
						ret = method.apply(t);
					} catch (Throwable e) {
						if (e instanceof StyleRuntimeException) {
							Throwable origin = ((StyleRuntimeException) e).origin();
							if (origin instanceof Break) {
								break;
							} else if (origin instanceof Continue) {
								continue;
							} else {
								throw ((StyleRuntimeException) e);
							}
						} else {
							throw $(e);
						}
					}
					collection.add(ret);
				}
				return collection;
			}
		}
	}

	public static class CollectionFuncSup<T> extends IterableFuncSup<T> {
		CollectionFuncSup(Collection<T> collection) {
			super(collection);
		}

		@SuppressWarnings("unchecked")
		public <Coll extends CollectionFuncSup<T>> Coll add(T t) {
			Collection<T> coll = (Collection<T>) iterable;
			coll.add(t);
			return (Coll) this;
		}
	}

	public static class ListFuncSup<T> extends CollectionFuncSup<T> {
		ListFuncSup(List<T> collection) {
			super(collection);
		}

		public static class ListIteratorInfo {
			public final int previousIndex;
			public final int nextIndex;
			public final boolean hasPrevious;
			public final boolean hasNext;

			ListIteratorInfo(int previousIndex, int nextIndex, boolean hasPrevious, boolean hasNext) {
				this.previousIndex = previousIndex;
				this.nextIndex = nextIndex;
				this.hasPrevious = hasPrevious;
				this.hasNext = hasNext;
			}
		}

		public void toSelf(R1ArgInterface<T, T> func) {
			toSelf($(func));
		}

		public void toSelf(function<T> func) {
			ListIterator<T> it = ((List<T>) iterable).listIterator();
			while (it.hasNext()) {
				T t = it.next();
				try {
					it.set(func.apply(t));
				} catch (Throwable throwable) {
					if (throwable instanceof StyleRuntimeException) {
						Throwable origin = ((StyleRuntimeException) throwable).origin();
						if (origin instanceof Break) {
							break;
						} else if (origin instanceof Continue) {
							continue;
						} else if (origin instanceof Remove) {
							it.remove();
						} else {
							throw ((StyleRuntimeException) throwable);
						}
					} else {
						throw $(throwable);
					}
				}
			}
		}

		public void forEach(Void1ArgInterface<T> func) {
			forEach($(func));
		}

		public void forEach(Void1ArgInterface<T> func, int index) {
			forEach($(func), index);
		}

		public void forEach(function<Object> func, int index) {
			forThose($.alwaysTrue(), func, index);
		}

		public void forThose(Predicate<T> predicate, Void1ArgInterface<T> func, int index) {
			forThose(predicate, $(func), index);
		}

		public void forThose(Predicate<T> predicate, Void2ArgInterface<T, ListIteratorInfo> func) {
			forThose(predicate, $(func));
		}

		public void forThose(Predicate<T> predicate, Void2ArgInterface<T, ListIteratorInfo> func, int index) {
			forThose(predicate, $(func), index);
		}

		@Override
		public void forThose(Predicate<T> predicate, function<Object> func) {
			forThose(predicate, func, 0);
		}

		public void forThose(Predicate<T> predicate, function<Object> func, int index) {
			ListIterator<T> it = ((List<T>) iterable).listIterator(index);
			T t;
			if (it.hasNext()) {
				t = it.next();
			} else {
				t = null;
			}
			while (it.hasNext()) {
				try {
					if (predicate.test(t)) {
						if (func.argCount() == function.ARG_UNDEFINED || func.argCount() == 2) {
							ListIteratorInfo info = new ListIteratorInfo(it.previousIndex(), it.nextIndex(),
									it.hasPrevious(), it.hasNext());
							func.apply(t, info);
						} else
							func.apply(t);
					}
					t = it.next();
				} catch (Throwable e) {
					if (e instanceof StyleRuntimeException) {
						Throwable origin = ((StyleRuntimeException) e).origin();
						if (origin instanceof Break) {
							break;
						} else if (origin instanceof Continue) {
							t = it.next();
							continue;
						} else if (origin instanceof Add) {
							it.add(((Add) origin).getAdd());
						} else if (origin instanceof Previous) {
							t = it.previous();
						} else if (origin instanceof $Set) {
							it.set((($Set) origin).getSet());
							t = it.next();
						} else {
							throw ((StyleRuntimeException) e);
						}
					} else {
						throw $(e);
					}
				}
			}
		}
	}

	public static class MapFuncSup<K, V> {
		private Map<K, V> map;

		MapFuncSup(Map<K, V> map) {
			this.map = map;
		}

		public void forEach(Void2ArgInterface<K, V> func) {
			forEach(Style.$(func));
		}

		public void forEach(function<Object> func) {
			Iterator<K> it = map.keySet().iterator();
			while (it.hasNext()) {
				K k = it.next();
				try {
					func.apply(k, map.get(k));
				} catch (Throwable throwable) {
					if (throwable instanceof StyleRuntimeException) {
						Throwable origin = ((StyleRuntimeException) throwable).origin();
						if (origin instanceof Break) {
							break;
						} else if (origin instanceof Continue) {
							continue;
						} else if (origin instanceof Remove) {
							it.remove();
						} else {
							throw ((StyleRuntimeException) throwable);
						}
					} else {
						throw Style.$(throwable);
					}
				}
			}
		}

		public void forThose(R2ArgsInterface<Boolean, K, V> predicate, Void2ArgInterface<K, V> func) {
			forThose(predicate, Style.$(func));
		}

		public void forThose(R2ArgsInterface<Boolean, K, V> predicate, function<Object> func) {
			Iterator<K> it = map.keySet().iterator();
			while (it.hasNext()) {
				K k = it.next();
				V v = map.get(k);
				try {
					if (predicate.apply(k, v))
						func.apply(k, v);
				} catch (Throwable throwable) {
					if (throwable instanceof StyleRuntimeException) {
						Throwable origin = ((StyleRuntimeException) throwable).origin();
						if (origin instanceof Break) {
							break;
						} else if (origin instanceof Continue) {
							continue;
						} else if (origin instanceof Remove) {
							it.remove();
						} else {
							throw ((StyleRuntimeException) throwable);
						}
					} else {
						throw Style.$(throwable);
					}
				}
			}
		}

		public MapFuncSup<K, V> append(K key, V value) {
			map.put(key, value);
			return this;
		}

		public static class TransformerColl<K, V, R, Coll extends Collection<R>> {
			private Map<K, V> map;
			private Coll collection;

			TransformerColl(Map<K, V> map, Coll collection) {
				this.map = map;
				this.collection = collection;
			}

			public Coll via(R2ArgsInterface<R, K, V> method) {
				return via(Style.$(method));
			}

			public Coll via(function<R> method) {
				for (K key : map.keySet()) {
					try {
						R val = method.apply(key, map.get(key));
						collection.add(val);
					} catch (Throwable e) {
						if (e instanceof StyleRuntimeException) {
							Throwable origin = ((StyleRuntimeException) e).origin();
							if (origin instanceof Break) {
								break;
							} else if (origin instanceof Continue) {
								continue;
							} else {
								throw ((StyleRuntimeException) e);
							}
						} else {
							throw Style.$(e);
						}
					}
				}
				return collection;
			}
		}

		public <R, Coll extends Collection<R>> TransformerColl<K, V, R, Coll> to(Coll collection) {
			return new TransformerColl<K, V, R, Coll>(map, collection);
		}

		public static class TransformerMap<K, V, K2, V2, M extends Map<K2, V2>> {
			private Map<K, V> map;
			private M toMap;

			TransformerMap(Map<K, V> map, M toMap) {
				this.map = map;
				this.toMap = toMap;
			}

			public M via(R2ArgsInterface<Entry<K2, V2>, K, V> method) {
				return via(Style.$(method));
			}

			public M via(function<Entry<K2, V2>> method) {
				for (K key : map.keySet()) {
					try {
						Entry<K2, V2> val = method.apply(key, map.get(key));
						toMap.put(val.key, val.value);
					} catch (Throwable e) {
						if (e instanceof StyleRuntimeException) {
							Throwable origin = ((StyleRuntimeException) e).origin();
							if (origin instanceof Break) {
								break;
							} else if (origin instanceof Continue) {
								continue;
							} else {
								throw ((StyleRuntimeException) e);
							}
						} else {
							throw Style.$(e);
						}
					}
				}
				return toMap;
			}
		}

		public <K2, V2, M extends Map<K2, V2>> TransformerMap<K, V, K2, V2, M> to(M m) {
			return new TransformerMap<K, V, K2, V2, M>(map, m);
		}

		public V $(K key) {
			return map.get(key);
		}
	}

	public static class function<R> {
		public static final int ARG_UNDEFINED = -1;
		private final int argCount;

		public int argCount() {
			return argCount;
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

		function(VoidNArgInterface body) {
			argCount = ARG_UNDEFINED;
			this.voidN = body;
		}

		function(Void0ArgInterface body) {
			argCount = 0;
			this.void0 = body;
		}

		@SuppressWarnings("unchecked")
		function(Void1ArgInterface<?> body) {
			argCount = 1;
			this.void1 = (Void1ArgInterface<Object>) body;
		}

		@SuppressWarnings("unchecked")
		function(Void2ArgInterface<?, ?> body) {
			argCount = 2;
			this.void2 = (Void2ArgInterface<Object, Object>) body;
		}

		@SuppressWarnings("unchecked")
		function(Void3ArgInterface<?, ?, ?> body) {
			argCount = 3;
			this.void3 = (Void3ArgInterface<Object, Object, Object>) body;
		}

		@SuppressWarnings("unchecked")
		function(Void4ArgInterface<?, ?, ?, ?> body) {
			argCount = 4;
			this.void4 = (Void4ArgInterface<Object, Object, Object, Object>) body;
		}

		@SuppressWarnings("unchecked")
		function(Void5ArgInterface<?, ?, ?, ?, ?> body) {
			argCount = 5;
			this.void5 = (Void5ArgInterface<Object, Object, Object, Object, Object>) body;
		}

		@SuppressWarnings("unchecked")
		function(Void6ArgInterface<?, ?, ?, ?, ?, ?> body) {
			argCount = 6;
			this.void6 = (Void6ArgInterface<Object, Object, Object, Object, Object, Object>) body;
		}

		@SuppressWarnings("unchecked")
		function(Void7ArgInterface<?, ?, ?, ?, ?, ?, ?> body) {
			argCount = 7;
			this.void7 = (Void7ArgInterface<Object, Object, Object, Object, Object, Object, Object>) body;
		}

		function(RNArgsInterface<R> body) {
			argCount = ARG_UNDEFINED;
			this.body = body;
		}

		function(R0ArgInterface<R> body) {
			argCount = 0;
			this.body0 = body;
		}

		@SuppressWarnings("unchecked")
		function(R1ArgInterface<R, ?> body) {
			argCount = 1;
			this.body1 = (R1ArgInterface<R, Object>) body;
		}

		@SuppressWarnings("unchecked")
		function(R2ArgsInterface<R, ?, ?> body) {
			argCount = 2;
			this.body2 = (R2ArgsInterface<R, Object, Object>) body;
		}

		@SuppressWarnings("unchecked")
		function(R3ArgsInterface<R, ?, ?, ?> body) {
			argCount = 3;
			this.body3 = (R3ArgsInterface<R, Object, Object, Object>) body;
		}

		@SuppressWarnings("unchecked")
		function(R4ArgsInterface<R, ?, ?, ?, ?> body) {
			argCount = 4;
			this.body4 = (R4ArgsInterface<R, Object, Object, Object, Object>) body;
		}

		@SuppressWarnings("unchecked")
		function(R5ArgsInterface<R, ?, ?, ?, ?, ?> body) {
			argCount = 5;
			this.body5 = (R5ArgsInterface<R, Object, Object, Object, Object, Object>) body;
		}

		@SuppressWarnings("unchecked")
		function(R6ArgsInterface<R, ?, ?, ?, ?, ?, ?> body) {
			argCount = 6;
			this.body6 = (R6ArgsInterface<R, Object, Object, Object, Object, Object, Object>) body;
		}

		@SuppressWarnings("unchecked")
		function(R7ArgsInterface<R, ?, ?, ?, ?, ?, ?, ?> body) {
			argCount = 7;
			this.body7 = (R7ArgsInterface<R, Object, Object, Object, Object, Object, Object, Object>) body;
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
				throw $(t);
			}
		}

		public Async<R> async(Object... args) {
			return new Async<>(this, args);
		}
	}

	public static class AsyncGroup {
		private Async<?>[] group;

		private StyleRuntimeException err;
		private function<Object> handler;
		private Object lock = new Object();

		AsyncGroup(function<Object> asyncHandler, Async<?>... group) {
			if (group.length == 0)
				throw new IllegalArgumentException("at least one Async object should be passed in");
			this.group = Arrays.copyOf(group, group.length);
			if (null != asyncHandler) {
				for (Async<?> a : group) {
					if (!a.hasErrHandler()) {
						a.onError(asyncHandler);
					}
				}
			}
		}

		public AsyncGroup callback(function<Object> func) {
			run(() -> {
				callbackSync(func);
			});
			return this;
		}

		public AsyncGroup callbackSync(function<Object> func) {
			try {
				Object[] awaits = new Object[group.length];
				int i = 0;
				for (Async<?> async : group) {
					awaits[i] = async.await();
					++i;
				}
				func.apply(awaits);
			} catch (Throwable e) {
				synchronized (lock) {
					err = $(e);
					if (handler != null) {
						handler.apply(err);
					}
				}
			}
			return this;
		}

		public void onError(Void1ArgInterface<StyleRuntimeException> handler) {
			onError($(handler));
		}

		public void onError(function<Object> handler) {
			synchronized (lock) {
				this.handler = handler;
				if (err != null) {
					handler.apply(err);
				}
			}
		}

		public StyleRuntimeException getErr() {
			return err;
		}
	}

	public static class StyleRuntimeException extends RuntimeException {
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

	public static class SwitchBlock<T> {
		private T toSwitch;
		private boolean doNext = false;
		private boolean found = false;

		SwitchBlock(T t) {
			this.toSwitch = t;
		}

		public SwitchBlock<T> Case(T ca, function<?> func) {
			if (toSwitch.equals(ca) || doNext) {
				try {
					func.apply();
					doNext = true;
					found = true;
				} catch (Throwable t) {
					if (t instanceof StyleRuntimeException) {
						if (((StyleRuntimeException) t).origin() instanceof Break) {
							doNext = false;
						} else {
							throw ((StyleRuntimeException) t);
						}
					} else {
						throw $(t);
					}
				}
			}
			return this;
		}

		public SwitchBlock<T> Case(T ca, Void0ArgInterface func) {
			return Case(ca, $(func));
		}

		public void Default(function<Object> func) {
			if (!found) {
				func.apply();
			}
		}

		public void Default(Void0ArgInterface func) {
			Default($(func));
		}
	}

	public static class JSONLike<K, V> extends LinkedHashMap<K, V> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 7448591337510287830L;

		public JSONLike(K key, V value) {
			put(key, value);
		}

		public JSONLike<K, V> $(K key, V value) {
			put(key, value);
			return this;
		}
	}

	public static class ForSupport<N extends Number> {
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

			@SuppressWarnings("hiding")
			private <N extends Number> int privateDoLoop(function<Object> func, N num) {
				try {
					func.apply(num);
				} catch (Throwable t) {
					if (t instanceof StyleRuntimeException) {
						if (((StyleRuntimeException) t).origin() instanceof Break) {
							return 1;
						} else if (((StyleRuntimeException) t).origin() instanceof Continue) {
							return 2;
						} else {
							throw ((StyleRuntimeException) t);
						}
					} else {
						throw $(t);
					}
				}
				return 0;
			}

			@SuppressWarnings("unchecked")
			public void loop(function<Object> doLoop) {
				if (start.equals(end)) {
					privateDoLoop(doLoop, start);
					return;
				}
				if (start instanceof Integer) {
					if (((Integer) start).compareTo((Integer) end) > 0) {
						if (null == step) {
							step = (N) new Integer(-1);
						}
						for (Integer i = (Integer) start; i.compareTo((Integer) end) >= 0; i += (Integer) step) {
							int ret = privateDoLoop(doLoop, i);
							if (ret == 1) {
								break;
							} else if (ret == 2) {
								continue;
							}
						}
					} else {
						if (null == step) {
							step = (N) new Integer(1);
						}
						for (Integer i = (Integer) start; i.compareTo((Integer) end) <= 0; i += (Integer) step) {
							int ret = privateDoLoop(doLoop, i);
							if (ret == 1) {
								break;
							} else if (ret == 2) {
								continue;
							}
						}
					}
				} else if (start instanceof Double) {
					if (((Double) start).compareTo((Double) end) > 0) {
						if (null == step) {
							step = (N) new Double(-1);
						}
						for (Double i = (Double) start; i.compareTo((Double) end) >= 0; i += (Double) step) {
							int ret = privateDoLoop(doLoop, i);
							if (ret == 1) {
								break;
							} else if (ret == 2) {
								continue;
							}
						}
					} else {
						if (null == step) {
							step = (N) new Double(1);
						}
						for (Double i = (Double) start; i.compareTo((Double) end) <= 0; i += (Double) step) {
							int ret = privateDoLoop(doLoop, i);
							if (ret == 1) {
								break;
							} else if (ret == 2) {
								continue;
							}
						}
					}
				} else if (start instanceof Long) {
					if (((Long) start).compareTo((Long) end) > 0) {
						if (null == step) {
							step = (N) new Long(-1);
						}
						for (Long i = (Long) start; i.compareTo((Long) end) >= 0; i += (Long) step) {
							int ret = privateDoLoop(doLoop, i);
							if (ret == 1) {
								break;
							} else if (ret == 2) {
								continue;
							}
						}
					} else {
						if (null == step) {
							step = (N) new Long(1);
						}
						for (Long i = (Long) start; i.compareTo((Long) end) <= 0; i += (Long) step) {
							int ret = privateDoLoop(doLoop, i);
							if (ret == 1) {
								break;
							} else if (ret == 2) {
								continue;
							}
						}
					}
				} else if (start instanceof Short) {
					if (((Short) start).compareTo((Short) end) > 0) {
						if (null == step) {
							step = (N) new Short((short) -1);
						}
						for (Short i = (Short) start; i
								.compareTo((Short) end) >= 0; i = (short) (step.shortValue() + i.shortValue())) {
							int ret = privateDoLoop(doLoop, i);
							if (ret == 1) {
								break;
							} else if (ret == 2) {
								continue;
							}
						}
					} else {
						if (null == step) {
							step = (N) new Short((short) 1);
						}
						for (Short i = (Short) start; i
								.compareTo((Short) end) <= 0; i = (short) (step.shortValue() + i.shortValue())) {
							int ret = privateDoLoop(doLoop, i);
							if (ret == 1) {
								break;
							} else if (ret == 2) {
								continue;
							}
						}
					}
				} else if (start instanceof Float) {
					if (((Float) start).compareTo((Float) end) > 0) {
						if (null == step) {
							step = (N) new Float(-1);
						}
						for (Float i = (Float) start; i.compareTo((Float) end) >= 0; i += (Float) step) {
							int ret = privateDoLoop(doLoop, i);
							if (ret == 1) {
								break;
							} else if (ret == 2) {
								continue;
							}
						}
					} else {
						if (null == step) {
							step = (N) new Float(1);
						}
						for (Float i = (Float) start; i.compareTo((Float) end) <= 0; i += (Float) step) {
							int ret = privateDoLoop(doLoop, i);
							if (ret == 1) {
								break;
							} else if (ret == 2) {
								continue;
							}
						}
					}
				} else if (start instanceof Byte) {
					if (((Byte) start).compareTo((Byte) end) > 0) {
						if (null == step) {
							step = (N) new Byte((byte) -1);
						}
						for (Byte i = (Byte) start; i
								.compareTo((Byte) end) >= 0; i = (byte) (step.byteValue() + i.byteValue())) {
							int ret = privateDoLoop(doLoop, i);
							if (ret == 1) {
								break;
							} else if (ret == 2) {
								continue;
							}
						}
					} else {
						if (null == step) {
							step = (N) new Byte((byte) 1);
						}
						for (Byte i = (Byte) start; i
								.compareTo((Byte) end) <= 0; i = (byte) (step.byteValue() + i.byteValue())) {
							int ret = privateDoLoop(doLoop, i);
							if (ret == 1) {
								break;
							} else if (ret == 2) {
								continue;
							}
						}
					}
				} else {
					throw new IllegalArgumentException();
				}
			}

			public void loop(Void1ArgInterface<N> doLoop) {
				loop($(doLoop));
			}
		}
	}

	public static class DateFuncSup {
		public static class DateSeperator {
			private long day;
			private long hour;
			private long minute;
			private long second;
			private long milli;

			long parse() {
				return milli + second * 1000 + minute * 60000 + hour * 3600000 + day * 86400000;
			}

			public DateSeperator day(long days) {
				day = days;
				return this;
			}

			public DateSeperator hour(long hours) {
				hour = hours;
				return this;
			}

			public DateSeperator minute(long minutes) {
				minute = minutes;
				return this;
			}

			public DateSeperator second(long senconds) {
				second = senconds;
				return this;
			}

			public DateSeperator milli(long millis) {
				milli = millis;
				return this;
			}
		}

		private Date date;

		public Date getDate() {
			return date;
		}

		DateFuncSup(Date date) {
			this.date = date;
		}

		public DateFuncSup add(DateSeperator d) {
			date.setTime(date.getTime() + d.parse());
			return this;
		}

		public DateFuncSup add(function<DateSeperator> dateFunction) {
			date.setTime(date.getTime() + dateFunction.apply(new DateSeperator()).parse());
			return this;
		}

		public DateFuncSup add(R1ArgInterface<DateSeperator, DateSeperator> dateFunction) {
			return add($(dateFunction));
		}

		public DateFuncSup substract(DateSeperator d) {
			date.setTime(date.getTime() - d.parse());
			return this;
		}

		public DateFuncSup substract(function<DateSeperator> dateFunction) {
			date.setTime(date.getTime() - dateFunction.apply(new DateSeperator()).parse());
			return this;
		}

		public DateFuncSup substract(R1ArgInterface<DateSeperator, DateSeperator> dateFunction) {
			return substract($(dateFunction));
		}

		public DateFuncSup nextMonth() {
			return nextMonth(1);
		}

		public DateFuncSup nextYear() {
			return nextYear(1);
		}

		public DateFuncSup previousMonth() {
			return previousMonth(1);
		}

		public DateFuncSup previousYear() {
			return previousYear(1);
		}

		public DateFuncSup nextMonth(int next) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, next);
			date.setTime(cal.getTimeInMillis());
			return this;
		}

		public DateFuncSup nextYear(int next) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.YEAR, next);
			date.setTime(cal.getTimeInMillis());
			return this;
		}

		public DateFuncSup previousMonth(int previous) {
			return nextMonth(-1);
		}

		public DateFuncSup previousYear(int previous) {
			return nextYear(-1);
		}

		public String toString(String format) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			String s = "" + cal.get(Calendar.SECOND);
			String ss = s.length() == 1 ? "0" + s : s;
			String i = "" + cal.get(Calendar.MINUTE);
			String ii = i.length() == 1 ? "0" + i : i;
			String h = "" + cal.get(Calendar.HOUR);
			String hh = h.length() == 1 ? "0" + h : h;
			String H = "" + cal.get(Calendar.HOUR_OF_DAY);
			String HH = H.length() == 1 ? "0" + H : H;
			String d = "" + cal.get(Calendar.DATE);
			String dd = d.length() == 1 ? "0" + d : d;
			String m = "" + (cal.get(Calendar.MONTH) + 1);
			String mm = m.length() == 1 ? "0" + m : m;
			String yyyy = "" + cal.get(Calendar.YEAR);
			String yy = yyyy.substring(2);
			String a = cal.get(Calendar.AM_PM) == Calendar.AM ? "am" : "pm";
			String A = a.toUpperCase();
			Map<String, String> replace = $(new LinkedHashMap<String, String>(),
					$("ss", ss).$("s", s).$("ii", ii).$("i", i).$("hh", hh).$("h", h).$("HH", HH).$("H", H).$("dd", dd)
							.$("d", d).$("mm", mm).$("m", m).$("yyyy", yyyy).$("yy", yy).$("a", a).$("A", A));

			StringBuilder sb = new StringBuilder(format);
			$(replace).forEach((k, v) -> {
				int index;
				int length = k.length();
				while ((index = sb.indexOf(k)) != -1) {
					sb.replace(index, index + length, v);
				}
				String upper = k.toUpperCase();
				if (!replace.containsKey(upper)) {
					while ((index = sb.indexOf(upper)) != -1) {
						sb.replace(index, index + length, v);
					}
				}
			});
			return sb.toString();
		}
	}

	public static class ComparableFuncSup<T> {
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
}
