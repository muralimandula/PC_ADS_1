
public class BST<Key extends Comparable<Key>, Value> {
    Node root;             

    class Node {
        Key key;
        Value val;
        Node left, right;
        int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BST() {
    }


    // return size of the node
    public int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    // isEmpty()
    public boolean isEmpty() {
        return root.size == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key keyToCompare) {

        if (x == null) {
            return null;
        }

        int cmp = keyToCompare.compareTo(x.key);

        if (cmp < 0) {
            // Found lesser, goes recursively left
            return get(x.left, keyToCompare);

        } else if (cmp > 0) {
            // Greater, goes recursilvely right
            return get(x.right, keyToCompare);

        } else      {
            return x.val;
        }
    }

    public void put(Key key, Value val) {

        if (val == null) {
            delete(key);
            return;
        }
        // updating the root of BST after putting a key,value
        root = put(root, key, val);
    }


    public Node put(Node x, Key keyToCompare, Value val) {
        if (x == null) {
            // if the root itself is null
            // the new one becomes the root

            return new Node(keyToCompare, val, 1);
        }
        // comparing with the root, goes recursive
        int cmp = keyToCompare.compareTo(x.key);

        // if less than root, goes to its left
        // RECURSIVE
        if(cmp < 0) {
            x.left  = put(x.left,  keyToCompare, val);

        // if less than root, goes to its right
        // RECURSIVE        
        } else if (cmp > 0) {
            x.right = put(x.right, keyToCompare, val);

        // Equals says, key already existing
        // Just updates its value.
        } else {
            x.val   = val;
        }

        // At this stage, with all recursions
        // x is node where we're updating
        // recursive callbacks, will get back to the main root again

        x.size = size(x.left) + size(x.right) + 1;  // recursion increaments size to every node in the path.

        return x;
    }



    public void deleteMin() {
        // passing root to find the possible left (i.e., minimum)
        root = deleteMin(root);
    }


    public Node deleteMin(Node x) {

        if (x.left == null) {
            // No left found, so Node x itself becomes minimum 
            // Node deleted -> Node.right becomes parent/root now
            return x.right;
        }
        // recursively going towards left, for minimum
        x.left = deleteMin(x.left);

        // updates size recursively for every Node
        x.size = size(x.left) + size(x.right) + 1;

        return x;
    }


    public void deleteMax() {
        root = deleteMax(root);
    }

    public Node deleteMax(Node x) {
        if (x.right == null) {
            // when no more right, its left becomes parent/root
            return x.left;
        }

        // Recursively going right for maximum
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }



    public void delete(Key key) {
        root = delete(root, key);
    }

    public Node delete(Node x, Key keyToCompare) {
        if (x == null) return null;

        int cmp = keyToCompare.compareTo(x.key);

        if (cmp < 0) {
            // Found less, go left
            x.left  = delete(x.left,  keyToCompare);
        } else if (cmp > 0) {
            // Found greater, going right
            x.right = delete(x.right, keyToCompare);
        } else {

            if (x.right == null) {
                // No right, make left parent
                return x.left;
            }
            if (x.left  == null) {
                // No left, make right parent
                return x.right;
            }

            // now the node to be deleted has both left, right child
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 



    public Key min() { 
        return min(root).key;
    } 

    public Node min(Node x) { 
        if (x.left == null) {
            // No more left, x is the minimum
            return x;
        }
        else {
            return min(x.left);
        }
    } 



    public Key max() {
        return max(root).key;
    } 

    public Node max(Node x) {
        if (x.right == null) {
            // No more right, x is the maximum
            return x;
        }
        else {
            return max(x.right);
        }
    } 




    public Key floor(Key key) {

        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        else {
            return x.key;
        }
    } 

    public Node floor(Node x, Key keyToCompare) {
        if (x == null) {
            return null;
        }
        int cmp = keyToCompare.compareTo(x.key);

        if (cmp == 0) {
            return x;
        }
        if (cmp <  0) {
            // Going left towards minimum
            return floor(x.left, keyToCompare);
        }
        
        // Then to right, after the possible minimum
        Node t = floor(x.right, keyToCompare); 
        if (t != null) {
            return t;
        }
        else {
            return x;
        } 
    } 


    public Key ceiling(Key key) {

        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        }
        else {
            return x.key;
        }
    }

    public Node ceiling(Node x, Key keyToCompare) {
        if (x == null) {
            return null;
        }
        int cmp = keyToCompare.compareTo(x.key);

        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) { 
            Node t = ceiling(x.left, keyToCompare); 
            if (t != null) {
                return t;
            }
            else {
                return x;
            } 
        }
        return ceiling(x.right, keyToCompare); 
    } 




    public Key select(int k) {

        Node x = select(root, k);
        return x.key;
    }

    // Return key of rank k. 
    public Node select(Node x, int k) {
        if (x == null) {
            return null; 
        }
        int t = size(x.left);

        if (t > k) {
            // current node.left has more 
            // go left, to find lesser
            return select(x.left,  k); 
        
        } else if (t < k) {
            // current node.right has less
            // gor right, to find greater size
            // this includes 
            return select(x.right, k-t-1); 
        } else {
            return x;
        }
    } 


    public int rank(Key key) {
        return rank(root, key);
    } 

    // Number of keys in the subtree less than key gives rank.
    public int rank(Node x, Key keyToCompare) {
        if (x == null) {
            // no nodes, return 0
            return 0;
        }
        int cmp = keyToCompare.compareTo(x.key);

        if      (cmp < 0) {
            return rank(x.left, keyToCompare); 
        
        } else if (cmp > 0) {
            // This includes the node.left size too
            return 1 + size(x.left) + rank(x.right, keyToCompare); 
        
        } else {
            return size(x.left);
        }
    } 



    public Iterable<Key> keys() {
        //         (leftMost, rightMost)
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {

        Queue<Key> queue = new Queue<Key>();
        // updates every node to the queue
        keys(root, queue, lo, hi);
        return queue;
    } 

    public void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) {
            // Nothing updating to the queue
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);

        if (cmplo < 0) {
            // Recursively enqueuing the minimum's/left ones first
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            // Now the root of the BST
            queue.enqueue(x.key);
        }
        if (cmphi > 0) {
            // Now, going recursively to right ones.
            keys(x.right, queue, lo, hi);
        }
    }

}
