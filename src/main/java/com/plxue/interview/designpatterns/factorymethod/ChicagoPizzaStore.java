package com.plxue.interview.designpatterns.factorymethod;

public class ChicagoPizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza = null;
		
		if (type.equals("cheese")) {
			pizza = new ChicagoStyleCheesePizza();
		}
		
		return pizza;
	}

}
