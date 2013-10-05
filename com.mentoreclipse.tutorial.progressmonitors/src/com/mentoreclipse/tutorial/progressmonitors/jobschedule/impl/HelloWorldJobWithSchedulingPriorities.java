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
public class HelloWorldJobWithSchedulingPriorities extends Job {

	private final int totalWorkUnits;

	public HelloWorldJobWithSchedulingPriorities(String name, int totalWorkUnits) {
		super(name);
		this.totalWorkUnits = totalWorkUnits;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		monitor.beginTask(getName(), totalWorkUnits);
		try {
			for (int i = 0; i < totalWorkUnits; i++) {
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
