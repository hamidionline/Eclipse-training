package com.mentoreclipse.tutorial.swt.samples.events;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Class representing the structure of a SWT Application. 
 * 
 * @author mentoreclipse
 */
public class SWTWidgetsWithEventsDemo {
	
	private Text nameText;

	/**
	 * Adds SWT Widgets to the <code>Shell</code> instance and hooking listeners
	 * to the same.
	 * 
	 * @param shell  the instance of the <code>Shell</code>.
	 */
	private void addListenersToWidgets(final Shell shell) {
		shell.setLayout(new GridLayout(2, false));
		
		Label nameLabel = new Label(shell, SWT.WRAP); 
		nameLabel.setText("Emp. Name: ");
		
		nameText = new Text(shell, SWT.BORDER);
		
		GridData nameData = new GridData(300, SWT.DEFAULT);
		nameText.setLayoutData(nameData);
		
		/*
		 * Creating a Button widget and adding a SelectionListener to the same.
		 */
		Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("Button1 with Selection Listener");
		
		
		button1.addSelectionListener(new ButtonSelectionListener());
		
		/*
		 * Creating a Button widget and adding a FocusListener to the same.
		 */
		Button button2 = new Button(shell, SWT.PUSH);
		button2.setText("Button2 with Focus Listener");
		button2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println(" Focus Lost. Focus Listener Activated for Button2.");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println(" Focus Gained. Focus Listener Activated for Button2.");
			}
		});
		
		
		/*
		 * Creating a Text widget and adding a SelectionListener to the same.
		 */
		final Text text = new Text(shell, SWT.BORDER);
		text.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				System.out.println(text.getText());
			}
		});
	}
	
	/**
	 * Creates a new instance of <code>Shell</code> and opens it.
	 */
	public void createAndOpenShell() {
		/* Create a connection between SWT and the Operating system */
		Display display = new Display();
		
		/* Creating a Window that can be maximized, minimized, closed and opened */
		final Shell shell = new Shell(display);
		
		addListenersToWidgets(shell);
		
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
		new SWTWidgetsWithEventsDemo().createAndOpenShell();
	}
}
