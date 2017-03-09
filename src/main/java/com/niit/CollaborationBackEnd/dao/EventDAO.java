package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Event;

public interface EventDAO {

	public void save(Event event);

	public void update(Event event);

	public void delete(String id);

	public List<Event> list();

}
