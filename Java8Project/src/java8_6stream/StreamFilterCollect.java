package java8_6stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamFilterCollect {

	public static void main(String[] args) {

		System.out.println("--with java 7--");

		List<String> lines = Arrays.asList("spring", "node", "java");
		List<String> result = getFilterOutput(lines, "java");
		for (String temp : result) {
			System.out.println(temp); // output : spring, node
		}

		System.out.println("\n--with java 8--");
		// with java 8
		List<String> result2 = lines.stream() // convert list to stream
				.filter(line -> !"java".equals(line)) // we dont like java
				.collect(Collectors.toList()); // collect the output and convert streams to a List
		result.forEach(System.out::println); // output : spring, node

		System.out.println("\n--predicate list--");
		List<String> names = Arrays.asList("Ali", "Veli", "Selami", "Cem", "Zeynel", "Can", "Hüseyin");
		Stream<String> stream = names.stream();
		Predicate predicate = name -> ((String) name).length() < 4;
		Stream<String> filtered = stream.filter(predicate);
		filtered.forEach(System.out::println);

		System.out.println("\n--distinct list--");
		IntStream intStream = IntStream.of(1, 1, 2, 3, 5, 8, 13, 13, 8);
		intStream.distinct().forEach(System.out::println);

		System.out.println("\n--sorted list--");
		IntStream sortedStream = IntStream.of(13, 1, 3, 5, 8, 1, 13, 2, 8);
		sortedStream.sorted().forEach(System.out::println);

		System.out.println("\n--range list--");
		LongStream range = LongStream.range(1, 10000);
		range.limit(10).forEach(System.out::println);

		System.out.println("\n--count range list--");
		IntStream range1 = IntStream.range(1, 10);
		IntStream rangeClosed = IntStream.rangeClosed(1, 10);
		System.out.println(range1.count());
		System.out.println(rangeClosed.count());

		System.out.println("\n--map rangeClosed list--");
		IntStream.rangeClosed(1, 5).map(n -> n * n).forEach(System.out::println);

		
		System.out.println("\n--parellelStream --");
		// Burda filter ve sorted metodu birlikte çalışmaktadır.
		// Stream kullansa idim sırayla çalışacaktı ve dizi gerçekten sıralı olarak yazdılacaktı.
		List<Integer> ints = Arrays.asList(1, 5, 3, 7, 11, 9, 15, 13);
		ints.parallelStream() // Paralel Stream
				.filter(Objects::nonNull) // null değilse
				.filter(n -> n > 0) // pozitif sayı ise
				.sorted() // sırala
				.forEach(System.out::println); // çıktıla

	}

	// with java 7
	private static List<String> getFilterOutput(List<String> lines, String filter) {
		List<String> result = new ArrayList<>();
		for (String line : lines) {
			if (!"java".equals(line)) { // we dont like java
				result.add(line);
			}
		}
		return result;
	}

}