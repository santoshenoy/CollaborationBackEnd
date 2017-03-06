package com.niit.CollaborationBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.UserDAO;
import com.niit.CollaborationBackEnd.model.User;

public class UserTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		User user = (User) context.getBean("user");

		/*
		 * user.setId("RAM_002"); user.setNam("SURESH");
		 * user.setmail("hdhdhd@gmail.com"); user.setDob("24-10-2016");
		 * user.setmobile("98738382"); user.setPsswrd("jjdddkd");
		 * user.setGender("M"); user.setRole("STUDENT"); user.setAddress("MVM");
		 * user.setIsOnline('h'); user.setStatus('k');
		 * 
		 * userDAO.save(user);
		 * 
		 * userDAO.delete("mmm");
		 */

		// user.setId("RAM_003");
		// user.setNam("RAMESH");

		/*user.setId("SAN_001");
		user.setNam("Santosh Shenoy");
		user.setmail("santoshenoy@gmail.com");
		user.setDob("10");
		user.setmobile("2222222");
		user.setPsswrd("jjdddkd");
		user.setGender("M");
		user.setRole("STUDENT");
		user.setAddress("MVM");
		user.setIsOnline('h');
		user.setStatus('k');

		userDAO.update(user);*/
		
		/*boolean val = userDAO.validateUser("hdsbad", "cdhn");
		if(val == true)
		{
			System.out.println("TRUE");
		}
		else
		{
			System.out.println("FALSE....");
		}*/
		
		
		user = userDAO.getUser("hdsbad");
		System.out.println(user.getNam());
		System.out.println(user.getId());
		System.out.println(user.getPsswrd());
	}

}
