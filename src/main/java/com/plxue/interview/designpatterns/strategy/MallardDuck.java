package com.plxue.interview.designpatterns.strategy;

public class MallardDuck extends Duck {

	public MallardDuck() {
		this.quackBehavior = new Quack();
		this.flyBehavior = new FlyWithWings();
	}

	@Override
	public void display() {
		System.out.println("I'm really a mallar duck!");
	}

}
