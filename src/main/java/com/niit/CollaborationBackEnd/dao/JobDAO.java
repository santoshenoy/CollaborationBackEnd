package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Job;

public interface JobDAO {
	
	public void save(Job job);

	public void update(Job job);

	public void delete(int id);

	public List<Job> list();


}
