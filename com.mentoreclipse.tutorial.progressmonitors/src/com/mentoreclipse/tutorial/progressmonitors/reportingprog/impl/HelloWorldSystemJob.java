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
public class HelloWorldSystemJob extends Job {

	public HelloWorldSystemJob(String name) {
		super(name);
		/*
		 * Initializing the job as a System job. A system job is just like any
		 * other job, except the corresponding UI support will not set up a
		 * progress view or show any other UI affordances associated with
		 * running a job. If your job is not either directly initiated by a
		 * user, or a periodic task that can be configured by a user, then your
		 * job should be a system job.
		 */
		setSystem(true);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		int unitsOfWork = 500;
		
		monitor.beginTask("Starting Hello World System Job", unitsOfWork);
		
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
