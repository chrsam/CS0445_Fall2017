import java.util.EmptyStackException;
import org.w3c.dom.Node;

public class LinkedStack<T> implements Stack<T> {

  int size;

  // references first Node in chain
  private Node<T> topNode;

  // serves as the default constructor
  public LinkedStack() {
    topNode = null;
    size = 0;
  }

  private class Node<T> {
    private T value;
    private Node<T> next;

    public Node() {
      value = null;
      next = null;
    }

    public Node(T value, Node<T> tempNode) {
    value = value;
    next = tempNode;
    }
    public T getValue() {
      return value;
    }

    public void setValue(T val) {
      value = val;
    }
  }

  public T pop() {
    if(isEmpty()) {
      throw new UnsupportedOperationException();
    }
    if(topNode.next == null) {
      T nodeValue = topNode.getValue();
      topNode = null;
      size--;
      return nodeValue;
    }
    T nodeValue = topNode.getValue();
    size--;
    topNode = topNode.next;
    return nodeValue;
  }

  public T peek() {
    if(isEmpty()) {
      throw new UnsupportedOperationException();
    } else {
      return topNode.getValue(); //.getValue?
    }
  }

  public void push (T thing) {
    Node<T> newNode = new Node<T>();
    newNode.setValue(thing);

    if(topNode == null) {
      topNode = newNode;
      size++;
    } else {
      newNode.next = topNode;
      topNode = newNode;
      size++;
    }
  }

  public boolean isEmpty() {
    return topNode == null;

  }

  public void clear() {
    topNode = null;
  }

}
