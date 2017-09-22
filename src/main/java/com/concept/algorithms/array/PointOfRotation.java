package com.concept.algorithms.array;

//find-the-point-of-rotation-in-sorted-array
//http://techieme.in/find-the-point-of-rotation-in-sorted-array/
public class PointOfRotation {

	public static void main(String[] args) {
		int[] a = {10,11,12,13,14,6,8,9};
		PointOfRotation pOfRotation = new PointOfRotation();
		pOfRotation.findPointOfRotation(a);
	}
	
	//10,11,12,13,14,6,8,9
	//10,11,12
	//10,11,12,13,14,6
	//14,6,8,9

	private void findPointOfRotation(int[] a) {
		
		int pointOfRotation = -1;
		if (null!=a || 0!=a.length) {
			int start=0, end=a.length-1, mid;
			mid=start+(end-start)/2;
///FILL CODE recursive
			//Look at left subarray, or right subarray
			//If the element is greater than left and less than right - we found it
			//Take care of edges

			
			
		}
		
	}

}
