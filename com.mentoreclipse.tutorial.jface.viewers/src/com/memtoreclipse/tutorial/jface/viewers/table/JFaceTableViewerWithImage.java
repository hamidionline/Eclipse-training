/**
 * 
 */
package com.memtoreclipse.tutorial.jface.viewers.table;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.memtoreclipse.tutorial.jface.viewers.Activator;
import com.mentoreclipse.tutorial.library.model.impl.Book;
import com.mentoreclipse.tutorial.library.model.impl.Library;
import com.mentoreclipse.tutorial.library.model.impl.LibraryModelFactory;

/**
 * Class demonstrating the use of JFace <code>TableViewer</code> control.
 *  
 * @author nbhusare
 */
public class JFaceTableViewerWithImage {
	
	/**
	 * Library Model content provider.
	 *  
	 * @author nbhusare
	 */
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
	
	/**
	 * Library model label Provider providing the Column text and also the
	 * Column Image.
	 * 
	 * @author nbhusare
	 */
	private class LibMdlLblProvider extends LabelProvider implements ITableLabelProvider {
		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return ImageDescriptor.createFromFile(Activator.class,
					"icons/treeitem.gif").createImage();
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			return ((Book)element).getName();
		}
	}
	
	/**
	 * Creates a <code>TableViewer</code> and places it on the passed
	 * <code>Shell</code>.
	 * 
	 * @param shell
	 *            the window that will contain the <code>TableViewer</code>.
	 */
	private void showTableViewer(final Shell shell) {
		TableViewer viewer = new TableViewer(shell, SWT.BORDER);
		viewer.setContentProvider(new LibMdlCntProvider());
		viewer.setLabelProvider(new LibMdlLblProvider());

		viewer.setInput(new LibraryModelFactory().getLibrary());
		
		// Setting the flag for making the "Lines" and the "Header" of the table visible.
		viewer.getTable().setLinesVisible(true);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		new JFaceTableViewerWithImage().showTableViewer(shell);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		
		display.dispose();
	}
}
