/**
 * 
 */
package com.mentoreclipse.tutorial.jface.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nbhusare
 *
 */
public class Library {

	List<Book> books = new ArrayList<Book>();

	public void addBook(Book book) {
		books.add(book);
	}
	
	public List<Book> getBooks() {
		return books;
	}
}
