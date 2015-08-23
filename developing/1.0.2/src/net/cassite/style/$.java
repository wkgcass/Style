package net.cassite.style;

import java.util.Date;

import net.cassite.style.control.Break;
import net.cassite.style.control.Continue;
import net.cassite.style.control.Remove;
import net.cassite.style.interfaces.RFunc1;
import net.cassite.style.interfaces.RFunc2;
import net.cassite.style.interfaces.VFunc1;

public class $ extends Style {
	private $() {
	}

	private static RFunc1<Boolean, ?> alwaysTrue = t -> true;

	@SuppressWarnings("unchecked")
	public static <T> RFunc1<Boolean, T> alwaysTrue() {
		return (RFunc1<Boolean, T>) alwaysTrue;
	}

	private static RFunc1<?, ?> copy = e -> e;

	@SuppressWarnings("unchecked")
	public static <R, T> RFunc1<R, T> copy() {
		return (RFunc1<R, T>) copy;
	}

	private static def<?> copyFunc = $(copy);

	@SuppressWarnings("unchecked")
	public static <T> def<T> copyFunc() {
		return (def<T>) copyFunc;
	}

	private static RFunc1<String, String> trim = s -> s.trim();

	public static RFunc1<String, String> trim() {
		return trim;
	}

	private static def<String> trimFunc = $(trim);

	public static def<String> trimFunc() {
		return trimFunc;
	}

	private static RFunc2<?, ?, ?> values = (k, v) -> v;

	@SuppressWarnings("unchecked")
	public static <K, V> RFunc2<V, K, V> values() {
		return (RFunc2<V, K, V>) values;
	}

	private static def<?> valuesFunc = $(values);

	@SuppressWarnings("unchecked")
	public static <V> def<V> valuesFunc() {
		return (def<V>) valuesFunc;
	}

	private static RFunc2<?, ?, ?> keys = (k, v) -> k;

	@SuppressWarnings("unchecked")
	public static <K, V> RFunc2<K, K, V> keys() {
		return (RFunc2<K, K, V>) keys;
	}

	private static def<?> keysFunc = $(keys);

	@SuppressWarnings("unchecked")
	public static <K> def<K> keyFunc() {
		return (def<K>) keysFunc;
	}

	private static RFunc2<Entry<?, ?>, ?, ?> entries = (k, v) -> new Entry<>(k, v);

	@SuppressWarnings("unchecked")
	public static <K, V, En extends Entry<K, V>> RFunc2<En, K, V> entries() {
		return (RFunc2<En, K, V>) entries;
	}

	private static def<Entry<?, ?>> entriesFunc = $(entries);

	@SuppressWarnings("unchecked")
	public static <K, V, En extends Entry<K, V>> def<En> entriesFunc() {
		return (def<En>) entriesFunc;
	}

	private static RFunc2<Entry<?, ?>, ?, ?> mapCopy = entries;

	@SuppressWarnings("unchecked")
	public static <K, V, En extends Entry<K, V>> RFunc2<En, K, V> mapCopy() {
		return (RFunc2<En, K, V>) mapCopy;
	}

	private static def<Entry<?, ?>> mapCopyFunc = entriesFunc;

	@SuppressWarnings("unchecked")
	public static <K, V, En extends Entry<K, V>> def<En> mapCopyFunc() {
		return (def<En>) mapCopyFunc;
	}

	static final Break Control_Break = new Break();
	static final Remove Control_Remove = new Remove();
	static final Continue Control_Continue = new Continue();

	public static Date current() {
		return new Date();
	}

	public static Date today() {
		return current();
	}

	public static Date tomorrow() {
		return $(new Date()).add(d -> d.day(1)).getDate();
	}

	public static Date yesterday() {
		return $(new Date()).substract(d -> d.day(1)).getDate();
	}

	public static final String fromLowerCases = "abcdefghijklmnopqrstuvwxyz";

	public static final String fromUpperCases = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final String fromNumbers = "0123456789";

	public static final String fromHex = "0123456789ABCDEF";

	public static final String fromAll = fromLowerCases + fromUpperCases + fromNumbers + fromHex;

	public static final String fromRecognizable = "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678";

	public static final String fromKeyboard = "`~1!2@3#4$5%6^7&8*9(0)-_=+qQeErRtTyYuUiIoOpP[{]}\\|aAsSdDfFgGhHjJkKlL;:'\"zZxXcCvVbBnNmM,<.>/?";

	public static final VFunc1<StyleRuntimeException> throwHandler = (err) -> {
		throw err;
	};

	public static final def<Object> throwHandlerFunc = $(throwHandler);

	public static final VFunc1<StyleRuntimeException> printHandler = (err) -> {
		err.origin().printStackTrace();
	};

	public static final def<Object> printHandlerFunc = $(printHandler);

	public static final RFunc2<Boolean, ?, ?> eql = (a, b) -> a.equals(b);

	@SuppressWarnings("unchecked")
	public static <T> RFunc2<Boolean, T, T> eql() {
		return (RFunc2<Boolean, T, T>) eql;
	}

	public static final def<Boolean> eqlFunc = $(eql);
}