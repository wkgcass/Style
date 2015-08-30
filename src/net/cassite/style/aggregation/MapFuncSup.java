package net.cassite.style.aggregation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.cassite.style.Entry;
import net.cassite.style.Style;
import net.cassite.style.StyleRuntimeException;
import net.cassite.style.def;
import net.cassite.style.ptr;
import net.cassite.style.control.Remove;
import net.cassite.style.interfaces.*;

/**
 * Supporter of maps
 * 
 * @author wkgcass
 *
 * @param <K>
 *                key type of the map
 * @param <V>
 *                value type of the map
 */
public class MapFuncSup<K, V> {
        private Map<K, V> map;

        MapFuncSup(Map<K, V> map) {
                this.map = map;
        }

        /**
         * define a function to deal with each entry in the map
         * 
         * @param func
         *                a function takes in each entry from map
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         */
        @SuppressWarnings("unchecked")
        public <R> R forEach(VFunc2<K, V> func) {
                return (R) forEach(Style.$(func));
        }

        /**
         * define a function to deal with each entry in the map
         * 
         * @param func
         *                a function takes in each entry from map and iterator
         *                info
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         */
        @SuppressWarnings("unchecked")
        public <R> R forEach(VFunc3<K, V, IteratorInfo<R>> func) {
                return (R) forEach(Style.$(func));
        }

        /**
         * define a function to deal with each entry in the map
         * 
         * @param func
         *                a function takes in each entry from map and returns
         *                'last loop value'
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         */
        public <R> R forEach(RFunc2<R, K, V> func) {
                return forEach(Style.$(func));
        }

        /**
         * define a function to deal with each entry in the map
         * 
         * @param func
         *                a function takes in each entry from map and iterator
         *                info<br>
         *                and returns 'last loop result'
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         * @see IteratorInfo
         */
        public <R> R forEach(RFunc3<R, K, V, IteratorInfo<R>> func) {
                return forEach(Style.$(func));
        }

        /**
         * define a function to deal with each entry in the map
         * 
         * @param func
         *                a function returns 'last loop result'
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         */
        public <R> R forEach(def<R> func) {
                return forThose((k, v) -> true, func);
        }

        /**
         * define a function to deal with each element in the map
         * 
         * @param predicate
         *                a function takes in each element from map and returns
         *                true or false(or null)
         * @param func
         *                a function takes in each element from map
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         */
        @SuppressWarnings("unchecked")
        public <R> R forThose(RFunc2<Boolean, K, V> predicate, VFunc2<K, V> func) {
                return (R) forThose(predicate, Style.$(func));
        }

        /**
         * define a function to deal with each element in the map
         * 
         * @param predicate
         *                a function takes in each element from map and returns
         *                true or false(or null)
         * @param func
         *                a function takes in each element from map and iterator
         *                info
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         * @see IteratorInfo
         */
        @SuppressWarnings("unchecked")
        public <R> R forThose(RFunc2<Boolean, K, V> predicate, VFunc3<K, V, IteratorInfo<R>> func) {
                return (R) forThose(predicate, Style.$(func));
        }

        /**
         * define a function to deal with each element in the map
         * 
         * @param predicate
         *                a function takes in each element from map and returns
         *                true or false(or null)
         * @param func
         *                a function takes in each element from map and returns
         *                'last loop info'
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         */
        public <R> R forThose(RFunc2<Boolean, K, V> predicate, RFunc2<R, K, V> func) {
                return forThose(predicate, Style.$(func));
        }

        /**
         * define a function to deal with each element in the map
         * 
         * @param predicate
         *                a function takes in each element from map and returns
         *                true or false(or null)
         * @param func
         *                a function takes in each element from map and iterator
         *                info<br>
         *                and returns 'last loop result'
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         * @see IteratorInfo
         */
        public <R> R forThose(RFunc2<Boolean, K, V> predicate, RFunc3<R, K, V, IteratorInfo<R>> func) {
                return forThose(predicate, Style.$(func));
        }

        /**
         * define a function to deal with each element in the map
         * 
         * @param predicate
         *                a function takes in each element from map and returns
         *                true or false(or null)
         * @param func
         *                a function returns 'last loop result'
         * @return return 'last loop value'.<br>
         *         check
         *         <a href="https://github.com/wkgcass/Style/">tutorial</a> for
         *         more info about 'last loop value'
         * @see IteratorInfo
         */
        public <R> R forThose(RFunc2<Boolean, K, V> predicate, def<R> func) {
                Iterator<K> it = map.keySet().iterator();
                IteratorInfo<R> info = new IteratorInfo<R>();
                ptr<Integer> i = Style.ptr(0);
                return Style.While(() -> it.hasNext(), (loopInfo) -> {
                        K k = it.next();
                        V v = map.get(k);
                        try {
                                return Style.If(predicate.apply(k, v), () -> {
                                        return func.apply(k, v, info.setValues(i.item - 1, i.item + 1, i.item != 0, it.hasNext(),
                                                        loopInfo.currentIndex, loopInfo.effectiveIndex, loopInfo.lastRes));
                                }).Else(() -> null);
                        } catch (Throwable err) {
                                StyleRuntimeException sErr = Style.$(err);
                                Throwable t = sErr.origin();
                                if (t instanceof Remove) {
                                        it.remove();
                                } else {
                                        throw sErr;
                                }
                        } finally {
                                i.item += 1;
                        }
                        return null;
                });

        }

        /**
         * put entries in a chain way
         * 
         * @param key
         *                key of the entry to put
         * @param value
         *                value of the entry to put
         * @return <code>this</code>
         */
        public MapFuncSup<K, V> append(K key, V value) {
                map.put(key, value);
                return this;
        }

        /**
         * Transformer which transforms a map into a collection
         * 
         * @author wkgcass
         *
         * @param <K>
         *                key type of entry to transform
         * @param <V>
         *                value type of entry to transform
         * @param <R>
         *                element type of the collection to transform to
         * @param <Coll>
         *                collection
         */
        public static class TransformerColl<K, V, R, Coll extends Collection<R>> {
                private Map<K, V> map;
                private Coll collection;

                TransformerColl(Map<K, V> map, Coll collection) {
                        this.map = map;
                        this.collection = collection;
                }

                /**
                 * define the transform process
                 * 
                 * @param method
                 *                a function takes in each entry from the map
                 *                and returns it's transformed state.
                 * @return collection with objects after the transform
                 */
                public Coll via(RFunc2<R, K, V> method) {
                        return via(Style.$(method));
                }

                /**
                 * define the transform process
                 * 
                 * @param method
                 *                a function returns it's transformed state.
                 * @return collection with objects after the transform
                 */
                public Coll via(def<R> method) {
                        Style.$(map).forEach((k, v) -> {
                                collection.add(method.apply(k, v));
                        });
                        return collection;
                }
        }

        /**
         * Entrance of transformer
         * 
         * @param collection
         *                the collection to support
         * @return new MapFuncSup.TransformerColl
         * @see MapFuncSup.TransformerColl
         */
        public <R, Coll extends Collection<R>> TransformerColl<K, V, R, Coll> to(Coll collection) {
                return new TransformerColl<K, V, R, Coll>(map, collection);
        }

        /**
         * Transform a map into an array
         * 
         * @author wkgcass
         *
         * @param <R>
         *                returned array type
         * @param <K>
         *                key type of the entry
         * @param <V>
         *                value type of the entry
         */
        public static class TransformerArr<K, V, R> {
                private Map<K, V> map;
                private R[] retArr;

                TransformerArr(Map<K, V> map, R[] retArr) {
                        this.map = map;
                        this.retArr = retArr;
                }

                /**
                 * define the transform process
                 * 
                 * @param method
                 *                a function takes in each entry from the map
                 *                and returns it's transformed state.
                 * @return an array with objects after the transform
                 */
                public R[] via(RFunc2<R, K, V> method) {
                        return via(Style.$(method));
                }

                /**
                 * define the transform process
                 * 
                 * @param method
                 *                a function takes in each entry from the map
                 *                and returns it's transformed state.
                 * @return an array with objects after the transform
                 */
                public R[] via(def<R> method) {
                        Style.$(map).forEach((k, v, i) -> {
                                if (i.effectiveIndex == retArr.length) {
                                        Style.Break();
                                } else {
                                        retArr[i.effectiveIndex] = method.apply(k, v);
                                }
                        });
                        return retArr;
                }
        }

        /**
         * Entrance of transformer
         * 
         * @param arr
         *                the array to support
         * @return new MapFuncSup.TransformerArr
         * @see MapFuncSup.TransformerArr
         */
        public <R> TransformerArr<K, V, R> to(R[] arr) {
                return new TransformerArr<K, V, R>(map, arr);
        }

        /**
         * Transforms a map into another one
         * 
         * @author wkgcass
         *
         * @param <K>
         *                key type of the map to transform
         * @param <V>
         *                value type of the map to transform
         * @param <K2>
         *                key type of the map to transform to
         * @param <V2>
         *                value type of the map to transform to
         * @param <M>
         *                the map to transform to
         */
        public static class TransformerMap<K, V, K2, V2, M extends Map<K2, V2>> {
                private Map<K, V> map;
                private M toMap;

                TransformerMap(Map<K, V> map, M toMap) {
                        this.map = map;
                        this.toMap = toMap;
                }

                /**
                 * define the transform process
                 * 
                 * @param method
                 *                a function takes in each entry from the map
                 *                and returns it's transformed state.
                 * @return an array with objects after the transform
                 */
                public M via(RFunc2<Entry<K2, V2>, K, V> method) {
                        return via(Style.$(method));
                }

                /**
                 * define the transform process
                 * 
                 * @param method
                 *                a function returns it's transformed state.
                 * @return an array with objects after the transform
                 */
                public M via(def<Entry<K2, V2>> method) {
                        Style.$(map).forEach((k, v) -> {
                                Entry<K2, V2> entry = method.apply(k, v);
                                toMap.put(entry.key, entry.value);
                        });
                        return toMap;
                }
        }

        /**
         * Entrance of transformer
         * 
         * @param m
         *                the map to support
         * @return new MapFuncSup.TransformerMap
         * @see MapFuncSup.TransformerMap
         */
        public <K2, V2, M extends Map<K2, V2>> TransformerMap<K, V, K2, V2, M> to(M m) {
                return new TransformerMap<K, V, K2, V2, M>(map, m);
        }

        /**
         * 
         * @return the first entry of the map or null if it doesn't contain one
         */
        public Entry<K, V> first() {
                Iterator<K> it = map.keySet().iterator();
                if (it.hasNext()) {
                        K k = it.next();
                        V v = map.get(k);
                        return new Entry<>(k, v);
                } else {
                        return null;
                }
        }

        /**
         * retrieve mapped value with given key<br>
         * simply invoke {@link Map#get(Object)}
         * 
         * @param key
         * @return mapped value
         */
        public V $(K key) {
                return map.get(key);
        }

        /**
         * find the first matched entry
         * 
         * @param filter
         *                matching function,<br>
         *                which takes in each entry in map and returns
         *                true/false/null
         * @return first matched entry
         */
        public Entry<K, V> findOne(RFunc2<Boolean, K, V> filter) {
                return findOne(Style.$(filter));
        }

        /**
         * find the first matched entry
         * 
         * @param filter
         *                matching function,<br>
         *                which returns true/false/null
         * @return first matched entry
         */
        public Entry<K, V> findOne(def<Boolean> filter) {
                return Style.$(findAll(filter, new HashMap<>(), 1)).first();
        }

        /**
         * put all matched entries to a new map
         * 
         * @param filter
         *                matching function,<br>
         *                which takes in each entry in map and returns
         *                true/false/null
         * @return all matched entries in a HashMap
         */
        public Map<K, V> findAll(RFunc2<Boolean, K, V> filter) {
                return findAll(Style.$(filter));
        }

        /**
         * put all matched entries to a new map
         * 
         * @param filter
         *                matching function,<br>
         *                which returns true/false/null
         * @return all matched entries in a HashMap
         */
        public Map<K, V> findAll(def<Boolean> filter) {
                return findAll(filter, new HashMap<K, V>());
        }

        /**
         * put all matched entries to given map
         * 
         * @param filter
         *                matching function,<br>
         *                which takes in each entry in map and returns
         *                true/false/null
         * @param map
         *                the map to put entries to
         * @return all matched entries in a HashMap
         */
        public Map<K, V> findAll(RFunc2<Boolean, K, V> filter, Map<K, V> map) {
                return findAll(Style.$(filter), map);
        }

        /**
         * put all matched entries to given map
         * 
         * @param filter
         *                matching function,<br>
         *                which returns true/false/null
         * @param map
         *                the map to put entries to
         * @return all matched entries in a HashMap
         */
        public Map<K, V> findAll(def<Boolean> filter, Map<K, V> map) {
                return findAll(filter, map, 0);
        }

        /**
         * put limited number of matched entries to given map
         * 
         * @param filter
         *                matching function,<br>
         *                which takes in each entry in map and returns
         *                true/false/null
         * @param map
         *                the map to put entries to
         * @param limit
         * @return all matched entries in a HashMap
         */
        public Map<K, V> findAll(RFunc2<Boolean, K, V> filter, Map<K, V> map, int limit) {
                return findAll(Style.$(filter), map, limit);
        }

        /**
         * put limited number of matched entries to given map
         * 
         * @param filter
         *                matching function,<br>
         *                which returns true/false/null
         * @param map
         *                the map to put entries to
         * @param limit
         * @return all matched entries in a HashMap
         */
        public Map<K, V> findAll(def<Boolean> filter, Map<K, V> map, int limit) {
                return Style.$(this.map).to(map).via((k, v) -> {
                        if (!filter.apply(k, v))
                                Style.Continue();
                        if (limit > 0 && limit <= map.size())
                                Style.Break();
                        return new Entry<K, V>(k, v);
                });
        }

        /**
         * simply invoke {@link Map#size()}
         * 
         * @return size of the supported map
         */
        public int size() {
                return map.size();
        }
}