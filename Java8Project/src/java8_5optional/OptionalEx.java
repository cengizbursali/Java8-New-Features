package java8_5optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author cengiz
 *
 */
public class OptionalEx {

	public static void main(String[] args) {

		Optional<Double> empty = Optional.empty(); // Değer içermeyen Opt
		Optional<String> of = Optional.of(null); // String türünden değer içeren Opt
		Optional<String> ofNull = Optional.of(null); // Optional#of null kabul etmez. İstisna fırlatır.
		Optional<Integer> ofNullable = Optional.ofNullable(null); // Optional#ofNullable null kabul eder. İstisna
																	// fırlatmaz.
		// ******************************************************************************************************************

		Integer number = null;
		//Double result = Math.pow(number, 2); // java.lang.NullPointerException
		//System.out.println("Result: " + result);

		// null check with java 7
		Integer number1 = null;
		if (number1 != null) {
			Double result1 = Math.pow(number1, 2);
			System.out.println("Result1: " + result1);
		}
		
		/*
		 * Eğer bir Optional içerisinde sadece veri varsa (null değilse) bir işin
		 * yapılması isteniyorsa ifPresent metodu kullanılabilir.
		 */
		// not null check with java 8
		Integer number2 = null;
		Optional<Integer> opt = Optional.ofNullable(number2);
		opt.ifPresent(num -> {
			Double result2 = Math.pow(num, 2);
			System.out.println("Result2: " + result2);
		});
		
		// ******************************************************************************************************************
		/*
		 * map: Optional nesnelerinin sarmaladığı veriler üzerinde dönüştürüm
		 * yapılabilmektedir. Bir önceki örneği bu şekilde yeniden yazabiliriz.
		 */
		Integer numara = null;
		Optional<Integer> op = Optional.ofNullable(numara);
		op.map(num -> Math.pow(num, 2)).ifPresent(System.out::println);

		// ******************************************************************************************************************

		String message = null;
		if (message != null)
			if (message.length() > 5)
				System.out.println(message);
		/**
		 * filter:Optional nesnelerinin sarmaladığı veriler üzerinde süzme işlemi de
		 * yapılabilmektedir.
		 */
		Optional<String> optMes = Optional.ofNullable(message);
		optMes.filter(m -> m.length() > 5).ifPresent(System.out::println);

		// ******************************************************************************************************************
		
		// java 7
		Integer num = null;
		int res = (num != null) ? num : 0;
		/**
		 * orElse:orElse metodu daha çok ternary (üçlü) şart ihtiyacı olduğu durumlarda
		 * ihtiyaç duyulabilir. Daha akıcı bir geliştirim deneyimi sunar.
		 */
		// java 8
		Optional<Integer> optNum = Optional.ofNullable(num);
		int res2 = optNum.orElse(0);

		// ******************************************************************************************************************
		/**
		 * orElseGet – Varsa al, yoksa üret
		 */
		List<String> names = Arrays.asList("Ali", "Veli", "Selami");
		Optional<List<String>> optList = Optional.ofNullable(names);
		names = optList.orElseGet(() -> new ArrayList()); // with lambda
		names = optList.orElseGet(ArrayList::new); // with method reference

		// ******************************************************************************************************************

		/**
		 * orElseThrow – Varsa al, yoksa fırlat
		 */
		Integer numm = null;
		Optional<Integer> optt = Optional.ofNullable(numm);
		int ress = optt.orElseThrow(ArrayIndexOutOfBoundsException::new);
	}

}
