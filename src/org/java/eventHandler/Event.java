package org.java.eventHandler;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Event {
	
	private String title;
	private LocalDate date;
	private int numSeats;
	private int reservedSeats;
	
	public Event(String title, String date, int numSeats) throws Exception {
		setTitle(title);
		setDate(date);
		setNumSeats(numSeats);
		setReservedSeats(0);
	}
	
	
	
	
	// Getters and setters 

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(String date) throws Exception {
		
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");	
		LocalDate typedDate = LocalDate.parse(date, formatter);
		
        String formattedDate = typedDate.format(formatter);
		
		if(typedDate.isBefore(now))
			throw new Exception("La data inserita non è valida : Data già passata");
		
		this.date = typedDate;
	}

	public int getNumSeats() {
		return numSeats;
	}

	private void setNumSeats(int numSeats) throws Exception {
		
		if(numSeats <= 0)
			throw new Exception("Il numero dei posti non può essere negativo o uguale a 0(zero)");
		
		this.numSeats = numSeats;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}

	private void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	
	
	// utils
	
	
	// Prenota se ci sono posti disponibili e se l'evento deve ancora iniziare 
	public void prenota() throws Exception {
		if(this.remainingSeats() == 0 || !date.isAfter(LocalDate.now()))
			throw new Exception("Impossibile prenotare un posto per questo evento");
		
		this.reservedSeats += 1;
	}
	
	
	public void disdici() throws Exception {
		if(reservedSeats == 0 || !date.isAfter(LocalDate.now()))
			throw new Exception("Impossibile disdire la prenotazione");
		
		this.reservedSeats -= 1;
	}
	
	public int remainingSeats() {
		
		return this.numSeats - this.reservedSeats;
	}
	
	@Override
	public String toString() {
				
		return this.date + " - " + this.title;
	}
	
	
}
