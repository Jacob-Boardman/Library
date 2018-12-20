package com.qa.Library_TDD;

import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryTest {

	@Test
	public void listNotEmptyTestOne() {
		Library libTest = new Library();

		Book b1 = new Book(0, 500, "The One Book", true, true);
		libTest.addItem(b1);

		int output = libTest.getItems().size();

		assertEquals(1, output);

	}

	@Test
	public void listNotEmptyTestTwo() {
		Library libTest = new Library();

		Book b1 = new Book(0, 500, "The One Book", true, true);
		Book b2 = new Book(1, 250, "The Two Book", true, true);

		libTest.addItem(b1);
		libTest.addItem(b2);

		int output = libTest.getItems().size();

		assertEquals(2, output);

	}

	@Test
	public void listItemTestOne() {
		Library libTest = new Library();

		Book b1 = new Book(0, 500, "The One Book", true, true);
		Map m1 = new Map(101, 40, "Map of United Kingdom", "United Kingdom", true);

		libTest.addItem(b1);
		libTest.addItem(m1);

		Item output = libTest.getItems().get(1);
		assertSame(output, m1);
	}

	@Test
	public void listItemTestTwo() {
		Library libTest = new Library();

		Book b1 = new Book(0, 500, "The One Book", true, true);
		Map m1 = new Map(1001, 40, "Map of United Kingdom", "United Kingdom", true);
		Journal j1 = new Journal(2001, 100, "Journal of INteresting Insects", 10, true);

		libTest.addItem(b1);
		libTest.addItem(m1);
		libTest.addItem(j1);

		Item output = libTest.getItems().get(2);
		assertSame(output, j1);
	}

	@Test
	public void listPersonTestOne() {
		PersonManager pManTest = new PersonManager();

		Person p1 = new Person("Mario", 25, "mario@nintendo.com", true);

		pManTest.addPerson(p1);
		int output = pManTest.getPeople().size();
		assertEquals(1, output);
	}

	@Test
	public void listRemoveItem() {
		Library libTest = new Library();

		Book b1 = new Book(0, 500, "The One Book", true, true);
		libTest.addItem(b1);
		libTest.removeItem(b1);
		int output = libTest.getItems().size();
		assertEquals(0, output);

	}

	@Test
	public void listRemovePerson() {
		PersonManager pManTest = new PersonManager();

		Person p1 = new Person("Mario", 25, "mario@nintendo.com", false);
		pManTest.addPerson(p1);
		pManTest.removePerson(p1);
		int output = pManTest.getPeople().size();
		assertEquals(0, output);
	}
	
	
	@Test
	public void checkInItem()
	{
		Library libTest = new Library();
		Person p1 = new Person("Mario", 25, "", false);
		
		Book b1 = new Book(0, 500, "The One Book", true, false);
		libTest.addItem(b1);
		libTest.checkItemIn(b1, p1);
		Book output = (Book) libTest.getItems().get(0);
		boolean boolOutput = output.isCheckedIn();
		
		assertTrue("Boolean was false",boolOutput);
		//assertEquals();
	}
	
	@Test
	public void checkOutItem()
	{
		Library libTest = new Library();
		Person p1 = new Person("Mario", 25, "", true);
		Book b1 = new Book(0, 500, "The One Book", true, true);
		
		libTest.addItem(b1);
		libTest.checkItemOut(b1, p1);
		
		assertEquals(true, p1.isRegistered());
		assertSame(b1, p1.getLibraryItems().get(0));
		assertEquals(1,p1.getCheckedOutCounter());
	}

	@Test
	public void registerPersonTest()
	{
		PersonManager pManTest = new PersonManager();
		Person p1 = new Person("Mario", 25, "", false);
		pManTest.addPerson(p1);
		
		pManTest.registerPerson(p1);
		Person output = pManTest.getPeople().get(0);
		assertEquals(true, output.isRegistered());	
	}
	
	@Test
	public void updatePersonTest()
	{
		PersonManager pManTest = new PersonManager();
		Person p1 = new Person("Mario", 25, "example@example.com", true);
		
		pManTest.addPerson(p1);
		pManTest.updatePerson(p1, "Mario", 26, "mario@nintendo.com");
		
		Person output = pManTest.getPeople().get(0);
		
		assertEquals("Mario", output.getName());
		assertEquals(26, output.getAge());
		assertEquals("mario@nintendo.com", output.getEmail());
	}
	
	@Test
	public void newUpdateTest()
	{
		Library libTest = new Library();
		
		Book b1 = new Book(0, 500, "The One Book", true, true);
		Book b2 = new Book(40, 500, "The Two Book", true, true);
		Map m1 = new Map(1001, 40, "Map of United Kingdom", "United Kingdom", true);
		Journal j1 = new Journal(2001, 100, "Journal of Interesting Insects", 10, true);

		libTest.addItem(b1);
		libTest.addItem(b2);
		libTest.addItem(m1);
		libTest.addItem(j1);
		
		//libTest.updateItem(40, new Book(40, 1500, "The Three Book", false, false));
		//libTest.updateItem(40, new Map(1001, 35, "Map of Great Britain", "Great Britain", false));
		
		libTest.updateItem(0, new Book(30, 1500, "The Three Book", false, false));
		libTest.updateItem(1001, new Map(1001, 35, "Map of Great Britain", "Great Britain", false));
		libTest.updateItem(2001, new Journal(2001, 90, "Interesting Insects", 8, true));
		
		assertEquals("The Three Book", libTest.getItems().get(0).getName());
		assertEquals("Map of Great Britain", libTest.getItems().get(2).getName());
		assertEquals("Interesting Insects", libTest.getItems().get(3).getName());
	}
	
	@Test
	public void personCheckIn()
	{
		Person p1 = new Person("Mario", 25, "example@example.com", true);
		Library libTest = new Library();
		
		Book b1 = new Book(0, 500, "The One Book", true, true);
		libTest.addItem(b1);
		p1.addItem(b1);
		libTest.checkItemIn(b1, p1);
		p1.removeItem(b1);
		assertEquals(0, p1.getLibraryItems().size());
		assertEquals(0, p1.getCheckedOutCounter());
	}
	

}
