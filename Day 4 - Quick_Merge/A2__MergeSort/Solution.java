import java.util.Arrays;

class Solution {
	/**
	 * 
	 * @param arr main array
	 * @param lo  lower index of left array
	 * @param mid end of left array, mid + 1 : start/lower of right array
	 * @param hi  end of right array
	 */
	public static void sortAndMerge(String[] arr, int lo, int mid, int hi) {
		// Find sizes of two subarrays to be merged 
		int size1 = mid - lo + 1; 
		int size2 = hi - mid;

		// left and right arrays
		String leftArr[] = new String[size1];
		String rightArr[] = new String[size2]; 

		// Main array into two parts
		for (int i = 0; i < size1; i++) {
			leftArr[i] = arr[lo + i]; 
		}

		for (int j = 0; j < size2; j++)  {
			rightArr[j] = arr[(mid + 1) + j]; 
		}

		/******* * Merging begins here */

		// low/start index of main array
		int i = 0;
		int j = 0; 

		// we already have a copy of both subarrays
		// updating them into the main array happens
		int k = lo;

		while (i < size1 && j < size2) {

			// updating the lesser one into the main array at k'th index
			if (leftArr[i].compareTo(rightArr[j]) < 0) { 
				arr[k] = leftArr[i]; 
				i++;
			} 
			else if(leftArr[i].compareTo(rightArr[j]) > 0){
				arr[k] = rightArr[j]; 
				j++;
			} else {
				// this false under equal values
				// No update haapens in main array
				// STABLE
			}
			k++;
		} 

		// above code updates possible values form subarrays

		// now we add/update remaing if any, unchecked
		while (i < size1) {
			arr[k] = leftArr[i]; 
			i++; 
			k++; 
		} 

		while (j < size2) {
			arr[k] = rightArr[j]; 
			j++; 
			k++; 
		}
	}

    public static void recursiveDivide(String[] arr, int lo, int hi) 
    { 
        if (lo < hi) { 
            // getting possible middle of the array
            int mid = (lo + hi) / 2; 
  
			recursiveDivide(arr, lo, mid);       // sorting left half

            recursiveDivide(arr , mid + 1, hi); // sorting right half

            // binding/merging up the sorted halves
            sortAndMerge(arr, lo, mid, hi); 
        } 
    } 
	public static String[] mergeSort(String[] arr){

		recursiveDivide(arr, 0, arr.length - 1);
		return arr;
	}

	public static void main(String[] args) {
		// int[] arr = new int[] {3, 5, 1, 0, -5, 32, 90, 25};

		String[] arr = new String[] {"ball", "apple", "ant", "cat", "beer"};

		System.out.println(Arrays.toString(mergeSort(arr)));
	}
}