package com.memtoreclipse.tutorial.jface.viewers.tree;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.mentoreclipse.tutorial.library.model.impl.Book;
import com.mentoreclipse.tutorial.library.model.impl.Chapter;
import com.mentoreclipse.tutorial.library.model.impl.Library;
import com.mentoreclipse.tutorial.library.model.impl.LibraryModelFactory;

/**
 * 
 * @author nbhusare
 *
 */
public class JFaceTreeViewerWithChildren {

	private class LibMdlCntProvider implements ITreeContentProvider {

		@Override
		public void dispose() {}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Library) return ((Library)inputElement).getBooks().toArray();
			return null;
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			return ((Book)parentElement).getChapters().toArray();
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return (element instanceof Library || element instanceof Book);
		}
	}

	class LibraryLabelProvider extends LabelProvider {
		
		@Override
		public String getText(Object element) {
			if (element instanceof Book) {
				return ((Book)element).getName();
			} else if (element instanceof Chapter) {
				return ((Chapter)element).getTitle();
			}
			return null;
		}
	}
	
	private void showTreeViewer(final Shell shell) {
		TreeViewer viewer = new TreeViewer(shell);
		viewer.setContentProvider(new LibMdlCntProvider());
		viewer.setLabelProvider(new LibraryLabelProvider());
		viewer.setInput(new LibraryModelFactory().getLibrary());
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		new JFaceTreeViewerWithChildren().showTreeViewer(shell);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
	}
}
