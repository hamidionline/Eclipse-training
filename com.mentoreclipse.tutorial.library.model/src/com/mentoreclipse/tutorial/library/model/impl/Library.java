/**
 * 
 */
package com.mentoreclipse.tutorial.library.model.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Model element representing a Library.
 *  
 * @author nbhusare
 */
public class Library {

	private List<Book> books = new ArrayList<Book>();
	
	public boolean addBook(Book book) {
		return books.add(book);
	}
	
	public List<Book> getBooks() {
		return books;
	}
}
