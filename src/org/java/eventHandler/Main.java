package org.java.eventHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
	// -------------------MILSTONE 1---------------------
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
		
		
		// -------------------MILSTONE 2 - 3---------------------
		Scanner sc = new Scanner(System.in);
		
////		Event newEvent = null;
//		Concert newConcert = null;
//		
//		
//		System.out.println("-------------Inserisci un nuovo evento------------");
//		// Titolo
//		System.out.println("Ttolo: ");
//		String title = sc.nextLine();
//		
//		// Data
//		System.out.println("Mese (MM): ");
//		int month = sc.nextInt();
//		while(month > 12) {
//			System.out.println("Mese deve essere valido(MM): ");
//			month = sc.nextInt();
//		}
//		
//		
//		System.out.println("Giorno (dd): ");
//		int day = sc.nextInt();
//		while(day > 31 || (day > 29 && month == 2)) {
//			System.out.println("Giorno deve essere valido(dd): ");
//			month = sc.nextInt();
//		}
//		
//		
//		System.out.println("Anno (yyyy): ");
//		int year = sc.nextInt();
//		
//		System.out.println("Ora (HH): ");
//		int hour = sc.nextInt();
//		
//		System.out.println("Minuti (mm): ");
//		int minutes = sc.nextInt();
//		
//		System.out.println("Quanto costa il biglietto(Usa la virgola ',' come separatore ): ");
//		BigDecimal price = sc.nextBigDecimal();
//		
//		
//		String date = "" + year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
//		String time = "" + hour + ":" + minutes;
//		
//		// Posti disponibili
//		System.out.println("Posti Disponibili: ");
//		int numSeats = sc.nextInt();
//		try {
//		
//			newConcert = new Concert(title, date, numSeats, time, price);
//		}catch(Exception e) {
//			
//			System.err.println(e.getMessage());
//			Main.main(args);
//		}
//		
//		
//		
//		// Chiedo quanti posti prenotare e stampo le prenotazioni avvenute e quelle non conformi ai controlli 
//		System.out.println("Quanti posti vuoi prenotare? ");
//		int numReservations = sc.nextInt();
//		
//		for(int i = 0; i < numReservations; i++) {
//			try {
//				
//				newConcert.prenota();
//				System.out.println("Prenotazione "  + (i + 1) + " avvenuta con successo");
//			}catch(Exception e) {
//			
//				System.err.println(e.getMessage());
//			}
//		}
//		
//		System.out.println("Prenotazioni: "+ newConcert.getReservedSeats());
//		System.out.println("Posti disponibili: "+ newConcert.remainingSeats());
//		
//		
//		// Chiedo quanti posti disdire e stampo le cancellazioni avvenute e quelle non conformi ai controlli 
//		System.out.println("------------------------------------");
//		System.out.println("Quanti posti vuoi disdire? ");
//		int numCanceling = sc.nextInt();
//		
//		for(int i = 0; i < numCanceling; i++) {
//			try {
//				
//				newConcert.disdici();
//				System.out.println("Cancellazione " + (i + 1) + " avvenuta con successo");
//			}catch(Exception e) {
//			
//				System.err.println(e.getMessage() + " " + (i + 1));
//			}
//		}
//		
//		
//		System.out.println("------------------------------------");		
//		System.out.println("Concerto: "+ newConcert);
//		System.out.println("Prenotazioni: "+ newConcert.getReservedSeats());
//		System.out.println("Posti disponibili: "+ newConcert.remainingSeats());
//		System.out.println("------------------------------------");
		
	
		List<Event> events = new ArrayList<>();
		
		Event event1 = new Event("Pietro", "2023-12-01", 01);
		Event event2 = new Event("Pietro", "2023-12-03", 01);
		Event event3 = new Event("Pietro", "2023-12-02", 01);
		
		
		events.add(event1);
		events.add(event2);
		events.add(event3);
		
		System.out.println(events);
		
		
		
		ProgramEvents program = new ProgramEvents("Natale");

		events.forEach(e -> {
			program.addEvents(e);
		});
		
		
		System.out.println(program.getEvents());
		
		
		System.out.println(program.findEventsByDate("2023-12-02"));
		
		System.out.println("\nEventi in ordine cronologico:");
		System.out.println(program.chronoOrderedEvents());
		System.out.println("\nNumero di eventi programmati: " + program.numOfEvents());

		
		System.out.println("\n------------------------Dopo l'eliminazione------------------------");
		program.deleteProgram();
		System.out.println(program.getEvents());
		System.out.println("\nNumero di eventi programmati: " + program.numOfEvents());
		
		
		sc.close();
	}
	
}
