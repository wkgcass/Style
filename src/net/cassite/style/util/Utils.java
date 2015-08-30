package net.cassite.style.util;

import java.util.Date;

import net.cassite.style.Core;
import net.cassite.style.def;
import net.cassite.style.ptr;
import net.cassite.style.interfaces.VFunc0;

public abstract class Utils extends Core {
        protected Utils() {

        }

        // date

        /**
         * Create a date supporter
         * 
         * @param date
         *                the date to support
         * @return Date supporter
         * @see DateFuncSup
         */
        public static DateFuncSup $(Date date) {
                return new DateFuncSup(date);
        }

        // regex

        /**
         * Create a simplified regex tool from a string.
         * 
         * @param regex
         *                a string assembled in the form of regex in JavaScript
         * @return new RegEx object helps you work with regex
         * @see RegEx
         */
        public static RegEx regex(String regex) {
                return new RegEx(regex);
        }

        // comparable

        /**
         * Enables you to compare two comparable objects with more readable
         * coding.<br>
         * e.g.
         * 
         * <pre>
         *  lt, gt, le, lte, ge, gte, eq, ne, neq
         * </pre>
         * 
         * @param comparable
         *                the first comparable object to be compared
         * @return ComparableFuncSup
         * @see ComparableFuncSup
         */
        public static <T> ComparableFuncSup<T> $(Comparable<T> comparable) {
                return new ComparableFuncSup<>(comparable);
        }

        // rand

        /**
         * get an integer randomly from start (inclusive) to end (inclusive)
         * 
         * @param start
         * @param end
         * @return random integer
         */
        public static int rand(int start, int end) {
                return (int) (Math.random() * (end - start + 1)) + start;
        }

        /**
         * get a double randomly from start (inclusive) to end (exclusive)
         * 
         * @param start
         * @param end
         * @return random double
         */
        public static double rand(double start, double end) {
                return Math.random() * (end - start) + start;
        }

        /**
         * get an integer littler than max (inclusive)
         * 
         * @param max
         * @return random integer
         */
        public static int rand(int max) {
                return (int) (Math.random() * (max + 1));
        }

        /**
         * get a double littler than max
         * 
         * @param max
         * @return random double
         */
        public static double rand(double max) {
                return Math.random() * max;
        }

        /**
         * generate a random string serial with characters from $chooseFrom and
         * given length.
         * 
         * @param chooseFrom
         *                characters to choose from
         * @param length
         *                generated serial length
         * @param unrepeatable
         *                true if the serial doesn't contain repeating
         *                characters. false otherwise.
         * @param ignoreCase
         *                true if the serial doesn't contain repeating
         *                case-ignored characters. false otherwise.<br>
         *                Only consider this argument when $unrepeatable is true
         * @return random string serial
         */
        public static String rand(String chooseFrom, int length, boolean unrepeatable, boolean ignoreCase) {
                if (length > chooseFrom.length() && unrepeatable) {
                        throw new RuntimeException("unrepeatable but length > chooseFrom.length");
                }
                StringBuilder sb = new StringBuilder();
                ptr<String> $chooseFrom = ptr(chooseFrom);
                For(1).to(length).loop(i -> {
                        char c = $chooseFrom.item.charAt(rand($chooseFrom.item.length() - 1));
                        while (sb.indexOf("" + c) != -1 && unrepeatable) {
                                c = $chooseFrom.item.charAt(rand(chooseFrom.length() - 1));
                        }
                        sb.append(c);
                        if (unrepeatable) {
                                if (ignoreCase) {
                                        $chooseFrom.item = $chooseFrom.item.replace(("" + c).toLowerCase(), "");
                                        $chooseFrom.item = $chooseFrom.item.replace(("" + c).toUpperCase(), "");
                                } else {
                                        $chooseFrom.item = $chooseFrom.item.replace(("" + c), "");
                                }
                        }
                });
                return sb.toString();
        }

        /**
         * generate a random string serial with characters from $chooseFrom and
         * given length.
         * 
         * @param chooseFrom
         *                characters to choose from
         * @param length
         *                generated serial length
         * @param unrepeatable
         *                true if the serial doesn't contain repeating
         *                characters. false otherwise.
         * @return random string serial
         */
        public static String rand(String chooseFrom, int length, boolean unrepeatable) {
                return rand(chooseFrom, length, unrepeatable, false);
        }

        /**
         * generate a random string serial with characters from $chooseFrom and
         * given length.
         * 
         * @param chooseFrom
         *                characters to choose from
         * @param length
         *                generated serial length
         * @return random string serial
         */
        public static String rand(String chooseFrom, int length) {
                return rand(chooseFrom, length, false, false);
        }

        /**
         * create a string supporter
         * 
         * @param base
         *                the string to be supported
         * @return String supporter
         * @see StringFuncSup
         */
        public static StringFuncSup $(String base) {
                return new StringFuncSup(base);
        }

        /**
         * Create a new thread and invoke start on it.
         * 
         * @param runnable
         *                function run on the new thread
         * @return created thread
         * 
         * @see Utils#run(def)
         */
        public static Thread run(VFunc0 runnable) {
                return Utils.run(Core.$(runnable));
        }

        /**
         * Create a new thread and invoke start on it.
         * 
         * @param toRun
         *                function run on the new thread
         * @return created thread
         */
        public static Thread run(def<Object> toRun) {
                Thread t = new Thread(() -> {
                        toRun.apply();
                });
                t.start();
                return t;
        }
}
