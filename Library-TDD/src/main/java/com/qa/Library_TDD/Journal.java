package com.qa.Library_TDD;

public class Journal extends Item implements Readable
{
	private int numberOfCitations;
	
	public Journal(int ID, int pageCount, String name, int numberOfCitations, boolean isCheckedIn) 
	{
		super(pageCount, ID, name, isCheckedIn);
		this.setNumberOfCitations(numberOfCitations);
	}

	public int getNumberOfCitations() {
		return numberOfCitations;
	}

	public void setNumberOfCitations(int numberOfCitations) {
		this.numberOfCitations = numberOfCitations;
	}
	
	@Override
	public void update(Item item) {
		super.update(item);
		this.setNumberOfCitations(((Journal)item).getNumberOfCitations());
	}

	@Override
	public void readable() {
		System.out.println("This is a Journal");
		
	}

}
