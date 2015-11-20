package net.cassite.style.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.cassite.style.Core.*;

/**
 * A Reg expression supporter that simplifies usage of RegEx<br>
 * and make it look like doing regex in JavaScript
 *
 * @author wkgcass
 */
public class RegEx {
        private Pattern p;
        private boolean isGlobal;
        private Map<String, Matcher> matchers = new HashMap<>();

        /**
         * @return the supporting pattern object
         * @see Pattern
         */
        public Pattern getPattern() {
                return p;
        }

        /**
         * initialize the regex with given string in the form of a regex
         * JavaScript<br>
         * e.g. <code>/ .* /g</code><br>
         * g for global, i for case insensitive, m for multiline, s for dotall,
         * d for unix_lines, u for unicode_case
         *
         * @param regex regex
         */
        public RegEx(String regex) {
                this(regex, 0);
        }

        /**
         * initialize the regex with given string in the form of a regex
         * JavaScript<br>
         * e.g. <code>/ .* /g</code>
         *
         * @param regex regex
         * @param mask  masks defined in Pattern
         */
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

        /**
         * initialize the regex with given Pattern object and set whether it
         * means global<br>
         * All patterns in java are global
         *
         * @param pattern  pattern
         * @param isGlobal true for global, false otherwise
         */
        public RegEx(Pattern pattern, boolean isGlobal) {
                this.p = pattern;
                this.isGlobal = isGlobal;
        }

        /**
         * get matcher of the given string
         *
         * @param str string
         * @return matcher
         */
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

        /**
         * same as JavaScript test<br>
         * simply invokes {@link Matcher#find()}
         *
         * @param toTest the string to be tested
         * @return true if found, false otherwise
         * @see Matcher#find()
         */
        public boolean test(String toTest) {
                return getMatcher(toTest).find();
        }

        /**
         * same as JavaScript exec
         *
         * @param toExec the string to exec
         * @return result string array
         */
        public String[] exec(String toExec) {
                Matcher m = getMatcher(toExec);
                if (m.find()) {
                        List<String> list = new ArrayList<>();
                        int count = m.groupCount();
                        For(1).to(count).loop(i -> {
                                list.add(m.group(i));
                        });
                        return list.toArray(new String[list.size()]);
                } else {
                        return null;
                }
        }

        /**
         * check if the string fully matches this regex pattern
         *
         * @param toMatch the string to match
         * @return true if matches, false otherwise
         */
        public boolean matches(String toMatch) {
                return getMatcher(toMatch).matches();
        }

        /**
         * replace the found substring with replacement<br>
         * for global regex, invoke {@link Matcher#replaceAll(String)}<br>
         * others, invoke {@link Matcher#replaceFirst(String)}
         *
         * @param str         the string to be replaced
         * @param replacement the string to replace
         * @return result string
         * @see Matcher#replaceAll(String)
         * @see Matcher#replaceFirst(String)
         */
        public String replace(String str, String replacement) {
                if (isGlobal) {
                        return getMatcher(str).replaceAll(replacement);
                } else {
                        return getMatcher(str).replaceFirst(replacement);
                }
        }
}
