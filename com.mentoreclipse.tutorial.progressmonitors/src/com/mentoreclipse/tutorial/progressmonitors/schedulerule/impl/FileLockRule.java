/**
 * 
 */
package com.mentoreclipse.tutorial.progressmonitors.schedulerule.impl;

import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;

/**
 * @author nbhusare
 *
 */
public class FileLockRule implements ISchedulingRule {

	private String path;

	public FileLockRule(java.io.File file) {
		this.path = file.getAbsolutePath();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.ISchedulingRule#contains(org.eclipse.core.runtime.jobs.ISchedulingRule)
	 */
	@Override
	public boolean contains(ISchedulingRule rule) {
		if (this == rule)
            return true;
         if (rule instanceof FileLockRule)
            return ((FileLockRule)rule).path.startsWith(path);
         if (rule instanceof MultiRule) {
            MultiRule multi = (MultiRule) rule;
            ISchedulingRule[] children = multi.getChildren();
            for (int i = 0; i < children.length; i++)
               if (!contains(children[i]))
                  return false;
            return true;
         }
         return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.ISchedulingRule#isConflicting(org.eclipse.core.runtime.jobs.ISchedulingRule)
	 */
	@Override
	public boolean isConflicting(ISchedulingRule rule) {
		if (! (rule instanceof FileLockRule)) return false;
		String otherPath = ((FileLockRule)rule).path;
        return path.startsWith(otherPath) || otherPath.startsWith(path);
	}

}
