package net.cassite.style.util.lang;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static net.cassite.style.Style.*;

/**
 * Supporter for strings
 *
 * @author wkgcass
 */
public class string {
        private String str;

        private static Map<String, string> map = new ConcurrentHashMap<>();

        public static string get(String str) {
                if (map.containsKey(str)) {
                        return map.get(str);
                } else {
                        string s = new string(str);
                        map.put(str, s);
                        return s;
                }
        }

        private string(String str) {
                this.str = str;
        }

        /**
         * fill the string like <code>My name is {0}, I'm {1} years old</code>
         * with given objects.<br>
         * simply invoke {@link MessageFormat#format(String, Object...)}
         *
         * @param fill fill object
         * @return formated string
         */
        public String fill(Object... fill) {
                return MessageFormat.format(str, fill);
        }

        /**
         * fill the string like
         * <code>My name is ${name}, I'm ${age} years old</code> with fields in
         * the given object.
         *
         * @param obj from object
         * @return formated string
         */
        public String from(Object obj) {
                StringBuilder sb = new StringBuilder(str);
                Method[] methods = obj.getClass().getMethods();
                Field[] fields = obj.getClass().getDeclaredFields();
                int lastIndex = -1;
                out:
                while (true) {
                        int start = sb.indexOf("${", lastIndex) + 2;
                        if (start == 1) {
                                break;
                        }
                        int end = sb.indexOf("}", start);
                        if (end == -1 || start == end) {
                                break;
                        }
                        String name = sb.substring(start, end);
                        // check functional methods
                        for (Method m : methods) {
                                String mName = m.getName();
                                if (m.getParameterTypes().length == 0 && m.getReturnType() != Void.TYPE && mName.equals(name)) {
                                        m.setAccessible(true);
                                        try {
                                                sb.replace(start - 2, end + 1, m.invoke(obj, new Object[0]).toString());
                                        } catch (Exception e) {
                                                throw $(e);
                                        }
                                        lastIndex = end;
                                        continue out;
                                }
                        }
                        // check getter
                        for (Method m : methods) {
                                String mName = m.getName();
                                if (m.getParameterTypes().length == 0 && m.getReturnType() != Void.TYPE
                                        && mName.equals("get" + name.substring(0, 1).toUpperCase() + name.substring(1))) {
                                        m.setAccessible(true);
                                        try {
                                                sb.replace(start - 2, end + 1, m.invoke(obj, new Object[0]).toString());
                                        } catch (Exception e) {
                                                throw $(e);
                                        }
                                        lastIndex = end;
                                        continue out;
                                }
                        }
                        // check field
                        for (Field f : fields) {
                                if (f.getName().equals(name)) {
                                        f.setAccessible(true);
                                        try {
                                                sb.replace(start - 2, end + 1, f.get(obj).toString());
                                        } catch (Exception e) {
                                                throw $(e);
                                        }
                                        lastIndex = end;
                                        continue out;
                                }
                        }
                        lastIndex = end;
                }
                str = sb.toString();
                return str;
        }

        @Override
        public String toString() {
                return str;
        }

        /**
         * generate a new string object with a sequence appended to the end of
         * current string
         *
         * @param str the string to append
         * @return new string object
         */
        public string add(String str) {
                return get(this.str + str);
        }
}