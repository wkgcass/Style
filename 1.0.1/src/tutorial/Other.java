package tutorial;

import java.util.Arrays;
import java.util.Date;

import net.cassite.style.$;
import net.cassite.style.Style;
import net.cassite.style.var;

public class Other extends Style {

	public static void main(String[] args) {
		System.out.println("\nDate===============");
		Date date = new Date();
		System.out.println(date);
		$(date).add(d -> d.day(1).hour(2).minute(3).second(4).milli(5)).nextYear().nextMonth()
				.substract(d -> d.day(5).hour(4).minute(3).second(2).milli(1));
		System.out.println($(date).toString("YYYY-mm-dd hh:ii:ss A"));

		System.out.println("\nRegEx==============");
		System.out.println(regex("/<[^>]*>/g").replace("<html>abc</html>", ""));
		System.out.println(regex("/<[^>]*>/").matches("<html>"));
		System.out.println(regex("/<[^>]*>/").test("abc<html>def"));
		System.out.println(Arrays.toString(regex("/(\\d+,)(\\d+)/").exec("123,456-34,345")));

		System.out.println("\nComparable==========");
		System.out.println($(1).lt(6));

		System.out.println("\nRand==========");
		System.out.println(rand(100));
		System.out.println(rand(0.125));
		System.out.println(rand(150, 200));
		System.out.println(rand(0.875, 1.0));
		System.out.println(rand($.fromKeyboard, 50, true, true));

		System.out.println("\nvar========");
		var sample = new Sample("cass", 20, "male");
		Sample s = sample.$();

		System.out.println("\nString=========");
		System.out.println($("current time is : {0}, it's time to write code with Style!")
				.fill($($.current()).toString("HH:ii:ss A")));
		System.out.println($("My name is ${name}, I'm ${age} years old, and I'm ${sex}.").from(s));

		System.out.println("\nImplicit type conversion");
		System.out.println(imp(s, String.class));
		System.out.println(imp("cassie;19;female", Sample.class).name());
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