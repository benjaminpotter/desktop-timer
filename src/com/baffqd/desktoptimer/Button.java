package com.baffqd.desktoptimer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Font;


public class Button extends JButton{

	public Button(String label) {
		super(label);
		
		setFont((Font) Preferences.getInstance().getPreference("BTN_FONT"));
		
		setOpaque(true);
		//setBorderPainted(false);
		//setBorder(BorderFactory.createEtchedBorder(BevelBorder.RAISED));
		setBackground((Color) Preferences.getInstance().getPreference("BTN_BG_COLOR"));
		
		setForeground((Color) Preferences.getInstance().getPreference("BTN_FG_COLOR"));
	}

}
