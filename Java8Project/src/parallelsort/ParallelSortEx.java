package parallelsort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 
 * @author cengiz
 *
 */
public class ParallelSortEx {

	public static void main(String[] args) {
		User[] users = User.getUsers();
		Consumer<User> printUser = u -> System.out.println(u.getName() + "-" + u.getAge());

		System.out.println("--Sort complete array--");
		Arrays.parallelSort(users);
		Arrays.stream(users).forEach(printUser);
		
		Comparator<User> ageComparator = Comparator.comparing(User::getAge);

		System.out.println("\n--Sort complete array with comparator--");
		Arrays.parallelSort(users, ageComparator);
		Arrays.stream(users).forEach(printUser);

		System.out.println("\n--Sort array from index 1 to 4 with comparator--");
		users = User.getUsers();
		Arrays.parallelSort(users, 1, 4, ageComparator);
		Arrays.stream(users).forEach(printUser);
		
		/*
		 * users[0] = new User("Ram", 25);
		users[1] = new User("Shyam", 22);
		users[2] = new User("Mohan", 21);
		users[3] = new User("Suresh", 30);
		users[4] = new User("Ramesh", 20);
		users[5] = new User("Dinesh", 27);
		 */
	}
}
