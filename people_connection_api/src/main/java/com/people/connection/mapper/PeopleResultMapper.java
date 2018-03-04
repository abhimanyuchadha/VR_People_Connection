package com.people.connection.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jongo.ResultHandler;

import com.mongodb.DBObject;

public class PeopleResultMapper implements ResultHandler<Map<String, List<String>>> {

	Map<String, List<String>> graph=new HashMap<String, List<String>>();
	@Override
	public Map<String, List<String>> map(DBObject result) {
		// TODO Auto-generated method stub
		
		System.out.println(result.get("known_uid"));
		
		System.out.println("heloooo---------------------------------------------------");
		return graph;
	}

}
