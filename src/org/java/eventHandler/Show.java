package org.java.eventHandler;

import java.math.BigDecimal;

public class Show extends Event{

	private BigDecimal price ; 
	
	public Show(String title, String date, int numSeats, BigDecimal price) throws Exception {
		super(title, date, numSeats);
		setPrice(price);
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getPrice() {
		return this.price;
	}
	
	@Override
	public String toString() {

		return this.getTitle() + " - " + this.getDate() + " - " + this.getPrice() + "$"; 
	}
	
}
