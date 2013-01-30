package com.plxue.interview.designpatterns.factorymethod;

import static org.junit.Assert.*;

import org.junit.Test;

public class PizzaStoreTest {

	@Test
	public void test() {
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();
		
		Pizza pizza = nyStore.orderPizza("cheese");
		pizza = chicagoStore.orderPizza("cheese");
	}

}
