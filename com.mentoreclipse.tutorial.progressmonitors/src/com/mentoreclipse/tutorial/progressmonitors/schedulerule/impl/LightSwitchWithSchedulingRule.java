package com.mentoreclipse.tutorial.progressmonitors.schedulerule.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

/**
 * 
 * @author nbhusare
 */
public class LightSwitchWithSchedulingRule {

	private boolean isOn = false;

	private final LightSwitchRule switchSchedulingRule = new LightSwitchRule();
	
	public boolean isOn() {
		return isOn;
	}

	public void on() {
		new LightOn().schedule();
	}
	
	public void off() {
		new LightOff().schedule();
	}
	
	/**
	 * Class to turn on the Light. 
	 * @author nbhusare
	 */
	class LightOn extends Job {

		public LightOn() {
			super("Turning on the Light");
			setRule(switchSchedulingRule);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			System.out.println("Turning On the Light");
			isOn = true;
			return Status.OK_STATUS;
		}
	}
	
	/**
	 * Class to turn off the Light. 
	 * @author nbhusare
	 */
	class LightOff extends Job {

		public LightOff() {
			super("Turning Off the Light");
			setRule(switchSchedulingRule);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			System.out.println("Turning Off the Light");
			isOn = false;
			return Status.OK_STATUS;
		}
	}

	public static void main(String[] args) {
		LightSwitchWithSchedulingRule lightSwitch = new LightSwitchWithSchedulingRule();
		lightSwitch.on();
		lightSwitch.off();
	}
}
