/**
 * 
 */
package com.plxue.interview.designpatterns.strategy;

/**
 * @author libin
 *
 */
public class ModelDuck extends Duck {
	
	public ModelDuck() {
		this.quackBehavior = new Quack();
		this.flyBehavior = new FlyNoWay();
	}

	/* (non-Javadoc)
	 * @see com.plxue.interview.designpatterns.strategy.Duck#display()
	 */
	@Override
	public void display() {
		System.out.println("I'm a model duck!");
	}

}
