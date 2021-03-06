/**
 * 
 */
package com.mentoreclipse.tutorial.jface.viewer;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.mentoreclipse.tutorial.jface.model.Book;
import com.mentoreclipse.tutorial.jface.model.Library;
import com.mentoreclipse.tutorial.jface.model.LibraryFactory;

/**
 * @author nbhusare
 *
 */
public class JfaceListeViewer {

	
	class BookContentProvider implements IStructuredContentProvider {

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object[] getElements(Object inputElement) {
			Library library = (Library) inputElement;
			return library.getBooks().toArray();
		}
	}

	class BookNameLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {
			Book book = (Book) element;
			return book.getName();
		}
	}
	
	private void createAndShowViewer(final Shell shell) {
		ListViewer bookViewer = new ListViewer(shell);
		bookViewer.setContentProvider(new BookContentProvider());
		bookViewer.setLabelProvider(new BookNameLabelProvider());
		bookViewer.setInput(new LibraryFactory().getLibrary());
	}
	
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		new JfaceListeViewer().createAndShowViewer(shell);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}
	
}
