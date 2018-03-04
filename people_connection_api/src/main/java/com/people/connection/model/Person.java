package com.people.connection.model;

/**
 * @author Abhimanyu
 *
 */
public class Person {

	Person parent;
	byte[] byteImage;
	String image;
	String id;
	String firstName;
	String lastName;

	public Person(String myId) {
		// TODO Auto-generated constructor stub
		this.id = myId;
	}

	public Person() {
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

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

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getByteImage() {
		return byteImage;
	}

	public void setByteImage(byte[] byteImage) {
		this.byteImage = byteImage;
	}

	public Person getParent() {
		return parent;
	}

	public void setParent(Person parent) {
		this.parent = parent;
	}

}
