import java.util.Arrays;

final class InsertionSentinel {

    // Insertion Sort using Sentinel

	public static int[] sentinelInsertion(int[] arr) {

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
    public static void main(String[] args) {

        int[] arr = new int[] {3, 1, 8, 6, 7, 0, -2, 1};

        System.out.println(Arrays.toString(sentinelInsertion(arr)));
    }
}