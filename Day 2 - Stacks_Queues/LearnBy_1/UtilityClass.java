class Node {
    String value;
    Node next;

    Node(String val) {
        this.value = val;
    }
}

class LinkedList {
    Node head;
    Node tail;

    public void addAtTail(String val) {
        Node node = new Node(val);

        if(head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
    }

    public String removeAndgetTail() {
        Node toPop = this.tail;

        Node temp = this.head;
        while(temp.next != tail) {
            temp = temp.next;
        }
        this.tail = temp;
        this.tail.next = null;

        return toPop.value;
    }

}

class Stack {
    LinkedList ll;

    Stack() {
        this.ll = new LinkedList();
    }

    public void push(String val) {
        ll.addAtTail(val);

    }

    public String pop() {
        return ll.removeAndgetTail();
    }

    public String printStack() {

        Node temp = this.ll.head;
        String out = "[";

        while (temp.next != null) {
            out += temp.value + ", ";
            temp = temp.next;
        }

        out += temp.value + "]";

        return out;
    }

}

final class UtilityClass {
    public static void main(String[] args) {

        String input = "it was - the best - of times - - - it was - the - -";

        String[] strArr = input.split(" ");
        Stack stack = new Stack();
        
        for (String eachString : strArr) { 


            if(!eachString.equals("-")) {
                System.out.println("\nPushing \"" + eachString + "\" into the stack.");
                stack.push(eachString);
            } else {
                System.out.println("------------Popping");
                System.out.println(stack.pop());
            }
            System.out.println(stack.printStack());

        }
    }
}