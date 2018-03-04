package com.people.connection.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.people.connection.model.Person;

/**
 * @author Abhimanyu
 *
 */
public class FindConnectionServiceImpl {

	public Person findConnectionNodes(Map<String, List<String>> graph, String myId, String findId) {
		Person person = null;
		Map<String, Boolean> visited = new HashMap<String, Boolean>();
		Iterator<String> iterator = graph.keySet().iterator();
		
		while (iterator.hasNext()) {
			String id = (String) iterator.next();
			visited.put(id, false);
			// listOfPersons.add(id);
		}

		List<Person> listOfPersonsQueue = new ArrayList<Person>();
		person = new Person(myId);
		listOfPersonsQueue.add(person);
		listOfPersonsQueue.add(null);
		int currentPointer = 0;
		int depth = 0;
		while (currentPointer < listOfPersonsQueue.size()) {
			Person tempPerson = listOfPersonsQueue.get(currentPointer++);
			
			if (null != tempPerson) {
				if(tempPerson.getId().equals(findId)) {
					return tempPerson;
				}
				visited.put(tempPerson.getId(),false);
				
				for (String connectedId : graph.get(tempPerson.getId())) {
					Person childPerson=new Person(connectedId);
					listOfPersonsQueue.add(childPerson);
					childPerson.setParent(childPerson);					
				}
			} else {
				listOfPersonsQueue.add(null);
				depth++;
			}
		}

		return person;

	}
}
