/**
 * 
 */
package com.mentoreclipse.tutorial.progressmonitors.jobschedule.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

/**
 * @author nbhusare
 *
 */
public class HelloWorldJobWithCustomScheduling extends Job {

	public HelloWorldJobWithCustomScheduling(String name) {
		super(name);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#shouldSchedule()
	 */
	@Override
	public boolean shouldSchedule() {
		return super.shouldSchedule() && CheckSchedulePrecondition();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#shouldRun()
	 */
	@Override
	public boolean shouldRun() {
		return super.shouldRun() && checkRunPreconditions();
	}
	
	/**
	 * Check preconditions before the Job is run.
	 * @return true if the conditions are met.
	 */
	private boolean checkRunPreconditions() {
		// Your check comes here.
		return true;
	}

	/**
	 * Check preconditions before the Job is scheduled.
	 * @return true if the conditions are met.
	 */
	private boolean CheckSchedulePrecondition() {
		// Your check comes here.
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		monitor.beginTask(getName(), 250);
		try {
			for (int i = 0; i < 250; i++) {
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
