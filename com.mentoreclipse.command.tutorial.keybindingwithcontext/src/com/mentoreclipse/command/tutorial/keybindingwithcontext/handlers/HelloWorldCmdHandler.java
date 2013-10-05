/**
 * 
 */
package com.mentoreclipse.command.tutorial.keybindingwithcontext.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author nbhusare
 *
 */
public class HelloWorldCmdHandler extends AbstractHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		MessageDialog.openInformation(HandlerUtil.getActiveShell(event),
				"Hello World", "Hello World to all...");
		return null;
	}

}
