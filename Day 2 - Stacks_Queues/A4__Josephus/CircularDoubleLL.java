class Node {

    int value;
    Node next;
    Node prev;

    Node(int val) {
        this.value = val;
    }
}

class CircularDoubleLL {
    Node head;
    Node tail;

    public void add(Node n) {
        if(head == null) {
			// System.out.println(n.value + " Head");
            this.head = n;
            this.tail = n;
        } else {
            
			// connecting next, prev
			// System.out.println(n.value + " new Add");
			
            this.tail.next = n;
            n.prev = this.tail;
            this.tail = n;
        }
    }

    public void connectCircle() {
        this.tail.next = this.head;
        this.head.prev = this.tail;
    }
}
