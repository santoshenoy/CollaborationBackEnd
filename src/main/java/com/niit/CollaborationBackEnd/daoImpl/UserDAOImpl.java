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
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Transactional
	public List<User> list() {
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public void delete(String id) {
		User user = new User();
		user.setId(id);
		sessionFactory.getCurrentSession().delete(user);

	}

	@Transactional
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Transactional
	public boolean validateUser(String id, String psswrd) {
		try {
			User user = sessionFactory.getCurrentSession().get(User.class, id);
			if (user.getPsswrd().equals(psswrd)) {
				//user.setErrorCode("200");
				//user.setErrorMsg("User Found");
				return true;
			} else {
				//user.setErrorCode("100");
				//user.setErrorMsg("Password incorrect");
				return false;
			}
		} catch (Exception ex) {
			User user = new User();
			//user.setErrorCode("100");
			//user.setErrorMsg("ID not found in Database");
			return false;
		}
	}
	
    @Transactional
	public User getUser(String id) {
		try {
			User user = sessionFactory.getCurrentSession().get(User.class, id);
			//user.setErrorCode("200");
			//user.setErrorMsg("User Found");
			return user;
		} catch (Exception ex) {
			User user = new User();
			ex.printStackTrace();
			//user.setErrorCode("404");
			//user.setErrorMsg("User Not Found");
			return null;
		}
	}
}
