package java8_1lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import parallelsort.User;

public class LambdaEx {

	public static void main(String[] args) {

		List<Developer> listDevs = getDevelopers();

		System.out.println("Before Sort");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}

		System.out.println("\nAfter Sort without lambda");
		// sort by salary
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});

		for (Developer developer : listDevs) {
			System.out.println(developer);
		}

		System.out.println("\nAfter Sort with lambda");
		Comparator<Developer> ageComparator = Comparator.comparing(Developer::getSalary);
		Collections.sort(listDevs, ageComparator);

		// alternatif
		// listDevs.sort((Developer o1, Developer o2)->o1.getAge()-o2.getAge());

		// java 8 only, lambda also, to print the List
		listDevs.forEach((developer) -> System.out.println(developer));
	}

	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("ahmet", new BigDecimal("10000"), 33));
		result.add(new Developer("mehmet", new BigDecimal("30000"), 20));
		result.add(new Developer("ali", new BigDecimal("20000"), 10));
		result.add(new Developer("veli", new BigDecimal("40000"), 55));

		return result;

	}

}