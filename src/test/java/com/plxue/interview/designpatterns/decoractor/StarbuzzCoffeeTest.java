package com.plxue.interview.designpatterns.decoractor;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StarbuzzCoffeeTest {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Test
	public void test() {
		Beverage b = new Espresso();
		b = new Soy(b);
		b = new Mocha(b);
		b = new SteamedMilk(b);
		LOG.debug(String.format("desc:%s, cost:%.2f", b.getDescription(),
				b.cost()));
	}

}
