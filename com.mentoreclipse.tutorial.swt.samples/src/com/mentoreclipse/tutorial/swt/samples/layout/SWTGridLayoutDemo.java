package com.mentoreclipse.tutorial.swt.samples.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SWTGridLayoutDemo {
	
	/**
	 * Apply <code>GridLayout</code> to the <code>Shell</code>.
	 * 
	 * @param shell the instance of <code>Shell</code>.
	 */
	private void applyRowLayout(final Shell shell) {
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		gridLayout.makeColumnsEqualWidth = true;
		
		gridLayout.marginLeft = 10;
		gridLayout.marginRight = 10;
		gridLayout.marginTop = 10;
		gridLayout.marginBottom = 10;

		gridLayout.horizontalSpacing = 50;
		gridLayout.verticalSpacing = 50;

		shell.setLayout(gridLayout);

		Button button1 = new Button(shell, SWT.BORDER | SWT.CENTER);
		button1.setText("Button 1");
		
		Button button2 = new Button(shell, SWT.BORDER | SWT.CENTER);
		button2.setText("Button 2");
		
		Button button3 = new Button(shell, SWT.BORDER | SWT.CENTER);
		button3.setText("Button 3");
		
		Button button4 = new Button(shell, SWT.BORDER | SWT.CENTER);
		button4.setText("Button 4");
		
		Button button5 = new Button(shell, SWT.BORDER | SWT.CENTER);
		button5.setText("Button 5");
		
		Button button6 = new Button(shell, SWT.BORDER | SWT.CENTER);
		button6.setText("Button 6");
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		
		new SWTGridLayoutDemo().applyRowLayout(shell);
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
