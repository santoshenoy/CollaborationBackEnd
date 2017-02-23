package com.niit.CollaborationBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackEnd.dao.JobDAO;
import com.niit.CollaborationBackEnd.model.Job;

public class JobTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		JobDAO jobDAO = (JobDAO) context.getBean("jobDAO");
		Job job = (Job) context.getBean("job");

		/*.setId(1);
		job.setTitle("BLOG 2");
		job.setDescription("fej1");
		job.setU_id("'RAM_003");
		job.setStatus("feffe1");*/

		jobDAO.delete(1);
	}

}
