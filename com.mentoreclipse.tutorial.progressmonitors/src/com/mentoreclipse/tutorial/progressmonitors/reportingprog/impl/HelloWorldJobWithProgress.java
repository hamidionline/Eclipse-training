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
public class HelloWorldJobWithProgress extends Job {

	public HelloWorldJobWithProgress(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		int totalWorkUnits = 500;
		// Naming the task in the progress view and establishing the total
		// amount of work to be done so that the view can compute progress. 
		monitor.beginTask(getName(), totalWorkUnits);
		try {
			for (int i = 0; i < 500; i++) {
				if (monitor.isCanceled()) return Status.CANCEL_STATUS;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					return Status.CANCEL_STATUS;	
				}

				// The progress view will calculate and display a percent
				// completion based on the amount of work reported in the worked
				// calls. 
				monitor.worked(1);
			} 
		} finally {
			monitor.done();
		}
		return Status.OK_STATUS;
	}

}
