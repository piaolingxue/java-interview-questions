/**
 * 
 */
package com.plxue.interview.designpatterns.decoractor;

/**
 * @author libin
 *
 */
public abstract class Beverage {
	protected String description;
	
	public String getDescription() {
		return this.description;
	}
	
	public abstract double cost();
}
