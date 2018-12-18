package com.qa.Library_TDD;

public class Book extends Item {
	private boolean isHardback;

	Book(int ID, int pageCount, String name, boolean isHardback, boolean isCheckedIn) {
		super(pageCount, ID, name, isCheckedIn);
		this.setHardback(isHardback);
	}

	public boolean isHardback() {
		return isHardback;
	}

	public void setHardback(boolean isHardback) {
		this.isHardback = isHardback;
	}

	@Override
	public void update(Item item) {
		super.update(item);
		this.setHardback(((Book) item).isHardback());
	}

}
