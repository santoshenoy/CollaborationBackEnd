package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Blog;

public interface BlogDAO {

	public void save(Blog blog);

	public void update(Blog blog);

	public void delete(String id);

	public List<Blog> list();

}
