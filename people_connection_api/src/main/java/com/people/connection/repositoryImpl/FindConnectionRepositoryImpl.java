package com.people.connection.repositoryImpl;

import java.util.List;
import java.util.Map;

import org.jongo.Find;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public Map<String, List<String>> getGraph() {
		// TODO Auto-generated method stub
		MongoCollection collection = dataSource.getCollection(PHOTO_IMAGES_COLLECTION);
		Find find= collection.find("{},{\"uid\":1, \"_id\":0}");
		

		return null;
	}

}
