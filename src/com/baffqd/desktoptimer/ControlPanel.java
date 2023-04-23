package com.baffqd.desktoptimer;

import javax.swing.JPanel;
import java.awt.Color;

public class ControlPanel extends JPanel {

	public ControlPanel() {
		super();
		
		setBackground((Color) Preferences.getInstance().getPreference("CONTROL_BG_COLOR"));
	}

}
