package com.people.connection.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Abhimanyu
 *
 */

@RequestMapping("/find")
public class FindConnectionController {
	
	@RequestMapping(value = "/connection", method = RequestMethod.GET)
	public ResponseEntity<Object> findConnection() {

		return null;
	}
	

}
