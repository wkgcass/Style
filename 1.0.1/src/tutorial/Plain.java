package tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.cassite.style.$;
import net.cassite.style.Async;
import net.cassite.style.Entry;
import net.cassite.style.var;
import net.cassite.style.Store;
import net.cassite.style.Supportters.function;

public class Plain implements var {
	public static void main(String[] args) {
		new Plain().main2(args);
	}

	@SuppressWarnings("unchecked")
	public void main2(String[] args) {
		Integer[] intArr = new Integer[] { 1, 2, 3, 5, 8, 10 };

		$(intArr).forEach((e) -> System.out.println(e));

		List<String> strList = new ArrayList<>();
		$(strList).add("123").add("456").add("1024");

		$(strList).forEach((e) -> System.out.println(e));

		Map<String, Integer> map = new HashMap<String, Integer>();
		$(map).append("cass", 1995).append("john", 1994).append("cassie", 1996);
		$(map).forEach((k, v) -> {
			System.out.println(k + " " + v);
		});

		For(0, (i) -> i < 10, (i) -> i + 1, (i) -> System.out.println(i));
		Iterator<String> strIt = strList.iterator();
		While(() -> strIt.hasNext(), () -> System.out.println(strIt.next()));

		List<Integer> arrayToList = $(intArr).to(new ArrayList<Integer>()).via((e) -> {
			return e + 100;
		});
		$(arrayToList).forEach((e) -> System.out.println(e));

		Set<String> collectionToSet = $(strList).to(new HashSet<String>()).via((e) -> e + ",abc");
		$(collectionToSet).forEach((e) -> System.out.println(e));

		List<String> mapToList = $(map).to(new ArrayList<String>()).via((k, v) -> "key is " + k + " value is " + v);
		$(mapToList).forEach((e) -> System.out.println(e));

		Map<String, Integer> mapToMap = $(map).to(new HashMap<String, Integer>())
				.via((k, v) -> new Entry<>(k + ",abc", v + 200));
		$(mapToMap).forEach((k, v) -> System.out.println("key is " + k + " value is " + v));

		$(intArr).forEach((e) -> {
			if (e == 3)
				Continue();
			if (e == 8)
				Break();
			System.out.println(e);
		});

		$(map).forEach((k, v) -> {
			if (k.equals("john"))
				Remove();
		});
		System.out.println(map);

		function<Integer> func = $((Integer i, Integer end, function<Integer> fun) -> {
			if (i < end) {
				return i + fun.apply(i + 1, end, fun);
			} else {
				return i;
			}
		});
		System.out.println(func.apply(1, 10, func));

		function<Double> oneToTen = $(() -> {
			System.out.println(Thread.currentThread());
			double mul = 1;
			for (double i = 10; i >= 1; --i) {
				mul *= i;
			}
			return mul;
		});
		function<Double> elevenToTwenty = $(() -> {
			System.out.println(Thread.currentThread());
			double mul = 1;
			for (double i = 20; i >= 11; --i) {
				mul *= i;
			}
			return mul;
		});
		function<Double> twentyOneToThirty = $(() -> {
			System.out.println(Thread.currentThread());
			double mul = 1;
			for (double i = 30; i >= 21; --i) {
				mul *= i;
			}
			return mul;
		});
		function<Double> ThirtyOneToForty = $(() -> {
			System.out.println(Thread.currentThread());
			double mul = 1;
			for (double i = 40; i >= 31; --i) {
				mul *= i;
			}
			return mul;
		});

		$(oneToTen.async(), elevenToTwenty.async(), twentyOneToThirty.async(), ThirtyOneToForty.async())
				.callback($((Double r1, Double r2, Double r3, Double r4) -> {
					System.out.println(r1 * r2 * r3 * r4);
					return Void.TYPE;
				}));

		Async<Double> async = oneToTen.async();

		try {
			Thread.sleep(1);
		} catch (InterruptedException e1) {
			$(e1).throwIn(RuntimeException.class);
			$(e1).throwNotIn(Error.class);
		}

		$(strList).forThose((e) -> true, (e) -> System.out.println(e));
		$(map).forThose((k, v) -> true, (k, v) -> System.out.println(k + " " + v));

		System.out.println(await(async));
		System.out.println(async.await());

		List<Integer> list = $(new ArrayList<Integer>(), 1, 2, 3, 4);
		$(list).forEach((e) -> System.out.println(e));

		int tmp = 1;
		Store<Integer> tmpS = store(tmp);
		Switch(tmp).Case(1, () -> System.out.println("switch(tmp) case 1:" + tmpS)).Case(2, () -> {
			System.out.println("case 2:" + tmpS);
			Break();
		}).Case(3, () -> System.out.println("case 3:" + tmpS)).Default(() -> System.out.println("default"));

		Map<String, Integer> testMap = $(new HashMap<>(), $("cass", 1995).$("cassie", 1996).$("unknown", 2001));
		$(testMap).forThose((k, v) -> v < 2000, (k, v) -> System.out.println("key:" + k + " value:" + v));

		System.out.println($(testMap).$("cass"));

		run(() -> System.out.println(Thread.currentThread()));

		For(1).to(11).step(2).loop(i -> {
			if (i > 7)
				Break();
			System.out.println(i);
		});

		Date date = new Date();
		System.out.println(date);
		$(date).add(d -> d.day(1).hour(2).minute(3).second(4).milli(5)).nextYear().nextMonth()
				.substract(d -> d.day(5).hour(4).minute(3).second(2).milli(1));
		System.out.println($(date).toString("YYYY-mm-dd hh:ii:ssA"));

		System.out.println(regex("/<[^>]*>/g").replace("<html>abc</html>", ""));
		System.out.println(regex("/<[^>]*>/").matches("<html>"));
		System.out.println(regex("/<[^>]*>/").test("abc<html>def"));
		System.out.println(Arrays.toString(regex("/(\\d+,)(\\d+)/").exec("123,456-34,345")));

		System.out.println($(1).lt(6));

		System.out.println(rand(100));
		System.out.println(rand(0.125));
		System.out.println(rand(150, 200));
		System.out.println(rand(0.875, 1.0));
		System.out.println(rand($.fromKeyboard, 50, true, true));

		var sample = new Sample("cass", 20, "male");
		Sample s = sample.$();

		System.out.println($("current time is : {0}, it's time to write code with Style!")
				.fill($($.current()).toString("HH:ii:ss A")));
		System.out.println($("My name is ${name}, I'm ${age} years old, and I'm ${sex}.").from(s));

		System.out.println(imp(s, String.class));
		System.out.println(imp("cassie;19;female", Sample.class).name());
		
		Integer year = If(map.containsKey("john"), () -> map.get("john"))
				.ElseIf(map.containsKey("cass"), () -> map.get("cass")).End();
		System.out.println(year);
	}
}
