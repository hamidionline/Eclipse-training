/**
 * 
 */
package com.mentoreclipse.commands.investigation.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IParameter;
import org.eclipse.core.commands.IParameterValues;
import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.internal.registry.ViewParameterValues;

/**
 * @author nbhusare
 *
 */
public class TestHandler extends AbstractHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
//		IWorkbenchSite wbSite = HandlerUtil.getActiveSite(event);
//		ICommandService cmdService = (ICommandService) wbSite.getService(ICommandService.class);
//		Command showViewCommand = cmdService.getCommand("com.mentoreclipse.commands.investigation.command.test");
//		try {
//			IParameter parameter = showViewCommand.getParameter("com.mentoreclipse.commands.investigation.commandParameter1");
//			ViewParameterValues parameterValues = (ViewParameterValues) parameter.getValues();
//			parameterValues.getParameterValues();
//			System.out.println("TestHandler.execute()");
//		} catch (NotDefinedException e) {
//			e.printStackTrace();
//		} catch (ParameterValuesException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Test", "Test");
		return null;
	}

}
