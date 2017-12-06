package stringjoiner;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
/**
 * 
 * @author cengiz
 *
 */
public class StringJoinerEx {

	public static void main(String[] args) {
		StringJoiner sj = new StringJoiner(",");
		sj.add("aaa");
		sj.add("bbb");
		sj.add("ccc");
		String result = sj.toString(); // aaa,bbb,ccc
		System.out.println(result);

		StringJoiner sj2 = new StringJoiner("/", "prefix-", "-suffix");
		sj2.add("2016");
		sj2.add("02");
		sj2.add("26");
		String result2 = sj2.toString(); // prefix-2016/02/26-suffix
		System.out.println(result2);

		// 2015-10-31
		String result3 = String.join(",", "2015", "10", "31");
		System.out.println(result3);

		List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
		// java | python | nodejs | ruby
		String result4 = list.stream().collect(Collectors.joining(" | "));
		System.out.println(result4);

	}

}
