package com.mentoreclipse.tutorial.swt.helloworld.impl;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Class representing the structure of a SWT Application. 
 * 
 * @author mentoreclipse
 */
public class SWTApplicationStructure {
	
	/**
	 * Creates a new instance of <code>Shell</code> and opens it.
	 */
	private void createAndOpenShell() {
		/* Create a connection between SWT and the Operating system */
		Display display = new Display();
		
		/* Creating a Window that can be maximized, minimized, closed and opened */
		final Shell shell = new Shell(display);
		
		FillLayout parentLayout = new FillLayout(SWT.HORIZONTAL); 
		shell.setLayout(parentLayout);
		
		
		
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
		new SWTApplicationStructure().createAndOpenShell();
	}
}
