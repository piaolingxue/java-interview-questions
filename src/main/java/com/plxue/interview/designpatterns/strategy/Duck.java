/**
 * 
 */
package com.plxue.interview.designpatterns.strategy;

/**
 * @author libin
 *
 */
public abstract class Duck {
	protected FlyBehavior flyBehavior;
	
	protected QuackBehavior quackBehavior;
	
	public abstract void display();
	
	public void performFly() {
		flyBehavior.fly();
	}
	
	public void performQuack() {
		quackBehavior.quack();
	}
	
	public void setFlyBehavior(FlyBehavior fb) {
		this.flyBehavior = fb;
	}
	
	public void setQuackBehavior(QuackBehavior qb) {
		this.quackBehavior = qb;
	}
	
	public void swim() {
		System.out.println("All Ducks swim!");
	}
}
