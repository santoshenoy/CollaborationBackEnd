package com.niit.CollaborationBackEnd.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackEnd.dao.Test_UserDAO;
import com.niit.CollaborationBackEnd.model.Test_User;
import com.niit.CollaborationBackEnd.model.User;

@Repository("test_UserDAO")
@EnableTransactionManagement
public class Test_UserDAOImpl implements Test_UserDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	public Test_UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addUser(Test_User test_User)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(test_User);
	}
	
	@Transactional
	public List<User> list()
	{
		
		String hql = "from Test_User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	

}
