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
	public void save(Friend friend) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
		} catch (Exception e) {
			e.printStackTrace();
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
	public List<Friend> getMyFriends(String u_id) {
		String hql1 = "select f_id from Friend where u_id='" + u_id + "' and status = 'A'";
		String hql2 = "select u_id from Friend where f_id='" + u_id + "' and status = 'A'";
		Query q1 = sessionFactory.openSession().createQuery(hql1);
		Query q2 = sessionFactory.openSession().createQuery(hql2);
		List<Friend> list1 = (List<Friend>) q1.list();
		List<Friend> list2 = (List<Friend>) q2.list();
		list1.addAll(list2);
		return list1;
	}

	@Transactional
	public List<Friend> getNewFriendRequests(String f_id) {
		String hql = "select u_id from Friend where f_id='" + f_id + "' and status = 'N'";
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

}
