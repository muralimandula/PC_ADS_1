
class MaxPQ {
    double[] maxPq;
    int size;
    int capacity;

    MaxPQ() {
        this.maxPq = new double[11];
        this.size = 0;
        this.capacity = 11;
    }   

    public int size() {
        return this.size;
    }

    public double getMax() {
        // maxPq always maintains maxOne at root (i.e., index 1)
        return this.maxPq[1];
    }

    public void resize() {

        // A new double[] with size/capacity doubled.
        double[] newpq = new double[capacity * 2];
        this.capacity = capacity * 2;

        // Ignoring the 0'th index position
        for (int i = 1; i < size; i++) {
            newpq[i] = this.maxPq[i];
        }
        this.maxPq = newpq;
    }

    public void insert(Double key) {

        // Initially inserts at last
        //--------------should insert at index ignoring 0. (size + 1)
        maxPq[size + 1] = key;
        this.size++;

        // should consider size + 11 since 0'th index ignored.
        if((size + 1) == capacity) {
            resize();
        }

        // element at last index/bottom level, to be swimmed up
        // heapifying our MaxPQ
        swim(size);
    }

    public void swim(int swimIndex) {

        //                 parent      < current/child
        while((swimIndex > 1) && maxPq[swimIndex / 2] < maxPq[swimIndex]) {
            exchange(swimIndex, swimIndex / 2);
            swimIndex = swimIndex / 2;  // swimming up
        }
    }

    public void exchange(int from, int to) {
        double temp = maxPq[from];
        maxPq[from] = maxPq[to];
        maxPq[to] = temp;
    }

    public double delMax() {

        // maxPq always maintains maxOne at root (i.e., index 1)
        double maxOne = maxPq[1];
        maxPq[1] = maxPq[size];
        this.size--;

        sink(1);

        return maxOne;
    }

    public void sink(int sinkIndex) {

        // starts sinking down
        while ((sinkIndex * 2) <= size) {  // validation

            int childIndex = 2 * sinkIndex;

            if ((childIndex < size) && (maxPq[childIndex] < maxPq[childIndex + 1])) {
                // Moves right : since left child is less than right.
                childIndex++;
            }

            if(maxPq[childIndex] < maxPq[sinkIndex]) {
                // satisfies maxPQ
                // break : sink settled
                break;
            }
            exchange(sinkIndex, childIndex);

            // updating sinking index, towards down/bottom
            sinkIndex = childIndex;

        }
    }
}
