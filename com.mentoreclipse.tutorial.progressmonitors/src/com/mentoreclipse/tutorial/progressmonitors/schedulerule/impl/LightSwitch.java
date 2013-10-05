package com.mentoreclipse.tutorial.progressmonitors.schedulerule.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;

/**
 * 
 * @author nbhusare
 */
public class LightSwitch {

	private boolean isOn = false;
	
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
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			System.out.println("Turning On the Light");
			isOn = true;
			return null;
		}
	}
	
	/**
	 * Class to turn off the Light. 
	 * @author nbhusare
	 */
	class LightOff extends Job {

		public LightOff() {
			super("Turning Off the Light");
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			System.out.println("Turning Off the Light");
			isOn = false;
			return null;
		}
	}

	public static void main(String[] args) {
		LightSwitch lightSwitch = new LightSwitch();
		lightSwitch.on();
		lightSwitch.off();
	}
}
