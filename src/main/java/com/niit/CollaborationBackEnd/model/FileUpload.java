package com.niit.CollaborationBackEnd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "profilepics")
@Component
public class FileUpload {

	@Id
	@GeneratedValue
	@Column(name = "FILE_ID")
	private int id;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Lob
	@Column(name = "FILE_DATA")
	private byte[] data;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String username;

}
