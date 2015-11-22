package net.cassite.style.util;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import static net.cassite.style.Style.*;
import static net.cassite.style.aggregation.Aggregation.*;

import net.cassite.style.def;
import net.cassite.style.interfaces.RFunc1;

/**
 * Supporter of java.util.Date<br>
 * Provide Date add/subtract/toStringformat
 *
 * @author wkgcass
 * @see Date
 */
public class DateFuncSup {
        public static class DateSeperator {
                private long day;
                private long hour;
                private long minute;
                private long second;
                private long milli;

                long parse() {
                        return milli + second * 1000 + minute * 60000 + hour * 3600000 + day * 86400000;
                }

                public DateSeperator day(long days) {
                        day = days;
                        return this;
                }

                public DateSeperator hour(long hours) {
                        hour = hours;
                        return this;
                }

                public DateSeperator minute(long minutes) {
                        minute = minutes;
                        return this;
                }

                public DateSeperator second(long senconds) {
                        second = senconds;
                        return this;
                }

                public DateSeperator milli(long millis) {
                        milli = millis;
                        return this;
                }
        }

        private Date date;

        /**
         * retrieve supported date object
         *
         * @return date
         */
        public Date getDate() {
                return date;
        }

        DateFuncSup(Date date) {
                this.date = date;
        }

        /**
         * Add date on supported date
         *
         * @param d date to add
         * @return <code>this</code>
         */
        public DateFuncSup add(DateSeperator d) {
                date.setTime(date.getTime() + d.parse());
                return this;
        }

        /**
         * Add date on supported date
         *
         * @param dateFunction date to add
         * @return <code>this</code>
         */
        public DateFuncSup add(def<DateSeperator> dateFunction) {
                date.setTime(date.getTime() + dateFunction.apply(new DateSeperator()).parse());
                return this;
        }

        /**
         * Add date on supported date
         *
         * @param dateFunction date to add
         * @return <code>this</code>
         */
        public DateFuncSup add(RFunc1<DateSeperator, DateSeperator> dateFunction) {
                return add($(dateFunction));
        }

        /**
         * subtract date on supported date
         *
         * @param d date to subtract
         * @return <code>this</code>
         */
        public DateFuncSup subtract(DateSeperator d) {
                date.setTime(date.getTime() - d.parse());
                return this;
        }

        /**
         * subtract date on supported date
         *
         * @param dateFunction date to subtract
         * @return <code>this</code>
         */
        public DateFuncSup subtract(def<DateSeperator> dateFunction) {
                date.setTime(date.getTime() - dateFunction.apply(new DateSeperator()).parse());
                return this;
        }

        /**
         * subtract date on supported date
         *
         * @param dateFunction date to subtract
         * @return <code>this</code>
         */
        public DateFuncSup subtract(RFunc1<DateSeperator, DateSeperator> dateFunction) {
                return subtract($(dateFunction));
        }

        /**
         * set date to next month
         *
         * @return <code>this</code>
         */
        public DateFuncSup nextMonth() {
                return nextMonth(1);
        }

        /**
         * set date to next year
         *
         * @return <code>this</code>
         */
        public DateFuncSup nextYear() {
                return nextYear(1);
        }

        /**
         * set date to last month
         *
         * @return <code>this</code>
         */
        public DateFuncSup previousMonth() {
                return previousMonth(1);
        }

        /**
         * set date to last year
         *
         * @return <code>this</code>
         */
        public DateFuncSup previousYear() {
                return previousYear(1);
        }

        /**
         * set date to next months
         *
         * @param next count of next months to set to
         * @return <code>this</code>
         */
        public DateFuncSup nextMonth(int next) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.MONTH, next);
                date.setTime(cal.getTimeInMillis());
                return this;
        }

        /**
         * set date to next years
         *
         * @param next count of next years to set to
         * @return <code>this</code>
         */
        public DateFuncSup nextYear(int next) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.YEAR, next);
                date.setTime(cal.getTimeInMillis());
                return this;
        }

        /**
         * set date to previous months
         *
         * @param previous count of previous months to set to
         * @return <code>this</code>
         */
        public DateFuncSup previousMonth(int previous) {
                return nextMonth(-1);
        }

        /**
         * set date to previous years
         *
         * @param previous count of previous years to set to
         * @return <code>this</code>
         */
        public DateFuncSup previousYear(int previous) {
                return nextYear(-1);
        }

        /**
         * format the date to string.<br>
         * check <a href="https://github.com/wkgcass/Style/">tutorial</a> for a
         * table about format details
         *
         * @param format format represents date string you need, such as <code>HH:ii:ss</code>
         * @return formatted date string
         */
        public String toString(String format) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);

                String s = "" + cal.get(Calendar.SECOND);
                String ss = s.length() == 1 ? "0" + s : s;
                String i = "" + cal.get(Calendar.MINUTE);
                String ii = i.length() == 1 ? "0" + i : i;
                String h = "" + cal.get(Calendar.HOUR);
                String hh = h.length() == 1 ? "0" + h : h;
                String H = "" + cal.get(Calendar.HOUR_OF_DAY);
                String HH = H.length() == 1 ? "0" + H : H;
                String d = "" + cal.get(Calendar.DATE);
                String dd = d.length() == 1 ? "0" + d : d;
                String m = "" + (cal.get(Calendar.MONTH) + 1);
                String mm = m.length() == 1 ? "0" + m : m;
                String yyyy = "" + cal.get(Calendar.YEAR);
                String yy = yyyy.substring(2);
                String a = cal.get(Calendar.AM_PM) == Calendar.AM ? "am" : "pm";
                String A = a.toUpperCase();
                Map<String, String> replace = $(new LinkedHashMap<String, String>(),
                        map("ss", ss).$("s", s).$("ii", ii).$("i", i).$("hh", hh).$("h", h).$("HH", HH).$("H", H).$("dd", dd).$("d", d)
                                .$("mm", mm).$("m", m).$("yyyy", yyyy).$("yy", yy).$("a", a).$("A", A));

                StringBuilder sb = new StringBuilder(format);

                $(replace).forEach((k, v) -> {
                        int index;
                        int length = k.length();
                        if (k.equals("A") || k.equals("a")) {
                                int lastAIndex = -1;
                                index = sb.indexOf(k, lastAIndex);
                                while (index != -1) {
                                        sb.replace(index, index + length, v);
                                        lastAIndex = index + 1;
                                        index = sb.indexOf(k, lastAIndex);
                                }
                        } else {
                                while ((index = sb.indexOf(k)) != -1) {
                                        sb.replace(index, index + length, v);
                                }
                        }
                        String upper = k.toUpperCase();
                        if (!replace.containsKey(upper)) {
                                while ((index = sb.indexOf(upper)) != -1) {
                                        sb.replace(index, index + length, v);
                                }
                        }
                        return null;
                });

                return sb.toString();
        }
}