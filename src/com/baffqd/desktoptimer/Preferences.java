package com.baffqd.desktoptimer;

import java.io.Serializable;
import java.util.HashMap;

// might need to be changed, could become super tedious
public class Preferences implements Serializable {
	
	private static Preferences instance;
	public static synchronized Preferences getInstance() {
		
		if(instance == null)
			instance = new Preferences();
		
		return instance;
	}
	
	private class Preference<T> {
		public T data;
		
		public Preference(T data) {
			this.data = data;
		}
	}
	
	private HashMap<String, Preference<?>> prefs;
	
	private Preferences() {
		prefs = new HashMap<String, Preference<?>>();
	}
	
	public <T> void setPreference(String key, T value) {
		prefs.put(key, new Preference<T>(value));
	}
	
	public <T> T getPreference(String key) {
		Preference<?> pref = prefs.get(key);
		if(pref == null) {
			return null;
		}
		
		return (T) pref.data; // might be dangerous
	}
}
