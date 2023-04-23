package com.baffqd.desktoptimer;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

// poll utility and update display
public class DisplayPanel extends JPanel {

	public DisplayPanel() {
		super();
		
		setLayout(new GridBagLayout());
		
		JLabel time = new JLabel();
		time.setFont((Font) Preferences.getInstance().getPreference("FONT"));
//		time.setFont(time.getFont().deriveFont(40f));
//		time.setForeground((Color) Preferences.getInstance().getPreference("DISPLAY_TEXT_COLOR"));
		add(time);
		
		setBackground((Color) Preferences.getInstance().getPreference("DISPLAY_BG_COLOR"));
		
		TimerTask updateTime = new TimerTask() {

			@Override
			public void run() {
				time.setText(Stopwatch.getInstance().getCurrentTime());
				DisplayPanel.this.repaint();
			}
			
		};
		
		new Timer().schedule(updateTime, 0, 100); // refresh 10 times a second
	}	
}
