package com.niit.CollaborationBackEnd.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackEnd.dao.FriendDAO;
import com.niit.CollaborationBackEnd.model.Friend;

@Repository("friendDAO")
@EnableTransactionManagement
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	SessionFactory sessionFactory;

	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Friend friend) {
		try {
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public void update(Friend friend) {
		try {
			sessionFactory.getCurrentSession().update(friend);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void delete(String u_id, String f_id) {
		Friend friend = new Friend();
		friend.setU_id(u_id);
		friend.setF_id(f_id);
		sessionFactory.getCurrentSession().delete(friend);
	}

	@Transactional
	public void setOnline(String u_id) {
		String hql = "update Friend set isOnline = 'Y' where u_id ='" + u_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
	}

	@Transactional
	public void setOffline(String u_id) {
		String hql = "update Friend set isOffline = 'N' where u_id ='" + u_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
	}

	@Transactional
	public List<String> getMyFriends(String u_id) {
		String hql1 = "select f_id from Friend where u_id='" + u_id + "' and status = 'A'";
		String hql2 = "select u_id from Friend where f_id='" + u_id + "' and status = 'A'";
		Query q1 = sessionFactory.getCurrentSession().createQuery(hql1);
		Query q2 = sessionFactory.getCurrentSession().createQuery(hql2);
		List<String> list1 = (List<String>) q1.list();
		List<String> list2 = (List<String>) q2.list();
		list1.addAll(list2);
		return list1;
	}

	@Transactional
	public List<Friend> getNewFriendRequests(String u_id) {
		String hql = "From Friend where f_id='" + u_id + "' and status = 'P'";
		Query query = sessionFactory.openSession().createQuery(hql);
		List<Friend> list = (List<Friend>) query.list();
		return list;
	}

	@Transactional
	public List<Friend> getFriendRequestsSentByMe(String u_id) {
		String hql = "select f_id from Friend where u_id='" + u_id + "' and status = 'N'";
		Query query = sessionFactory.openSession().createQuery(hql);
		List<Friend> list = (List<Friend>) query.list();
		return list;
	}

	@Transactional
	public boolean accept(String userID, String friendID) {
		// log.info("Update Friend");
		System.out.println("Update Friend");
		try {
			String sql = "UPDATE Friend SET status = 'A' where u_id = '" + friendID + "' and f_id = '" + userID + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(sql);
			query.executeUpdate();
			// log.info("Update friend success");
			System.out.println("Update Friend Success");
			return true;
		} catch (Exception e) {
			// log.error("Error updating friend");
			System.out.println("Error Updating Friend");
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean reject(String userID, String friendID) {
		// log.info("Update Friend");
		System.out.println("Update Friend");
		try {
			String sql = "UPDATE Friend SET status = 'R' where u_id = '" + friendID + "' and f_id = '" + userID + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(sql);
			query.executeUpdate();
			// log.info("Update friend success");
			System.out.println("Update Friend Success");
			return true;
		} catch (Exception e) {
			// log.error("Error updating friend");
			System.out.println("Error Updating Friend");
			e.printStackTrace();
			return false;
		}
	}

	
	
	
}
