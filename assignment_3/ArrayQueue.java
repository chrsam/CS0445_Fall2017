import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T> {

  private T[] line = (T[]) new Object[DEFAULT_CAPACITY]; // array of Queue entries under the label "line"
  private int head = 0;
  private int tail = 0;
  private int size = 0;
  private static final int DEFAULT_CAPACITY = 50;

  /** (also known as dequeue)
   *  Removes and returns the entry at the front of this Queue.
   *  @return object at front of Queue
   *  @throws UnsupportedOperationException if Queue is empty before operation
   */
  public T remove() {
      T result = peek();
      size--;
      head = (head + 1) % line.length;
      return result;
  }

  /** (also known as getFront)
   *  Retrieves entry at front of Queue.
   *  @return object at front of Queue
   *  @throws UnsupportedOperationException if Queue is empty before operation
   */
  public T peek() {
    if(size == 0) {
      throw new UnsupportedOperationException();
    } else {
      return line[head];
    }
  }

  /** (also known as enqueue)
   *  Adds new entry to back of queue.
   *  @param newEntry (object to be added)
   *  @return none
   */
  public void add(T thing) {
      checkCapacity(); // if array is full, resize array. if not, do nothing.
      line[tail] = thing; // set new entry as last object in the array.
      tail = (tail + 1) % line.length;
      size++; // increment size to indicate array got larger by 1
  }

  /**
   *  Detects if Queue is empty.
   *  @return True if Queue is empty, False otherwise.
   */
  public boolean isEmpty() {
      return(size == 0);
  }

  private void checkCapacity() {
    if (size > 0 && head == tail) {
        T[] newArray = (T[]) new Object[line.length * 2];
        System.arraycopy(line, head, newArray, 0, (line.length - head));
        System.arraycopy(line, 0, newArray, line.length - head, tail);
        tail = line.length;
        head = 0;
        line = newArray;
    }
  }
}
