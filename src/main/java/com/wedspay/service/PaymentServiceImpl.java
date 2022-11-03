package com.wedspay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wedspay.dao.PaymentDAO;
import com.wedspay.entity.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDAO paymentDAO;
	@Override
	@Transactional
	public void savePayment(Payment p) {
		paymentDAO.savePayment(p);
	}

}
