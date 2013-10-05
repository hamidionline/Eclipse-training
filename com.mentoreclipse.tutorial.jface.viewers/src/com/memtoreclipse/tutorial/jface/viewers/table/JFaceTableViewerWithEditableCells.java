/**
 * 
 */
package com.memtoreclipse.tutorial.jface.viewers.table;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;

import com.mentoreclipse.tutorial.library.model.impl.Book;
import com.mentoreclipse.tutorial.library.model.impl.Library;
import com.mentoreclipse.tutorial.library.model.impl.LibraryModelFactory;

/**
 * Class demonstrating the use of JFace <code>TableViewer</code> control.
 *  
 * @author nbhusare
 */
public class JFaceTableViewerWithEditableCells {
	
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

	private class BookNameModifier implements ICellModifier {

		private TableViewer viewer;

		public BookNameModifier(final TableViewer viewer) {
			this.viewer = viewer;
		}
		
		@Override
		public boolean canModify(Object element, String property) {
			return true;
		}

		@Override
		public Object getValue(Object element, String property) {
			return ((Book)element).getName();
		}

		@Override
		public void modify(Object element, String property, Object value) {
			TableItem item = (TableItem) element;
			((Book)item.getData()).setName(value.toString());
			viewer.update(item.getData(), null);
		}
	}
	
	private void showTableViewer(final Shell shell) {
		TableViewer viewer = new TableViewer(shell, SWT.BORDER|SWT.FULL_SELECTION);
		viewer.setContentProvider(new LibMdlCntProvider());
		viewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((Book)element).getName();
			}
		});

		// Enable modification of cells.
		viewer.setCellModifier(new BookNameModifier(viewer));
		viewer.setColumnProperties(new String[] {"Column 1"});
		viewer.setCellEditors(new CellEditor[] {new TextCellEditor(viewer.getTable())});
		
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
		new JFaceTableViewerWithEditableCells().showTableViewer(shell);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		
		display.dispose();
	}
}
