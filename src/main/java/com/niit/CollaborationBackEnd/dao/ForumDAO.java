package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Forum;

public interface ForumDAO {

	public void save(Forum forum);

	public void update(Forum forum);

	public void delete(String id);

	public List<Forum> list();

}
