import java.util.Arrays;

final class LearnBy {

    LearnBy() {

    }
    public static void main(final String[] args) {
        
        final int[] arr = new int[] {2, 3, 4, 1, 2, 6, 0, 7, 5, 3, 4};


        int pairs = 0;
        int loops = 0;

        /*
        * Brute force,, looping
        */
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {     //  N^2   : Quadratic

                loops++;

                if (arr[i] == arr[j] && i != j) {
                    pairs++;
                }
            }
        }
        System.out.println("\nQuadratic, N^2  :  loops "  + loops + "  " + pairs / 2 + " pairs");
        //                                                            pairs / 2,  since accessing same twice



        /*
        * Below is to sort array before operation, costs NlogN to sort
        */
        Arrays.sort(arr);                           /// N log N  : Linearthimic
        pairs = 0;                                   //   +
        loops = 0;

        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {   // N  :  linear

            loops++;
            if (arr[i] == arr[i + 1]) {
                pairs++;
            }
        }
        System.out.println("\nUsing sort");
        System.out.println("Linearthimic    :  loops "  +  loops + "  " + pairs + " pairs");
    }
}
