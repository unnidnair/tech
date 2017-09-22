package com.concept.algorithms.attempts;

import java.util.Arrays;
import java.util.Comparator;

public class Meetings {

	public static void main(String[] args) {
		Meetings meetings = new Meetings();
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(9, 11);
		intervals[1] = new Interval(11, 12);
		intervals[2] = new Interval(1, 3);
		System.out.println("Can attend : " + meetings.canAttendMeetings(intervals));
	}
	
	public boolean canAttendMeetings(Interval[] intervals) {
//	    Arrays.sort(intervals, new Comparator<Interval>(){
//	        public int compare(Interval a, Interval b){
//	            return a.start-b.start;
//	        }
//	    });
	    
		//lambda
	    Arrays.sort(intervals, (a,b) -> a.start-b.start);
	    
	    //Read https://stackoverflow.com/questions/21970719/java-arrays-sort-with-lambda-expression
	    //and http://www.baeldung.com/java-8-double-colon-operator
	    
	    for(int i=0; i<intervals.length-1; i++){
	        if(intervals[i].end>intervals[i+1].start){
	            return false;
	        }
	    }
	 
	    return true;
	}
	


}

class Interval {
	int start, end;
	public Interval(int start, int end) {
		this.start=start;
		this.end=end;
	}
}
