package com.mentoreclipse.tutorial.command.impl;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class HelloWorldCommand extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);

		// Your business logic comes here...

		ErrorDialog.openError(window.getShell(), "sdsad", "test Error dialog",
				new Status(IStatus.ERROR, "com.mentoreclipse.tutorial.command",
						"Your errroe message comes here"));
		return null;
	}
}
