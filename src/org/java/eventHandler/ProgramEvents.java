package org.java.eventHandler;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList; 
import java.util.Comparator;
import java.util.List;


public class ProgramEvents {
	
	private String title;
	private List<Event> events;
	
	public ProgramEvents(String title) {

		setTitle(title);
		setEvents();
	}
	
	
	
	// Getters and setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Event> getEvents() {
		
		return events;
	}
	public void setEvents() {
		this.events = new ArrayList<Event>();
	}
	

	// UTILS
	public void addEvents(Event event) {
	
		this.events.add(event);
	}
	
	public List<Event> findEventsByDate(String date) {
		
		List<Event> eventsInDate = new ArrayList<>();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");	
		LocalDate formattedDate = LocalDate.parse(date, formatter);
		
		this.events.forEach(e ->{
			if(e.getDate().compareTo(formattedDate) == 0) {
				eventsInDate.add(e);
			}
		});
		
	
		return eventsInDate;
	}
	
	
	public int numOfEvents() {
		
		return (int)events.stream().count();
		
		// return this.events.size(); No Lambda
	}
	
	
	public String chronoOrderedEvents() {
		
		this.events.sort(Comparator.comparing(Event::getDate));
		String res = this.title + "{\n";
		for(Event e : this.events) {
			res += e.getDate() + " - " + e.getTitle() + ", \n";
		}
		
		res += "}";
		return res;
	}
	
	
	public String formatPrice(BigDecimal price) {
	
		
		DecimalFormat formatter = new DecimalFormat("#,##0.00");
		String formattedPrice = formatter.format(price);
		
		return formattedPrice;
	}
	
	

	// Media prezzo Concerti
	public String avgConcertPrice() {
		
		List<Concert> concerts = new ArrayList<Concert>();
		BigDecimal sum = BigDecimal.ZERO;
		
		
		for(Event el : events) {
			if(el instanceof Concert) {
				concerts.add((Concert)el);
			}
		}
		
		for(Concert con : concerts) {
			sum =  sum.add(con.getPrice());
		}
		
		BigDecimal avg = sum.divide(BigDecimal.valueOf(concerts.size()));
		
		
		return this.formatPrice(avg) + "$";
		
	}
	
	
	// Media prezzo Spettacoli
	public String avgShowPrice() {
		
		List<Show> shows = new ArrayList<Show>();
		BigDecimal sum = BigDecimal.ZERO;
		
		
		for(Event el : events) {
			if(el instanceof Show) {
				shows.add((Show)el);
			}
		}
		
		for(Show show : shows) {
			sum =  sum.add(show.getPrice());
		}
		
		BigDecimal avg = sum.divide(BigDecimal.valueOf(shows.size()));
		
		
		return this.formatPrice(avg) + "$";
		
	}
	
	// Media prezzo totale
	public String avgEventsPrice() {
		
		BigDecimal sum = BigDecimal.ZERO;
		
		
		for(Event ev : events) {
			sum =  sum.add(ev.getPrice());
		}
		
		BigDecimal avg = sum.divide(BigDecimal.valueOf(this.events.size()), 2, RoundingMode.HALF_UP);
		
		
		return this.formatPrice(avg) + "$";
		
	}
	
	
	public void deleteProgram() {
		
		this.events = new ArrayList<>();
	}
	
	
}
