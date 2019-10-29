public interface StequeInterface {
    /**
     * similar to the push in Stack
     * @param val
     */
    void push(Object val);


    /**
     * similar to the pop in Stack
     * @return 
     */
    Object pop();


    /**
     * Enqueue of a reqular Queue 
     */
    void enqueue(Object val);

    /**
     * Denqueue of a reqular Queue 
     * @return 
     */
    Object dequeue();
}