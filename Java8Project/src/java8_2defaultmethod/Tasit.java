package java8_2defaultmethod;

public interface Tasit {

	default void gazla() {
		System.out.println("Taşıt gaza basıyor.");
	}
}