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

		job.setTitle("BLOG 1");
		job.setDescription("fej");
		job.setU_id("'RAM_002");
		job.setStatus("feffe");

		jobDAO.save(job);
	}

}
