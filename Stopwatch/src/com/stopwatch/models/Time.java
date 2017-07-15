package com.stopwatch.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Time {
	public  String  start="00:00";
	public   String  stop="00:00";
	public   String running="00:00";
	
	static ArrayList<Time> all = new ArrayList<Time>();
	
	public Time() {
		this.start=start;
		this.stop=stop;
		this.running=running;
	}
	


	public static void addToList(Time obj) {
		all.add(obj);
	}
	
	public static ArrayList<Time> getAll() {
		return all;
	}
	
	public  String getRunningTime() throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(this.start);
		Date date2 = format.parse(this.stop);
		long difference = date2.getTime() - date1.getTime();
		long diffSec = difference / 1000;
		long min = diffSec / 60;
		long sec = diffSec % 60;
		System.out.println("The difference is "+min+" minutes and "+sec+" seconds.");
		
		String result=""+Long.toString(min)+":"+Long.toString(sec)+"";
		this.running=result;
		return result;
	}
	
	
	public String getStart() {
		return this.start;
	}
	public  void setStart(String start) {
		this.start = start;
	}
	public  String getStop() {
		return this.stop;
	}
	public  void setStop(String stop) {
		this.stop = stop;
	}
	public  String getRunning() {
		return running;
	}
	public  void setRunning(String running) {
		this.running = running;
	}
	
	
}
