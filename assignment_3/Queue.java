public interface Queue<T> {

  /** (also known as dequeue)
   *  Removes and returns the entry at the front of this Queue.
   *  @return object at front of Queue
   *  @throws EmptyQueueException if Queue is empty before operation
   */
  public T remove();

  /** (also known as getFront)
   *  Retrieves entry at front of Queue.
   *  @return object at front of Queue
   *  @throws EmptyQueueException if Queue is empty
   */
  public T peek();

  /** (also known as enqueue)
   *  Adds new entry to back of queue.
   *  @param newEntry (object to be added)
   */
  public void add(T thing);

  /**
   *  Detects if Queue is empty.
   *  @return True if Queue is empty, False otherwise.
   */
  public boolean isEmpty();
}
