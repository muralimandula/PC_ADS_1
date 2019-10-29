class Solution {

    public static String Josephus(final int a, final int b) {
        // fill you code Here
        String out = "";

        CircularDoubleLL cdll = new CircularDoubleLL();

        // framing the circle as a Circular_Double_LinkedList: cdll.
        // adds 0, 1, 2, 3,......., a positions/seats as nodes

        for (int i = 0; i < a; i++) {
            Node node = new Node(i);
            cdll.add(node);
        }

        // connecting head and tail : Makes the Double_LinkedList circular.
        cdll.connectCircle();

        // count to check people eliminated
        int count = 0;

        // getting started with head
        Node temp = cdll.head;

        // i to check the b'th person and remove/eliminate from cdll.
        int i = 1;

        while (count != a) {

            temp = temp.next;
            i++;
            // System.out.println("------" + out);
            if (i == b) {
                i = 1;
                out += (temp.value) + " ";
                // below code connects x -> z, from x -> y -> z. Ignores y
                // here y is our temp (i.e., at b'th position in circle).
                Node prevNode = temp.prev; // x
                Node nextNode = temp.next; // z

                prevNode.next = nextNode; // x -> z
                nextNode.prev = prevNode; // z <- x

                temp = temp.next;

                count++;
            }
        }
        // to remove additonal spaces at ends.
        return out.trim();
    }

    //  public static void main(String[] args) {
    //  Solution.Josephus(7, 2);
    // }
}

