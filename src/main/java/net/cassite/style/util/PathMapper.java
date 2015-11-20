package net.cassite.style.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.cassite.style.Core;
import net.cassite.style.def;
import net.cassite.style.interfaces.RFunc0;

/**
 * A place holding variables based on paths.<br>
 * The paths are separated with '.',<br>
 * a map(String, Object) is used to hold variables, it looks like <br>
 * 
 * <pre>
 *  {a={b={c={$value=i am a.b.c}, $value=abc}}}
 * </pre>
 * 
 * @author wkgcass
 *
 */
public class PathMapper {
        private Map<String, Object> containMap = new ConcurrentHashMap<>();

        private Map<String, Object> getMap(String path) {
                String[] paths = path.split("\\.");

                def<Map<String, Object>> find = Core.function((Integer cursor, Map<String, Object> base, def<Map<String, Object>> func) -> {
                        if (cursor == paths.length) {
                                return base;
                        }
                        if (!base.containsKey(paths[cursor])) {
                                base.put(paths[cursor], new ConcurrentHashMap<String, Object>());
                        }
                        return func.apply(cursor + 1, base.get(paths[cursor]), func);
                });

                return find.apply(0, containMap, find);
        }

        @SuppressWarnings("unchecked")
        public <T> T put(String path, T t) {
                Map<String, Object> map = getMap(path);

                return (T) map.put("$value", t);
        }

        @SuppressWarnings("unchecked")
        public <T> T get(String path) {
                Map<String, Object> map = getMap(path);

                return (T) map.get("$value");
        }

        @SuppressWarnings("unchecked")
        public <T> T get(String path, RFunc0<T> init) {
                Map<String, Object> map = getMap(path);

                if (map.containsKey("$value")) {
                        return (T) map.get("$value");
                } else {
                        try {
                                T t = init.apply();
                                map.put("$value", t);
                                return t;
                        } catch (Throwable t) {
                                throw Core.$(t);
                        }
                }
        }

        public Map<String, Object> getContainMap() {
                return containMap;
        }
}
