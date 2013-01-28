package com.plxue.interview.designpatterns.strategy;

public class MuteQuack implements QuackBehavior {

	public void quack() {
		System.out.println("muteQuack!");
	}

}
