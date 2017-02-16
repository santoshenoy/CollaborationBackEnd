package com.niit.CollaborationBackEnd.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackEnd.dao.UserDAO;
import com.niit.CollaborationBackEnd.model.User;

@Repository("userDAO")
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(User user)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	@Transactional
	public List<User> list()
	{
		String hql = "from C_USER";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
}