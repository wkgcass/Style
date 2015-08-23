package net.cassite.style;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.cassite.style.control.Remove;
import net.cassite.style.interfaces.*;

public class MapFuncSup<K, V> {
	private Map<K, V> map;

	MapFuncSup(Map<K, V> map) {
		this.map = map;
	}

	@SuppressWarnings("unchecked")
	public <R> R forEach(VFunc2<K, V> func) {
		return (R) forEach(Style.$(func));
	}

	@SuppressWarnings("unchecked")
	public <R> R forEach(VFunc3<K, V, IteratorInfo<R>> func) {
		return (R) forEach(Style.$(func));
	}

	public <R> R forEach(RFunc2<R, K, V> func) {
		return forEach(Style.$(func));
	}

	public <R> R forEach(RFunc3<R, K, V, IteratorInfo<R>> func) {
		return forEach(Style.$(func));
	}

	public <R> R forEach(def<R> func) {
		return forThose((k, v) -> true, func);
	}

	@SuppressWarnings("unchecked")
	public <R> R forThose(RFunc2<Boolean, K, V> predicate, VFunc2<K, V> func) {
		return (R) forThose(predicate, Style.$(func));
	}

	@SuppressWarnings("unchecked")
	public <R> R forThose(RFunc2<Boolean, K, V> predicate, VFunc3<K, V, IteratorInfo<R>> func) {
		return (R) forThose(predicate, Style.$(func));
	}

	public <R> R forThose(RFunc2<Boolean, K, V> predicate, RFunc2<R, K, V> func) {
		return forThose(predicate, Style.$(func));
	}

	public <R> R forThose(RFunc2<Boolean, K, V> predicate, RFunc3<R, K, V, IteratorInfo<R>> func) {
		return forThose(predicate, Style.$(func));
	}

	public <R> R forThose(RFunc2<Boolean, K, V> predicate, def<R> func) {
		Iterator<K> it = map.keySet().iterator();
		IteratorInfo<R> info = new IteratorInfo<R>();
		ptr<Integer> i = Style.ptr(0);
		return Style.While(() -> it.hasNext(), (loopInfo) -> {
			K k = it.next();
			V v = map.get(k);
			try {
				return Style.If(predicate.apply(k, v), () -> {
					if (func.argCount() == 3)
						return func.apply(k, v,
								info.setValues(i.item - 1, i.item + 1, i.item != 0, it.hasNext(), loopInfo.currentIndex,
										loopInfo.effectiveIndex, loopInfo.lastRes));
					else
						return func.apply(k, v);
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

		public Coll via(RFunc2<R, K, V> method) {
			return via(Style.$(method));
		}

		public Coll via(def<R> method) {
			Style.$(map).forEach((k, v) -> {
				collection.add(method.apply(k, v));
			});
			return collection;
		}
	}

	public <R, Coll extends Collection<R>> TransformerColl<K, V, R, Coll> to(Coll collection) {
		return new TransformerColl<K, V, R, Coll>(map, collection);
	}

	public static class TransformerArr<K, V, R> {
		private Map<K, V> map;
		private R[] retArr;

		TransformerArr(Map<K, V> map, R[] retArr) {
			this.map = map;
			this.retArr = retArr;
		}

		public R[] via(RFunc2<R, K, V> method) {
			return via(Style.$(method));
		}

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

	public static class TransformerMap<K, V, K2, V2, M extends Map<K2, V2>> {
		private Map<K, V> map;
		private M toMap;

		TransformerMap(Map<K, V> map, M toMap) {
			this.map = map;
			this.toMap = toMap;
		}

		public M via(RFunc2<Entry<K2, V2>, K, V> method) {
			return via(Style.$(method));
		}

		public M via(def<Entry<K2, V2>> method) {
			Style.$(map).forEach((k, v) -> {
				Entry<K2, V2> entry = method.apply(k, v);
				toMap.put(entry.key, entry.value);
			});
			return toMap;
		}
	}

	public <K2, V2, M extends Map<K2, V2>> TransformerMap<K, V, K2, V2, M> to(M m) {
		return new TransformerMap<K, V, K2, V2, M>(map, m);
	}

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

	public V $(K key) {
		return map.get(key);
	}

	public Entry<K, V> findOne(RFunc2<Boolean, K, V> filter) {
		return findOne(Style.$(filter));
	}

	public Entry<K, V> findOne(def<Boolean> filter) {
		return Style.$(findAll(filter, new HashMap<>(), 1)).first();
	}

	public Map<K, V> findAll(RFunc2<Boolean, K, V> filter) {
		return findAll(Style.$(filter));
	}

	public Map<K, V> findAll(def<Boolean> filter) {
		return findAll(filter, new HashMap<K, V>());
	}

	public Map<K, V> findAll(RFunc2<Boolean, K, V> filter, Map<K, V> map) {
		return findAll(Style.$(filter), map);
	}

	public Map<K, V> findAll(def<Boolean> filter, Map<K, V> map) {
		return findAll(filter, map, 0);
	}

	public Map<K, V> findAll(RFunc2<Boolean, K, V> filter, Map<K, V> map, int limit) {
		return findAll(Style.$(filter), map, limit);
	}

	public Map<K, V> findAll(def<Boolean> filter, Map<K, V> map, int limit) {
		return Style.$(this.map).to(map).via((k, v) -> {
			if (!filter.apply(k, v))
				Style.Continue();
			if (limit > 0 && limit <= map.size())
				Style.Break();
			return new Entry<K, V>(k, v);
		});
	}

	public int size() {
		return map.size();
	}
}