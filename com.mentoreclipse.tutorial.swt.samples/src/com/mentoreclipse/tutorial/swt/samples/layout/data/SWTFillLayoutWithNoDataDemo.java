package com.mentoreclipse.tutorial.swt.samples.layout.data;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SWTFillLayoutWithNoDataDemo {
	
	/**
	 * Apply <code>FillLayout</code> to the <code>Shell</code>.
	 * 
	 * @param shell the instance of <code>Shell</code>.
	 */
	private void applyFillLayout(final Shell shell) {
		final FillLayout fillLayout = new FillLayout();
		fillLayout.type = SWT.HORIZONTAL;
		fillLayout.marginHeight = 10;
		fillLayout.marginWidth = 10;
		fillLayout.spacing = 10;
		
		shell.setLayout(fillLayout);
		
		Button button = new Button(shell, SWT.PUSH);
		button.setText("Button 1");
		
		Button button2 = new Button(shell, SWT.PUSH);
		button2.setText("Button 2");

		Button button3 = new Button(shell, SWT.PUSH);
		button3.setText("Button 3");
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		
		new SWTFillLayoutWithNoDataDemo().applyFillLayout(shell);
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
