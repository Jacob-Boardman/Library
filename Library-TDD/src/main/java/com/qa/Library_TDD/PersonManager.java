package com.qa.Library_TDD;

import java.util.ArrayList;
import java.util.List;

public class PersonManager 
{
	private List<Person> peopleList = new ArrayList<>();
	
	public void addPerson(Person person)
	{
		peopleList.add(person);
	}
	
	public void removePerson(Person person)
	{
		peopleList.remove(person);
	}
	
	public void registerPerson(Person person) 
	{
		if(!person.isRegistered())
		{
			person.setEmail("example@example.com");
			person.setRegistered(true);
		}
		else
		{
			System.out.println("You are already registered");
		}
	}
	
	public void updatePerson(Person person, String name, int age, String email)
	{
		person.setName(name);
		person.setAge(age);
		person.setEmail(email);
	}
	
	public List<Person> getPeople() {
		return peopleList;
	}

	public void setPeople(List<Person> people) {
		this.peopleList = people;
	}
}
