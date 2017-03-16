package com.niit.CollaborationBackEnd.dao;

import java.util.List;

import com.niit.CollaborationBackEnd.model.Friend;

public interface FriendDAO {
	
	public boolean save(Friend friend);

	public void update(Friend friend);

	public void delete(String u_id, String f_id);
	
	public void setOnline(String u_id);
	
	public void setOffline(String u_id);
	
	public List<String> getMyFriends(String u_id);
	
	public List<Friend> getFriendRequestsSentByMe(String u_id);
	
	public List<Friend> getNewFriendRequests(String f_id);
	
	public boolean accept(String userID, String friendID);
	
	public boolean reject(String userID, String friendID);
	
}
