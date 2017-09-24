package com.concept.sort;

//Gif of some sort -- http://javadecodedquestions.blogspot.com/2013/02/data-structure-questions-for-java.html
public class SortAlgorithms {

	public static void main(String... args) {

		int a[] = { 7, 5, 2, 4, 3, 9 };
		bubbleSort(a);
		System.out.println("bubbleSort");
		for (int num : a) {
			System.out.print(num + " ");
		}
		System.out.println("");
		
		int b[] = { 7, 5, 2, 4, 3, 9 };
		selectionSort(b);
		System.out.println("selectionSort");
		for (int num : b) {
			System.out.print(num + " ");
		}
		System.out.println("");

		int c[] = { 7, 5, 2, 4, 3, 9 };
		insertionSort(c);
		System.out.println("insertionSort");
		for (int num : c) {
			System.out.print(num + " ");
		}
		System.out.println("");

		int d[] = { 7, 5, 2, 4, 3, 9 };
		mergeSort(d);
		System.out.println("mergeSort");
		for (int num : d) {
			System.out.print(num + " ");
		}
		System.out.println("");

		int e[] = { 7, 5, 2, 4, 3, 9 };
		quickSort(e);
		System.out.println("quickSort");
		for (int num : e) {
			System.out.print(num + " ");
		}
		System.out.println("");

		int f[] = { 7, 5, 2, 4, 3, 9 };
		heapSort(f);
		System.out.println("heapSort");
		for (int num : f) {
			System.out.print(num + " ");
		}
		System.out.println("");
	}

	public static void bubbleSort(int[] array) {
		if (null == array || 0 == array.length)
			return;
		for (int i = array.length - 1; i >= 0; i--) {
			for (int j = 1; j <= i; j++) {
				if (array[j - 1] > array[j]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

	public static void selectionSort(int[] array) {
		if (null == array || 0 == array.length)
			return;
		for (int i = 0; i < array.length; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}

	public static void insertionSort(int[] array) {
		if (null == array || 0 == array.length)
			return;
		for (int i = 1; i < array.length; i++) {
			int index = array[i];
			int j = i;
			while (j > 0 && array[j - 1] > index) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = index;
		}
	}

	public static void mergeSort(int[] array) {
		if (null == array || 0 == array.length)
			return;
		mergeSort(array, 0, array.length - 1);

	}

	private static void mergeSort(int[] array, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSort(array, low, middle);
			mergeSort(array, middle + 1, high);
			merge(array, low, middle, high);
		}
	}

	private static void merge(int[] array, int low, int middle, int high) {
		int[] temp = new int[array.length];
		for (int i = low; i <= high; i++) {
			temp[i] = array[i];
		}

		int leftPointer = low;
		int rightPointer = middle + 1;
		int current = low;

		while (leftPointer <= middle && rightPointer <= high) {
			if (temp[leftPointer] <= temp[rightPointer]) {
				array[current++] = temp[leftPointer];
				leftPointer++;
			} else {
				array[current++] = temp[rightPointer];
				rightPointer++;
			}
		}

		while (leftPointer <= middle) {
			array[current++] = temp[leftPointer++];
		}

		while (rightPointer <= high) {
			array[current++] = temp[rightPointer++];
		}

	}

	private static void quickSort(int[] array) {
		if (null == array || 0 == array.length)
			return;
		doQuickSort(array, 0, array.length - 1);

	}

	private static void doQuickSort(int[] array, int low, int high) {
		if (low >= high)
			return;
		int middle = low + (high - low) / 2;

		int i = low, j = high;
		while (i <= j) {
			while (array[i] < array[middle]) {
				i++;
			}

			while (array[j] > array[middle]) {
				j--;
			}

			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}

		if (low < j)
			doQuickSort(array, low, j);

		if (high > i)
			doQuickSort(array, i, high);
	}

	private static int n;
	private static int left;
	private static int right;
	private static int largest;

	private static void heapSort(int[] array) {
		buildheap(array);
		for(int i=n; i>0; i--) {
			exchange(array, 0, i); 
			n--;
			maxheap(array, 0);
			//examineHeap(array);
		}
	}

//	private static void examineHeap(int[] array) {
//		for (int num:array) {
//			System.out.print(num + " ");
//		}
//		System.out.println("");
//	}

	private static void buildheap(int[] array) {
		n = array.length - 1;
		for (int i = n / 2; i >= 0; i--) {
			maxheap(array, i);
		}
		//examineHeap(array);
	}

	private static void maxheap(int[] array, int i) {
		left = 2 * i;
		right = 2 * i + 1;

		if (left <= n && array[left] > array[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right <= n && array[right] > array[largest]) {
			largest = right;
		}
		if (largest != i) {
			exchange(array, i, largest);
			maxheap(array, largest);
		}
	}

	private static void exchange(int[] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
}
