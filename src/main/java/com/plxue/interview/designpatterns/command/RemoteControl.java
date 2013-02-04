package com.plxue.interview.designpatterns.command;

public class RemoteControl {
	Command[] onCommands;
	Command[] offCommands;
	Command undoCommand;
	
	public RemoteControl() {
		onCommands = new Command[7];
		offCommands = new Command[7];
		
		undoCommand = new NoCommand();
		NoCommand noCommand = new NoCommand();
		for (int i = 0; i < 7; ++i) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}
	
	public void set(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}
	
	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
		undoCommand = onCommands[slot];
	}
	
	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
		undoCommand = offCommands[slot];
	}
	
	public void undo() {
		undoCommand.undo();
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n---------Remote Control------\n");
		for (int i = 0; i < 7; ++i) {
			sb.append(String.format("[slot:%d] %s,%s\n", i, onCommands[i].getClass().getName(),
					offCommands[i].getClass().getName()));
		}
		return sb.toString();
	}
}
