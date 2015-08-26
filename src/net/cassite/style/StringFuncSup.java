package net.cassite.style;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;

/**
 * Supporter for strings
 * 
 * @author wkgcass
 *
 */
public class StringFuncSup extends Style {
        private String str;

        StringFuncSup(String str) {
                this.str = str;
        }

        /**
         * fill the string like <code>My name is {0}, I'm {1} years old</code>
         * with given objects.<br>
         * simply invoke {@link MessageFormat#format(String, Object...)}
         * 
         * @param fill
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
         * @param obj
         * @return formated string
         */
        public String from(Object obj) {
                StringBuilder sb = new StringBuilder(str);
                Method[] methods = obj.getClass().getMethods();
                Field[] fields = obj.getClass().getDeclaredFields();
                int lastIndex = -1;
                out: while (true) {
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
}