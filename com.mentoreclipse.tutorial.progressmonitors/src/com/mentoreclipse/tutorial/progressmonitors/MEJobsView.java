/**
 * 
 */
package com.mentoreclipse.tutorial.progressmonitors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import com.mentoreclipse.tutorial.progressmonitors.jobschedule.impl.HelloWorldJobWithRescheduling;
import com.mentoreclipse.tutorial.progressmonitors.jobschedule.impl.HelloWorldJobWithSchedulingPriorities;
import com.mentoreclipse.tutorial.progressmonitors.reportingprog.impl.HelloWorldJob;
import com.mentoreclipse.tutorial.progressmonitors.reportingprog.impl.HelloWorldJobWithCustomStatus;
import com.mentoreclipse.tutorial.progressmonitors.reportingprog.impl.HelloWorldJobWithCustomStatus.Employee;
import com.mentoreclipse.tutorial.progressmonitors.reportingprog.impl.HelloWorldJobWithProgress;
import com.mentoreclipse.tutorial.progressmonitors.reportingprog.impl.HelloWorldJobWithProgressGroup;
import com.mentoreclipse.tutorial.progressmonitors.reportingprog.impl.HelloWorldJobWithProgressSubtask;
import com.mentoreclipse.tutorial.progressmonitors.reportingprog.impl.HelloWorldSystemJob;
import com.mentoreclipse.tutorial.progressmonitors.reportingprog.impl.HelloWorldUserJob;
import com.mentoreclipse.tutorial.progressmonitors.status.impl.CustomSuccessStatus;

/**
 * @author nbhusare
 *
 */
public class MEJobsView extends ViewPart {

	/**
	 * 
	 */
	public MEJobsView() {}
	
	/**
	 * 
	 * @param parent
	 */
	private void initJob(final Composite parent) {
		new Label(parent, SWT.NONE).setText("Simple Job :");
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Start Job");
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Starting the Job");
				Job helloworldJob = new HelloWorldJob("Hello World Job");
				helloworldJob.schedule();
				System.out.println("Code to run after the Job#schedule is called");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}
	
	/**
	 * 
	 * @param parent
	 */
	private void initJobWithCustomResult(Composite parent) {
		new Label(parent, SWT.NONE).setText("Job With Custom Result :");
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Start Job");
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				HelloWorldJobWithCustomStatus helloworldJob = new HelloWorldJobWithCustomStatus("Hello World Job");
				helloworldJob.schedule();
				if (helloworldJob.getResult().isOK()) {
					Employee employee = (Employee) ((CustomSuccessStatus) helloworldJob
							.getResult()).getYourObject();
					System.out.println("Employee name: " + employee.getName());
				} else  {
					System.out.println("Job executed \"With\" errors");
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}
	
	/**
	 * 
	 * @param parent
	 */
	private void initJobWithJoin(Composite parent) {
		new Label(parent, SWT.NONE).setText("Job with #join():");
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Start Job");
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Starting the Job");
				Job helloworldJob = new HelloWorldJob("Hello World Job");
				helloworldJob.schedule();
				try {
					helloworldJob.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("Code to run after the Job#schedule is called");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}
	
	/**
	 * 
	 * @param parent
	 */
	private void initJobWithChangeListener(Composite parent) {
		new Label(parent, SWT.NONE).setText("Job with Change Listener:");
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Start Job");
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Job helloworldJob = new HelloWorldJob("Hello World Job");
				helloworldJob.addJobChangeListener(new JobChangeListener());
				helloworldJob.schedule();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}
	

	/**
	 * 
	 * @param parent
	 */
	private void initJobWithProgress(Composite parent) {
		new Label(parent, SWT.NONE).setText("Job with Progress:");
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Start Job");
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Job helloworldJob = new HelloWorldJobWithProgress("Hello World job with Progress");
				helloworldJob.schedule();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}

	/**
	 * 
	 * @param parent
	 */
	private void initJobWithProgressGroup(Composite parent) {
		new Label(parent, SWT.NONE).setText("Job with Progress Group:");
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Start Job");
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				IJobManager jobManager = Job.getJobManager();
				IProgressMonitor progressGroup = jobManager.createProgressGroup();
				
				progressGroup.beginTask("Plug-in integration in progress", 750);
				
				Job helloworldJob1 = new HelloWorldJobWithProgressGroup("Installing plug-ins in Eclipse");
				helloworldJob1.setProgressGroup(progressGroup, 250);
				
				Job helloworldJob2 = new HelloWorldJobWithProgressGroup("Discovering the Plug-ins ");
				helloworldJob2.setProgressGroup(progressGroup, 250);
				
				Job helloworldJob3 = new HelloWorldJobWithProgressGroup("Integrating the Plug-ins");
				helloworldJob3.setProgressGroup(progressGroup, 250);
				
				helloworldJob1.schedule();
				helloworldJob2.schedule();
				helloworldJob3.schedule();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}

	
	/**
	 * 
	 * @param parent
	 */
	private void initJobWithProgessSubtask(Composite parent) {
		new Label(parent, SWT.NONE).setText("Job with Progress Subtask:");
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Start Job");
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Job helloworldJob = new HelloWorldJobWithProgressSubtask("Hello World Job with progress Subtask");
				helloworldJob.schedule();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}

	/**
	 * 
	 * @param parent
	 */
	private void initSystemJob(Composite parent) {
		new Label(parent, SWT.NONE).setText("System Job:");
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Start Job");
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Job helloworldJob = new HelloWorldSystemJob("Hello World System Job"); 
				helloworldJob.schedule();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}

	/**
	 * 
	 * @param parent
	 */
	private void initUserJob(Composite parent) {
		new Label(parent, SWT.NONE).setText("User Job:");
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Start Job");
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Job helloworldJob = new HelloWorldUserJob("Hello World User Job"); 
				helloworldJob.schedule();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}

	/**
	 * 
	 * @param parent
	 */
	private void initJobWithSchedulingPriorities(Composite parent) {
		new Label(parent, SWT.NONE).setText("Job with Scheding Priorities:");
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Start Job");
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Job installationJob = new HelloWorldJobWithSchedulingPriorities("Installing plug-ins in Eclipse", 1500);
				Job discoveryJob = new HelloWorldJobWithSchedulingPriorities("Discovering the Plug-ins ", 1800);
				Job integrationJob = new HelloWorldJobWithSchedulingPriorities("Integrating the Plug-ins", 2500);
				
				// Setting the priorities for the Jobs.
				installationJob.setPriority(Job.INTERACTIVE);
				discoveryJob.setPriority(Job.BUILD);
				integrationJob.setPriority(Job.DECORATE);
				
				//Scheduling the jobs
				installationJob.schedule();
				discoveryJob.schedule();
				integrationJob.schedule();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}

	/**
	 * 
	 * @param parent
	 */
	private void initJobWithDelay(Composite parent) {
		new Label(parent, SWT.NONE).setText("Job with Scheding Delays:");
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Start Job");
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Job installationJob = new HelloWorldJobWithSchedulingPriorities("Installing plug-ins in Eclipse", 1500);
				Job discoveryJob = new HelloWorldJobWithSchedulingPriorities("Discovering the Plug-ins ", 1800);
				Job integrationJob = new HelloWorldJobWithSchedulingPriorities("Integrating the Plug-ins", 2500);
				
				//Scheduling the jobs
				installationJob.schedule(0);
				discoveryJob.schedule(1000);
				integrationJob.schedule(1500);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}

	/**
	 * 
	 * @param parent
	 */
	private void initJobWithResheduling(Composite parent) {
		new Label(parent, SWT.NONE).setText("Job with Resheduling:");
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Start Job");
		button.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Job installationJob = new HelloWorldJobWithRescheduling("Installing plug-ins in Eclipse");
				installationJob.schedule();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}

	
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite root) {
		final Composite parent = new Composite(root, SWT.NONE);
		parent.setLayout(new GridLayout(2, true));
		
		// Initialize simple job.
		initJob(parent);
		
		// Initialize job with #join().
		initJobWithJoin(parent);
		
		// Initialize job with custom result status.
		initJobWithCustomResult(parent);
		
		// Initialize job with Change listener.
		initJobWithChangeListener(parent);
		
		// Initialize job with Progress.
		initJobWithProgress(parent);
		
		// Initialize job with Progress subtask.
		initJobWithProgessSubtask(parent);
		
		// Initialize Job with Progress Group
		initJobWithProgressGroup(parent);
		
		// Initialize System job.
		initSystemJob(parent);
		
		// Initialize User job.
		initUserJob(parent);
		
		// Initialize Job with Scheduling priorities.
		initJobWithSchedulingPriorities(parent);
		
		// Initialize Job with Scheduling delays.
		initJobWithDelay(parent);
		
		// Initialize Job with rescheduling.
		initJobWithResheduling(parent);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {}
}
