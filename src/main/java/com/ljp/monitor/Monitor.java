package com.ljp.monitor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Monitor {
	
	private static Map<String,Integer> monitorMap = new ConcurrentHashMap<String, Integer>();
	
	public static void init() {
		
	}
	
	public static void save() {
		
	}
	
	public static void incream(String website) {
		if(monitorMap.containsKey(website)) {
			monitorMap.put(website, monitorMap.get(website) + 1);
		}else {
			monitorMap.put(website, 1);
		}
	}
	
	public static String str() {
		return monitorMap.toString();
	}
	
}
