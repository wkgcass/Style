package net.cassite.style;

import java.util.Date;

import net.cassite.style.aggregation.A1ArrTransformer;
import net.cassite.style.aggregation.A1FuncSup;
import net.cassite.style.aggregation.A1Transformer;
import net.cassite.style.aggregation.MapFuncSup;
import net.cassite.style.control.Break;
import net.cassite.style.control.Continue;
import net.cassite.style.control.Remove;
import net.cassite.style.interfaces.RFunc1;
import net.cassite.style.interfaces.RFunc2;
import net.cassite.style.interfaces.VFunc1;

import static net.cassite.style.Style.*;
import static net.cassite.style.util.Utils.*;

/**
 * Constants that's usually used with <b>Style tool box</b><br>
 * Recommended context are provided, but they are not limited to those
 * recommendations.
 *
 * @author wkgcass
 */
public class $ {
        private $() {
        }

        private static RFunc1<Boolean, ?> alwaysTrue = t -> true;

        /**
         * Used as 1st argument in {@link A1FuncSup#forThose(RFunc1, def)} or
         * {@link MapFuncSup#forThose(RFunc2, def)} <br>
         * When its supposed to be always true
         *
         * @return alwaysTrue
         */
        @SuppressWarnings("unchecked")
        public static <T> RFunc1<Boolean, T> alwaysTrue() {
                return (RFunc1<Boolean, T>) alwaysTrue;
        }

        private static RFunc1<?, ?> copy = e -> e;

        /**
         * Used as 1st argument in {@link A1Transformer#via(RFunc1)} or
         * {@link A1ArrTransformer#via(RFunc1)} <br>
         * When its supposed to fill new collection/array with exactly same
         * values.
         *
         * @return copy
         */
        @SuppressWarnings("unchecked")
        public static <R, T> RFunc1<R, T> copy() {
                return (RFunc1<R, T>) copy;
        }

        private static def<?> copyFunc = $(copy);

        /**
         * Used as 1st argument in {@link A1Transformer#via(def)} or
         * {@link A1ArrTransformer#via(def)} <br>
         * When its supposed to fill new collection/array with exactly same
         * values.
         *
         * @return copyFunc
         */
        @SuppressWarnings("unchecked")
        public static <T> def<T> copyFunc() {
                return (def<T>) copyFunc;
        }

        private static RFunc1<String, String> trim = String::trim;

        /**
         * Used as 1st argument in {@link A1Transformer#via(RFunc1)} or
         * {@link A1ArrTransformer#via(RFunc1)} <br>
         * When its supposed to fill collection/array with trimmed values.
         *
         * @return trim
         */
        public static RFunc1<String, String> trim() {
                return trim;
        }

        private static def<String> trimFunc = $(trim);

        /**
         * Used as 1st argument in {@link A1Transformer#via(def)} or
         * {@link A1ArrTransformer#via(def)} <br>
         * When its supposed to fill collection/array with trimmed values.
         *
         * @return trimFunc
         */
        public static def<String> trimFunc() {
                return trimFunc;
        }

        private static RFunc2<?, ?, ?> values = (k, v) -> v;

        /**
         * Used as 1st argument in
         * {@link MapFuncSup.TransformerColl#via(RFunc2)}<br>
         * When its supposed to fill collection with values of the map
         *
         * @return values
         */
        @SuppressWarnings("unchecked")
        public static <K, V> RFunc2<V, K, V> values() {
                return (RFunc2<V, K, V>) values;
        }

        private static def<?> valuesFunc = $(values);

        /**
         * Used as 1st argument in {@link MapFuncSup.TransformerColl#via(def)}
         * <br>
         * When its supposed to fill collection with values of the map
         *
         * @return valuesFunc
         */
        @SuppressWarnings("unchecked")
        public static <V> def<V> valuesFunc() {
                return (def<V>) valuesFunc;
        }

        private static RFunc2<?, ?, ?> keys = (k, v) -> k;

        /**
         * Used as 1st argument in
         * {@link MapFuncSup.TransformerColl#via(RFunc2)}<br>
         * When its supposed to fill collection with keys of the map
         *
         * @return keys
         */
        @SuppressWarnings("unchecked")
        public static <K, V> RFunc2<K, K, V> keys() {
                return (RFunc2<K, K, V>) keys;
        }

        private static def<?> keysFunc = $(keys);

        /**
         * Used as 1st argument in {@link MapFuncSup.TransformerColl#via(def)}
         * <br>
         * When its supposed to fill collection with keys of the map
         *
         * @return keyFunc
         */
        @SuppressWarnings("unchecked")
        public static <K> def<K> keyFunc() {
                return (def<K>) keysFunc;
        }

        private static RFunc2<Entry<?, ?>, ?, ?> entries = Entry::new;

        /**
         * Used as 1st argument in {@link MapFuncSup.TransformerMap#via(RFunc2)}
         * <br>
         * When its supposed to fill map with exactly the same entries.
         *
         * @return entries
         */
        @SuppressWarnings("unchecked")
        public static <K, V, En extends Entry<K, V>> RFunc2<En, K, V> entries() {
                return (RFunc2<En, K, V>) entries;
        }

        private static def<? extends Entry<?, ?>> entriesFunc = $(entries);

        /**
         * Used as 1st argument in {@link MapFuncSup.TransformerMap#via(def)}
         * <br>
         * When its supposed to fill map with exactly the same entries.
         *
         * @return entriesFunc
         */
        @SuppressWarnings("unchecked")
        public static <K, V, En extends Entry<K, V>> def<En> entriesFunc() {
                return (def<En>) entriesFunc;
        }

        private static RFunc2<Entry<?, ?>, ?, ?> mapCopy = entries;

        /**
         * Used as 1st argument in {@link MapFuncSup.TransformerMap#via(RFunc2)}
         * <br>
         * When its supposed to fill map with exactly the same entries.<br>
         * an alias of {@link #entries()}
         *
         * @return mapCopy
         * @see #entries()
         */
        @SuppressWarnings("unchecked")
        public static <K, V, En extends Entry<K, V>> RFunc2<En, K, V> mapCopy() {
                return (RFunc2<En, K, V>) mapCopy;
        }

        private static def<? extends Entry<?, ?>> mapCopyFunc = entriesFunc;

        /**
         * Used as 1st argument in {@link MapFuncSup.TransformerMap#via(def)}
         * <br>
         * When its supposed to fill map with exactly the same entries.<br>
         * an alias of {@link #entriesFunc()}
         *
         * @return mapCopyFunc
         * @see #entriesFunc()
         */
        @SuppressWarnings("unchecked")
        public static <K, V, En extends Entry<K, V>> def<En> mapCopyFunc() {
                return (def<En>) mapCopyFunc;
        }

        static final Break Control_Break = new Break();
        static final Remove Control_Remove = new Remove();
        static final Continue Control_Continue = new Continue();

        /**
         * @return current date
         */
        public static Date current() {
                return new Date();
        }

        /**
         * an alias for {@link #current()}
         *
         * @return current date
         * @see #current()
         */
        public static Date today() {
                return current();
        }

        /**
         * @return date represents tomorrow
         */
        public static Date tomorrow() {
                return $(new Date()).add(d -> d.day(1)).getDate();
        }

        /**
         * @return date represents yesterday
         */
        public static Date yesterday() {
                return $(new Date()).subtract(d -> d.day(1)).getDate();
        }

        /**
         * Used as 1st argument in {@link net.cassite.style.util.Utils#rand(String, int)} or
         * {@link net.cassite.style.util.Utils#rand(String, int, boolean)} or
         * {@link net.cassite.style.util.Utils#rand(String, int, boolean, boolean)}<br>
         * When required to generating strings from lower case characters
         */
        public static final String fromLowerCases = "abcdefghijklmnopqrstuvwxyz";

        /**
         * Used as 1st argument in {@link net.cassite.style.util.Utils#rand(String, int)} or
         * {@link net.cassite.style.util.Utils#rand(String, int, boolean)} or
         * {@link net.cassite.style.util.Utils#rand(String, int, boolean, boolean)}<br>
         * When required to generating strings from upper case characters
         */
        public static final String fromUpperCases = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        /**
         * Used as 1st argument in {@link net.cassite.style.util.Utils#rand(String, int)} or
         * {@link net.cassite.style.util.Utils#rand(String, int, boolean)} or
         * {@link net.cassite.style.util.Utils#rand(String, int, boolean, boolean)}<br>
         * When required to generating strings from 0-9
         */
        public static final String fromNumbers = "0123456789";

        /**
         * Used as 1st argument in {@link net.cassite.style.util.Utils#rand(String, int)} or
         * {@link net.cassite.style.util.Utils#rand(String, int, boolean)} or
         * {@link net.cassite.style.util.Utils#rand(String, int, boolean, boolean)}<br>
         * When required to generating strings from 0-F
         */
        public static final String fromHex = fromNumbers + "ABCDEF";

        /**
         * Used as 1st argument in {@link net.cassite.style.util.Utils#rand(String, int)} or
         * {@link net.cassite.style.util.Utils#rand(String, int, boolean)} or
         * {@link net.cassite.style.util.Utils#rand(String, int, boolean, boolean)}<br>
         * When required to generating strings from
         * <code>fromLowerCases + fromUpperCases + fromNumbers</code>
         */
        public static final String fromAll = fromLowerCases + fromUpperCases + fromNumbers;

        /**
         * Used as 1st argument in {@link net.cassite.style.util.Utils#rand(String, int)} or
         * {@link net.cassite.style.util.Utils#rand(String, int, boolean)} or
         * {@link net.cassite.style.util.Utils#rand(String, int, boolean, boolean)}<br>
         * When required to generating strings from
         * 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678'(without those
         * easily mistaken)
         */
        public static final String fromRecognizable = "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678";

        /**
         * Used as 1st argument in {@link net.cassite.style.util.Utils#rand(String, int)} or
         * {@link net.cassite.style.util.Utils#rand(String, int, boolean)} or
         * {@link net.cassite.style.util.Utils#rand(String, int, boolean, boolean)}<br>
         * When required to generating strings from all keys(with or without
         * shift)
         */
        public static final String fromKeyboard = "`~1!2@3#4$5%6^7&8*9(0)-_=+qQeErRtTyYuUiIoOpP[{]}\\|aAsSdDfFgGhHjJkKlL;:'\"zZxXcCvVbBnNmM,<.>/?";

        /**
         * Used as 1st argument in {@link AsyncGroup#onError(VFunc1)} or
         * {@link Async#onError(VFunc1)} or {@link Async#awaitError(VFunc1)}
         * <br>
         * When the error needs to be thrown.
         */
        public static final VFunc1<StyleRuntimeException> throwHandler = (err) -> {
                throw err;
        };

        /**
         * Used as 1st argument in {@link AsyncGroup#onError(def)} or
         * {@link Async#onError(def)} or {@link Async#awaitError(def)} <br>
         * When the error needs to be thrown.
         */
        public static final def<Void> throwHandlerFunc = $(throwHandler);

        /**
         * Used as 1st argument in {@link AsyncGroup#onError(VFunc1)} or
         * {@link Async#onError(VFunc1)} or {@link Async#awaitError(VFunc1)}
         * <br>
         * When the its needed to call <code>err.printStackTract()</code>
         */
        public static final VFunc1<StyleRuntimeException> printHandler = (err) -> err.origin().printStackTrace();

        /**
         * Used as 1st argument in {@link AsyncGroup#onError(def)} or
         * {@link Async#onError(def)} or {@link Async#awaitError(def)} <br>
         * When the its needed to call <code>err.printStackTract()</code>
         */
        public static final def<Void> printHandlerFunc = $(printHandler);

        /**
         * Used as 3rd argument in {@link Style#Switch(Object, Class, RFunc2)}
         * <br>
         * When the switch is a normal switch when two objects' value are equal,
         * do case.
         */
        public static final RFunc2<Boolean, ?, ?> eql = Object::equals;

        /**
         * Used as 3rd argument in {@link Style#Switch(Object, Class, RFunc2)}
         * <br>
         * When the switch is a normal switch when two objects' value are equal,
         * do case.
         *
         * @return eql
         */
        @SuppressWarnings("unchecked")
        public static <T> RFunc2<Boolean, T, T> eql() {
                return (RFunc2<Boolean, T, T>) eql;
        }

        /**
         * Used as 3rd argument in {@link Style#Switch(Object, Class, def)} <br>
         * When the switch is a normal switch when two objects' value are equal,
         * do case.
         */
        public static final def<Boolean> eqlFunc = $(eql);

        public static final String[] readOnlyToSearch = new String[]{"add", "set", "update", "append", "put", "push", "pop", "remove", "delete",
                "insert"};
}