package com.homework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.homework.mapper.PersonMapper;
import com.homework.pojo.Person;
import com.homework.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonMapper personMapper;

	@Override
	public void add(Person person) {
		// TODO Auto-generated method stub
		personMapper.add(person);
	}

}
