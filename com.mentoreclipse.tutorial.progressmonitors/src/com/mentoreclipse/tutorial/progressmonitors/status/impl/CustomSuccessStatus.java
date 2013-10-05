/**
 * 
 */
package com.mentoreclipse.tutorial.progressmonitors.status.impl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * @author nbhusare
 *
 */
public class CustomSuccessStatus extends Status {

	private final Object yourObject;
	
	public CustomSuccessStatus(IStatus status, Object yourObject) {
		super(status.getSeverity(), status.getPlugin(), status.getCode(),
				status.getMessage(), status.getException());
		this.yourObject = yourObject;
	}

	public Object getYourObject() {
		return yourObject;
	}
}
