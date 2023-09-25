package org.java.eventHandler;

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
	
	
	
	public void deleteProgram() {
		
		this.events = new ArrayList<>();
	}
	
	
}
