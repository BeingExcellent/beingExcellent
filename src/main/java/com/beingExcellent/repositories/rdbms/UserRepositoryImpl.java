package com.beingExcellent.repositories.rdbms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.beingExcellent.model.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public User findByUserName(String username) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		session.beginTransaction();
		User user = (User) session.bySimpleNaturalId(User.class).load(username);
		tx.commit();
		return user;
	}
	
}
