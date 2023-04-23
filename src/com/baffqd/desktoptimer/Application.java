package com.baffqd.desktoptimer;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//import javax.swing.JMenuBar; // menu bars didn't look very good
//import javax.swing.JMenu;
//import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class Application extends JFrame {
	private enum Mode { STOPWATCH, TIMER, CLOCK }

	private static final String WINDOW_NAME = "Desktop Timer";
	private Mode mode;
	
	private StopwatchPanel stopwatch;
	private TimerPanel timer;
	private ClockPanel clock;
	
	public Application() {
		super(WINDOW_NAME);
		
		setLayout(new BorderLayout());
		
		DisplayPanel display = new DisplayPanel();
		add(display, BorderLayout.CENTER);
		
		stopwatch = new StopwatchPanel();
		add(stopwatch, BorderLayout.SOUTH);
		
		timer = new TimerPanel();
		// add(timer, BorderLayout.SOUTH);
		
		clock = new ClockPanel();
		// add(clock, BorderLayout.SOUTH);
		
		setMode(Mode.STOPWATCH);
		setAlwaysOnTop(true);
		setSize(300, 150);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
	public void run() {
		
	}

	public static void main(String[] args) {
//		System.setProperty("apple.laf.useScreenMenuBar", "true");
//		System.setProperty("com.apple.mrj.application.apple.menu.about.name", "DesktopTimer");
		
		try {
            // Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
		catch (ClassNotFoundException e) {
		       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		
		Preferences.getInstance().setPreference("FONT", new Font("Helvetica", Font.PLAIN, 45));
		Preferences.getInstance().setPreference("BTN_FONT", new Font("Helvetica", Font.PLAIN, 15));
		
		Preferences.getInstance().setPreference("CONTROL_BG_COLOR", new Color(138, 137, 192));
		
		Preferences.getInstance().setPreference("BTN_BG_COLOR", new Color(255, 253, 247));
		Preferences.getInstance().setPreference("BTN_FG_COLOR", new Color(29, 26, 5));
		
		Preferences.getInstance().setPreference("DISPLAY_TEXT_COLOR", new Color(29, 26, 5));
		Preferences.getInstance().setPreference("DISPLAY_BG_COLOR", new Color(255, 253, 247));

		
		new Application().run();
	}
}
