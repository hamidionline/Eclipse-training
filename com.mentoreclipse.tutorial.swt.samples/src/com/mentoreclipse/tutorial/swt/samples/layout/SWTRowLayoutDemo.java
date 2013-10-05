package com.mentoreclipse.tutorial.swt.samples.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SWTRowLayoutDemo {
	
	/**
	 * Apply <code>RowLayout</code> to the <code>Shell</code>.
	 * 
	 * @param shell the instance of <code>Shell</code>.
	 */
	private void applyRowLayout(final Shell shell) {
		RowLayout layout = new RowLayout();
		
		layout.type = SWT.VERTICAL;
		layout.spacing = 10;
		layout.marginLeft = 10;
		layout.marginRight = 10;
		layout.marginTop = 10;
		layout.marginBottom = 10;
		layout.marginBottom = 10;
		
		layout.wrap = false; // TODO : Show with true/false values.
		layout.pack = false;

		shell.setLayout(layout);

		Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("Button 1 daskdasdakn");

		Button button2 = new Button(shell, SWT.TOGGLE);
		button2.setText("Button 2");

		Button button3 = new Button(shell, SWT.PUSH | SWT.BORDER);
		button3.setText("Button 3");
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);

		new SWTRowLayoutDemo().applyRowLayout(shell);
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
