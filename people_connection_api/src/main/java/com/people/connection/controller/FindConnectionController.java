package com.people.connection.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.people.connection.model.Person;


/**
 * @author Abhimanyu
 *
 */

@RequestMapping("/find")
@RestController
public class FindConnectionController {
	
	@RequestMapping(value = "/connection", method = RequestMethod.GET)
	public ResponseEntity<Person> findConnection() {
		
		return new ResponseEntity<>(new Person(),HttpStatus.OK);
	}
	

}
