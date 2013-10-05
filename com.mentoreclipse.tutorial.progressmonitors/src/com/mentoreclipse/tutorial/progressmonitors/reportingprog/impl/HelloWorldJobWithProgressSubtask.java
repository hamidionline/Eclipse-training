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
public class HelloWorldJobWithProgressSubtask extends Job {

	public HelloWorldJobWithProgressSubtask(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		int totalWorkUnits = 500;
		monitor.beginTask(getName(), totalWorkUnits);
		try {
			
			// Sub-task 1 of the job.
			for (int i = 0; i < 250; i++) {
				if (monitor.isCanceled()) return Status.CANCEL_STATUS;
				monitor.subTask("Subtask 1");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					return Status.CANCEL_STATUS;	
				}
				monitor.worked(1);
			} 
			
			// Sub-task 2 of the job
			for (int i = 0; i < 250; i++) {
				if (monitor.isCanceled()) return Status.CANCEL_STATUS;
				monitor.subTask("Subtask 2");
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
