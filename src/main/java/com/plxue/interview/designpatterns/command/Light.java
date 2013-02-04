/**
 * 
 */
package com.plxue.interview.designpatterns.command;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

/**
 * @author libin
 *
 */
public class Light {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	public void on() {
		if (LOG.isDebugEnabled())
			LOG.debug("light is on!");
	}
	
	public void off() {
		if (LOG.isDebugEnabled())
			LOG.debug("light is off!");
	}
}
