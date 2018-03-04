package com.people.connection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.people.connection.model.Person;
import com.people.connection.service.FindConnectionService;


/**
 * @author Abhimanyu
 *
 */

@RequestMapping("/find")
@RestController
public class FindConnectionController {
	
	@Autowired
	FindConnectionService findConnectionService;
	
	@RequestMapping(value = "/connection", method = RequestMethod.POST)
	public ResponseEntity<Person> findConnection(Person person) {
		
		person=findConnectionService.findConnection(person);
		return new ResponseEntity<>(person,HttpStatus.OK);
	}
	

}
