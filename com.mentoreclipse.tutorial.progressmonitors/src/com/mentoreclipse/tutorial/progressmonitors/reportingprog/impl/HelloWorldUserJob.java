/**
 * 
 */
package com.mentoreclipse.tutorial.progressmonitors.reportingprog.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

/**
 * @author nbhusare
 *
 */
public class HelloWorldUserJob extends Job {

	public HelloWorldUserJob(String name) {
		super(name);
		/*
		 * Initializing the job as a user job. A user job will appear in a modal
		 * progress dialog that provides a button for moving the dialog into the
		 * background. The workbench defines a user preference that controls
		 * whether these dialogs are ever modal. By defining your job as a user
		 * job, your progress feedback will automatically conform with the user
		 * preference for progress viewing.
		 */
		setUser(true);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		int unitsOfWork = 500;
		
		monitor.beginTask(getName(), unitsOfWork);
		
		try {
			for (int i = 0; i < unitsOfWork; i++) {
				if (monitor.isCanceled()) return Status.CANCEL_STATUS;
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					return Status.CANCEL_STATUS;
				}
				
				monitor.worked(1);
			}
		} finally {
			monitor.done();
		}
		return Status.OK_STATUS;
	}
}
