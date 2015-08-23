package net.cassite.style;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import net.cassite.style.control.*;
import net.cassite.style.control.$Set;
import net.cassite.style.interfaces.*;
import net.cassite.style.reflect.ClassSup;
import net.cassite.style.reflect.MethodSupport;
import net.cassite.style.reflect.ProxyHandler;

public class Style {

	protected Style() {
	}

	// ┌─────────────────────────────────┐
	// │............function.............│
	// └─────────────────────────────────┘

	// void functions

	public static def<Object> function(VFunc0 body) {
		return $(body);
	}

	public static def<Object> function(VFunc1<?> body) {
		return $(body);
	}

	public static def<Object> function(VFunc2<?, ?> body) {
		return $(body);
	}

	public static def<Object> function(VFunc3<?, ?, ?> body) {
		return $(body);
	}

	public static def<Object> function(VFunc4<?, ?, ?, ?> body) {
		return $(body);
	}

	public static def<Object> function(VFunc5<?, ?, ?, ?, ?> body) {
		return $(body);
	}

	public static def<Object> function(VFunc6<?, ?, ?, ?, ?, ?> body) {
		return $(body);
	}

	public static def<Object> function(VFunc7<?, ?, ?, ?, ?, ?, ?> body) {
		return $(body);
	}

	// functions with return value

	public static <R> def<R> function(RFunc0<R> body) {
		return $(body);
	}

	public static <R> def<R> function(RFunc1<R, ?> body) {
		return $(body);
	}

	public static <R> def<R> function(RFunc2<R, ?, ?> body) {
		return $(body);
	}

	public static <R> def<R> function(RFunc3<R, ?, ?, ?> body) {
		return $(body);
	}

	public static <R> def<R> function(RFunc4<R, ?, ?, ?, ?> body) {
		return $(body);
	}

	public static <R> def<R> function(RFunc5<R, ?, ?, ?, ?, ?> body) {
		return $(body);
	}

	public static <R> def<R> function(RFunc6<R, ?, ?, ?, ?, ?, ?> body) {
		return $(body);
	}

	public static <R> def<R> function(RFunc7<R, ?, ?, ?, ?, ?, ?, ?> body) {
		return $(body);
	}

	// void functions

	public static def<Object> $(VFunc0 body) {
		return new def<Object>(body);
	}

	public static def<Object> $(VFunc1<?> body) {
		return new def<Object>(body);
	}

	public static def<Object> $(VFunc2<?, ?> body) {
		return new def<Object>(body);
	}

	public static def<Object> $(VFunc3<?, ?, ?> body) {
		return new def<Object>(body);
	}

	public static def<Object> $(VFunc4<?, ?, ?, ?> body) {
		return new def<Object>(body);
	}

	public static def<Object> $(VFunc5<?, ?, ?, ?, ?> body) {
		return new def<Object>(body);
	}

	public static def<Object> $(VFunc6<?, ?, ?, ?, ?, ?> body) {
		return new def<Object>(body);
	}

	public static def<Object> $(VFunc7<?, ?, ?, ?, ?, ?, ?> body) {
		return new def<Object>(body);
	}

	// functions with return value

	public static <R> def<R> $(RFunc0<R> body) {
		return new def<R>(body);
	}

	public static <R> def<R> $(RFunc1<R, ?> body) {
		return new def<R>(body);
	}

	public static <R> def<R> $(RFunc2<R, ?, ?> body) {
		return new def<R>(body);
	}

	public static <R> def<R> $(RFunc3<R, ?, ?, ?> body) {
		return new def<R>(body);
	}

	public static <R> def<R> $(RFunc4<R, ?, ?, ?, ?> body) {
		return new def<R>(body);
	}

	public static <R> def<R> $(RFunc5<R, ?, ?, ?, ?, ?> body) {
		return new def<R>(body);
	}

	public static <R> def<R> $(RFunc6<R, ?, ?, ?, ?, ?, ?> body) {
		return new def<R>(body);
	}

	public static <R> def<R> $(RFunc7<R, ?, ?, ?, ?, ?, ?, ?> body) {
		return new def<R>(body);
	}

	// function support

	public static <T> ptr<T> ptr(T o) {
		return new ptr<T>(o);
	}

	public static <T> T $(ptr<T> store) {
		return store.item;
	}

	public static <T> ptr<T> $(ptr<T> ptr, T newItem) {
		ptr.item = newItem;
		return ptr;
	}

	// ┌─────────────────────────────────┐
	// │...........async&await...........│
	// └─────────────────────────────────┘

	public static AsyncGroup $(Async<?>... asyncs) {
		return new AsyncGroup(null, asyncs);
	}

	public static AsyncGroup $(def<Object> handler, Async<?>... asyncs) {
		return new AsyncGroup(handler, asyncs);
	}

	public static AsyncGroup $(VFunc1<StyleRuntimeException> handler, Async<?>... asyncs) {
		return new AsyncGroup($(handler), asyncs);
	}

	public static <R> R await(Async<R> async) {
		return async.await();
	}

	public static Thread run(VFunc0 runnable) {
		return run($(runnable));
	}

	public static Thread run(def<Object> toRun) {
		Thread t = new Thread(() -> {
			toRun.apply();
		});
		t.start();
		return t;
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw $(e);
		}
	}

	// ┌─────────────────────────────────┐
	// │........iteration control........│
	// └─────────────────────────────────┘

	public static <T> T Break() throws Break {
		throw $.Control_Break;
	}

	public static <T> T Remove() throws Remove {
		throw $.Control_Remove;
	}

	public static <T> T Continue() throws Continue {
		throw $.Control_Continue;
	}

	public static <T> T Set(T toSet) {
		throw new $Set(toSet);
	}

	public static <T> T BreakWithResult(T res) {
		throw new BreakWithResult(res);
	}

	// ┌─────────────────────────────────┐
	// │...collections, maps and arrays..│
	// └─────────────────────────────────┘

	public static ArrayFuncSup<Integer> $(int[] array) {
		Integer[] arr = new Integer[array.length];
		For(0).to(array.length - 1).loop(i -> {
			arr[i] = array[i];
		});
		return $(arr);
	}

	public static ArrayFuncSup<Double> $(double[] array) {
		Double[] arr = new Double[array.length];
		For(0).to(array.length - 1).loop(i -> {
			arr[i] = array[i];
		});
		return $(arr);
	}

	public static ArrayFuncSup<Float> $(float[] array) {
		Float[] arr = new Float[array.length];
		For(0).to(array.length - 1).loop(i -> {
			arr[i] = array[i];
		});
		return $(arr);
	}

	public static ArrayFuncSup<Boolean> $(boolean[] array) {
		Boolean[] arr = new Boolean[array.length];
		For(0).to(array.length - 1).loop(i -> {
			arr[i] = array[i];
		});
		return $(arr);
	}

	public static ArrayFuncSup<Character> $(char[] array) {
		Character[] arr = new Character[array.length];
		For(0).to(array.length - 1).loop(i -> {
			arr[i] = array[i];
		});
		return $(arr);
	}

	public static ArrayFuncSup<Byte> $(byte[] array) {
		Byte[] arr = new Byte[array.length];
		For(0).to(array.length - 1).loop(i -> {
			arr[i] = array[i];
		});
		return $(arr);
	}

	public static ArrayFuncSup<Long> $(long[] array) {
		Long[] arr = new Long[array.length];
		For(0).to(array.length - 1).loop(i -> {
			arr[i] = array[i];
		});
		return $(arr);
	}

	public static ArrayFuncSup<Short> $(short[] array) {
		Short[] arr = new Short[array.length];
		For(0).to(array.length - 1).loop(i -> {
			arr[i] = array[i];
		});
		return $(arr);
	}

	public static <T> ArrayFuncSup<T> $(T[] array) {
		return new ArrayFuncSup<T>(array);
	}

	public static <T> IterableFuncSup<T> $(Iterable<T> it) {
		return new IterableFuncSup<>(it);
	}

	public static <T> CollectionFuncSup<T> $(Collection<T> coll) {
		return new CollectionFuncSup<>(coll);
	}

	public static <T> ListFuncSup<T> $(List<T> coll) {
		return new ListFuncSup<T>(coll);
	}

	@SafeVarargs
	public static <E, Coll extends Collection<E>> Coll $(Coll collection, E... elements) {
		for (E e : elements) {
			collection.add(e);
		}
		return collection;
	}

	public static <K, V> MapFuncSup<K, V> $(Map<K, V> map) {
		return new MapFuncSup<>(map);
	}

	public static <K, V, M extends Map<K, V>> M $(M map, JSONLike<K, V> entries) {
		for (K key : entries.keySet()) {
			map.put(key, entries.get(key));
		}
		return map;
	}

	// ┌─────────────────────────────────┐
	// │......basic grammar enhance......│
	// └─────────────────────────────────┘
	// for

	public static <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, def<R> loop) {
		R res = null;
		LoopInfo<R> info = new LoopInfo<R>();
		int cursor = 0;
		int effctiveCursor = 0;
		for (T ii = i; condition.test(ii); ii = increment.apply(ii)) {
			try {
				R tmpRes;
				if (loop.argCount() == 2) {
					tmpRes = loop.apply(ii, info.setValues(cursor, effctiveCursor, res));
				} else {
					tmpRes = loop.apply(ii);
				}
				if (tmpRes != null) {
					res = tmpRes;
					++effctiveCursor;
				}
			} catch (Throwable e) {
				if (e instanceof StyleRuntimeException) {
					Throwable origin = ((StyleRuntimeException) e).origin();
					if (origin instanceof Break) {
						break;
					} else if (origin instanceof Continue) {
						continue;
					} else if (origin instanceof BreakWithResult) {
						res = ((BreakWithResult) origin).getRes();
						break;
					} else {
						throw ((StyleRuntimeException) e);
					}
				} else {
					throw $(e);
				}
			} finally {
				++cursor;
			}
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public static <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, VFunc1<T> loop) {
		return (R) For(i, condition, increment, $(loop));
	}

	public static <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, RFunc1<R, T> loop) {
		return (R) For(i, condition, increment, $(loop));
	}

	@SuppressWarnings("unchecked")
	public static <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment,
			VFunc2<T, LoopInfo<R>> loop) {
		return (R) For(i, condition, increment, $(loop));
	}

	public static <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment,
			RFunc2<R, T, LoopInfo<R>> loop) {
		return (R) For(i, condition, increment, $(loop));
	}

	public static <N extends Number> ForSupport<N> For(N start) {
		return new ForSupport<N>(start);
	}

	public static <N extends Number> ForSupport<N> from(N start) {
		return new ForSupport<N>(start);
	}

	// while

	public static <R> R While(BooleanSupplier condition, def<R> loop) {
		R res = null;
		LoopInfo<R> info = new LoopInfo<>();
		int currentIndex = 0;
		int effectiveIndex = 0;
		while (condition.getAsBoolean()) {
			try {
				R tmpRes;
				if (loop.argCount() == 1)
					tmpRes = loop.apply(info.setValues(currentIndex, effectiveIndex, res));
				else
					tmpRes = loop.apply();
				if (tmpRes != null) {
					res = tmpRes;
					++effectiveIndex;
				}
			} catch (Throwable e) {
				if (e instanceof StyleRuntimeException) {
					Throwable origin = ((StyleRuntimeException) e).origin();
					if (origin instanceof Break) {
						break;
					} else if (origin instanceof Continue) {
						continue;
					} else if (origin instanceof BreakWithResult) {
						res = ((BreakWithResult) origin).getRes();
						break;
					} else {
						throw ((StyleRuntimeException) e);
					}
				} else {
					throw $(e);
				}
			} finally {
				++currentIndex;
			}
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public static <R> R While(BooleanSupplier condition, VFunc0 loop) {
		return While(condition, (def<R>) $(loop));
	}

	public static <R> R While(BooleanSupplier condition, RFunc0<R> loop) {
		return While(condition, $(loop));
	}

	@SuppressWarnings("unchecked")
	public static <R> R While(BooleanSupplier condition, VFunc1<LoopInfo<R>> loop) {
		return While(condition, (def<R>) $(loop));
	}

	public static <R> R While(BooleanSupplier condition, RFunc1<R, LoopInfo<R>> loop) {
		return While(condition, $(loop));
	}

	// switch

	public static <T> SwitchBlock<T, T> Switch(T t) {
		return Switch(t, $.eqlFunc);
	}

	public static <T> SwitchBlock<T, T> Switch(T t, RFunc2<Boolean, T, T> method) {
		return Switch(t, $(method));
	}

	public static <T> SwitchBlock<T, T> Switch(T t, def<Boolean> method) {
		return new SwitchBlock<T, T>(t, method);
	}

	public static <T, R> SwitchBlock<T, R> Switch(T t, Class<R> cls) {
		return Switch(t, cls, $.eqlFunc);
	}

	public static <T, R> SwitchBlock<T, R> Switch(T t, Class<R> cls, RFunc2<Boolean, T, T> method) {
		return Switch(t, cls, $(method));
	}

	public static <T, R> SwitchBlock<T, R> Switch(T t, Class<R> cls, def<Boolean> method) {
		return new SwitchBlock<T, R>(t, method);
	}

	// if

	public static <T, INIT> IfBlock<T, INIT> If(INIT init, T val) {
		return If(init, () -> val);
	}

	public static <T, INIT> IfBlock<T, INIT> If(INIT init, RFunc1<T, INIT> body) {
		return If(init, $(body));
	}

	@SuppressWarnings("unchecked")
	public static <T, INIT> IfBlock<T, INIT> If(INIT init, VFunc1<INIT> body) {
		return (IfBlock<T, INIT>) If(init, $(body));
	}

	public static <T, INIT> IfBlock<T, INIT> If(INIT init, RFunc0<T> body) {
		return If(init, $(body));
	}

	@SuppressWarnings("unchecked")
	public static <T, INIT> IfBlock<T, INIT> If(INIT init, VFunc0 body) {
		return (IfBlock<T, INIT>) If(init, $(body));
	}

	public static <T, INIT> IfBlock<T, INIT> If(INIT init, def<T> body) {
		return new IfBlock<>(() -> init, body);
	}

	public static <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, T val) {
		return If(init, () -> val);
	}

	public static <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, RFunc1<T, INIT> body) {
		return If(init, $(body));
	}

	@SuppressWarnings("unchecked")
	public static <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, VFunc1<INIT> body) {
		return (IfBlock<T, INIT>) If(init, $(body));
	}

	public static <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, RFunc0<T> body) {
		return If(init, $(body));
	}

	@SuppressWarnings("unchecked")
	public static <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, VFunc0 body) {
		return (IfBlock<T, INIT>) If(init, $(body));
	}

	public static <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, def<T> body) {
		return new IfBlock<>(init, body);
	}

	// ┌─────────────────────────────────┐
	// │............throwable............│
	// └─────────────────────────────────┘

	public static StyleRuntimeException $(Throwable t) {
		if (t instanceof StyleRuntimeException) {
			return (StyleRuntimeException) t;
		} else {
			return new StyleRuntimeException(t);
		}
	}

	// ┌─────────────────────────────────┐
	// │..............other..............│
	// └─────────────────────────────────┘
	// json like
	public static <K, V> JSONLike<K, V> map(K key, V value) {
		return new JSONLike<K, V>(key, value);
	}

	// date
	public static DateFuncSup $(Date date) {
		return new DateFuncSup(date);
	}

	// regex
	public static RegEx regex(String regex) {
		return new RegEx(regex);
	}

	// comparable
	public static <T> ComparableFuncSup<T> $(Comparable<T> comparable) {
		return new ComparableFuncSup<>(comparable);
	}

	// rand
	public static int rand(int start, int end) {
		return (int) (Math.random() * (end - start + 1)) + start;
	}

	public static double rand(double start, double end) {
		return Math.random() * (end - start) + start;
	}

	public static int rand(int max) {
		return (int) (Math.random() * (max + 1));
	}

	public static double rand(double max) {
		return Math.random() * max;
	}

	public static String rand(String chooseFrom, int length, boolean unrepeatable, boolean ignoreCase) {
		if (length > chooseFrom.length() && unrepeatable) {
			throw new RuntimeException("unrepeatable but length > chooseFrom.length");
		}
		StringBuilder sb = new StringBuilder();
		ptr<String> $chooseFrom = ptr(chooseFrom);
		For(1).to(length).loop(i -> {
			char c = $chooseFrom.item.charAt(rand($chooseFrom.item.length() - 1));
			while (sb.indexOf("" + c) != -1 && unrepeatable) {
				c = $chooseFrom.item.charAt(rand(chooseFrom.length() - 1));
			}
			sb.append(c);
			if (unrepeatable) {
				if (ignoreCase) {
					$chooseFrom.item = $chooseFrom.item.replace(("" + c).toLowerCase(), "");
					$chooseFrom.item = $chooseFrom.item.replace(("" + c).toUpperCase(), "");
				} else {
					$chooseFrom.item = $chooseFrom.item.replace(("" + c), "");
				}
			}
		});
		return sb.toString();
	}

	public static String rand(String chooseFrom, int length, boolean unrepeatable) {
		return rand(chooseFrom, length, unrepeatable, false);
	}

	public static String rand(String chooseFrom, int length) {
		return rand(chooseFrom, length, false, false);
	}

	public static int $(IteratorInfo<?> info) {
		return info.currentIndex;
	}

	public static StringFuncSup $(String base) {
		return new StringFuncSup(base);
	}

	/**
	 * Implicit Type Conversion.<br/>
	 * In order to use implicit type conversion,<br/>
	 * the class <b>to be converted to</b> may contain methods like this:<br/>
	 * <code>static R from(T o)</code><br/>
	 * <b>OR</b> the class of the object (param 'o') <b>to convert</b> may
	 * contain methods like this:<br/>
	 * <code>toT</code><br/>
	 * e.g.<br/>
	 * The following definition means you can convert String to User or convert
	 * User to String.
	 * 
	 * <pre>
	 * class User{
	 * static User from(String s)...
	 * String toString()...
	 * }
	 * </pre>
	 * 
	 * @param o
	 *            original object
	 * @param cls
	 *            the type to convert to
	 * @return object of converted type
	 */
	@SuppressWarnings("unchecked")
	public static <T> T imp(Object o, Class<T> cls) {
		Method m;
		try {
			m = o.getClass().getMethod("to" + cls.getSimpleName(), new Class[0]);
			if (m.getReturnType() != cls) {
				throw new RuntimeException("Invalid implicit type conversion definition. Return type mismatch");
			}
			m.setAccessible(true);
			return (T) m.invoke(o, new Object[0]);
		} catch (NoSuchMethodException e) {
			try {
				m = cls.getMethod("from", o.getClass());
				if (m.getReturnType() != cls) {
					throw new RuntimeException("Invalid implicit type conversion definition. Return type mismatch");
				} else if (!Modifier.isStatic(m.getModifiers())) {
					throw new RuntimeException(
							"Invalid implicit type conversion definition. Method starts with 'from' should be static.");
				}
				m.setAccessible(true);
				return (T) m.invoke(null, o);
			} catch (NoSuchMethodException e1) {
				throw new RuntimeException("No implicit type conversion definition.");
			} catch (Exception e1) {
				throw $(e1);
			}
		} catch (Exception e) {
			throw $(e);
		}
	}

	public static <T> T avoidNull(T t, RFunc0<T> Default) {
		if (t == null)
			try {
				return Default.apply();
			} catch (Throwable throwable) {
				throw $(throwable);
			}
		else
			return t;
	}

	// ┌─────────────────────────────────┐
	// │...........reflection............│
	// └─────────────────────────────────┘

	public static <T> ClassSup<T> cls(Class<T> cls) {
		return new ClassSup<>(cls);
	}

	@SuppressWarnings("unchecked")
	public static <T> ClassSup<T> cls(String clsName) {
		try {
			return (ClassSup<T>) cls(Class.forName(clsName));
		} catch (Exception e) {
			throw $(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> ClassSup<T> cls(T obj) {
		return (ClassSup<T>) cls(obj.getClass());
	}

	@SuppressWarnings("unchecked")
	public static <T> T proxy(InvocationHandler handler, T toProxy) {
		return (T) Proxy.newProxyInstance(toProxy.getClass().getClassLoader(), toProxy.getClass().getInterfaces(),
				handler);
	}

	@SuppressWarnings("unchecked")
	public static <P> P proxy(ProxyHandler<P> proxyHandler) {
		List<MethodSupport<?, ProxyHandler<P>>> methods = cls(proxyHandler).allMethods();
		P toProxy = proxyHandler.toProxy;

		return (P) Proxy.newProxyInstance(toProxy.getClass().getClassLoader(), toProxy.getClass().getInterfaces(),
				(p, m, args) -> {
					return If($(methods).forEach(e -> {
						if (e.name().equals(m.getName()) && e.argCount() == m.getParameterCount() &&
								avoidNull($(m.getParameterTypes()).forEach((pt, i) -> {
							if (!pt.equals(e.argTypes()[$(i)]))
								return BreakWithResult(false);
							else
								return true;
						}), () -> true))
							return BreakWithResult(e);
						else
							return null;
					}), res -> (Object) res.invoke(proxyHandler, args))
							.Else(() -> m.invoke(toProxy, args));
				});
	}

	@SafeVarargs
	public static <T> T[] packAsArray(T[] array, T... toPack) {
		return $(toPack).to(array).via($.copy());
	}

}
