package tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.cassite.style.Store;
import net.cassite.style.Style;

/**
 * A demo showing how to do logic/iteration control<br/>
 * Including for/while loop, enhanced switch,<br/>
 * and how to use break/continue/remove
 * 
 * @author wkgcass
 *
 */
public class LogicControl extends Style {

	public static void main(String[] args) {
		// init
		Integer[] intArr = new Integer[] { 1, 2, 3, 5, 8, 10 };
		Map<String, Integer> map = new HashMap<String, Integer>();
		$(map).append("cass", 1995).append("john", 1994).append("cassie", 1996);
		List<String> strList = new ArrayList<>();
		$(strList).add("123").add("456").add("1024");

		System.out.println("\nSwitch-Case============");
		int tmp = 1;
		Store<Integer> tmpS = store(tmp);
		Switch(tmp).Case(1, () -> System.out.println("switch(tmp) case 1:" + tmpS)).Case(2, () -> {
			System.out.println("case 2:" + tmpS);
			Break();
		}).Case(3, () -> System.out.println("case 3:" + tmpS)).Default(() -> System.out.println("default"));

		System.out.println("\nLoop===========");
		System.out.println("For:");
		For(0, (i) -> i < 10, (i) -> i + 1, (i) -> System.out.println(i));
		System.out.println("For start to end");
		For(1).to(11).step(2).loop(i -> {
			if (i > 7)
				Break();
			System.out.println(i);
		});
		System.out.println("While:");
		Iterator<String> strIt = strList.iterator();
		While(() -> strIt.hasNext(), () -> System.out.println(strIt.next()));

		System.out.println("loop control============");
		System.out.println("break and continue");
		$(intArr).forEach((e) -> {
			if (e == 3)
				Continue();
			if (e == 8)
				Break();
			System.out.println(e);
		});
		System.out.println("remove");
		$(map).forEach((k, v) -> {
			if (k.equals("john"))
				Remove();
		});
		System.out.println(map);
	}

}
