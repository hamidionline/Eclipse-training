package com.mentoreclipse.tutorial.swt.samples.layout.data;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SWTRowLayoutWithDataDemo {
	
	/**
	 * Apply <code>RowLayout</code> to the <code>Shell</code>.
	 * 
	 * @param shell the instance of <code>Shell</code>.
	 */
	private void applyRowLayout(final Shell shell) {
		RowLayout layout = new RowLayout();
		layout.type = SWT.HORIZONTAL;
		layout.spacing = 50;
		
		layout.marginLeft = 10;
		layout.marginRight = 10;
		layout.marginTop = 10;
		layout.marginBottom = 10;
		
		layout.wrap = false; // TODO : Show with true/false values.
		layout.pack = true;

		shell.setLayout(layout);

		Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("Button 1");

		RowData rowData = new RowData();
		rowData.height = 200;
		rowData.width = 200;
		button1.setLayoutData(rowData);

		Button button2 = new Button(shell, SWT.PUSH);
		button2.setText("Button 2");

		RowData rowData2 = new RowData();
		rowData2.height = 100;
		rowData2.width = 100;
		button2.setLayoutData(rowData2);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);

		new SWTRowLayoutWithDataDemo().applyRowLayout(shell);
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
