package com.mentoreclipse.tutorial.library.model.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Model element representing a Book in the Library.
 *  
 * @author nbhusare
 */
public class Book {
	
	private String name;
	
	private Author author;

	private List<Chapter> chapters = new ArrayList<Chapter>();
	
	public Book(String name, Author author) {
		this.name = name;
		this.author = author;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}
	
	public boolean addChapter(Chapter chapter) {
		return chapters.add(chapter);
	}
	
	public String getChapterNames() {
		StringBuffer buffer = new StringBuffer();
		Iterator<Chapter> iterator = chapters.iterator();
		while (iterator.hasNext()) {
			buffer.append(((Chapter)iterator.next()).getTitle());
			buffer.append(", ");
			
		}
		return buffer.toString();
	}
	
}
