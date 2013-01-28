/**
 * 
 */
package com.plxue.interview.designpatterns.observer;

import java.util.ArrayList;

/**
 * @author libin
 *
 */
public class WeatherData implements Subject {
	private ArrayList<Observer> observers;
	
	private float tempture;
	
	private float humidity;
	
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		int index = observers.indexOf(o);
		if (index > 0)
			observers.remove(index);
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(tempture, humidity, pressure);
		}
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(float temp, float humidity, float pressure) {
		this.tempture = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
}
