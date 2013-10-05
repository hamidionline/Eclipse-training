/**
 * 
 */
package com.memtoreclipse.tutorial.jface.viewers.list;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.mentoreclipse.tutorial.library.model.impl.Book;
import com.mentoreclipse.tutorial.library.model.impl.Library;
import com.mentoreclipse.tutorial.library.model.impl.LibraryModelFactory;

/**
 * Class representing the use of JFace <code>ListViewer</code> control.
 * 
 * @author nbhusare
 */
public class JFaceListViewerDemo {

	private class LibMdlCntProvider implements IStructuredContentProvider {

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public Object[] getElements(Object inputElement) {
			Library library = (Library) inputElement;
			return library.getBooks().toArray();

		}
	}

	private class LibModelLabelProvider extends LabelProvider {
		@Override 
		public String getText(Object element) {
			Book book = (Book) element;
			return book.getName();
		}
	}
	
	/**
	 * 
	 * @param shell
	 */
	public void showListViewer(final Shell shell) {
		ListViewer viewer = new ListViewer(shell, SWT.BORDER | SWT.SINGLE);
		viewer.setContentProvider(new LibMdlCntProvider());
		viewer.setLabelProvider(new LibModelLabelProvider());
		viewer.setInput(new LibraryModelFactory().getLibrary());
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		new JFaceListViewerDemo().showListViewer(shell);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
