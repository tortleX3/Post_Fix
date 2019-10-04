package stack;

/***
 * <p></p>
 * elem stores element.
 * @param <T> the elements stored in the stack
 */
public class Node<T> {
    /***
     * <p></p>
     * elem stores element.
     */
    private T elem;

    /***
     * <p></p>
     * next stores the item below.
     */
    private Node next;

    Node(T e, Node next) {
        this.next = next;
        elem = e;
    }
    T getElem() {
        return elem;
    }
    Node getNext() {
        return next;
    }
//    public void setNext(Node n) {
//        next = n;
//    }
}
