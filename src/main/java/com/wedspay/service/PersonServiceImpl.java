package com.wedspay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wedspay.dao.PersonDAO;
import com.wedspay.entity.Payment;
import com.wedspay.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;
	@Override
	@Transactional
	public void savePerson(Person p) {
		personDAO.savePerson(p);
	}

	@Override
	@Transactional
	public Person getPerson(Long id) {
		return personDAO.getPerson(id);
	}

	@Override
	@Transactional
	public Person getPersonByMarriageId(String marriageId) {
		return personDAO.getPersonByMarriageId(marriageId);
	}

	@Override
	public void saveBothEntity(Payment p) {
		// TODO Auto-generated method stub
	}

}
