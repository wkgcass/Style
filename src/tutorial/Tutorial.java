package tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.cassite.style.Async;
import net.cassite.style.Style;
import net.cassite.style.def;
import net.cassite.style.var;

public class Tutorial extends Style {
	public static void main(String[] args) {
		System.out.println(
				"Style is a library that simulates functional programming with carefully choosen method/class names.");
		List<Person> list = $(new ArrayList<>(), new Person("001", "cass"), new Person("002", "air"));

		// define a function:
		def<Boolean> check = $(
				(List<Person> ls, String name) -> null != $(list).forEach(e -> {
					if (e.name().equals(name))
						return true;
					return null;
				}));
		System.out.println(check.apply(list, "cass"));

		// If expression with return value:
		System.out.println(If(
				$(list).findOne(e -> e.name().equals("cass")),
				res -> {
					return res.id();
				}).Else(() -> "Not Found!"));

		// forEach with iterator info
		$(list).forEach((e, i) -> System.out.println(
				"Element is:" + e + " Index is:" + $(i)));

		// async await and exception handling
		System.out.println("async await and exception handling");
		Async<Boolean> async = check.async(list, "cass");
		Boolean res = async.await();
		// or
		res = await(async);
		System.out.println(res);

		async.onError((err) -> err.origin().printStackTrace());

		// if expression
		System.out.println(
				If(3 > 4, 1).ElseIf(3 > 2, () -> 2).ElseIf(4 > 3, 5).Else(3));
		// will return Integer.

		If(1 > 2, () -> System.out.println(1))
				.ElseIf(3 > 2, () -> System.out.println(2))
				.Else(() -> System.out.println(3));
		// void functions in if-expression will return null

		String str = Switch(6, String.class)
				.Case(7, () -> "g")
				.Case(6, "f")
				.Default(() -> null);
		System.out.println(str);

		$(new ArrayList<String>(), "hello", "world", "!");

		$(new HashMap<String, Integer>(),
				map("a", 1).$("b", 2).$("c", 3));

		String[] strArr = new String[] {
				"a", "b", "c", "d"
		};
		System.out.println($(strArr).forEach(e -> {
			if (e.equals("b"))
				Continue();
			if (e.equals("d"))
				Break();
			return e;
		}));

		Map<String, Integer> map = $(new HashMap<String, Integer>(),
				map("cass", 1995).$("john", 1996).$("alpha", 1994));
		$(map).forEach((k, v, i) -> {
			if (k.equals("alpha"))
				Continue();
			System.out.println("key is:" + k + " value is:" + v + " current index is:" + $(i) + " effective index is:"
					+ i.effectiveIndex);
		});
		// the result is null (because there are no return values in the loop)

		Date date = new Date();
		$(date).add(d -> d.day(1).hour(2).minute(3).second(4).milli(5))
				.nextYear().nextMonth()
				.subtract(d -> d.day(5).hour(4).minute(3).second(2).milli(1));
		System.out.println($(date).toString("YYYY-mm-dd hh:ii:ss A"));

		System.out.println(regex("/<[^>]*>/g").replace("<html>abc</html>", ""));
		System.out.println(regex("/<[^>]*>/").matches("<html>"));
		System.out.println(regex("/<[^>]*>/").test("abc<html>def"));
		System.out.println(Arrays.toString(regex("/(\\d+,)(\\d+)/").exec("123,456-34,345")));

		System.out.println($("hello, my name is {0}, let's write java with {1}!").fill("cass", "Style"));

		var sample = new Sample("cass", 20, "male");
		System.out.println(
				$("My name is ${name}, I'm ${age} years old, and I'm ${sex}.")
						.from(sample));
	}
}

class Person {
	private String id;
	private String name;

	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String name() {
		return this.name;
	}

	public String id() {
		return this.id;
	}
}

class Sample implements var {
	private String name;
	private int age;
	public String sex;

	public Sample(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String name() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public static Sample from(String str) {
		String[] strArr = str.split(";");
		return new Sample(strArr[0], Integer.parseInt(strArr[1]), strArr[2]);
	}
}