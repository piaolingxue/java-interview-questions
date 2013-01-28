package com.plxue.interview.designpatterns.builtin.observer;

import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.plxue.interview.designpatterns.observer.DisplayElement;

public class CurrentConditionsDisplay implements DisplayElement, Observer {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	private Observable observable;
	
	private float temperature;
	
	private float humidity;
	
	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}

	}

	public void display() {
		LOG.info(String.format(
				"Current Conditions:%.2f F degrees and %.2f % humidity.",
				this.temperature, this.humidity));
	}

}
