package org.java.eventHandler;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
	
//	Event mioEvento = new Event("Pietro", "2023-09-26", 100);
//	
//		System.out.println(mioEvento);
//		
//		mioEvento.prenota();
//		mioEvento.prenota();
//		mioEvento.prenota();
//
//		
//		mioEvento.disdici();
//		mioEvento.disdici();
//		mioEvento.disdici();
//		
////		mioEvento.disdici();
////		mioEvento.disdici();
//		
//		
//		
//		System.out.println(mioEvento.getReservedSeats());
		
		
	
		Scanner sc = new Scanner(System.in);
		
		Event newEvent = null;
		
		
		System.out.println("-------------Inserisci un nuovo evento------------");
		// Titolo
		System.out.println("Ttolo: ");
		String title = sc.nextLine();
		
		// Data
		System.out.println("Mese (MM): ");
		int month = sc.nextInt();
		while(month > 12) {
			System.out.println("Mese deve essere valido(MM): ");
			month = sc.nextInt();
		}
		
		
		System.out.println("Giorno (dd): ");
		int day = sc.nextInt();
		while(day > 31 || (day > 29 && month == 2)) {
			System.out.println("Giorno deve essere valido(dd): ");
			month = sc.nextInt();
		}
		
		
		System.out.println("Anno (yyyy): ");
		int year = sc.nextInt();
		
		
		String date = "" + year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
		
		
		// Posti disponibili
		System.out.println("Posti Disponibili: ");
		int numSeats = sc.nextInt();
		try {
		
			newEvent = new Event(title, date, numSeats);
		}catch(Exception e) {
			
			System.err.println(e.getMessage());
			Main.main(args);
		}
		
		
		
		// Chiedo quanti posti prenotare e stampo le prenotazioni avvenute e quelle non conformi ai controlli 
		System.out.println("Quanti posti vuoi prenotare? ");
		int numReservations = sc.nextInt();
		
		for(int i = 0; i < numReservations; i++) {
			try {
				
				newEvent.prenota();
				System.out.println("Prenotazione "  + (i + 1) + " avvenuta con successo");
			}catch(Exception e) {
			
				System.err.println(e.getMessage());
			}
		}
		
		System.out.println("Prenotazioni: "+ newEvent.getReservedSeats());
		System.out.println("Posti disponibili: "+ newEvent.remainingSeats());
		
		
		// Chiedo quanti posti disdire e stampo le cancellazioni avvenute e quelle non conformi ai controlli 
		System.out.println("------------------------------------");
		System.out.println("Quanti posti vuoi disdire? ");
		int numCanceling = sc.nextInt();
		
		for(int i = 0; i < numCanceling; i++) {
			try {
				
				newEvent.disdici();
				System.out.println("Cancellazione " + (i + 1) + " avvenuta con successo");
			}catch(Exception e) {
			
				System.err.println(e.getMessage() + " " + (i + 1));
			}
		}
		
		
		System.out.println("------------------------------------");
		System.out.println("Prenotazioni: "+ newEvent.getReservedSeats());
		System.out.println("Posti disponibili: "+ newEvent.remainingSeats());
		System.out.println("------------------------------------");
		
	
	}
	
}
