package com.niit.CollaborationBackEnd.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackEnd.dao.BlogDAO;
import com.niit.CollaborationBackEnd.model.Blog;

@Repository("blogDAO")
@EnableTransactionManagement
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}

	@Transactional
	public void update(Blog blog) {
		sessionFactory.getCurrentSession().update(blog);
	}

	@Transactional
	public void delete(String id) {
		Blog blog = new Blog();
		blog.setId(id);
		sessionFactory.getCurrentSession().delete(blog);
	}

	@Transactional
	public List<Blog> list() {
		String hql = "from Blog";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}
