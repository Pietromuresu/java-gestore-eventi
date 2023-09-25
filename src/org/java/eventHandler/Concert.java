package org.java.eventHandler;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event {

	private LocalTime hour;
	private BigDecimal price;
	
	
	public Concert(String title, String date, int numSeats, String hour, BigDecimal price) throws Exception {
		super(title, date, numSeats);
		setHour(hour);
		setPrice(price);
	}
	

	
	// getters and setters

	public LocalTime getHour() {
		return hour;
	}


	public void setHour(String hour) {
			
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		
		LocalTime newHour = LocalTime.parse(hour, formatter);
		
		this.hour = newHour;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) throws Exception {
		if(price.compareTo(BigDecimal.ZERO) == -1)
			throw new Exception("Il prezzo non può essere inferiore a zero");
		
		this.price = price;
	}
	
	public String getFullDate() {
		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Formattare l'orario utilizzando il formatter
		 String hourStr = hour.format(formatter);
		
		return  "" + super.getDate() + " - " + hourStr; 
	}
	
	
	public String getFormattedPrice() {
		
		return this.price + "$";
	}
	
	@Override
	public String toString() {
		return getFullDate() + " - " + super.getTitle() + " - " + getFormattedPrice() ;
	}
	
}
