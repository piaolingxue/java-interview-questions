package com.plxue.interview.designpatterns.factorymethod;



public class NYPizzaStore extends PizzaStore {

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza = null;

		if (type.equals("cheese"))
			pizza = new NYStyleCheesePizza();
		else if (type.equals("veggie"))
			pizza = new NYStyleVeggiePizza();
		else if (type.equals("calm"))
			pizza = new NYStyleClamPizza();
		else if (type.equals("peperoni"))
			pizza = new NYStylePepperoniPizza();
		return pizza;
	}
}
