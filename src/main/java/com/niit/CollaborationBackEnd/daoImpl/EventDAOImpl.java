package com.niit.CollaborationBackEnd.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackEnd.dao.EventDAO;
import com.niit.CollaborationBackEnd.model.Event;

@Repository("eventDAO")
@EnableTransactionManagement
public class EventDAOImpl implements EventDAO {

	@Autowired
	SessionFactory sessionFactory;

	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
	}

	@Transactional
	public void update(Event event) {
		sessionFactory.getCurrentSession().update(event);
	}

	@Transactional
	public void delete(String id) {
		Event event = new Event();
		event.setId(id);
		sessionFactory.getCurrentSession().delete(event);
	}

	@Transactional
	public List<Event> list() {
		String hql = "from Event";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
