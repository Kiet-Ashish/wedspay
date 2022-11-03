package com.wedspay.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wedspay.entity.Person;
import com.wedspay.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
	@Override
	public User getUserByMobileNo(String mobile) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> q = session.createQuery("from User u where u.mobile =:m", User.class);
		q.setParameter("m", mobile);
		List<User> list = q.getResultList();
		return list.get(0);
	}
	@Override
	public User getUserByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> q = session.createQuery("from User u where u.email =:email", User.class);
		q.setParameter("email", userName);
		List<User> list = q.getResultList();
		if(list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
	@Override
	public List<Person> getPersonsList(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> q = session.createQuery("from User u where u.email =:email", User.class);
		q.setParameter("email", userName);
		List<User> list = q.getResultList();
		return list.get(0).getMarriages();
	}

}
