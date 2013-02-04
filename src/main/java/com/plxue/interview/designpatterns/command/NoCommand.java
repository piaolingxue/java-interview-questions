package com.plxue.interview.designpatterns.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoCommand implements Command {
	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	public void execute() {
		LOG.debug("NoCommand");
	}

	public void undo() {
		LOG.debug("NoCommand undo!");
	}

}
