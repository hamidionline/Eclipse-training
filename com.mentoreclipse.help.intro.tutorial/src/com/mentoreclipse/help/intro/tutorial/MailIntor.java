/**
 * 
 */
package com.mentoreclipse.help.intro.tutorial;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.IntroPart;

/**
 * @author nbhusare
 *
 */
public class MailIntor extends IntroPart {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.intro.IIntroPart#standbyStateChanged(boolean)
	 */
	@Override
	public void standbyStateChanged(boolean standby) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.IntroPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, true));
		
		Label label = new Label(parent, SWT.WRAP);
		label.setText("Welcome to my Mail.");
		
		GridDataFactory.fillDefaults().align(GridData.CENTER, GridData.CENTER).grab(true, true).applyTo(label);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.IntroPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
