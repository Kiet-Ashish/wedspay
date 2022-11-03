package com.wedspay.service;

import com.wedspay.entity.Payment;
import com.wedspay.entity.Person;

public interface PersonService {
	public void savePerson(Person p);
	public Person getPerson(Long id);
	public Person getPersonByMarriageId(String marriageId);
	public void saveBothEntity(Payment p);
}
