package com.qa.Library_TDD;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Item> itemsList = new ArrayList<>();

	public void addItem(Item item) {
		itemsList.add(item);
	}

	public void removeItem(Item item) {
		itemsList.remove(item);
	}

	public void checkItemIn(Item item) {
		item.setCheckedIn(true);
	}

	public void checkItemOut(Item item) {
		if (item.isCheckedIn()) {
			item.setCheckedIn(false);
		} else {
			System.out.println("Item is already checked out");
		}
	}

	/*
	 * public void updateItemDetails(int ID, Item item, int pageCount, String name)
	 * { item.setPageCount(pageCount); item.setID(ID); item.setName(name); }
	 */

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
