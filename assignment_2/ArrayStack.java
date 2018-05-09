import java.util.EmptyStackException;
import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {

  private T[] stack; // array of stack entries
  private int topIndex; // index of top entry
  private boolean initialized = false;
  private static final int DEFAULT_CAPACITY = 50;
  private static final int MAX_CAPACITY = 10000;

  // default constructor
  public ArrayStack() {
    this(DEFAULT_CAPACITY);
  }

  // initialized constructor
  public ArrayStack(int initialCapacity) {

    // The cast is safe because the new array contains null entries
    @SuppressWarnings("unchecked")
    T[] tempStack = (T[]) new Object[initialCapacity];
    stack = tempStack;
    topIndex = -1; // -1 indicates empty stack
    initialized = true;
  }

  /**
   * removes top object from stack
   * throws an exception if the stack is empty before the operation
   * @param
   * @return stack's top entry
   */
  public T pop() {
    if(isEmpty()) {
      throw new UnsupportedOperationException();
    } else {
      T top = stack[topIndex];
      stack[topIndex] = null;
      topIndex--;
      return top;
    }
  }

  public T peek() {
    if(isEmpty()) {
      throw new UnsupportedOperationException();
    } else {
      return stack[topIndex];
    }
  }

  public void push (T thing) {
    ensureCapacity();
    stack[topIndex + 1] = thing;
    topIndex++;
  }

  public boolean isEmpty() {
    return topIndex < 0;
  }

  private void ensureCapacity() {
    if(topIndex + 1 == stack.length) {
      int newLength = 2 * stack.length + 1;
      stack = Arrays.copyOf(stack, newLength);
    }
  }

}
