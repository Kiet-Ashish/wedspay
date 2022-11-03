package com.wedspay.dao;

import com.wedspay.entity.Person;

public interface PersonDAO {
	
	public void savePerson(Person p);
	public Person getPerson(Long id);
	public Person getPersonByMarriageId(String marriageId);
}
