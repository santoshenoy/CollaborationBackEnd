package com.niit.CollaborationBackEnd.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackEnd.dao.ForumDAO;
import com.niit.CollaborationBackEnd.model.Forum;

@Repository("forumDAO")
@EnableTransactionManagement
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
	}

	@Transactional
	public void update(Forum forum) {
		sessionFactory.getCurrentSession().update(forum);
	}

	@Transactional
	public void delete(String id) {
		Forum forum = new Forum();
		forum.setId(id);
		sessionFactory.getCurrentSession().delete(forum);
	}

	@Transactional
	public List<Forum> list() {
		String hql = "from Forum";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
