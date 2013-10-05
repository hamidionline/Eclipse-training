/**
 * 
 */
package com.memtoreclipse.tutorial.jface.viewers.table;

import org.eclipse.jface.viewers.ColumnLabelProvider;

import com.mentoreclipse.tutorial.library.model.impl.Book;
import com.mentoreclipse.tutorial.library.model.impl.Chapter;

/**
 * @author nbhusare
 *
 */
public class ChapterNameLabelProvider extends ColumnLabelProvider {

	@Override
	public String getText(Object element) {
		Chapter chapter = ((Book)element).getChapters().get(0);
		return chapter.getTitle(); 
	}

	
}
