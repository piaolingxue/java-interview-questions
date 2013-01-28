package com.plxue.interview.designpatterns.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());

	private float temperature;

	private float humidity;

	private Subject subject;

	private CurrentConditionsDisplay(Subject subject) {
		this.subject = subject;
		this.subject.registerObserver(this);
	}

	public void display() {
		LOG.info(String.format(
				"Current Conditions:%.2f F degrees and %.2f % humidity.",
				this.temperature, this.humidity));
	}

	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;

		display();
	}

}
