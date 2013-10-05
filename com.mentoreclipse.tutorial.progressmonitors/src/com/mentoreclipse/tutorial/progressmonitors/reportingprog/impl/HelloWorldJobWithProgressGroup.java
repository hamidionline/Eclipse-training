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
public class HelloWorldJobWithProgressGroup extends Job {

	public HelloWorldJobWithProgressGroup(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		int totalWorkUnits = 250;
		monitor.beginTask(getName(), totalWorkUnits);
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
