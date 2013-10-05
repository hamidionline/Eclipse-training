/**
 * 
 */
package com.mentoreclipse.commands.investigation.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Default Handler to be executed if no handler associated with this command is
 * active.
 * 
 * @see org.eclipse.core.commands.AbstractHandler
 * @see org.eclipse.core.commands.IHandler
 * @author nbhusare
 * 
 */
public class TestDefaultHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.
	 * ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		MessageDialog.openInformation(HandlerUtil.getActiveShell(event),
				"Default Dialog", "Default Dialog Text");
		return null;
	}

}
