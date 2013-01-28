package com.plxue.interview.designpatterns.builtin.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AngelListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.out.println("Don’t do it, you might regret it!");
	}

}
