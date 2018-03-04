package com.people.connection.repository;

import java.util.List;
import java.util.Map;

/**
 * @author Abhimanyu
 *
 */
public interface FindConnectionRepository {

	Map<String, List<String>> getGraph();

}
