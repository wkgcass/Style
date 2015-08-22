package net.cassite.style;

import java.util.Date;
import java.util.function.Predicate;

import net.cassite.style.Supportters.StyleRuntimeException;
import net.cassite.style.Supportters.function;
import net.cassite.style.control.Break;
import net.cassite.style.control.Continue;
import net.cassite.style.control.Remove;
import net.cassite.style.interfaces.R1ArgInterface;
import net.cassite.style.interfaces.R2ArgsInterface;
import net.cassite.style.interfaces.Void1ArgInterface;

public class $ extends Style {
	private $() {
	}

	private static Predicate<?> alwaysTrue = t -> true;

	@SuppressWarnings("unchecked")
	public static <T> Predicate<T> alwaysTrue() {
		return (Predicate<T>) alwaysTrue;
	}

	private static R1ArgInterface<?, ?> copy = e -> e;

	@SuppressWarnings("unchecked")
	public static <T> R1ArgInterface<T, T> copy() {
		return (R1ArgInterface<T, T>) copy;
	}

	private static def<?> copyFunc = $(copy);

	@SuppressWarnings("unchecked")
	public static <T> def<T> copyFunc() {
		return (def<T>) copyFunc;
	}

	private static R1ArgInterface<String, String> trim = s -> s.trim();

	public static R1ArgInterface<String, String> trim() {
		return trim;
	}

	private static def<String> trimFunc = $(trim);

	public static def<String> trimFunc() {
		return trimFunc;
	}

	private static R2ArgsInterface<?, ?, ?> values = (k, v) -> v;

	@SuppressWarnings("unchecked")
	public static <K, V> R2ArgsInterface<V, K, V> values() {
		return (R2ArgsInterface<V, K, V>) values;
	}

	private static def<?> valuesFunc = $(values);

	@SuppressWarnings("unchecked")
	public static <V> def<V> valuesFunc() {
		return (def<V>) valuesFunc;
	}

	private static R2ArgsInterface<?, ?, ?> keys = (k, v) -> k;

	@SuppressWarnings("unchecked")
	public static <K, V> R2ArgsInterface<K, K, V> keys() {
		return (R2ArgsInterface<K, K, V>) keys;
	}

	private static def<?> keysFunc = $(keys);

	@SuppressWarnings("unchecked")
	public static <K> def<K> keyFunc() {
		return (def<K>) keysFunc;
	}

	private static R2ArgsInterface<Entry<?, ?>, ?, ?> entries = (k, v) -> new Entry<>(k, v);

	@SuppressWarnings("unchecked")
	public static <K, V, En extends Entry<K, V>> R2ArgsInterface<En, K, V> entries() {
		return (R2ArgsInterface<En, K, V>) entries;
	}

	private static def<Entry<?, ?>> entriesFunc = $(entries);

	@SuppressWarnings("unchecked")
	public static <K, V, En extends Entry<K, V>> def<En> entriesFunc() {
		return (def<En>) entriesFunc;
	}

	private static R2ArgsInterface<Entry<?, ?>, ?, ?> mapCopy = entries;

	@SuppressWarnings("unchecked")
	public static <K, V, En extends Entry<K, V>> R2ArgsInterface<En, K, V> mapCopy() {
		return (R2ArgsInterface<En, K, V>) mapCopy;
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

	public static final Void1ArgInterface<StyleRuntimeException> throwHandler = (err) -> {
		throw err;
	};

	public static final def<Object> throwHandlerFunc = $(throwHandler);

	public static final Void1ArgInterface<StyleRuntimeException> printHandler = (err) -> {
		err.origin().printStackTrace();
	};

	public static final def<Object> printHandlerFunc = $(printHandler);

	public static final R2ArgsInterface<Boolean, ?, ?> eql = (a, b) -> a.equals(b);

	@SuppressWarnings("unchecked")
	public static <T> R2ArgsInterface<Boolean, T, T> eql() {
		return (R2ArgsInterface<Boolean, T, T>) eql;
	}

	public static final function<Boolean> eqlFunc = $(eql);
}