package com.mentoreclipse.tutorial.jface.model;

/**
 * 
 * @author nbhusare
 *
 */
public class LibraryFactory {

	public Library getLibrary() {
		Library library = new Library();
		library.addBook(new Book("Book 1"));
		library.addBook(new Book("Book 2"));
		library.addBook(new Book("Book 3"));
		library.addBook(new Book("Book 4"));
		library.addBook(new Book("Book 5"));
		library.addBook(new Book("Book 6"));
		library.addBook(new Book("Book 7"));
		return library;
	}
	
}
