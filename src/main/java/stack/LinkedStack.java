package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
  /***
   * <p></p>
   * firstItem stores top item.
   */
  private Node<T> firstItem;
  /***
   * <p></p>
   * size stores number of elements.
   */
  private int size;
  public LinkedStack() {
     size = 0;
     firstItem = null;
  }
  /**
   * {@inheritDoc}.
   */
  @Override
  public T pop() throws StackUnderflowException {
    if (isEmpty()) {
      throw new StackUnderflowException("Attempting to pop an empty stack");
    }

    T temp = firstItem.getElem();
    firstItem = firstItem.getNext();
    size--;
    return temp;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public T top() throws StackUnderflowException {
    if (isEmpty()) {
      throw new StackUnderflowException("Attempting to top an empty stack");
    } else {
      return firstItem.getElem();
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean isEmpty() {
    return firstItem == null;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void push(T elem) {
    firstItem = new Node(elem, firstItem);
    size++;
  }
}
