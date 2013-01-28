package com.plxue.interview.designpatterns.strategy;

import static org.junit.Assert.*;

import org.junit.Test;

public class MiniDuckSimulatorTest {

	@Test
	public void test_malladuck() {
		Duck duck = new MallardDuck();
		duck.performFly();
		duck.performQuack();
		duck.display();
	}

	@Test
	public void test_modelduck() {
		Duck duck = new ModelDuck();
		duck.performFly();
		duck.setFlyBehavior(new FlyRocketPowered());
		duck.performFly();
	}
}
