import java.util.Arrays;

class Solution{
	public static boolean isMinHeap(double[] arr){

		// Base case for any input double[]
		if (arr.length == 0) {
			return false;
		}

		/****************Compare only if left, right child exists */
		int k = 0;

		// Through the length of array
		while(k < arr.length - 2) {

			// Only if left child exist
			if((k + 1) < arr.length) {

				// parent > leftChild
				if(arr[k] > arr[k + 1]) {
					return false;
				}
			}

			// Only if right child exist
			if((k + 2) < arr.length) {

				// parent > rightChild
				if(arr[k] > arr[k + 2]) {
					return false;
				}
			}
			k++;
		}

		return true;

		// EVERY SORTED(ascending) ARRAY FOLLWS A MINHEAP
		/************************************************ 

		// Take a copy of main array, else behaves as a aliased one.
		// main array remains as given.

		double[] arrCopy = Arrays.copyOf(arr, arr.length);
		Arrays.sort(arrCopy);

		return Arrays.toString(arrCopy).equals(Arrays.toString(arr));
		************************************************** */


		// Just compare existing children
		// Exception Handling when NO child found. IndexOutOfBounds
		/****************************************************
		int k = 0;
		double parent, leftChild, rightChild;

		while(k < arr.length) {

			parent = arr[k];
			
			try {
				leftChild = arr[(2 * k) + 1];
				if(parent > leftChild) {
					return false;
				}
			} catch(Exception e) {
				// possibly comes when no child exists 
				// IndexOutOfBounds
			}

			try {
				rightChild = arr[(2 * k) + 2];
				if(parent > rightChild) {
					return false;
				}
			}catch(Exception e) {
				// possibly comes when no child exists 
				// IndexOutOfBounds
			}
			k++;
		}
		return true;

		*******************************************************/
	}

	public static void main(String[] args) {
		System.out.println(isMinHeap(new double[] {2,3,4,5,6,10}));
	}
}