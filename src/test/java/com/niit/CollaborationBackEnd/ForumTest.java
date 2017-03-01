package com.niit.CollaborationBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.ForumDAO;
import com.niit.CollaborationBackEnd.model.Forum;

public class ForumTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		ForumDAO forumDAO = (ForumDAO) context.getBean("forumDAO");
		Forum forum = (Forum) context.getBean("forum");
		
		forum.setId("FOR_003");
		forum.setName("FORUM 3");
		forum.setDescription("fewdjnssav");
		forum.setU_id("'RAM_004");
		forum.setStatus("cjdisdfdsa");
		//forum.setF_date("24/10/2017");
		
		forumDAO.save(forum);
	}
}