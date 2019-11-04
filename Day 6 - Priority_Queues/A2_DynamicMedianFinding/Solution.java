import java.util.PriorityQueue;

class Solution{
	public static double[] dynamicMedian(double[] arr){

		PriorityQueue<Double> minPQ = new PriorityQueue<Double>();
		MaxPQ maxPQ = new MaxPQ();

		double[] toReturn = new double[arr.length];
		int doubleSize = 0;

		double median = 0;

		// In priority Queues:
		// root of MinPq is minimum of all, root of maxPQ is maximum of all.
		// So, minPQ and maxPQ can combine to form a sorted array. Finds Medain.

		// System.out.println("MinPQ\t   MaxPQ     Median\n______________________________");
		for (int i = 0; i < arr.length; i++) {


			double input = arr[i];

			if(input > median) {
				// Greater than median always goes to MinPQ,
				minPQ.add(input);

			} else if (input < median) {
				// Lesser than median goes to MaxPQ.
				maxPQ.insert(input);

			} else {
				minPQ.add(input);
			}

			// Below print is to debug updated minPQ, maxPQ's ()size : topValue) and Dynamic Median.
			// System.out.println(minPQ.size() + " : " + minPQ.peek() + "    " + maxPQ.size() + " : " + +maxPQ.getMax() + "   "+ median);
			
			// minPQ has more elements : Remove in minPQ and insert into maxPQ
			if ((minPQ.size() - maxPQ.size()) > 1) {
				maxPQ.insert(minPQ.poll());
			}

			// maxPQ has more elements : Remove in maxPQ and insert into minPQ
			if ((maxPQ.size() - minPQ.size()) > 1) {
				minPQ.add(maxPQ.delMax());
			}

			// Difference is just 1 element
			// So, the PQ with max elements will hold the median**********
			if (Math.abs((minPQ.size() - maxPQ.size())) == 1) {

				if (minPQ.size() > maxPQ.size()) {
					median = minPQ.peek();

					toReturn[doubleSize++] = median;
					// System.out.println(median);
				} else {
					median = maxPQ.getMax();
					toReturn[doubleSize++] = median;
					// System.out.println(median);
				}
			}
			if (minPQ.size()  == maxPQ.size()) {

				double min = minPQ.peek();
				double max = maxPQ.getMax();

				median = (min + max) / 2.0;
				toReturn[doubleSize++] = median;
				// System.out.println(median);

			}			
		}

		return toReturn;
	}
}


