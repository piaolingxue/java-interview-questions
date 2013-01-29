package com.plxue.interview.designpatterns.decoractor;

public class DarkRoast extends Beverage {
	public DarkRoast() {
		this.description = "Dark Roast";
	}
	
	@Override
	public double cost() {
		return 0.99;
	}

}
