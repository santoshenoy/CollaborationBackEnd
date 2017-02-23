package com.niit.CollaborationBackEnd.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackEnd.dao.JobDAO;
import com.niit.CollaborationBackEnd.model.Job;

@Repository("jobDAO")
@EnableTransactionManagement
public class JobDAOImpl implements JobDAO {

	@Autowired
	SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(Job job) {
		sessionFactory.getCurrentSession().save(job);
	}

	@Transactional
	public void update(Job job) {
		sessionFactory.getCurrentSession().update(job);
	}

	@Transactional
	public void delete(int id) {
		Job jobtodelete = new Job();
		jobtodelete.setId(id);
		sessionFactory.getCurrentSession().delete(jobtodelete);
	}

	@Transactional
	public List<Job> list() {
		String hql = "from Job";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
