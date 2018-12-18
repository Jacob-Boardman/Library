package com.qa.Library_TDD;

public abstract class Item 
{
	private int pageCount;
	private int ID;
	private String name;
	private boolean isCheckedIn;
	
	
	Item(int pageCount, int ID, String name, boolean isCheckedIn)
	{
		this.pageCount = pageCount;
		this.ID = ID;
		this.name = name;
		this.setCheckedIn(isCheckedIn);
	}

	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isCheckedIn() {
		return isCheckedIn;
	}


	public void setCheckedIn(boolean isCheckedIn) {
		this.isCheckedIn = isCheckedIn;
	}

	public void update(Item item) throws ClassCastException{ 
		this.setID(item.getID());
		this.setName(item.getName());
		this.setPageCount(item.getPageCount());
		this.setCheckedIn(item.isCheckedIn());
	}
	

}
