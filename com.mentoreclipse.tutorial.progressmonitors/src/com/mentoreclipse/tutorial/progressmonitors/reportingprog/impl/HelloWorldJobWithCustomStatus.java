/**
 * 
 */
package com.mentoreclipse.tutorial.progressmonitors.reportingprog.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import com.mentoreclipse.tutorial.progressmonitors.Activator;
import com.mentoreclipse.tutorial.progressmonitors.status.impl.CustomSuccessStatus;

/**
 * @author nbhusare
 *
 */
public class HelloWorldJobWithCustomStatus extends Job {

	public HelloWorldJobWithCustomStatus(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		System.out.println("Hello World Job executed");

		Employee employee = new Employee("Neeraj");
		
		CustomSuccessStatus status = new CustomSuccessStatus(
				new Status(Status.OK, Activator.PLUGIN_ID,
						Activator.STATUS_ERROR, "Upable to run the Job",
						new Throwable("Upable to run the Job")), employee);
		
		return status;
	}
	
	public class Employee {
		
		private String name;

		public Employee(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}
