package com.concept.interview;

import java.util.ArrayList;
import java.util.List;

public class FlowerBed {

	// Input: [1,0,0,0,0,0,1,0,0]
	//
//	    3 => true
//	    4 => false
	//
	// Input: [1,0,0,1,0,0,1,0,0]
	//
//	    1 => true
//	    2 => false
	//
	// Input: [1]
	//
//	    1 => true
//	    2 => false
	// 
	// [1,0,0,0,0,1] --> 1
	public static void main(String... args) {
		FlowerBed bed = new FlowerBed();
		List<Boolean> bedLayout =  new ArrayList<>();
		bedLayout.add(true);
		bedLayout.add(false);
		bedLayout.add(false);
		bedLayout.add(false);
		bedLayout.add(false);
		bedLayout.add(true);
		System.out.println(bed.canPlaceFlowers(bedLayout, 2));
	}
	
	public boolean canPlaceFlowers(List<Boolean> flowerbed, int numberToPlace) {
	    // Implementation here
	    
	    //Condition 1 -  Cut sanity
	    if ((null==flowerbed || flowerbed.isEmpty()) && numberToPlace > 0) return false;
	  
	  
	    boolean canPlaceFlowers = false;
	    Boolean[] values = (Boolean[]) flowerbed.toArray(new Boolean[0]);
	    //int[] node = new int[flowerbed.size()];
	    int globalSum = 0;
	    
	    //Condition 2 -  Single element cases + initialize 0th position otherwise
	    if (values.length > 1) {
	        //node[0] = !values[1] && !values[0] ? 1 : 0; //node[0] = 0;
	    	globalSum = !values[1] && !values[0] ? 1 : 0; //node[0] = 0;
	    } else if (values.length == 1 && !values[0]) {
	        //node[0] = 1;
	    	globalSum=1;
	        if (numberToPlace ==1) canPlaceFlowers = true;
	    } else { 
	        //node[0] = 0;
	    }
	    
	    //Condition 3 -  Loop around, break out when meeting condition else go on till end
	    if (!canPlaceFlowers) {
	        int i=1;
	        // [1,0,0,0,0,1] --> 1
	        for (; i< (values.length-1); i++) {  //1-5
	           int  hold = !values[i-1] && !values[i+1] && !values[i]?1:0; 
	           if (hold==1) values[i] = true;
	           //node[i] =  node[i-1] + hold; //node[2] = 1;
	           globalSum+=hold;
	           //if (node[i] >= numberToPlace) {
	           if (globalSum >= numberToPlace) {
	               canPlaceFlowers = true;
	               break;
	           }
	        }
	        //if (!canPlaceFlowers && (node[i] + (values[values.length-1] && !values[values.length]?1:0)) >= numberToPlace)
	        if (!canPlaceFlowers && (globalSum + (values[values.length-2] && !values[values.length-1]?1:0)) >= numberToPlace) 
	        	canPlaceFlowers = true;
	    }
	    
	    return canPlaceFlowers;
	}


}
