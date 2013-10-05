package com.mentoreclipse.tutorial.swt.samples.basic;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Class representing the structure of a SWT Application. 
 * 
 * @author mentoreclipse
 */
public class SWTWidgetsDemo {
	
	/**
	 * Adds SWT Widgets to the <code>Shell</code> instance.
	 * @param shell the instance of the <code>Shell</code>.
	 */
	private void addSWTWidgetsToShell(final Shell shell) {
		shell.setLayout(new GridLayout(7, false));
	}
	
	/**
	 * Creates a new instance of <code>Shell</code> and opens it.
	 */
	public void createAndOpenShell() {
		/* Create a connection between SWT and the Operating system */
		Display display = new Display();
		
		/* Creating a Window that can be maximized, minimized, closed and opened */
		final Shell shell = new Shell(display);
		shell.open();
		
		/* Check if the Shell is not disposed */
		while (!shell.isDisposed()) {
			/* Check the Operating systems event queue for events */
			if (!display.readAndDispatch())
				/* Let the user-interface thread sleep as there are no events in the event queue */
				display.sleep();
		}
		
		/* Dispose the operating systems resources associated with the receiver */
		display.dispose();
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new SWTWidgetsDemo().createAndOpenShell();
	}
}
