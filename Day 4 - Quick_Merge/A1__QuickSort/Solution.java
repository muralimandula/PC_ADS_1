import java.util.Arrays;
import java.util.Random;

class Solution {

	public static int doPartitioning(int[] arr, int lo, int hi) {

		// Considering pivot element as the last element of array

		// Random rand = new Random();
		// int myRandPivot = rand.
		int pivot = arr[hi];
		int pivotIndex = hi;

		// i starts from start of the array
		// keep inserting the values less than pivot, at i'th index

		int i = lo;   

        for (int j = lo; j < hi; j++) 
        { 
            if (arr[j] < pivot) { 
            	// found element value less than pivot, so swap
                int temp = arr[i]; 
                arr[i] = arr[j];
				arr[j] = temp;
				
				i++; // moving the position,
					 // where another value less than pivot to be inserted
            } 
        }

	    // seperation done. So, moving/swapping pivot to i'th

		// Regardless of comparision happening, it updates pivot for partition
		// Hence, NOT STABLE
        int temp = arr[i];
        arr[i] = pivot; 
		arr[pivotIndex] = temp;

        return i;
	}

	public static void recursivePartition(int[] arr, int lo, int hi) {
		// System.out.println(Arrays.toString(arr));

		if(lo < hi) {

			int partIndex = doPartitioning(arr, lo, hi);

			// partiotioning done, can exclude the value at partition Index

			recursivePartition(arr, lo, partIndex - 1); // sort before partIndex
			recursivePartition(arr, partIndex + 1, hi); // sort after partIndex
		}
	}


	public static int[] quickSort(int[] arr){
		// fill you code Here
		// System.out.println(Arrays.toString(arr));
		recursivePartition(arr, 0, arr.length - 1);
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {3, 5, 1, 0, -5, 32, 90, 25};

		System.out.println(Arrays.toString(quickSort(arr)));
	}
	
}


