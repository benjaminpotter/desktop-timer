package com.baffqd.desktoptimer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StopwatchPanel extends ControlPanel {
	
	// controls
	private Button btnStart;
	private Button btnStop;
	private Button btnReset;

	public StopwatchPanel() {
		super();
		
		btnStart = new Button("start");
		btnStop = new Button("stop");
		btnReset = new Button("reset");
		
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Stopwatch.getInstance().start();
			}
		});
		
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Stopwatch.getInstance().stop();
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Stopwatch.getInstance().reset();
			}
		});
		
		add(btnStart);
		add(btnStop);
		add(btnReset);
	}

}
