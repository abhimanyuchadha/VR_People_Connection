package com.people.connection.repositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jongo.Find;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.people.connection.model.Response;
import com.people.connection.repository.FindConnectionRepository;

/**
 * @author Abhimanyu
 *
 */
@Repository
public class FindConnectionRepositoryImpl implements FindConnectionRepository {

	@Autowired
	private Jongo dataSource;

	private static String PHOTO_IMAGES_COLLECTION = "photo_images";

	@Override
	public List<Response> getGraph() {
		// TODO Auto-generated method stub
		MongoCollection collection = dataSource.getCollection(PHOTO_IMAGES_COLLECTION);
		MongoCursor<Response> cursor = collection.find().as(Response.class);
		List<Response> l= convertMongoCursorToList(cursor);
		return l;
//		Map<String, List<String>> map=new HashMap<String, List<String>>();
//		for(Response r:l) {
//			List<String> arrayList=new ArrayList<>();
//			for(String key:r.getConnections()) {
//				arrayList.add(key);
//			}
//			map.put(r.getUid(), arrayList);
//		}
//		return map;
	}
	
	public <T> List<T> convertMongoCursorToList(MongoCursor<T> cursor) {
		List<T> list = new ArrayList<>();
		for (T t : cursor) {
			list.add(t);
		}
		return list;
	}


}
