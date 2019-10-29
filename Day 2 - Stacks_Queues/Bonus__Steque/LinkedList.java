class Node<Item> {
    Item value;
    Node next;

    Node(Item val) {
        this.value = val;
    }
}

class LinkedList {
    Node head;
    Node tail;

    /**
     * Add element at the end of the LinkedList
     * updates tail
     * @param val
     */
    public void addAtLast(Object val) {
        System.out.println("Adding at lastt : " + val);

        Node node = new Node(val);

        if (head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;

            // added as well updated tail
            this.tail = node;
        }
    }

    /**
     * Adds element at the begining of the LinkedList
     * Updates head 
     * @param val
     */
    public void addAtFirst(Object val) {
        System.out.println("Adding at first : " + val);
        Node node = new Node(val);
        node.next = this.head;

        // added as well updated head
        this.head = node;
    }

    /**
     * remove node/element at last in LinkedList
     * applicable for pop and dequeue (since, both removes last element)
     * @return
     */
    public Object removeLast() {

        if (this.head == null) {
            return "No node exists in the Steque.";
        }

        Node temp = this.head;

        while(temp.next != tail) {
            temp = temp.next;
        }

        // Eliminating the tail
        temp.next = null;

        // Making temp(the one before tail) as new tail
        this.tail = temp;
        System.out.println("Removing from last : " + temp.value);

        return temp.value;
    }

    public void printLL() {
        Node temp = this.head;
        String out = "";
        while(temp.next != null) {
            // System.out.print(temp.value + " ->");
            out += temp.value + " -> ";
            temp = temp.next;
        }

        out += temp.value;

        System.out.println(out);
    }
}
