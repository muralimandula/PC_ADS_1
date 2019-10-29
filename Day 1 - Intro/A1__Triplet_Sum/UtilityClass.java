import java.util.Arrays;

class BinarySearch {

    public int binarySearch(int[] arr, int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the 
            // middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present 
        // in array 
        return -1; 
    }
}

final class UtilityClass {

    public static void main(final String[] args) {

        final int[] arr = new int[] {1, 4, 45, 6, 10, 8, -24 };
        final int sumToBe = 22;

        int count = 0;
        /*
         * triplet count in cubic time.    N^3  (3 loops)
         */
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if ((arr[i] + arr[j] + arr[k]) == sumToBe) {
                        count++;
                    }
                }
            }
        }

        System.out.println("Brute force, Cubic : " + count + " triplets");


        /*
         * Sort array, to reduce complexity of  N^3 to N^2
         */

        // costs NlogN to sort
        Arrays.sort(arr);

        count = 0;

        for (int i = 0; i < arr.length - 2; i++) {   // N

            int j = i + 1;            // second element index, index next to first element (Increase towards third)
            int k = arr.length  - 1;  // third element index, index of the last element    (Decrease towards second)

            int sum = arr[i] + arr[j] + arr[k];

            while (j < k) {                            // log N

                // System.out.println( j + " --- " + k);
                sum = arr[i] + arr[j] + arr[k];

                if (sum == sumToBe) {
                    count++;
                    break;
                } else if (sum < sumToBe) {
                    j++;
                } else {
                    k--;
                }
            }

        }
        System.out.println("With just Sort     : " + count + " triplets");


        /**
         * Now,, Binary Search over the sorted : Searching third element
         */
        count = 0;
        for (int i = 0; i < arr.length; i++) {            // N

            for (int j =  i + 1; j < arr.length; j++) {   // N log N

                int num1 = arr[i];
                int num2 = arr[j];

                int num3ToSearch = (sumToBe - num1 - num2);
    
                int lo = j + 1;
                int high = arr.length - 1;
                BinarySearch bs = new BinarySearch();     

                if((num1 < num2) && (num2 < num3ToSearch)) {

                    if (bs.binarySearch(arr, lo, high, num3ToSearch) != -1) {
                        count++;
                    }
                }
                
            }
        }
        
        System.out.println("With BinarySearch  : " + count + " triplets");

 
    }

}
