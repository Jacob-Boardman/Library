package com.qa.Library_TDD;

import java.util.ArrayList;
import java.util.List;

public class Person 
{
	private String name;
	private int age;
	private String email;
	private boolean isRegistered;
	private int checkedOutCounter;
	
	private List<Item> libraryItems = new ArrayList<>();
	
	Person(String name, int age, String email, boolean isRegistered)
	{
		this.name = name;
		this.age = age;
		this.email = email;
		this.isRegistered = isRegistered;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public List<Item> getLibraryItems() {
		return libraryItems;
	}

	public void setLibraryItems(List<Item> libraryItems) {
		this.libraryItems = libraryItems;
	}

	public void addItem(Item item) {
		libraryItems.add(item);
	}


	public int getCheckedOutCounter() {
		return checkedOutCounter;
	}


	public void setCheckedOutCounter(int checkedOutCounter) {
		this.checkedOutCounter += checkedOutCounter;
	}
}
