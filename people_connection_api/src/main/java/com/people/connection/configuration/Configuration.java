package com.people.connection.configuration;

import org.jongo.Jongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;


@org.springframework.context.annotation.Configuration
public class Configuration {

		
		@Autowired
		Environment env;	

		@Bean
		public Jongo jongo() throws Exception {
			Jongo jongo = null;
			try {
				MongoClientURI uri = new MongoClientURI(env.getProperty("spring.data.mongodb.uri"));
				MongoClient mongoClient = new MongoClient(uri);
				DB db = mongoClient.getDB(env.getProperty("database"));
				jongo = new Jongo(db);
				// is to be created for the first time to avoid duplicate entries
				// jongo.getCollection("historical").ensureIndex("{DATE:1},{unique:true}");

			} catch (Exception e) {
				System.err.println("error in creating jongo bean ::" + e);
				throw e;
			}
			return jongo;
		}

}
