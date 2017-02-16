package com.niit.CollaborationBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.Test_UserDAO;
import com.niit.CollaborationBackEnd.model.Test_User;

public class Test_UserTest {

	public static void main(String[] args) 
	{

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		Test_UserDAO test_UserDAO  = (Test_UserDAO)context.getBean("test_UserDAO");
		Test_User test_User  = (Test_User)context.getBean("test_User");
		
		test_User.setId("RAM_002");
		test_User.setName("SURESH");
		
		test_UserDAO.addUser(test_User);

	}

}
