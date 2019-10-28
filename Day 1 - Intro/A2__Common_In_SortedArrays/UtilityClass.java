final class UtilityClass {
    public static void main(String[] args) {
        
        int[] arr1 = new int[] {1, 3, 5, 6, 8, 10};
        
        int[] arr2 = new int[] {3, 6, 10, 13, 17, 19};

        int i = 0;
        int j = 0;

        int count = 0;

        while(i < arr1.length && j < arr2.length) {

            if (arr1[i] == arr2[j]) {
                System.out.println(arr1[i]);
                i++;
                j++;
                count++;

                // since sorted, the one lesser should increment its index to get its next.
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
    }
}