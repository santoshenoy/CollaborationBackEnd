package com.niit.CollaborationBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.FriendDAO;
import com.niit.CollaborationBackEnd.model.Friend;

public class FriendTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		FriendDAO friendDAO = (FriendDAO) context.getBean("friendDAO");
		Friend friend = (Friend) context.getBean("friend");
		
		friend.setU_id("RAM_002");
		friend.setF_id("RAHUL_002");
		friend.setIsOnline("N");
		friend.setStatus("A");
		
		friendDAO.save(friend);
	}

}
