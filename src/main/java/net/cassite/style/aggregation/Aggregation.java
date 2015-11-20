package net.cassite.style.aggregation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import static net.cassite.style.Core.*;

import net.cassite.style.JSONLike;

public abstract class Aggregation {
        protected Aggregation() {

        }

        // ┌─────────────────────────────────┐
        // │...collections, maps and arrays..│
        // └─────────────────────────────────┘

        /**
         * Create an array supporter with int[]<br>
         * This method converts int[] into a new array:Integer[]<br>
         * and invoke {@link #$(Object[])}
         *
         * @param array the array to support
         * @return Integer[] array supporter
         */
        public static ArrayFuncSup<Integer> $(int[] array) {
                Integer[] arr = new Integer[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
        }

        /**
         * Create an array supporter with double[]<br>
         * This method converts double[] into a new array:Double[]<br>
         * and invoke {@link #$(Object[])}
         *
         * @param array the array to support
         * @return Double[] array supporter
         */
        public static ArrayFuncSup<Double> $(double[] array) {
                Double[] arr = new Double[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
        }

        /**
         * Create an array supporter with float[]<br>
         * This method converts float[] into a new array:Float[]<br>
         * and invoke {@link #$(Object[])}
         *
         * @param array the array to support
         * @return Float[] array supporter
         */
        public static ArrayFuncSup<Float> $(float[] array) {
                Float[] arr = new Float[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
        }

        /**
         * Create an array supporter with boolean[]<br>
         * This method converts boolean[] into a new array:Boolean[]<br>
         * and invoke {@link #$(Object[])}
         *
         * @param array the array to support
         * @return Boolean[] array supporter
         */
        public static ArrayFuncSup<Boolean> $(boolean[] array) {
                Boolean[] arr = new Boolean[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
        }

        /**
         * Create an array supporter with char[]<br>
         * This method converts char[] into a new array:char[]<br>
         * and invoke {@link #$(Object[])}
         *
         * @param array the array to support
         * @return Character[] array supporter
         */
        public static ArrayFuncSup<Character> $(char[] array) {
                Character[] arr = new Character[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
        }

        /**
         * Create an array supporter with byte[]<br>
         * This method converts byte[] into a new array:Byte[]<br>
         * and invoke {@link #$(Object[])}
         *
         * @param array the array to support
         * @return Byte[] array supporter
         */
        public static ArrayFuncSup<Byte> $(byte[] array) {
                Byte[] arr = new Byte[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
        }

        /**
         * Create an array supporter with long[]<br>
         * This method converts long[] into a new array:Long[]<br>
         * and invoke {@link #$(Object[])}
         *
         * @param array the array to support
         * @return Long[] array supporter
         */
        public static ArrayFuncSup<Long> $(long[] array) {
                Long[] arr = new Long[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
        }

        /**
         * Create an array supporter with short[]<br>
         * This method converts short[] into a new array:Short[]<br>
         * and invoke {@link #$(Object[])}
         *
         * @param array the array to support
         * @return Short[] array supporter
         */
        public static ArrayFuncSup<Short> $(short[] array) {
                Short[] arr = new Short[array.length];
                For(0).to(array.length - 1).loop(i -> {
                        arr[i] = array[i];
                });
                return $(arr);
        }

        /**
         * Create an array supporter with T[]<br>
         *
         * @param array the array to support
         * @return Short[] array supporter
         */
        public static <T> ArrayFuncSup<T> $(T[] array) {
                return new ArrayFuncSup<T>(array);
        }

        /**
         * Create an iterable supporter
         *
         * @param it the iterable object to support
         * @return Iterable supporter
         */
        public static <T> IterableFuncSup<T> $(Iterable<T> it) {
                return new IterableFuncSup<>(it);
        }

        /**
         * Create a collection supporter
         *
         * @param coll the collection to support
         * @return Collection supporter
         */
        public static <T> CollectionFuncSup<T> $(Collection<T> coll) {
                return new CollectionFuncSup<>(coll);
        }

        /**
         * Create a list supporter
         *
         * @param coll the list to support
         * @return List supporter
         */
        public static <T> ListFuncSup<T> $(List<T> coll) {
                return new ListFuncSup<T>(coll);
        }

        /**
         * add these elements into given collection.<br>
         * usually used when initializing a collection.<br>
         * however you can also add elements into already existed collections.
         *
         * @param collection the collection to add elements into
         * @param elements   elements to add
         * @return param collection
         */
        @SafeVarargs
        public static <E, Coll extends Collection<E>> Coll $(Coll collection, E... elements) {
                for (E e : elements) {
                        collection.add(e);
                }
                return collection;
        }

        /**
         * Create a map supporter
         *
         * @param map the map to support
         * @return Map supporter
         */
        public static <K, V> MapFuncSup<K, V> $(Map<K, V> map) {
                return new MapFuncSup<>(map);
        }

        /**
         * put entries into the given map.<br>
         * usually used when initializing a map.<br>
         * however you can also put entries into already existed maps.
         *
         * @param map     the map to put entries into
         * @param entries entries to put, in the form of a JSONLike object.<br>
         *                a JSONLike object can be created with
         *                {@link #map(Object, Object)}<br>
         *                and can put in entries using
         *                {@link JSONLike#$(Object, Object)}<br>
         *                e.g.
         *                <p>
         *                <pre>
         *                               map("cass", 1995).$("john", 1994).$("cassie", 1996)
         *                               </pre>
         * @return param map
         * @see JSONLike
         * @see #map(Object, Object)
         */
        public static <K, V, M extends Map<K, V>> M $(M map, JSONLike<K, V> entries) {
                for (K key : entries.keySet()) {
                        map.put(key, entries.get(key));
                }
                return map;
        }

        // json like

        /**
         * Create a JSONLike object.<br>
         * it helps you create a map with similar method as how JSON initializes
         *
         * @param key   first key of the map
         * @param value first value of the map
         * @return a new JSONLike object
         * @see JSONLike
         */
        public static <K, V> JSONLike<K, V> map(K key, V value) {
                return new JSONLike<K, V>(key, value);
        }

        /**
         * Create a JSONLike object from an array similar to JSON
         *
         * @param json an array look like JSON.<br>
         *             e.g.
         *             <p>
         *             <pre>
         *             new Object["name" ,"cass",
         *                       "age", 20,
         *                       "sex", "male"]
         *                            </pre>
         * @return a new JSONLike object
         * @see JSONLike
         */
        public static JSONLike<String, Object> map(Object[] json) {
                if (json.length % 2 != 0 || json.length == 0) {
                        throw new RuntimeException("Wrong json format");
                }
                JSONLike<String, Object> map = new JSONLike<String, Object>(json[0].toString(), json[1]);
                for (int i = 2; i < json.length; i += 2) {
                        String key = json[i].toString();
                        Object value = json[i + 1];
                        map.$(key, value);
                }
                return map;
        }

        /**
         * Join lists into one, the joined list's elements are in order of
         * argument order and original lists' element order<br>
         * you cannot modify the returned joined list's size.<br>
         * in other words, the joined list doesn't support methods like add,
         * remove, addAll, retainAll, removeAll...
         *
         * @param toJoin the lists to join
         * @return a joined list
         */
        @SafeVarargs
        public static <T> List<T> join(List<T>... toJoin) {
                return new JoinedList<>(toJoin);
        }

        @SafeVarargs
        public static <E> List<E> list(E... elements) {
                List<E> toReturn = new ArrayList<E>();
                $(elements).forEach(e -> {
                        toReturn.add(e);
                });
                return toReturn;
        }

        @SafeVarargs
        public static <E> java.util.Set<E> set(E... elements) {
                java.util.Set<E> toReturn = new LinkedHashSet<E>();
                $(elements).forEach(e -> {
                        toReturn.add(e);
                });
                return toReturn;
        }
}
