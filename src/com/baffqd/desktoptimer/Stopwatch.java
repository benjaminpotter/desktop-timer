package com.baffqd.desktoptimer;

public class Stopwatch {
	
	private static Stopwatch instance;
	public static synchronized Stopwatch getInstance() {
		
		if(instance == null)
			instance = new Stopwatch();
		
		return instance;
	}
	
	private boolean isCounting;
	private long startTime;
	private long time; // time in seconds
	
	private void updateTime() {
		if(!isCounting)
			return;
		
		long currentTime = (System.currentTimeMillis() / 1000);
		time += currentTime - startTime;
		startTime = currentTime;
	}
	
	public void start() {
		if(!isCounting)
			startTime = System.currentTimeMillis() / 1000;
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
		
		
		return String.format("%02d : %02d : %02d", hours, minutes, seconds).toString();
	}

}
