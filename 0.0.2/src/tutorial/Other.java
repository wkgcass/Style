package tutorial;

import java.util.Arrays;
import java.util.Date;

import net.cassite.style.$;
import net.cassite.style.Style;

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
	}

}
