package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Test_User;
import com.niit.CollaborationBackEnd.model.User;

public interface Test_UserDAO {
	public void addUser(Test_User test_User);
	
	public List<User> list();
	
}
