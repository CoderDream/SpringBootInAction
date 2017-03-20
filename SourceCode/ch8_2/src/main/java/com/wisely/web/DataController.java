package com.wisely.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.dao.PersonRepository;
import com.wisely.domain.Person;

@RestController
public class DataController {
	//1 Spring Data JPA宸茶嚜鍔ㄤ负浣犳敞鍐宐ean锛屾墍浠ュ彲鑷姩娉ㄥ叆
	@Autowired
	PersonRepository personRepository;
	
	/**
	 * 淇濆瓨
	 * save鏀寔鎵归噺淇濆瓨锛�<S extends T> Iterable<S> save(Iterable<S> entities);
	 * 
	 * 鍒犻櫎锛�
	 * 鍒犻櫎鏀寔浣跨敤id锛屽璞′互锛屾壒閲忓垹闄ゅ強鍒犻櫎鍏ㄩ儴锛�
	 * void delete(ID id);
	 * void delete(T entity);
	 * void delete(Iterable<? extends T> entities);
	 * void deleteAll();
	 * 
	 */
	@RequestMapping("/save")
	public Person save(String name,String address,Integer age){
		
		Person p = personRepository.save(new Person(null, name, age, address));
		
		return p;
		
	}
	

	
	/**
	 * 娴嬭瘯findByAddress
	 */
	@RequestMapping("/q1")
	public List<Person> q1(String address){
		
		List<Person> people = personRepository.findByAddress(address);
		
		return people;
		
	}
	
	/**
	 * 娴嬭瘯findByNameAndAddress
	 */
	@RequestMapping("/q2")
	public Person q2(String name,String address){
		
		Person people = personRepository.findByNameAndAddress(name, address);
		
		return people;
		
	}
	
	/**
	 * 娴嬭瘯withNameAndAddressQuery
	 */
	@RequestMapping("/q3")
	public Person q3(String name,String address){
		
		Person p = personRepository.withNameAndAddressQuery(name, address);
		
		return p;
		
	}
	
	/**
	 * 娴嬭瘯withNameAndAddressNamedQuery
	 */
	@RequestMapping("/q4")
	public Person q4(String name,String address){
		
		Person p = personRepository.withNameAndAddressNamedQuery(name, address);
		
		return p;
		
	}
	
	/**
	 * 娴嬭瘯鎺掑簭
	 */
	@RequestMapping("/sort")
	public List<Person> sort(){
		
		List<Person> people = personRepository.findAll(new Sort(Direction.ASC,"age"));
		
		return people;
		
	}
	
	/**
	 * 娴嬭瘯鍒嗛〉
	 */
	@RequestMapping("/page")
	public Page<Person> page(){
		
		Page<Person> pagePeople = personRepository.findAll(new PageRequest(1, 2));
		
		return pagePeople;
		
	}
	
	
	@RequestMapping("/auto")
	public Page<Person> auto(Person person){
		
		Page<Person> pagePeople = personRepository.findByAuto(person, new PageRequest(0, 10));
		
		return pagePeople;
		
	}
	
	

}
