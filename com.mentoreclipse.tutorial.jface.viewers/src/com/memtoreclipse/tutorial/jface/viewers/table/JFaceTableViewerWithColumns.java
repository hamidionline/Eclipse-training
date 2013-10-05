/**
 * 
 */
package com.memtoreclipse.tutorial.jface.viewers.table;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.mentoreclipse.tutorial.library.model.impl.Book;
import com.mentoreclipse.tutorial.library.model.impl.Library;
import com.mentoreclipse.tutorial.library.model.impl.LibraryModelFactory;

/**
 * Class demonstrating the use of JFace <code>TableViewer</code> control.
 *  
 * @author nbhusare
 */
public class JFaceTableViewerWithColumns {
	
	private class LibMdlCntProvider implements IStructuredContentProvider {

		@Override
		public void dispose() {}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

		@Override
		public Object[] getElements(Object inputElement) {
			return ((Library)inputElement).getBooks().toArray();
		}
	}

	private void showTableViewer(final Shell shell) {
		TableViewer viewer = new TableViewer(shell, SWT.BORDER);
		viewer.setContentProvider(new LibMdlCntProvider());
		
		// Column for Book Name.
		TableViewerColumn column = new TableViewerColumn(viewer, SWT.None);
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((Book)element).getName();
			}
		});
		column.getColumn().setWidth(200);
		column.getColumn().setText("Book Name");
		
		// Column for Author Name.
		column = new TableViewerColumn(viewer, SWT.None);
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((Book)element).getAuthor().getName();
			}
		});
		column.getColumn().setWidth(200);
		column.getColumn().setText("Author Name");
		
		// Column for Chapters.
		column = new TableViewerColumn(viewer, SWT.None);
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((Book)element).getChapterNames();
			}
		});
		column.getColumn().setWidth(200);
		column.getColumn().setText("Chapters");
		
		viewer.setInput(new LibraryModelFactory().getLibrary());
		
		// Setting the flag for making the "Lines" and the "Header" of the table visible.
		viewer.getTable().setLinesVisible(true);
		viewer.getTable().setHeaderVisible(true);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		new JFaceTableViewerWithColumns().showTableViewer(shell);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		
		display.dispose();
	}
}
