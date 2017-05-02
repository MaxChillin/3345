package Project5;

import java.text.DecimalFormat;

/** 
 * @author 		Jeremy Pierce
 * Class: 		SE 3345.003 Data Structures
 * Section:		003
 * Semester:	Fall 2016
 * Project 3: 	Event class
 * Description: This class is used with the functionality for the Binary Min Heap
 * Date: 		11/9/2016
 */
public class Event {
	
	private static DecimalFormat myFormat = new DecimalFormat("00.00");
	private double timeOfEvent;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTime(){
		return timeOfEvent;
	}
	
	public void setTime(double time){
		timeOfEvent = time;
	}
	
	public String toString(){
		return this.getName() + " : " + myFormat.format(this.getTime());
	}

}
