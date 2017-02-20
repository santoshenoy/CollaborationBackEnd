package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.CollaborationBackEnd.model.User;


public interface UserDAO {

	public void save(User user);

	public void update(User user);

	public void delete(String id);

	public List<User> list();

}