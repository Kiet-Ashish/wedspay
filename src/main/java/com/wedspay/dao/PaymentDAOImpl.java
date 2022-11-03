package com.wedspay.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wedspay.entity.Payment;

@Repository
public class PaymentDAOImpl implements PaymentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void savePayment(Payment p) {
		Session session = sessionFactory.getCurrentSession();
		session.save(p);
	}
}
