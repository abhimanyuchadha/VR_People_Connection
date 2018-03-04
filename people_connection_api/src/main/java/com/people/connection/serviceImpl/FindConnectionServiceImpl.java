package com.people.connection.serviceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people.connection.model.Person;
import com.people.connection.repository.FindConnectionRepository;
import com.people.connection.service.FindConnectionService;

/**
 * @author Abhimanyu
 *
 */
@Service
public class FindConnectionServiceImpl implements FindConnectionService {

	@Autowired
	FindConnectionRepository findConnectionRepository;

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
				if (!visited.get(tempPerson.getId()).booleanValue()) {
					if (tempPerson.getId().equals(findId)) {
						return tempPerson;
					}
					visited.put(tempPerson.getId(), true);
					for (String connectedId : graph.get(tempPerson.getId())) {
						Person childPerson = new Person(connectedId);
						listOfPersonsQueue.add(childPerson);
						childPerson.setParent(tempPerson);
					}
				}
			} else {
				listOfPersonsQueue.add(null);
				depth++;
			}
		}

		return person;

	}

	@Override
	public Person findConnection(Person person) {
		// TODO Auto-generated method stub
		String findId = getIdOfUnknownPerson(person);
		String myId = person.getId();
		Map<String, List<String>> graph=findConnectionRepository.getGraph();
		Person perso=findConnectionNodes(graph, myId, findId);		

		return perso;
	}

	private String getIdOfUnknownPerson(Person person) {
		// TODO Auto-generated method stub
		String ret ="1";
		 try
		    {
		        int number1 = 10;
		        int number2 = 32;
		        ProcessBuilder pb = new ProcessBuilder("python3","/home/ubuntu/pythonFCRecg/face_rec_noders.py",person.getImage());
		        Process p = pb.start();
		        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		         ret = in.readLine();
		        System.out.println("value is : "+ret);
		    }
		    catch(Exception e)
		    {
		    	System.out.println("-----------------------------------------------------------------------------------------");
		        System.out.println(e);
		        
		    }
		return ret;
	}
}
