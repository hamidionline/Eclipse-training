/**
 * 
 */
package com.mentoreclipse.tutorial.progressmonitors.schedulerule.impl;

import org.eclipse.core.runtime.jobs.ISchedulingRule;

/**
 * @author nbhusare
 *
 */
public class LightSwitchRule implements ISchedulingRule {

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.ISchedulingRule#contains(org.eclipse.core.runtime.jobs.ISchedulingRule)
	 */
	@Override
	public boolean contains(ISchedulingRule rule) {
		return isConflicting(rule);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.ISchedulingRule#isConflicting(org.eclipse.core.runtime.jobs.ISchedulingRule)
	 */
	@Override
	public boolean isConflicting(ISchedulingRule rule) {
		return rule == this;
	}
}
