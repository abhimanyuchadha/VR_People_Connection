package com.people.connection.repository;

import java.util.List;
import java.util.Map;

import com.people.connection.model.Response;

/**
 * @author Abhimanyu
 *
 */
public interface FindConnectionRepository {

	List<Response> getGraph();

}
