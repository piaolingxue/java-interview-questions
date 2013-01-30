package com.plxue.interview.designpatterns.factory;

/**
 * 创建工厂并非一种设计模式，更多来讲应该是一种编程习惯
 * @author libin
 *
 */
public class PizzaStore {
	
	private SimplePizzaFactory factory;
	
	public PizzaStore(SimplePizzaFactory factory) {
		this.factory = factory;
	}
	
	public Pizza orderPizza(String type) {
		Pizza pizza = factory.createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
