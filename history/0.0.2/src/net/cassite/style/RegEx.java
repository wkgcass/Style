package net.cassite.style;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx extends Style {
	private Pattern p;
	private boolean isGlobal;
	private Map<String, Matcher> matchers = new HashMap<String, Matcher>();

	public Pattern getPattern() {
		return p;
	}

	public RegEx(String regex) {
		this(regex, 0);
	}

	public RegEx(String regex, int mask) {
		// grammar examination
		int flagMask = mask;
		String ex;
		if (regex.startsWith("/")) {
			if (regex.lastIndexOf('/') == 0) {
				throw new RuntimeException("RegExp must ends with '/' and flags(g,m,i,s,d,u)");
			} else {
				char[] flags;
				if (regex.lastIndexOf('/') == regex.length() - 1) {
					flags = new char[0];
				} else {
					flags = regex.substring(regex.lastIndexOf('/') + 1).toCharArray();
				}
				for (char f : flags) {
					if (f == 'g' || f == 'G') {
						isGlobal = true;
					} else if (f == 'i' || f == 'I') {
						flagMask = flagMask | Pattern.CASE_INSENSITIVE;
					} else if (f == 'm' || f == 'M') {
						flagMask = flagMask | Pattern.MULTILINE;
					} else if (f == 's' || f == 'S') {
						flagMask = flagMask | Pattern.DOTALL;
					} else if (f == 'd' || f == 'D') {
						flagMask = flagMask | Pattern.UNIX_LINES;
					} else if (f == 'u' || f == 'U') {
						flagMask = flagMask | Pattern.UNICODE_CASE;
					} else {
						throw new RuntimeException("unknown flag '" + f + "'");
					}
				}
				ex = regex.substring(1, regex.lastIndexOf('/'));
			}
		} else {
			throw new RuntimeException("RegExp must start with '/'");
		}
		// compile
		p = Pattern.compile(ex, flagMask);
	}

	public RegEx(Pattern pattern, boolean isGlobal) {
		this.p = pattern;
		this.isGlobal = isGlobal;
	}

	public Matcher getMatcher(String str) {
		Matcher m;
		if (matchers.containsKey(str)) {
			m = matchers.get(str);
		} else {
			m = p.matcher(str);
			matchers.put(str, m);
		}
		return m;
	}

	public boolean test(String toTest) {
		return getMatcher(toTest).find();
	}

	public String[] exec(String toExec) {
		Matcher m = getMatcher(toExec);
		if (m.find()) {
			List<String> list = new ArrayList<String>();
			int count = m.groupCount();
			For(1).to(count).loop(i -> {
				list.add(m.group(i));
			});
			return list.toArray(new String[list.size()]);
		} else {
			return null;
		}
	}

	public boolean matches(String toMatch) {
		return getMatcher(toMatch).matches();
	}

	public String replace(String str, String replacement) {
		if (isGlobal) {
			return getMatcher(str).replaceAll(replacement);
		} else {
			return getMatcher(str).replaceFirst(replacement);
		}
	}
}
