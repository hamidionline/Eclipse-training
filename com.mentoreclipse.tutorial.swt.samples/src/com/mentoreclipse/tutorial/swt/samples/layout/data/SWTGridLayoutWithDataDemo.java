package com.mentoreclipse.tutorial.swt.samples.layout.data;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SWTGridLayoutWithDataDemo {
	
	/**
	 * Apply <code>GridLayout</code> to the <code>Shell</code>.
	 * 
	 * @param shell the instance of <code>Shell</code>.
	 */
	private void applyRowLayout(final Shell shell) {
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = true;
		
		gridLayout.marginLeft = 10;
		gridLayout.marginRight = 10;
		gridLayout.marginTop = 10;
		gridLayout.marginBottom = 10;

		gridLayout.horizontalSpacing = 50;
		gridLayout.verticalSpacing = 50;

		shell.setLayout(gridLayout);

		/* Button 1 */
		Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("Button 1");

		GridData gridData = new GridData();
		gridData.horizontalSpan = 2;
		
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL; 
		
		gridData.horizontalIndent = 20; // Default value is 0
		
		gridData.grabExcessHorizontalSpace = false;
		gridData.grabExcessVerticalSpace = true;

		button1.setLayoutData(gridData);
		
		/* Button 2 */
		Button button2 = new Button(shell, SWT.PUSH);
		button2.setText("Button 2");
		
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(button2);
		
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		
		new SWTGridLayoutWithDataDemo().applyRowLayout(shell);
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
