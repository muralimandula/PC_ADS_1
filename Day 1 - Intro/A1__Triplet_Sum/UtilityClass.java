import java.util.Arrays;

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

        System.out.println("Cubic time : " + count + " triplets");


        /*
         * Sort array, to reduce complexity of  N^3 to N^2
         */

        // costs of NlogN to sort
        Arrays.sort(arr);

        count = 0;

        for (int i = 0; i < arr.length - 2; i++) {

            int j = i + 1;            // second value index, from index next to first element
            int k = arr.length  - 1;  // third value index, from last till it meet second

            int sum = arr[i] + arr[j] + arr[k];

            while (j < k) {

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
        System.out.println("With Sort : " + count + " triplets");
    }

}
