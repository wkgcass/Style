package net.cassite.style;

import java.lang.reflect.InvocationHandler;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import net.cassite.style.control.Break;
import net.cassite.style.control.Continue;
import net.cassite.style.control.Remove;
import net.cassite.style.interfaces.*;
import net.cassite.style.reflect.ClassSup;
import net.cassite.style.reflect.ProxyHandler;

public interface var {

	// ┌─────────────────────────────────┐
	// │............function.............│
	// └─────────────────────────────────┘

	// void functions

	default def<Object> function(VFunc0 body) {
		return Style.function(body);
	}

	default def<Object> function(VFunc1<?> body) {
		return Style.function(body);
	}

	default def<Object> function(VFunc2<?, ?> body) {
		return Style.function(body);
	}

	default def<Object> function(VFunc3<?, ?, ?> body) {
		return Style.function(body);
	}

	default def<Object> function(VFunc4<?, ?, ?, ?> body) {
		return Style.function(body);
	}

	default def<Object> function(VFunc5<?, ?, ?, ?, ?> body) {
		return Style.function(body);
	}

	default def<Object> function(VFunc6<?, ?, ?, ?, ?, ?> body) {
		return Style.function(body);
	}

	default def<Object> function(VFunc7<?, ?, ?, ?, ?, ?, ?> body) {
		return Style.function(body);
	}

	// functions with return value

	default <R> def<R> function(RFunc0<R> body) {
		return Style.function(body);
	}

	default <R> def<R> function(RFunc1<R, ?> body) {
		return Style.function(body);
	}

	default <R> def<R> function(RFunc2<R, ?, ?> body) {
		return Style.function(body);
	}

	default <R> def<R> function(RFunc3<R, ?, ?, ?> body) {
		return Style.function(body);
	}

	default <R> def<R> function(RFunc4<R, ?, ?, ?, ?> body) {
		return Style.function(body);
	}

	default <R> def<R> function(RFunc5<R, ?, ?, ?, ?, ?> body) {
		return Style.function(body);
	}

	default <R> def<R> function(RFunc6<R, ?, ?, ?, ?, ?, ?> body) {
		return Style.function(body);
	}

	default <R> def<R> function(RFunc7<R, ?, ?, ?, ?, ?, ?, ?> body) {
		return Style.function(body);
	}

	// void functions

	default def<Object> $(VFunc0 body) {
		return Style.$(body);
	}

	default def<Object> $(VFunc1<?> body) {
		return Style.$(body);
	}

	default def<Object> $(VFunc2<?, ?> body) {
		return Style.$(body);
	}

	default def<Object> $(VFunc3<?, ?, ?> body) {
		return Style.$(body);
	}

	default def<Object> $(VFunc4<?, ?, ?, ?> body) {
		return Style.$(body);
	}

	default def<Object> $(VFunc5<?, ?, ?, ?, ?> body) {
		return Style.$(body);
	}

	default def<Object> $(VFunc6<?, ?, ?, ?, ?, ?> body) {
		return Style.$(body);
	}

	default def<Object> $(VFunc7<?, ?, ?, ?, ?, ?, ?> body) {
		return Style.$(body);
	}

	// functions with return value

	default <R> def<R> $(RFunc0<R> body) {
		return Style.$(body);
	}

	default <R> def<R> $(RFunc1<R, ?> body) {
		return Style.$(body);
	}

	default <R> def<R> $(RFunc2<R, ?, ?> body) {
		return Style.$(body);
	}

	default <R> def<R> $(RFunc3<R, ?, ?, ?> body) {
		return Style.$(body);
	}

	default <R> def<R> $(RFunc4<R, ?, ?, ?, ?> body) {
		return Style.$(body);
	}

	default <R> def<R> $(RFunc5<R, ?, ?, ?, ?, ?> body) {
		return Style.$(body);
	}

	default <R> def<R> $(RFunc6<R, ?, ?, ?, ?, ?, ?> body) {
		return Style.$(body);
	}

	default <R> def<R> $(RFunc7<R, ?, ?, ?, ?, ?, ?, ?> body) {
		return Style.$(body);
	}

	// function support

	default <T> ptr<T> ptr(T o) {
		return Style.ptr(o);
	}

	default <T> T $(ptr<T> store) {
		return Style.$(store);
	}

	default <T> ptr<T> $(ptr<T> ptr, T newItem) {
		return Style.$(ptr, newItem);
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

	default AsyncGroup $(VFunc1<StyleRuntimeException> handler, Async<?>... asyncs) {
		return Style.$(handler, asyncs);
	}

	default <R> R await(Async<R> async) {
		return Style.await(async);
	}

	default Thread run(VFunc0 runnable) {
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

	default <T> T Break() throws Break {
		return Style.Break();
	}

	default <T> T Remove() throws Remove {
		return Style.Remove();
	}

	default <T> T Continue() throws Continue {
		return Style.Continue();
	}

	default <T> T BreakWithResult(T res) {
		return Style.BreakWithResult(res);
	}

	default <T> T Set(T toSet) {
		return Style.Set(toSet);
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

	default <T> ListFuncSup<T> $(List<T> list) {
		return Style.$(list);
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

	default <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, def<R> loop) {
		return Style.For(i, condition, increment, loop);
	}

	default <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, VFunc1<T> loop) {
		return Style.For(i, condition, increment, loop);
	}

	default <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, RFunc1<R, T> loop) {
		return Style.For(i, condition, increment, loop);
	}

	default <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, VFunc2<T, LoopInfo<R>> loop) {
		return Style.For(i, condition, increment, loop);
	}

	default <T, R> R For(T i, Predicate<T> condition, UnaryOperator<T> increment, RFunc2<R, T, LoopInfo<R>> loop) {
		return Style.For(i, condition, increment, loop);
	}

	default <N extends Number> ForSupport<N> For(N start) {
		return Style.For(start);
	}

	default <N extends Number> ForSupport<N> from(N start) {
		return Style.For(start);
	}

	// while

	default <R> R While(BooleanSupplier condition, def<R> loop) {
		return Style.While(condition, loop);
	}

	default <R> R While(BooleanSupplier condition, VFunc0 loop) {
		return Style.While(condition, loop);
	}

	default <R> R While(BooleanSupplier condition, RFunc0<R> loop) {
		return Style.While(condition, loop);
	}

	default <R> R While(BooleanSupplier condition, VFunc1<LoopInfo<R>> loop) {
		return Style.While(condition, loop);
	}

	default <R> R While(BooleanSupplier condition, RFunc1<R, LoopInfo<R>> loop) {
		return Style.While(condition, loop);
	}

	// switch

	default <T> SwitchBlock<T, T> Switch(T t) {
		return Style.Switch(t);
	}

	default <T> SwitchBlock<T, T> Switch(T t, RFunc2<Boolean, T, T> method) {
		return Style.Switch(t, method);
	}

	default <T> SwitchBlock<T, T> Switch(T t, def<Boolean> method) {
		return Style.Switch(t, method);
	}

	default <T, R> SwitchBlock<T, R> Switch(T t, Class<R> cls) {
		return Style.Switch(t, cls);
	}

	default <T, R> SwitchBlock<T, R> Switch(T t, Class<R> cls, RFunc2<Boolean, T, T> method) {
		return Style.Switch(t, cls, method);
	}

	default <T, R> SwitchBlock<T, R> Switch(T t, Class<R> cls, def<Boolean> method) {
		return Style.Switch(t, cls, method);
	}

	// if

	default <T, INIT> IfBlock<T, INIT> If(INIT init, T val) {
		return Style.If(init, val);
	}

	default <T, INIT> IfBlock<T, INIT> If(INIT init, RFunc1<T, INIT> body) {
		return Style.If(init, body);
	}

	default <T, INIT> IfBlock<T, INIT> If(INIT init, VFunc1<INIT> body) {
		return Style.If(init, body);
	}

	default <T, INIT> IfBlock<T, INIT> If(INIT init, RFunc0<T> body) {
		return Style.If(init, body);
	}

	default <T, INIT> IfBlock<T, INIT> If(INIT init, VFunc0 body) {
		return Style.If(init, body);
	}

	default <T, INIT> IfBlock<T, INIT> If(INIT init, def<T> body) {
		return Style.If(init, body);
	}

	default <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, T val) {
		return Style.If(init, val);
	}

	default <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, RFunc1<T, INIT> body) {
		return Style.If(init, body);
	}

	default <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, VFunc1<INIT> body) {
		return Style.If(init, body);
	}

	default <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, RFunc0<T> body) {
		return Style.If(init, body);
	}

	default <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, VFunc0 body) {
		return Style.If(init, body);
	}

	default <T, INIT> IfBlock<T, INIT> If(RFunc0<INIT> init, def<T> body) {
		return Style.If(init, body);
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
	default <K, V> JSONLike<K, V> map(K key, V value) {
		return Style.map(key, value);
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

	default int $(IteratorInfo<?> info) {
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

	default <T> T avoidNull(T t, RFunc0<T> Default) {
		return Style.avoidNull(t, Default);
	}

	// ┌─────────────────────────────────┐
	// │...........reflection............│
	// └─────────────────────────────────┘

	default <T> ClassSup<T> cls(Class<T> cls) {
		return Style.cls(cls);
	}

	default ClassSup<?> cls(String clsName) {
		return Style.cls(clsName);
	}

	default ClassSup<?> cls(Object obj) {
		return Style.cls(obj);
	}

	default <P> P proxy(ProxyHandler<P> proxyHandler) {
		return Style.proxy(proxyHandler);
	}

	default <T> T proxy(InvocationHandler handler, T toProxy) {
		return Style.proxy(handler, toProxy);
	}

}
