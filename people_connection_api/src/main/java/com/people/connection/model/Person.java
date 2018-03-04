package com.people.connection.model;

/**
 * @author Abhimanyu
 *
 */
public class Person {

	Person parent;
	byte[] image;
	String id;
	String firstName;
	String lastName;

	public Person(String myId) {
		// TODO Auto-generated constructor stub
		this.id = myId;
	}

	public Person() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Person getParent() {
		return parent;
	}

	public void setParent(Person parent) {
		this.parent = parent;
	}

}
