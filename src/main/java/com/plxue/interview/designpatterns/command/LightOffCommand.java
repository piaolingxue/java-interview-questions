/**
 * 
 */
package com.plxue.interview.designpatterns.command;

/**
 * @author libin
 *
 */
public class LightOffCommand implements Command {
	private Light light;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}

	/* (non-Javadoc)
	 * @see com.plxue.interview.designpatterns.command.Command#execute()
	 */
	public void execute() {
		light.off();
	}

	/* (non-Javadoc)
	 * @see com.plxue.interview.designpatterns.command.Command#undo()
	 */
	public void undo() {
		light.on();
	}

}
