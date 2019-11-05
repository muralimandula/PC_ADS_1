
class MaxPQ<GenericType> {
    GenericType[] maxPq;
    int size;
    int capacity;

    MaxPQ() {
        this.maxPq = (GenericType[]) new Object[11];
        this.size = 0;
        this.capacity = 11;
    }   

    public int size() {
        return this.size;
    }

    public GenericType getMax() {
        // maxPq always maintains maxOne at root (i.e., index 1)
        return this.maxPq[1];
    }

    public void resize() {

        // A new GenericType[] with size/capacity GenericTyped.
        GenericType[] newpq = (GenericType[]) new Object[capacity * 2];
        this.capacity = capacity * 2;

        // Ignoring the 0'th index position
        for (int i = 1; i < size; i++) {
            newpq[i] = this.maxPq[i];
        }
        this.maxPq = newpq;
    }

    public void insert(GenericType key) {

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
        if((size > 1 && ((double)maxPq[size] > (double)maxPq[size / 2]))) {
            System.out.println("HeapiFy happens here");
        }
        swim(size);
    }

    public void swim(int swimIndex) {

        //                 parent      < current/child
        while((swimIndex > 1) && (double)maxPq[swimIndex / 2] < (double)maxPq[swimIndex]) {
            // System.out.println("Im");
            exchange(swimIndex, swimIndex / 2);
            swimIndex = swimIndex / 2;  // swimming up
        }
    }

    public void exchange(int from, int to) {
        GenericType temp = maxPq[from];
        maxPq[from] = maxPq[to];
        maxPq[to] = temp;
    }

    public GenericType delMax() {

        // maxPq always maintains maxOne at root (i.e., index 1)
        GenericType maxOne = maxPq[1];
        maxPq[1] = maxPq[size];
        this.size--;

        sink(1);

        return maxOne;
    }

    public void sink(int sinkIndex) {

        // starts sinking down
        while ((sinkIndex * 2) <= size) {  // validation

            int childIndex = 2 * sinkIndex;

            if ((childIndex < size) && ((double)maxPq[childIndex] < (double)maxPq[childIndex + 1])) {
                // Moves right : since left child is less than right.
                childIndex++;
            }

            if((double)maxPq[childIndex] < (double)maxPq[sinkIndex]) {
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
