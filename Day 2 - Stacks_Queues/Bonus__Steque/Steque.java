class Steque implements StequeInterface {

    LinkedList steque;

    Steque() {
        this.steque = new LinkedList();
    }

    public void push(Object val) {
        steque.addAtLast(val);
    }

    public Object pop() {
        return steque.removeLast();
    }

    public void enqueue(Object val) {
        steque.addAtFirst(val);
    }

    public Object dequeue() {
        return steque.removeLast();
    }

    public void printSteque() {
        steque.printLL();
    }

    public static void main(String[] args) {
        Steque steque = new Steque();

        System.out.println(steque.pop());

        steque.push(1);
        steque.push(2);

        steque.printSteque();
        steque.enqueue(4);

        steque.printSteque();

        steque.pop();

        steque.printSteque();

        steque.dequeue();

        steque.printSteque();


        
    }

}