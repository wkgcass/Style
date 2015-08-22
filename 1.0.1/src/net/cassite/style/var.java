package net.cassite.style;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import net.cassite.style.Supportters.function;

import net.cassite.style.Supportters.ArrayFuncSup;
import net.cassite.style.Supportters.AsyncGroup;
import net.cassite.style.Supportters.CollectionFuncSup;
import net.cassite.style.Supportters.ComparableFuncSup;
import net.cassite.style.Supportters.DateFuncSup;
import net.cassite.style.Supportters.ForSupport;
import net.cassite.style.Supportters.IfBlock;
import net.cassite.style.Supportters.IterableFuncSup;
import net.cassite.style.Supportters.IteratorInfo;
import net.cassite.style.Supportters.JSONLike;
import net.cassite.style.Supportters.MapFuncSup;
import net.cassite.style.Supportters.StyleRuntimeException;
import net.cassite.style.Supportters.StringFuncSup;
import net.cassite.style.Supportters.SwitchBlock;
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

/**
 * 
 * @since 0.1.1
 */
public interface var {

	// ┌─────────────────────────────────┐
	// │............function.............│
	// └─────────────────────────────────┘

	// void functions
	default function<Object> function(VoidNArgInterface body) {
		return Style.function(body);
	}

	default function<Object> function(Void0ArgInterface body) {
		return Style.function(body);
	}

	default function<Object> function(Void1ArgInterface<?> body) {
		return Style.function(body);
	}

	default function<Object> function(Void2ArgInterface<?, ?> body) {
		return Style.function(body);
	}

	default function<Object> function(Void3ArgInterface<?, ?, ?> body) {
		return Style.function(body);
	}

	default function<Object> function(Void4ArgInterface<?, ?, ?, ?> body) {
		return Style.function(body);
	}

	default function<Object> function(Void5ArgInterface<?, ?, ?, ?, ?> body) {
		return Style.function(body);
	}

	default function<Object> function(Void6ArgInterface<?, ?, ?, ?, ?, ?> body) {
		return Style.function(body);
	}

	default function<Object> function(Void7ArgInterface<?, ?, ?, ?, ?, ?, ?> body) {
		return Style.function(body);
	}

	// functions with return value
	default <R> function<R> function(RNArgsInterface<R> body) {
		return Style.function(body);
	}

	default <R> function<R> function(R0ArgInterface<R> body) {
		return Style.function(body);
	}

	default <R> function<R> function(R1ArgInterface<R, ?> body) {
		return Style.function(body);
	}

	default <R> function<R> function(R2ArgsInterface<R, ?, ?> body) {
		return Style.function(body);
	}

	default <R> function<R> function(R3ArgsInterface<R, ?, ?, ?> body) {
		return Style.function(body);
	}

	default <R> function<R> function(R4ArgsInterface<R, ?, ?, ?, ?> body) {
		return Style.function(body);
	}

	default <R> function<R> function(R5ArgsInterface<R, ?, ?, ?, ?, ?> body) {
		return Style.function(body);
	}

	default <R> function<R> function(R6ArgsInterface<R, ?, ?, ?, ?, ?, ?> body) {
		return Style.function(body);
	}

	default <R> function<R> function(R7ArgsInterface<R, ?, ?, ?, ?, ?, ?, ?> body) {
		return Style.function(body);
	}

	// void functions

	default function<Object> $(VoidNArgInterface body) {
		return Style.$(body);
	}

	default function<Object> $(Void0ArgInterface body) {
		return Style.$(body);
	}

	default function<Object> $(Void1ArgInterface<?> body) {
		return Style.$(body);
	}

	default function<Object> $(Void2ArgInterface<?, ?> body) {
		return Style.$(body);
	}

	default function<Object> $(Void3ArgInterface<?, ?, ?> body) {
		return Style.$(body);
	}

	default function<Object> $(Void4ArgInterface<?, ?, ?, ?> body) {
		return Style.$(body);
	}

	default function<Object> $(Void5ArgInterface<?, ?, ?, ?, ?> body) {
		return Style.$(body);
	}

	default function<Object> $(Void6ArgInterface<?, ?, ?, ?, ?, ?> body) {
		return Style.$(body);
	}

	default function<Object> $(Void7ArgInterface<?, ?, ?, ?, ?, ?, ?> body) {
		return Style.$(body);
	}

	// functions with return value
	default <R> function<R> $(RNArgsInterface<R> body) {
		return Style.$(body);
	}

	default <R> function<R> $(R0ArgInterface<R> body) {
		return Style.$(body);
	}

	default <R> function<R> $(R1ArgInterface<R, ?> body) {
		return Style.$(body);
	}

	default <R> function<R> $(R2ArgsInterface<R, ?, ?> body) {
		return Style.$(body);
	}

	default <R> function<R> $(R3ArgsInterface<R, ?, ?, ?> body) {
		return Style.$(body);
	}

	default <R> function<R> $(R4ArgsInterface<R, ?, ?, ?, ?> body) {
		return Style.$(body);
	}

	default <R> function<R> $(R5ArgsInterface<R, ?, ?, ?, ?, ?> body) {
		return Style.$(body);
	}

	default <R> function<R> $(R6ArgsInterface<R, ?, ?, ?, ?, ?, ?> body) {
		return Style.$(body);
	}

	default <R> function<R> $(R7ArgsInterface<R, ?, ?, ?, ?, ?, ?, ?> body) {
		return Style.$(body);
	}

	// function support

	default <T> Store<T> store(T o) {
		return Style.store(o);
	}

	default <T> T $(val<T> store) {
		return Style.$(store);
	}

	// ┌─────────────────────────────────┐
	// │...........async&await...........│
	// └─────────────────────────────────┘

	default AsyncGroup $(Async<?>... asyncs) {
		return Style.$(asyncs);
	}

	default AsyncGroup $(def<Object> handler, Async<?>... asyncs) {
		return Style.$(handler, asyncs);
	}

	default AsyncGroup $(Void1ArgInterface<StyleRuntimeException> handler, Async<?>... asyncs) {
		return Style.$(handler, asyncs);
	}

	default <R> R await(Async<R> async) {
		return Style.await(async);
	}

	default Thread run(Void0ArgInterface runnable) {
		return Style.run(runnable);
	}

	default Thread run(def<Object> toRun) {
		return Style.run(toRun);
	}

	default void sleep(long millis) {
		Style.sleep(millis);
	}

	// ┌─────────────────────────────────┐
	// │........iteration control........│
	// └─────────────────────────────────┘

	default void Break() throws Break {
		Style.Break();
	}

	default void Remove() throws Remove {
		Style.Remove();
	}

	default void Continue() throws Continue {
		Style.Continue();
	}

	// ┌─────────────────────────────────┐
	// │...collections, maps and arrays..│
	// └─────────────────────────────────┘

	default ArrayFuncSup<Integer> $(int[] array) {
		return Style.$(array);
	}

	default ArrayFuncSup<Double> $(double[] array) {
		return Style.$(array);
	}

	default ArrayFuncSup<Float> $(float[] array) {
		return Style.$(array);
	}

	default ArrayFuncSup<Boolean> $(boolean[] array) {
		return Style.$(array);
	}

	default ArrayFuncSup<Character> $(char[] array) {
		return Style.$(array);
	}

	default ArrayFuncSup<Byte> $(byte[] array) {
		return Style.$(array);
	}

	default ArrayFuncSup<Long> $(long[] array) {
		return Style.$(array);
	}

	default ArrayFuncSup<Short> $(short[] array) {
		return Style.$(array);
	}

	default <T> ArrayFuncSup<T> $(T[] array) {
		return Style.$(array);
	}

	default <T> IterableFuncSup<T> $(Iterable<T> it) {
		return Style.$(it);
	}

	default <T> CollectionFuncSup<T> $(Collection<T> coll) {
		return Style.$(coll);
	}

	default <E, Coll extends Collection<E>> Coll $(Coll collection, @SuppressWarnings("unchecked") E... elements) {
		return Style.$(collection, elements);
	}

	default <K, V> MapFuncSup<K, V> $(Map<K, V> map) {
		return Style.$(map);
	}

	default <K, V, M extends Map<K, V>> M $(M map, JSONLike<K, V> entries) {
		return Style.$(map, entries);
	}

	// ┌─────────────────────────────────┐
	// │......basic grammar enhance......│
	// └─────────────────────────────────┘
	// for

	default <T> void For(T i, Predicate<T> condition, UnaryOperator<T> increment, def<Object> loop) {
		Style.For(i, condition, increment, loop);
	}

	default <T> void For(T i, Predicate<T> condition, UnaryOperator<T> increment, Void1ArgInterface<T> loop) {
		Style.For(i, condition, increment, loop);
	}

	default <N extends Number> ForSupport<N> For(N start) {
		return Style.For(start);
	}

	default <N extends Number> ForSupport<N> from(N start) {
		return Style.For(start);
	}

	// while

	default void While(BooleanSupplier condition, def<Object> loop) {
		Style.While(condition, loop);
	}

	default void While(BooleanSupplier condition, Void0ArgInterface loop) {
		Style.While(condition, loop);
	}

	// switch

	default <T> SwitchBlock<T> Switch(T t) {
		return Style.Switch(t);
	}

	default <T> SwitchBlock<T> Switch(T t, R2ArgsInterface<Boolean, T, T> method) {
		return Style.Switch(t, method);
	}

	default <T> SwitchBlock<T> Switch(T t, function<Boolean> method) {
		return Style.Switch(t, method);
	}

	// if
	default <T> IfBlock<T> If(boolean expression, T val) {
		return Style.If(expression, val);
	}

	default <T> IfBlock<T> If(boolean expression, R0ArgInterface<T> body) {
		return Style.If(expression, body);
	}

	default <T> IfBlock<T> If(boolean expression, def<T> body) {
		return Style.If(expression, body);
	}

	// ┌─────────────────────────────────┐
	// │............throwable............│
	// └─────────────────────────────────┘

	default StyleRuntimeException $(Throwable t) {
		return Style.$(t);
	}

	// ┌─────────────────────────────────┐
	// │..............other..............│
	// └─────────────────────────────────┘
	// json like
	default <K, V> JSONLike<K, V> $(K key, V value) {
		return Style.$(key, value);
	}

	// date
	default DateFuncSup $(Date date) {
		return Style.$(date);
	}

	// regex
	default RegEx regex(String regex) {
		return Style.regex(regex);
	}

	// comparable
	default <T> ComparableFuncSup<T> $(Comparable<T> comparable) {
		return Style.$(comparable);
	}

	// rand
	default int rand(int start, int end) {
		return Style.rand(start, end);
	}

	default double rand(double start, double end) {
		return Style.rand(start, end);
	}

	default int rand(int max) {
		return Style.rand(max);
	}

	default double rand(double max) {
		return Style.rand(max);
	}

	default String rand(String chooseFrom, int length, boolean unrepeatable, boolean ignoreCase) {
		return Style.rand(chooseFrom, length, unrepeatable, ignoreCase);
	}

	default String rand(String chooseFrom, int length, boolean unrepeatable) {
		return Style.rand(chooseFrom, length, unrepeatable);
	}

	default String rand(String chooseFrom, int length) {
		return Style.rand(chooseFrom, length);
	}

	default int $(IteratorInfo info) {
		return Style.$(info);
	}

	default StringFuncSup $(String base) {
		return Style.$(base);
	}

	/**
	 * Implicit Type Conversion.<br/>
	 * To achieve implicit type conversion,<br/>
	 * the class to be converted to may contain methods like this:<br/>
	 * <code>static R from(T o)</code><br/>
	 * <b>OR</b> the class of the object (param 'o') to convert may contain
	 * methods like this:<br/>
	 * <code>toT</code><br/>
	 * e.g.<br/>
	 * The following definition means you can convert String to User or convert
	 * User to String with this method.
	 * 
	 * <pre>
	 * static User from(String s)...
	 * String toString()...
	 * </pre>
	 * 
	 * @param o
	 *            original object
	 * @param cls
	 *            the type to convert to
	 * @return object of converted type
	 */
	default <T> T imp(Object o, Class<T> cls) {
		return Style.imp(o, cls);
	}

	/**
	 * get object in real type<br/>
	 * if you defined object using <code>var v=...</code>
	 * 
	 * @return object in real type
	 */
	@SuppressWarnings("unchecked")
	default <TYPE> TYPE $() {
		return (TYPE) this;
	}

	/**
	 * get object in targeted type<br/>
	 * if you defined object using <code>var v=...</code>
	 * 
	 * @param cls
	 *            target type
	 * @return object in targeted type
	 */
	@SuppressWarnings("unchecked")
	default <TYPE> TYPE $(Class<TYPE> cls) {
		return (TYPE) this;
	}

}
