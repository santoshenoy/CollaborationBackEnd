package com.niit.CollaborationBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.EventDAO;
import com.niit.CollaborationBackEnd.model.Event;

public class EventTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		EventDAO eventDAO = (EventDAO) context.getBean("eventDAO");
		Event event = (Event) context.getBean("event");

		event.setId("EVENT_001");
		event.setName("EVENT 1");
		event.setDescription("fewdjnssav");
		event.setVenue("Bangalore");

		eventDAO.save(event);
	}

}
