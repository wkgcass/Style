package tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.cassite.style.$;
import net.cassite.style.Async;
import net.cassite.style.Style;
import net.cassite.style.Supportters.function;
import net.cassite.style.def;
import net.cassite.style.val;
import net.cassite.style.var;

public class DocSupport extends Style {

	public static void main(String[] args) {
		// 起步
		$(args).forEach(s -> System.out.println(s));

		// 函数式编程 － 创建
		def<Integer> foo = function((Integer i, function<Integer> func) -> i > 99 ? i : i + func.apply(i + 1, func));
		System.out.println(foo.apply(1, foo));
		// 函数式编程 - 工具
		int age = 20;
		val<Integer> _age = store(age);
		def<Object> grow = function(() -> $(_age) + 1);
		System.out.println(grow.apply());

		// 异步编程 - Async
		Async<Integer> aFoo = foo.async(1, foo);
		// 异步编程 - Await
		System.out.println(aFoo.await());
		System.out.println(await(aFoo));
		aFoo.onError($.printHandler);
		// 异步编程 - Callback1
		def<Object> funcWithCallback = function(
				(Integer sum, Integer cursor, function<Object> func, function<Object> callback) -> {
					if (cursor > 99)
						callback.apply(sum + cursor);
					else
						func.apply(sum + cursor, cursor + 1, func, callback);
				});
		funcWithCallback.async(0, 1, funcWithCallback, function((Integer sum) -> System.out.println(sum)));
		// 异步编程 - Callback2
		def<Double> oneToTen = function(() -> {
			System.out.println(Thread.currentThread());
			double mul = 1;
			for (double i = 10; i >= 1; --i) {
				mul *= i;
			}
			return mul;
		});
		def<Double> elevenToTwenty = function(() -> {
			System.out.println(Thread.currentThread());
			double mul = 1;
			for (double i = 20; i >= 11; --i) {
				mul *= i;
			}
			return mul;
		});
		def<Double> twentyOneToThirty = function(() -> {
			System.out.println(Thread.currentThread());
			double mul = 1;
			for (double i = 30; i >= 21; --i) {
				mul *= i;
			}
			return mul;
		});
		def<Double> ThirtyOneToForty = function(() -> {
			System.out.println(Thread.currentThread());
			double mul = 1;
			for (double i = 40; i >= 31; --i) {
				mul *= i;
			}
			return mul;
		});

		$(oneToTen.async(), elevenToTwenty.async(), twentyOneToThirty.async(), ThirtyOneToForty.async())
				.callback(function((Double r1, Double r2, Double r3, Double r4) -> {
					System.out.println(r1 * r2 * r3 * r4);
				})).onError($.printHandler);

		// 集合－初始化
		List<String> list = $(new ArrayList<String>(), "winds", "sgslx", "beiKe");
		Map<String, Integer> map = $(new HashMap<String, Integer>(), $("cass", 1995).$("john", 1994).$("cassie", 1996));
		// 集合－foreach,forthose
		String[] names = list.toArray(new String[list.size()]);
		$(names).forEach(name -> System.out.println(name));
		$(names).forThose(name -> name.contains("i"), name -> System.out.println(name));
		// 集合－toSelf
		$(names).toSelf(e -> e + " changed.");
		$(names).forEach(name -> System.out.println(name));
		// 集合－transform
		List<String> mapToList = $(map).to(new ArrayList<String>()).via((k, v) -> "key is " + k + " value is " + v);
		$(mapToList).forEach((e) -> System.out.println(e));

		// for
		For(0, (i) -> i < 10, (i) -> i + 1, (i) -> System.out.println(i));
		For(1).to(11).step(2).loop(i -> System.out.println(i));

		// string
		var sample = new Sample("cass", 20, "male");
		System.out.println($("My name is ${name}, I'm ${age} years old, and I'm ${sex}.").from(sample));

		// implicit type conversion
		System.out.println(imp(sample, String.class));
		System.out.println(imp("cassie;19;female", Sample.class).name());
	}

}
