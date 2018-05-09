/* For this assignment, your goal is to complete a MaxHeap and implement a HeapSort algorithm. A mostly-implemented MaxHeap
 * has been provided for you.
 */

public class MaxHeap {

  private static final int DEFAULT_CAPACITY = 20; //represents default capacity if user does not give one
  private int nextPosition = 0;
  private long[] values;

  //Serves as default constructor. Creates Long array of size 20.
  public MaxHeap() {
    values = new long[DEFAULT_CAPACITY];
  }

  //Creates Long array of whatever size is given.
  public MaxHeap(int initialCapacity) {
    values = new long[initialCapacity];
  }

  public MaxHeap(long[] array) {
    this.values = array;
    for (int i = 1; i < values.length; i++) {
      reheapUp(i);
    }
    nextPosition = values.length;
  }

  public void heapsort(long[] array) {

    //TODO implement the heap sort algorithm. "array" should be sorted in place - i.e., don't create a copy.

    MaxHeap heap = new MaxHeap(array);

    while(!heap.isEmpty()) {
      remove(0);
    }

    // for(int i = 0; i < array.length; i++) {
    //   remove(0);
    // }


    // for(int rootIndex = n / 2 - 1; rootIndex >= 0; rootIndex--) {
    //   reheap(array, rootIndex, n-1);
    //   swap(array, 0, n - 1);
    // }
    //
    // for(int lastIndex = n - 2; lastIndex > 0; lastIndex--) {
    //   reheap(array, 0, lastIndex);
    //   swap(array, 0, lastIndex;)
    // }
  }

  public boolean isEmpty() {
    return nextPosition == 0;
  }

  public void add(long value) {
    ensureCapacity();
    values[nextPosition] = value;
    reheapUp(nextPosition);
    nextPosition++;
  }

  public long getMax() {
    if (this.isEmpty()) {
      throw new UnsupportedOperationException("Heap is empty.");
    }
    return values[0];
  }

  public long remove(int i) {

    // throw new UnsupportedOperationException("TODO: implement this");
    swap(0, nextPosition);
    reheapDown(0);
    nextPosition--;
    return values[0];
  }

  private void reheapDown(int i) {
    int maxChild = getMaxChildIndex(i);
    if (maxChild > -1) {
      if (values[i] < values[maxChild]) {
        swap(i, maxChild);
        reheapDown(maxChild);
      }
    }
  }

  //takes newest array entry's position as parameter
  //finds parent
  private void reheapUp(int i) {
    int parent = (i - 1) / 2;
    if (parent >= 0) {
      if (values[parent] < values[i]) {
        swap(i, parent);
        reheapUp(parent);
      }
    }
  }

  private void ensureCapacity() {
    if (nextPosition >= values.length) {
      long[] temp = new long[values.length * 2 + 1];
      System.arraycopy(values, 0, temp, 0, values.length);
      values = temp;
    }
  }

  //takes new position and old position as parameters
  private void swap(int a, int b) {
    long temp = values[a];
    values[a] = values[b];
    values[b] = temp;
  }

  private int getMaxChildIndex(int i) {
    int left = 2 * i + 1;
    if (left >= nextPosition) {
      return -1;
    } else {
      int right = 2 * i + 2;
      if (right >= nextPosition || values[left] > values[right]) {
        return left;
      } else {
        return right;
      }
    }
  }
}
