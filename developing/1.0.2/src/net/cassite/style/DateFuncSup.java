package net.cassite.style;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import net.cassite.style.interfaces.RFunc1;

public class DateFuncSup extends Style {
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

	public Date getDate() {
		return date;
	}

	DateFuncSup(Date date) {
		this.date = date;
	}

	public DateFuncSup add(DateSeperator d) {
		date.setTime(date.getTime() + d.parse());
		return this;
	}

	public DateFuncSup add(def<DateSeperator> dateFunction) {
		date.setTime(date.getTime() + dateFunction.apply(new DateSeperator()).parse());
		return this;
	}

	public DateFuncSup add(RFunc1<DateSeperator, DateSeperator> dateFunction) {
		return add($(dateFunction));
	}

	public DateFuncSup substract(DateSeperator d) {
		date.setTime(date.getTime() - d.parse());
		return this;
	}

	public DateFuncSup substract(def<DateSeperator> dateFunction) {
		date.setTime(date.getTime() - dateFunction.apply(new DateSeperator()).parse());
		return this;
	}

	public DateFuncSup substract(RFunc1<DateSeperator, DateSeperator> dateFunction) {
		return substract($(dateFunction));
	}

	public DateFuncSup nextMonth() {
		return nextMonth(1);
	}

	public DateFuncSup nextYear() {
		return nextYear(1);
	}

	public DateFuncSup previousMonth() {
		return previousMonth(1);
	}

	public DateFuncSup previousYear() {
		return previousYear(1);
	}

	public DateFuncSup nextMonth(int next) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, next);
		date.setTime(cal.getTimeInMillis());
		return this;
	}

	public DateFuncSup nextYear(int next) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, next);
		date.setTime(cal.getTimeInMillis());
		return this;
	}

	public DateFuncSup previousMonth(int previous) {
		return nextMonth(-1);
	}

	public DateFuncSup previousYear(int previous) {
		return nextYear(-1);
	}

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
				map("ss", ss).$("s", s).$("ii", ii).$("i", i).$("hh", hh).$("h", h).$("HH", HH).$("H", H).$("dd", dd)
						.$("d", d).$("mm", mm).$("m", m).$("yyyy", yyyy).$("yy", yy).$("a", a).$("A", A));

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