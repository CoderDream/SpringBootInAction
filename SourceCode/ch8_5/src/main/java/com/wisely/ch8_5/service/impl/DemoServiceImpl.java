package com.wisely.ch8_5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wisely.ch8_5.dao.PersonRepository;
import com.wisely.ch8_5.domain.Person;
import com.wisely.ch8_5.service.DemoService;


@Service
public class DemoServiceImpl implements DemoService {
	
	@Autowired
	PersonRepository personRepository;

	@Override
	@CachePut(value = "people", key = "#person.id")
	public Person save(Person person) {
		Person p = personRepository.save(person);
		System.out.println("涓篿d銆乲ey涓�:"+p.getId()+"鏁版嵁鍋氫簡缂撳瓨");
		return p;
	}

	@Override
	@CacheEvict(value = "people")//2
	public void remove(Long id) {
		System.out.println("鍒犻櫎浜唅d銆乲ey涓�"+id+"鐨勬暟鎹紦瀛�");
		//杩欓噷涓嶅仛瀹為檯鍒犻櫎鎿嶄綔
	}

	@Override
	@Cacheable(value = "people", key = "#person.id")//3
	public Person findOne(Person person) {
		Person p = personRepository.findOne(person.getId());
		System.out.println("涓篿d銆乲ey涓�:"+p.getId()+"鏁版嵁鍋氫簡缂撳瓨");
		return p;
	}

}
