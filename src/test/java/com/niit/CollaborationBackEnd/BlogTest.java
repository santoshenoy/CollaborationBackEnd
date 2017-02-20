package com.niit.CollaborationBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.BlogDAO;
import com.niit.CollaborationBackEnd.model.Blog;

public class BlogTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		BlogDAO blogDAO = (BlogDAO) context.getBean("blogDAO");
		Blog blog = (Blog) context.getBean("blog");
		
		blog.setId("BLO_001");
		blog.setName("BLOG 1");
		blog.setDescription("fej");
		blog.setU_id("'RAM_002");
		blog.setStatus("feffe");
		blog.setB_date("24/10/2016");
		
		blogDAO.save(blog);
	}

}
