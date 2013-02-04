package com.plxue.interview.designpatterns.command;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandTest {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void test() {
		Light light = new Light();
		LightOnCommand lightOn = new LightOnCommand(light);
		LightOffCommand lightOff = new LightOffCommand(light);
		RemoteControl control = new RemoteControl();
		control.set(0, lightOn, lightOff);
		LOG.debug(control.toString());
		control.onButtonWasPushed(0);
		control.offButtonWasPushed(0);
		control.onButtonWasPushed(1);
		control.offButtonWasPushed(1);
		control.undo();
	}

}
