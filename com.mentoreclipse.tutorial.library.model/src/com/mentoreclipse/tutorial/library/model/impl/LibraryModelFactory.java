package com.mentoreclipse.tutorial.library.model.impl;

/**
 * Factory for generating model elements.
 *  
 * @author nbhusare
 */
public class LibraryModelFactory {

	private Library library;
	
	/**
	 * Creates a new instance of the <code>ModelFactory</code> class and
	 * initializes the <code>Library</code> model element.
	 */
	public LibraryModelFactory() {
		initializeLibrary();    
	}

	/**
	 * Initializes the <code>Library</code> model element.
	 */
	private void initializeLibrary() {
		library = new Library();
		library.addBook(addChapters(new Book("Book 1", new Author("Author 1"))));
		library.addBook(addChapters(new Book("Book 2", new Author("Author 2"))));
		library.addBook(addChapters(new Book("Book 3", new Author("Author 3"))));
		library.addBook(addChapters(new Book("Book 4", new Author("Author 4"))));
		library.addBook(addChapters(new Book("Book 5", new Author("Author 5"))));
		library.addBook(addChapters(new Book("Book 6", new Author("Author 1"))));
		library.addBook(addChapters(new Book("Book 7", new Author("Author 2"))));
		library.addBook(addChapters(new Book("Book 8", new Author("Author 3"))));
		library.addBook(addChapters(new Book("Book 9", new Author("Author 4"))));
		library.addBook(addChapters(new Book("Book 10", new Author("Author 5"))));

	}
	
	private Book addChapters(Book book) {
		book.addChapter(new Chapter("Chapter 1"));
		book.addChapter(new Chapter("Chapter 2"));
		book.addChapter(new Chapter("Chapter n"));
		book.addChapter(new Chapter("Chapter n + 1"));
		book.addChapter(new Chapter("Chapter n + 1 + ...."));
		return book;
	}
	
	public Library getLibrary() {
		return library;
	}
}
