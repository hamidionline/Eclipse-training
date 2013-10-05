/**
 * 
 */
package com.memtoreclipse.tutorial.jface.viewers.table;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
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
public class JFaceTableViewer {
	
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
		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER);
		tableViewer.setContentProvider(new LibMdlCntProvider());
		tableViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((Book)element).getName();
			}
		});
		
		
		tableViewer.setInput(new LibraryModelFactory().getLibrary());
		
		// Setting the flag for making the "Lines" and the "Header" of the table visible.
		tableViewer.getTable().setLinesVisible(true);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		new JFaceTableViewer().showTableViewer(shell);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		
		display.dispose();
	}
}
