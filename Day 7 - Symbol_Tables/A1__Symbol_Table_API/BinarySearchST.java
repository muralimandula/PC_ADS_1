import java.util.Arrays;


class BinarySearchST<Key extends Comparable<Key>, Value> {

    Key[] keys;
    Value[] values;
    int capacity;
    int size;

    BinarySearchST() {
        this.size = 0;
        this.capacity = 10;
        this.keys = (Key[]) new Comparable[10];
        this.values = (Value[]) new Object[10];
    }

    // 	inserts key and a value at appropriate position in the arrays. 
    public void put(Key k, Value v) {

        int keyIndex = rank(k);

        // key already exists in the symbol table
        if (keyIndex < size && keys[keyIndex].compareTo(k) == 0) { 
            values[keyIndex] = v;
            return;
        }

        // inserting new key-value pair, at keyIndex/right index (since it's rank)
        for (int j = size; j > keyIndex; j--)  {

            // copying value at previous to next
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }

        // Now we are at right index to insert keyIndex.

        keys[keyIndex] = k;
        values[keyIndex] = v;
        this.size++;

        if(this.size == this.capacity) {
            resize();
        }

    }

    public int size() {
        return this.size;
    }

    public void resize() {
        this.keys = Arrays.copyOf(keys, capacity * 2);
        this.values = Arrays.copyOf(values, capacity * 2);

        this.capacity = capacity * 2;

    }

    //   	return true if the given key is in the symboltable.
    public boolean contains(Key k){
        return get(k) != null;
    }


    // 		return value paired with Key.
    public Value get(Key k) {
        if (k == null) {
            return null;
        }
        int keyIndex = rank(k);
        // Finds possible position of k from rank().
        // Checking it's existence in key[] using compareTo() == 0.
        if (keyIndex < size && keys[keyIndex].compareTo(k) == 0) {
            return values[keyIndex];
        } 
        return null; // Not FOUND
    }


    // return largest key at size - 1, since Ordered
    public Key max() {

        if(this.size == 0) {
            return null;
        }
        return this.keys[size - 1];
    }

    public Key min() {

        if(this.size == 0) {
            return null;
        }
        return this.keys[0];
    }


    // 		return largest key less than or equal to key
    public Key floor(Key k) {
        if((this.size == 0) || (k == null)) {
            return null;
        }

        // finding possible key position/rank in our symbol table.
        int keyIndex = rank(k);

        if (keyIndex < size && k.compareTo(keys[keyIndex]) == 0) { // finds exact
            return keys[keyIndex];
        } else {
            return keys[keyIndex -1];  // if not found, just below/floor of it
        }

    }

    //  return number of keys less than key. (i.e., index of it's own)
    //    
    public int rank(Key key) {


        int lo = 0;
        int hi = size - 1;
        while (lo <= hi) { 
            
            // A similar one of a binary Search
            int mid = lo + (hi - lo) / 2;
            int find = key.compareTo(keys[mid]);

            if(find == 0) {
                // found at mid
                return mid;

            } else if (find < 0) {
                // can find at left of mid.
                hi = mid - 1; 
            } else {
                // can find at right of mid.
                lo = mid + 1; 
            }
        } 
        return lo;
    }

    // 		delete smallest key
    public void deleteMin() {

        Key minKey = this.min();

        if (minKey != null) {
            int keyIndex = rank(minKey);

            if (keyIndex == size || keys[keyIndex].compareTo(minKey) != 0) {
                return;
            }
            
            // copying each next value to it's previous.
            for (int j = keyIndex; j < size - 1; j++)  {
                keys[j] = keys[j+1];
                values[j] = values[j+1];
            }
    
            this.size--;

            keys[size] = null;  // to avoid loitering
            values[size] = null;
        }
    }

    //  
    public Iterable<Key> keys() {

        // To ignore null values
        // since resize to minimize not implemented
        int count = 0;
        for (int i = 0; i < keys.length; i++) {
            if(keys[i] == null) {
                break;
            } else {
                count++;
            }
        }
        this.keys = Arrays.copyOf(keys, count);

        Iterable<Key> iterable = Arrays.asList(keys);
        return iterable;
    }

}