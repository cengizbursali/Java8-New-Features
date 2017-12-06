package java8_2defaultmethod;

public interface Arac {
	default void gazla() {
		System.out.println("Araç gaza basıyor.");
	}

	void dur();
}