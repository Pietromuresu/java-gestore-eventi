package org.java.eventHandler;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
	
	Event mioEvento = new Event("Pietro", "2023-09-26", 100);
	
		System.out.println(mioEvento);
		
		mioEvento.prenota();
		mioEvento.prenota();
		mioEvento.prenota();

		
		mioEvento.disdici();
		mioEvento.disdici();
		mioEvento.disdici();
		
//		mioEvento.disdici();
//		mioEvento.disdici();
		
		
		
		System.out.println(mioEvento.getReservedSeats());
	}
	
}
