package com.niit.CollaborationBackEnd;

import java.util.List;

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
		
		/*blog.setId("BLO_003");
		blog.setName("BLOG 3");
		blog.setDescription("fejfdds");
		blog.setU_id("RAM_002");
		blog.setStatus("feffdvwedw");
		//blog.setB_date("24/10/2016");*/
		
		
		//blogDAO.save(blog);
		
		List<Blog> b =  blogDAO.list();
		for(Blog b1 : b)
		{
			System.out.println(b1);
		}
		
	}

}
