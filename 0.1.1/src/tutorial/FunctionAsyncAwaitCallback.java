package tutorial;

import net.cassite.style.Async;
import net.cassite.style.Style;
import net.cassite.style.Supportters.function;

/**
 * This demo shows function grammar <br/>
 * Including creating functions through lambda expressions <br/>
 * and using async/await and callback to simplify async programming
 * 
 * @author wkgcass
 *
 */
public class FunctionAsyncAwaitCallback extends Style {
	public static void main(String[] args) {
		System.out.println("This demo might not print in order of the code.");
		System.out.println("function===========");
		function<Integer> func = $((Integer i, Integer end, function<Integer> fun) -> {
			if (i < end) {
				return i + fun.apply(i + 1, end, fun);
			} else {
				return i;
			}
		});
		System.out.println(func.apply(1, 10, func));

		System.out.println("\nasync/await and callback=============");
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
				}));

		Async<Double> async = oneToTen.async();

		System.out.println("\nretrieve the async value using await:");
		System.out.println(await(async));
		System.out.println("or use async.await()");
		System.out.println(async.await());

		System.out.println("\nSimplfied Thread creation===========");
		run(() -> {
			sleep(1000);
			System.out.println(Thread.currentThread());
		});
	}
}
