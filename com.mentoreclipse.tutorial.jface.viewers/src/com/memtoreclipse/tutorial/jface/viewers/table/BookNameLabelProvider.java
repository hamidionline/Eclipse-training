/**
 * 
 */
package com.memtoreclipse.tutorial.jface.viewers.table;

import org.eclipse.jface.viewers.ColumnLabelProvider;

import com.mentoreclipse.tutorial.library.model.impl.Book;

/**
 * @author nbhusare
 *
 */
public class BookNameLabelProvider extends ColumnLabelProvider   {

	@Override
	public String getText(Object element) {
		return ((Book)element).getName();
	}
	
}
