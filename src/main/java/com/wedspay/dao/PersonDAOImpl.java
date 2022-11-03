package com.wedspay.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wedspay.entity.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void savePerson(Person p) {
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(p);
	}

	@Override
	public Person getPerson(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Person person = session.get(Person.class, id);
		return person;
	}

	@Override
	public Person getPersonByMarriageId(String marriageId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Person> q = session.createQuery("from Person p where p.marriageId =:m", Person.class);
		q.setParameter("m", marriageId);
		List<Person> list = q.getResultList();
		if(list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

}
