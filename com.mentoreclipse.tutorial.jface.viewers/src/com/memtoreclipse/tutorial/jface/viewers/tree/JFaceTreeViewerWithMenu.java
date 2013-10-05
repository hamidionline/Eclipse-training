package com.memtoreclipse.tutorial.jface.viewers.tree;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
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
public class JFaceTreeViewerWithMenu {

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
			if (parentElement instanceof Book) {
				return ((Book)parentElement).getChapters().toArray();
			}
			return null;
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return ((element instanceof Library) || element instanceof Book);
		}
	}

	private void showTreeViewer(final Shell shell) {
		final TreeViewer viewer = new TreeViewer(shell);
		viewer.setContentProvider(new LibMdlCntProvider());
		viewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Book) {
					return ((Book)element).getName();
				} else if (element instanceof Chapter) {
					return ((Chapter)element).getTitle();
				}
				return null;
			}
		});
		viewer.setInput(new LibraryModelFactory().getLibrary());
		
		//Action to be executed.
		final Action action = new Action("") {
		};
		
		// Add a menu to the viewer
		MenuManager menuManager = new MenuManager();
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(new IMenuListener() {
			
			@Override
			public void menuAboutToShow(IMenuManager manager) {
				IStructuredSelection selection = (IStructuredSelection) viewer
						.getSelection();
				if (!selection.isEmpty()) {
					Object object = selection.getFirstElement();
					if (object instanceof Book) {
						MessageDialog.openInformation(viewer.getTree().getShell(), "This is a book selected", "Book " + ((Book)object).getName() + "is selected");
					} else {
						action.setText("Edit Chapter - " + ((Chapter)object).getTitle());
					}
					manager.add(action);
				}
			}
		});
		
		viewer.getControl().setMenu(menuManager.createContextMenu(viewer.getControl()));
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		new JFaceTreeViewerWithMenu().showTreeViewer(shell);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
	}
}
