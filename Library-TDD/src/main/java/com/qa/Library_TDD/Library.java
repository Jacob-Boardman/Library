package com.qa.Library_TDD;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Item> itemsList = new ArrayList<>();
	private PersonManager pMan = new PersonManager();

	public void addItem(Item item) {
		itemsList.add(item);
	}

	public void removeItem(Item item) {
		itemsList.remove(item);
	}

	public void checkItemIn(Item item, Person person) 
	{
		if(item.isCheckedIn())
		{
			System.out.println("Item is already checked in");
		}
		else
		{
			item.setCheckedIn(true);
			person.removeItem(item);
			person.setCheckedOutCounter(-1);
		}
		
	}

	public void checkItemOut(Item item, Person person) 
	{
		if (item.isCheckedIn() && person.isRegistered()) 
		{
			item.setCheckedIn(false);
			person.addItem(item);
			person.setCheckedOutCounter(1);
		} 
		else if(!person.isRegistered())
		{
			System.out.println("You need to register first");
			pMan.registerPerson(person);
		}
		else
		{
			System.out.println("Item is already checked out");
		}
	}

	public void updateItem(int ID, Item item) {
		try {
			this.itemsList.stream().filter(newItem -> newItem.getID() == ID).forEach(newItem -> newItem.update(item));
		} catch (ClassCastException cce) {
			System.out.println(cce.getMessage());
		}
	}

	public List<Item> getItems() {
		return itemsList;
	}

	public void setItems(List<Item> items) {
		this.itemsList = items;
	}

}
