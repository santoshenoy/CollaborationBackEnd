package com.niit.CollaborationBackEnd.dao;

import com.niit.CollaborationBackEnd.model.FileUpload;

public interface FileUploadDAO {

	public void save(FileUpload fileUpload);

	FileUpload getFile(String id);

}
