package net.cassite.style;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StringFuncSup extends Style {
	private String str;

	StringFuncSup(String str) {
		this.str = str;
	}

	public String fill(Object... fill) {
		$(fill).forEach((s, i) -> {
			str = str.replace("{" + $(i) + "}", fill[$(i)].toString());
		});
		return str;
	}

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