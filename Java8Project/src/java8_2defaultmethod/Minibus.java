package java8_2defaultmethod;

public class Minibus implements Arac,Tasit {
	
	@Override
	public void dur() {
		System.out.println("Minibüs duruyor..");
	}
	
	
	@Override
	public void gazla() {
		Tasit.super.gazla();
	}
	
	/*
	@Override
	public void gazla() {
		Arac.super.gazla();
	}*/
	
	
	

}