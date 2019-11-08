import java.util.ArrayList;
import java.util.Iterator;
// import java.util.Queue;


class SequentialSearchST<Key, Value> {

    Node head;
    Node tail;
    
    class Node<Key, Value> {
        Key key;
        Value val;
        Node next;
        Node prev;
    
        Node(Key k, Value v) {
            this.key = k;
            this.val = v;
        }
    }

    public void put(Key k, int v) {

        Node node = new Node(k, v);        
        if(head == null) {
            this.head = node;
            this.tail = node;

        } else {

            Node temp = head;
            boolean newKey = true;

            while(temp != null) {
                if(temp.key.equals(k)) {
                    temp.val = v;
                    newKey = false;
                    break;
                }
                temp = temp.next;
            }

            if(newKey) {

                /**TO ADD NEW one at HEAD******************/
                // node.next = head;
                // head.prev = node;
                // head = node;

                /**TO ADD NEW one at TAIL******************/
                this.tail.next = node;
                node.prev = this.tail;
                this.tail = node;

            }
        }
    }

    public Value get(Key k) {
        Node temp = head;

        while(temp != null) {
            if(temp.key.equals(k)) {

                // Remove itself from the LL
                // And, added as recently accessed.
                updateRecent(temp);

                return (Value)temp.val;
            }
            temp = temp.next;
        }
        return (Value)head.val;
        
    }

    public void updateRecent(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        // Above code skips node in LL

        // TO ADD THE RECENT accessed one at HEAD****************
        node.next = head;
        head.prev = node;

        head = node;
        head.prev = null;

        // TO ADD THE RECENT accessed one at TAIL****************
        // tail.next = node;
        // node.prev = tail;
        // tail = node;
        // tail.next = null;
    }

    public Iterable<Key> keys()  {

        // USING Queue.java from algs4
        Queue<Key> queue = new Queue<Key>();


        // Traversing from Tail to Head, In accordance with the test cases.
        Node temp = tail;
        while(temp != null) {
            queue.enqueue((Key) temp.key);
            temp = temp.prev;
        }
        return queue;

        /**BELOW CODE is to use an ARRAYList as an Iterable */
        /**But, the default toKey() supports comma (,) seperated representation */
        //
        // ArrayList<Key> out = new ArrayList<Key>();
        // Node temp = tail;
        // while(temp != null) {
        //     out.add((Key)temp.key);
        //     temp = temp.prev;
        // }
        // return out;
    }
}
