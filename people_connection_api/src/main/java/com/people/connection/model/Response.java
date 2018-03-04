package com.people.connection.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

	@JsonProperty("first_name")
	String firstName;
	
	@JsonProperty("last_name")
	String lastName;
	
	@JsonProperty("uid")
	String uid;
	
	@JsonProperty("path")
	String path;
	
	@JsonProperty("known_uid")
	String[] connections;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String[] getConnections() {
		return connections;
	}

	public void setConnections(String[] connections) {
		this.connections = connections;
	}
	
	
	
}
