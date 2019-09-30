package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {

  Node<T> firstItem;
  int size;
  public LinkedStack() {
     size = 0;
     firstItem = null;
  }
  /**
   * {@inheritDoc}.
   */
  @Override
  public T pop() throws StackUnderflowException {
    if(isEmpty()) return null;

    T temp = firstItem.elem;
    Node n = firstItem.next;
    firstItem = n;
    size--;
    return temp;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public T top() throws StackUnderflowException {
    if(firstItem == null) return null;
    else {
      return firstItem.elem;
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean isEmpty() {
    if(firstItem == null) return true;
    else return false;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int size() {
    if(firstItem == null) return 0;
    return size;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void push(T elem) {
    Node<T> newItem = new Node(elem, firstItem);
    firstItem = newItem;
    size++;
  }
}
