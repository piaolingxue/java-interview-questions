package com.plxue.interview.designpatterns.builtin.observer;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {
	private JFrame frame;
	
	public static void main(String[] args) {
		SwingObserverExample example = new SwingObserverExample();
		example.go();
	}
	
	public void go() {
		frame = new JFrame("a test");
		JButton button = new JButton("Should I do it?");
		button.addActionListener(new AngelListener());
		button.addActionListener(new DavidListener());
		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.setVisible(true);
	}
	
	
}
