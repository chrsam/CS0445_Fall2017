public class LinkedQueue<T> implements Queue<T> {

  private Node head, tail; // nodes at front and end of queue
  private int size;        // number of items

  // nested class to define Node
  private class Node {
    public T data;    // entry in queue
    public Node next; // link to next node
  }

  // default constructor
  public LinkedQueue() {
    head = null;
    tail = null;
    size = 0;
  }

  /** (also known as dequeue)
   *  Removes and returns the entry at the front of this Queue.
   *  @return object at front of Queue
   */
  public T remove() {
    T thing = peek();
    head = head.next;
    size--;
    return thing;
  }

  /** (also known as getFront)
   *  Retrieves entry at front of Queue.
   *  @return object at front of Queue
   *  @throws UnsupportedOperationException if Queue is empty
   */
  public T peek() {
    if(isEmpty()) {
      throw new UnsupportedOperationException();
    } else {
      return head.data;
    }
  }

  /** (also known as enqueue)
   *  Adds new entry to back of queue.
   *  @param newEntry (object to be added)
   */
  public void add(T thing) {
    Node newNode = new Node();
    newNode.data = thing;
    if(isEmpty()) {
       head = newNode;
       tail = head;
    } else {
      tail.next = newNode;
      tail = tail.next;
    }
    size++;
  }

  /**
   *  Detects if Queue is empty.
   *  @return True if Queue is empty, False otherwise.
   */
  public boolean isEmpty() {
    return (size == 0);
  }
}
