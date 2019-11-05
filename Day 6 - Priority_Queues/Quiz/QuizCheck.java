final class QuizCheck {

    public static void main(String[] args) {
        
        MaxPQ maxPq = new MaxPQ();

        double[] arr = new double[] {100, 20, 3, 101, 54, 96, 103, 71, 60};

        for (int j = 0; j < arr.length; j++) {
            maxPq.insert(arr[j]);            
        }
    }
}