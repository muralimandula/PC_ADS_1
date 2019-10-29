class BinarySearch {

    public int binarySearch(int[] arr, int l, int r, int x) {

        if (l <= r) { //index validation

            // getting the mmiddle index

            int mid = l + (r - l) / 2; 
  

            // element found
            if (arr[mid] == x)  {

                int foundAt = mid;

                int before = mid - 1;

                // finding the one before it, if same
                while(arr[before] == x) {
                    before--;
                }
                foundAt = before + 1;
                return foundAt;
            }
  
            if (x < arr[mid]) {

                // go Left
                return binarySearch(arr, l, mid - 1, x); 
            } else {

                // go Right
                return binarySearch(arr, mid + 1, r, x);    
            }
        } 
  
        // it executes when not found
        return -1; 
    }
}


final class UtilityClass {

    public static void main(String[] args) {

        //                     0  1  2  3  4  5  6  7   8   9  10
        int[] arr = new int[] {1, 2, 3, 8, 8, 8, 8, 8, 20, 31, 51};

        
        int n = new BinarySearch().binarySearch(arr, 0, arr.length, 8);

        if (n == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("First occurance at " + n + ".");
        }
    }


}