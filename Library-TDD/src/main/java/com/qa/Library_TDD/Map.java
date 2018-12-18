package com.qa.Library_TDD;

public class Map extends Item 
{
	private String country;

	public Map(int ID, int pageCount, String name, String country, boolean isCheckedIn) 
	{
		super(pageCount, ID, name, isCheckedIn);
		this.setCountry(country);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public void update(Item item) {
		super.update(item);
		this.setCountry(((Map)item).getCountry());
	}

}
