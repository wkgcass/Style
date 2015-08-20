package net.cassite.style;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import net.cassite.style.Supportters.ArrayFuncSup;
import net.cassite.style.Supportters.AsyncGroup;
import net.cassite.style.Supportters.CollectionFuncSup;
import net.cassite.style.Supportters.ComparableFuncSup;
import net.cassite.style.Supportters.DateFuncSup;
import net.cassite.style.Supportters.ForSupport;
import net.cassite.style.Supportters.IterableFuncSup;
import net.cassite.style.Supportters.JSONLike;
import net.cassite.style.Supportters.MapFuncSup;
import net.cassite.style.Supportters.StyleRuntimeException;
import net.cassite.style.Supportters.SwitchBlock;
import net.cassite.style.Supportters.function;
import net.cassite.style.control.Break;
import net.cassite.style.control.Continue;
import net.cassite.style.control.Remove;
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

public class Style {

	protected Style() {
	}

	// ┌─────────────────────────────────┐
	// │............function.............│
	// └─────────────────────────────────┘

	// void functions
	public static function<Object> function(VoidNArgInterface body) {
		return $(body);
	}

	public static function<Object> function(Void0ArgInterface body) {
		return $(body);
	}

	public static function<Object> function(Void1ArgInterface<?> body) {
		return $(body);
	}

	public static function<Object> function(Void2ArgInterface<?, ?> body) {
		return $(body);
	}

	public static function<Object> function(Void3ArgInterface<?, ?, ?> body) {
		return $(body);
	}

	public static function<Object> function(Void4ArgInterface<?, ?, ?, ?> body) {
		return $(body);
	}

	public static function<Object> function(Void5ArgInterface<?, ?, ?, ?, ?> body) {
		return $(body);
	}

	public static function<Object> function(Void6ArgInterface<?, ?, ?, ?, ?, ?> body) {
		return $(body);
	}

	public static function<Object> function(Void7ArgInterface<?, ?, ?, ?, ?, ?, ?> body) {
		return $(body);
	}

	// functions with return value
	public static <R> function<R> function(RNArgsInterface<R> body) {
		return $(body);
	}

	public static <R> function<R> function(R0ArgInterface<R> body) {
		return $(body);
	}

	public static <R> function<R> function(R1ArgInterface<R, ?> body) {
		return $(body);
	}

	public static <R> function<R> function(R2ArgsInterface<R, ?, ?> body) {
		return $(body);
	}

	public static <R> function<R> function(R3ArgsInterface<R, ?, ?, ?> body) {
		return $(body);
	}

	public static <R> function<R> function(R4ArgsInterface<R, ?, ?, ?, ?> body) {
		return $(body);
	}

	public static <R> function<R> function(R5ArgsInterface<R, ?, ?, ?, ?, ?> body) {
		return $(body);
	}

	public static <R> function<R> function(R6ArgsInterface<R, ?, ?, ?, ?, ?, ?> body) {
		return $(body);
	}

	public static <R> function<R> function(R7ArgsInterface<R, ?, ?, ?, ?, ?, ?, ?> body) {
		return $(body);
	}

	// void functions

	public static function<Object> $(VoidNArgInterface body) {
		return new function<Object>(body);
	}

	public static function<Object> $(Void0ArgInterface body) {
		return new function<Object>(body);
	}

	public static function<Object> $(Void1ArgInterface<?> body) {
		return new function<Object>(body);
	}

	public static function<Object> $(Void2ArgInterface<?, ?> body) {
		return new function<Object>(body);
	}

	public static function<Object> $(Void3ArgInterface<?, ?, ?> body) {
		return new function<Object>(body);
	}

	public static function<Object> $(Void4ArgInterface<?, ?, ?, ?> body) {
		return new function<Object>(body);
	}

	public static function<Object> $(Void5ArgInterface<?, ?, ?, ?, ?> body) {
		return new function<Object>(body);
	}

	public static function<Object> $(Void6ArgInterface<?, ?, ?, ?, ?, ?> body) {
		return new function<Object>(body);
	}

	public static function<Object> $(Void7ArgInterface<?, ?, ?, ?, ?, ?, ?> body) {
		return new function<Object>(body);
	}

	// functions with return value
	public static <R> function<R> $(RNArgsInterface<R> body) {
		return new function<R>(body);
	}

	public static <R> function<R> $(R0ArgInterface<R> body) {
		return new function<R>(body);
	}

	public static <R> function<R> $(R1ArgInterface<R, ?> body) {
		return new function<R>(body);
	}

	public static <R> function<R> $(R2ArgsInterface<R, ?, ?> body) {
		return new function<R>(body);
	}

	public static <R> function<R> $(R3ArgsInterface<R, ?, ?, ?> body) {
		return new function<R>(body);
	}

	public static <R> function<R> $(R4ArgsInterface<R, ?, ?, ?, ?> body) {
		return new function<R>(body);
	}

	public static <R> function<R> $(R5ArgsInterface<R, ?, ?, ?, ?, ?> body) {
		return new function<R>(body);
	}

	public static <R> function<R> $(R6ArgsInterface<R, ?, ?, ?, ?, ?, ?> body) {
		return new function<R>(body);
	}

	public static <R> function<R> $(R7ArgsInterface<R, ?, ?, ?, ?, ?, ?, ?> body) {
		return new function<R>(body);
	}

	// function support

	public static <T> Store<T> store(T o) {
		return new Store<T>(o);
	}

	public static <T> T $(Store<T> store) {
		return store.item;
	}

	// ┌─────────────────────────────────┐
	// │...........async&await...........│
	// └─────────────────────────────────┘

	public static AsyncGroup $(Async<?>... asyncs) {
		return new AsyncGroup(null, asyncs);
	}

	public static AsyncGroup $(function<Object> handler, Async<?>... asyncs) {
		return new AsyncGroup(handler, asyncs);
	}

	public static AsyncGroup $(Void1ArgInterface<StyleRuntimeException> handler, Async<?>... asyncs) {
		return new AsyncGroup($(handler), asyncs);
	}

	public static <R> R await(Async<R> async) {
		return async.await();
	}

	public static Thread run(Void0ArgInterface runnable) {
		return run($(runnable));
	}

	public static Thread run(function<Object> toRun) {
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

	public static void Break() throws Break {
		throw $.Control_Break;
	}

	public static void Remove() throws Remove {
		throw $.Control_Remove;
	}

	public static void Continue() throws Continue {
		throw $.Control_Continue;
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

	public static <T> void For(T i, Predicate<T> condition, UnaryOperator<T> increment, function<Object> loop) {
		for (T ii = i; condition.test(ii); ii = increment.apply(ii)) {
			try {
				loop.apply(ii);
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
		}
	}

	public static <T> void For(T i, Predicate<T> condition, UnaryOperator<T> increment, Void1ArgInterface<T> loop) {
		For(i, condition, increment, $(loop));
	}

	public static <N extends Number> ForSupport<N> For(N start) {
		return new ForSupport<N>(start);
	}

	public static <N extends Number> ForSupport<N> from(N start) {
		return new ForSupport<N>(start);
	}

	// while

	public static void While(BooleanSupplier condition, function<Object> loop) {
		while (condition.getAsBoolean()) {
			try {
				loop.apply();
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
		}
	}

	public static void While(BooleanSupplier condition, Void0ArgInterface loop) {
		While(condition, $(loop));
	}

	// switch

	public static <T> SwitchBlock<T> Switch(T t) {
		return new SwitchBlock<T>(t);
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
	public static <K, V> JSONLike<K, V> $(K key, V value) {
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
		Store<String> $chooseFrom = store(chooseFrom);
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
}
