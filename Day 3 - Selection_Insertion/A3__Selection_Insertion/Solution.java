class Solution {

	public int[] sortInsertion(int[] arr) {
		// fill you code Here

		int toCheck;

		for (int i = 1; i < arr.length; i++) {
			// i starts from 0, takes it as element to be swapped
			toCheck = arr[i];
			int j = i - 1;

			while(j >= 0 && toCheck < arr[j]) {

				// copying/pushing the greater value to next index
				arr[j + 1] = arr[j];

				// moving to previousOne, everytime, possible till 0'th index
				j = j - 1;
			}

			arr[j + 1] = toCheck;
		}
		return arr;
	}

	// Insertion Sort using Sentinel

	public int[] sentinelInsertion(int[] arr) {

		int miniOne = arr[0];
		int minIndex = 0;
		
		for(int i = 1; i < arr.length; i++) {
		if(miniOne > arr[i]) {
			miniOne = arr[i];
			minIndex = i;
			}
		}
		arr[minIndex] = arr[0];
		arr[0] = miniOne;
		// fixed minimum value of the arr into 0'th index
		
		int n = arr.length; 
		
		// i starts from index 2, where it can be compared with index 1
		for (int i = 2; i < n; ++i) {
			
			int toCheck = arr[i];  // At index 2
			int j = i - 1;         // At index 1, index of value behind the checking Value
			
			while (toCheck < arr[j]) {  // if toCheck value is less than its previous
				
				arr[j + 1] = arr[j]; 
				j = j - 1; 
			} 
			arr[j + 1] = toCheck; 
		} 
		return arr;
	}
	

	public int[] sortSelection(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			// i strarts form 0

			int miniOne = arr[i]; // assuming it to be minimum
			int miniIndex = i;

			for (int j = i + 1; j < arr.length; j++) {
			// j starts everytime from next to i
			
				if (arr[j] < miniOne) { // if found any  minimum value
					miniOne = arr[j];   // update it as minimum
					miniIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = miniOne;
			arr[miniIndex] = temp;

		}
		return arr;
	}
}