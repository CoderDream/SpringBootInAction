package com.wisely.ch8_4.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisely.ch8_4.dao.PersonRepository;
import com.wisely.ch8_4.domain.Person;
import com.wisely.ch8_4.service.DemoService;
@Service
public class DemoServiceImpl implements DemoService {
	@Autowired
	PersonRepository personRepository; //1
	
	@Transactional(rollbackFor={IllegalArgumentException.class}) //2
	public Person savePersonWithRollBack(Person person){
		Person p =personRepository.save(person);

		if(person.getName().equals("姹簯椋�")){
			throw new IllegalArgumentException("姹簯椋炲凡瀛樺湪锛屾暟鎹皢鍥炴粴"); //3
		}
		return p;
	}

	@Transactional(noRollbackFor={IllegalArgumentException.class}) //4
	public Person savePersonWithoutRollBack(Person person){
		Person p =personRepository.save(person);
		
		if(person.getName().equals("姹簯椋�")){
			throw new IllegalArgumentException("姹簯椋炶櫧宸插瓨鍦紝鏁版嵁灏嗕笉浼氬洖婊�");
		}
		return p;
	}
}
