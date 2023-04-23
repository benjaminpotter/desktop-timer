package com.baffqd.desktoptimer;

public class Timer {
	
	private static Timer instance;
	public static synchronized Timer getInstance() {
		
		if(instance == null)
			instance = new Timer();
		
		return instance;
	}
	
	private boolean isCounting;
	private long startTime;
	private long time; // time in seconds
	
	private void updateTime() {
		if(!isCounting)
			return;
		
		time = (System.currentTimeMillis() / 1000) - startTime;
	}
	
	public void start() {
		if(startTime == 0)
			reset();
		isCounting = true;
	}
	
	public void stop() {
		updateTime();
		isCounting = false;
	}
	
	public void reset() {
		startTime = System.currentTimeMillis() / 1000;
		time = 0;
	}
	
	public String getCurrentTime() {
		if(isCounting)
			updateTime();
		
		long seconds = time % 60;
		long minutes = (long) Math.floor(time/60.0) % 60;
		long hours = (long) Math.floor(time/60/60);
		
		
		return hours + ":" + minutes + ":" + seconds;
	}

}

