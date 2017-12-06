package java8_3methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReferenceEx {

	static List<String> names = Arrays.asList("Cengiz,Furkan,Barış,Uğur");

	public static void main(String[] args) {

		System.out.println("--static method reference--");
		names.forEach(MethodReferenceEx::printList);

		System.out.println("\n--instance method reference--");
		MethodReferenceEx app = new MethodReferenceEx();
		names.forEach(app::printList2);

		System.out.println("\n--method reference--");
		names.forEach(System.out::println);
		
		System.out.println("\n--print list with consumer--");
		names.forEach(new Consumer<String>() { 
		    @Override
		    public void accept(String s) {
		        System.out.println(s);
		    }
		});
		
		System.out.println("\n--print list with lambda--");
		names.forEach(s->{
			   System.out.println(s);
			});
	}

	// Static method
	public static void printList(String s) {
		System.out.println(s);
	}

	// Non-static method
	public void printList2(String s) {
		System.out.println(s);
	}

}
