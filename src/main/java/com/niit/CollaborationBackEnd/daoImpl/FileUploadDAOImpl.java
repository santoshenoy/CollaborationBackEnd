package com.niit.CollaborationBackEnd.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackEnd.dao.FileUploadDAO;
import com.niit.CollaborationBackEnd.model.FileUpload;

@Repository("fileUploadDAO")
@EnableTransactionManagement
public class FileUploadDAOImpl implements FileUploadDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public FileUploadDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(FileUpload fileUpload) {
		Session session = sessionFactory.getCurrentSession();
		session.save(fileUpload);
	}

	@Transactional
	public FileUpload getFile(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from FileUpload where username=?");
		query.setParameter(0, username);
		FileUpload fileUpload = (FileUpload) query.setMaxResults(1).uniqueResult();
		// session.close();
		return fileUpload;
	}

}
