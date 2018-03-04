package com.people.connection.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people.connection.model.Person;
import com.people.connection.model.Response;
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
		List<Response> list=findConnectionRepository.getGraph();
		Map<String, Response> map=new HashMap<>();
		for(Response rep:list) {
			map.put(rep.getUid(), rep);
		}
		
		Map<String, List<String>> graph=new HashMap<String, List<String>>();
		for(Response r:list) {
			List<String> arrayList=new ArrayList<>();
			for(String key:r.getConnections()) {
				arrayList.add(key);
			}
			graph.put(r.getUid(), arrayList);
		}
		
		Person perso=findConnectionNodes(graph, myId, findId);
		Person person1=perso;
		while(person1.getParent()!=null) {
			Response rr=map.get(person1.getId());
			person1.setFirstName(rr.getFirstName());
			person1.setLastName(rr.getLastName());
			person1=person1.getParent();
		}
		Response response2=map.get(person1.getId());
		person1.setFirstName(response2.getFirstName());
		person1.setLastName(response2.getLastName());

		return perso;
	}

	private String getIdOfUnknownPerson(Person person) {
		// TODO Auto-generated method stub
		String ret ="1";
		 try
		    {
		        int number1 = 10;
		        int number2 = 32;
		        BufferedImage image = null;
		        byte[] imageByte;

		        Decoder decoder=Base64.getDecoder(); 
		        imageByte = decoder.decode(person.getImage());//decodeBuffer(person.getImage());
		        ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
		        image = ImageIO.read(bis);
		        bis.close();

		        // write the image to a file
		        File outputfile = new File("/home/ubuntu/mlh_project/image.png");
		        ImageIO.write(image, "png", outputfile);
		        
		        ProcessBuilder pb = new ProcessBuilder("python3","/home/ubuntu/mlh_project/VR_People_Connection" + 
		        		"face_rec_noders.py","/home/ubuntu/mlh_project/image.png");
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
