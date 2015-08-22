package tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.cassite.style.Entry;
import net.cassite.style.Style;

/**
 * A demo shows how to create, iterate on, or transform a collection/map<br/>
 * 
 * @author wkgcass
 *
 */
public class CollectionsMapsArrays extends Style {
	public static void main(String[] args) {
		System.out.println("forEach===================");
		System.out.println("on array:");

		Integer[] intArr = new Integer[] { 1, 2, 3, 5, 8, 10 };
		$(intArr).forEach((e) -> System.out.println(e));

		System.out.println("on collection (such as list):");

		List<String> strList = new ArrayList<>();
		$(strList).add("123").add("456").add("1024");
		$(strList).forEach((e) -> System.out.println(e));

		System.out.println("on map:");

		Map<String, Integer> map = new HashMap<String, Integer>();
		$(map).append("cass", 1995).append("john", 1994).append("cassie", 1996);
		$(map).forEach((k, v) -> {
			System.out.println(k + " " + v);
		});

		System.out.println("\nCollection enhanced with forThose");
		$(strList).forThose((e) -> true, (e) -> System.out.println(e));
		$(map).forThose((k, v) -> true, (k, v) -> System.out.println(k + " " + v));

		System.out.println("'on collection' extends 'on iterable' so there's no need to demostrate");

		System.out.println("iterator to collection");
		Set<String> collectionToSet = $(strList).to(new HashSet<String>()).via((e) -> e + ",abc");
		$(collectionToSet).forEach((e) -> System.out.println(e));

		System.out.println("map to collection");
		List<String> mapToList = $(map).to(new ArrayList<String>()).via((k, v) -> "key is " + k + " value is " + v);
		$(mapToList).forEach((e) -> System.out.println(e));

		System.out.println("map to map");
		Map<String, Integer> mapToMap = $(map).to(new HashMap<String, Integer>())
				.via((k, v) -> new Entry<>(k + ",abc", v + 200));
		$(mapToMap).forEach((k, v) -> System.out.println("key is " + k + " value is " + v));

		System.out.println("\nCollection builder===============");
		List<Integer> list = $(new ArrayList<Integer>(), 1, 2, 3, 4);
		$(list).forEach((e) -> System.out.println(e));

		System.out.println("\nMap builder and JSONLike===============");
		Map<String, Integer> testMap = $(new HashMap<>(), $("cass", 1995).$("cassie", 1996).$("unknown", 2001));
		$(testMap).forThose((k, v) -> v < 2000, (k, v) -> System.out.println("key:" + k + " value:" + v));

		System.out.println("\nEasy way of retrieving values from a map");
		System.out.println($(testMap).$("cass"));
	}
}
