import java.util.Stack;

/* For this assignment, you will implement an Iterator that operates as a depth-first search of a binary tree.
 * A TreeSet is provided.
 */

public class StringTreeSet {

  private int size;
  private TreeNode root;

  // creates the Iterator for the tree
  public StringIterator iterator() {
    return new TreeIterator();
  }

  public int size() {
    return size;
  }

  public void add(String value) {
    if (root == null) {
      root = new TreeNode(value);
      size++;
    } else {
      add(value, root);
    }
  }

  public boolean contains(String value) {
    return contains(value, root);
  }

  public String remove(String value) {
    if (size > 0) {
      int c = value.compareTo(root.value);
      if (c == 0) {
        return removeRoot();
      } else {
        TreeNode parent = getParentOf(value);
        if (parent != null) {
          c = value.compareTo(parent.value);
          TreeNode remove = null;
          if (c < 0) {
            remove = parent.left;
            size--;
            if (remove.countChildren() == 2) {
              return complexRemove(remove);
            } else {
              if (remove.countChildren() == 0 || remove.hasLeftChild()) {
                parent.left = remove.left;
              } else {
                parent.left = remove.right;
              }
              return remove.value;
            }
          } else {
            remove = parent.right;
            size--;
            if (remove.countChildren() == 2) {
              return complexRemove(remove);
            } else {
              if (remove.countChildren() == 0 || remove.hasLeftChild()) {
                parent.right = remove.left;
              } else {
                parent.right = remove.right;
              }
              return remove.value;
            }
          }
        }
      }
    }
    return null;
  }

  private class TreeIterator implements StringIterator {
    //
    //TODO your goal is to implement this StringIterator.  It should return values in order.
    //

    Stack<TreeNode> nodeStack;
    private TreeNode currentNode;

    // Stack Constructor. Instantiates a Stack.
    // Calls addToStack for the root - this adds all direct left descendants to the stack.
    public TreeIterator() {
      nodeStack = new Stack<TreeNode>();
      addToStack(nodeStack, root);
    }

    // Adds a node to the stack, then adds its left child to the stack, then adds that node's
    // left child to the stack, until there are no more children.
    private void addToStack(Stack<TreeNode> nodeStack, TreeNode currentNode) {
      nodeStack.push(currentNode);
      if(currentNode.hasLeftChild()) {
        addToStack(nodeStack, currentNode.left);
      }
    }

    // Pops the stack. Adds the result's right child and all of the result's right child left
    // descendants to the stack. Returns result's value
    public String next() {

      TreeNode result = null;
      result = nodeStack.pop();
      if(result.hasRightChild()) {
        addToStack(nodeStack, result.right);
      }
      if(result.right.hasLeftChild()) {
        addToStack(nodeStack, result.left);
      }
      return result.value;

      // TreeNode nextNode = null;
      // while(currentNode != null) {
      //   nodeStack.push(currentNode);
      //   currentNode = currentNode.left;
      // }
      // if(!nodeStack = null) {
      //   nextNode = nodeStack.pop();
      //   assert nextNode != null;
      //   currentNode = nextNode.right;
      // } else {
      //   throw new NoSuchElementException;
      // }
      // return nextNode.value;

      // TreeNode result = nodeStack.pop(node);
      // if(result.hasRightChild()) {
      //   addToStack(nodeStack, result.right);
      // }
      // if(result.right.hasLeftChild()) {
      //   addToStack(nodeStack, result.right.left);
      // }
      // return result.value;
    }

    // If the stack is empty, we don't have anything left.
    public boolean hasNext() {
      return currentNode != null;
    }
  }

  private String complexRemove(TreeNode node) {
    String result = node.value;
    if (goLeft()) {
      if (node.left.hasRightChild()) {
        TreeNode parent = getParentOfRightmostNode(node.left);
        node.value = parent.right.value;
        parent.right = parent.right.left;
      } else {
        node.value = node.left.value;
        node.left = node.left.left;
      }
    } else {
      if (node.right.hasLeftChild()) {
        TreeNode parent = getParentOfLeftmostNode(node.right);
        node.value = parent.left.value;
        parent.left = parent.left.right;
      } else {
        node.value = node.right.value;
        node.right = node.right.right;
      }
    }
    return result;
  }

  private TreeNode getParentOfLeftmostNode(TreeNode node) {
    TreeNode current = node;
    while (current.left.hasLeftChild()) {
      current = current.left;
    }
    return current;
  }

  private TreeNode getParentOfRightmostNode(TreeNode node) {
    TreeNode current = node;
    while (current.right.hasRightChild()) {
      current = current.right;
    }
    return current;
  }

  private boolean goLeft() {
    return Math.random() < 0.5;
  }

  private TreeNode getParentOf(String value) {
    TreeNode parent = root;
    TreeNode current;
    int c = value.compareTo(parent.value);
    if (c < 0) {
      current = parent.left;
    } else {
      current = parent.right;
    }
    while (current != null) {
      c = value.compareTo(current.value);
      if (c == 0) {
        return parent;
      } else if (c < 0) {
        parent = current;
        current = current.left;
      } else {
        parent = current;
        current = current.right;
      }
    }
    return null;
  }

  private String removeRoot() {
    String result = root.value;
    if (root.countChildren() == 0) {
      root = null;
    } else if (root.countChildren() == 2) {
      complexRemove(root);
    } else if (root.hasLeftChild()) {
      root = root.left;
    } else {
      root = root.right;
    }
    size--;
    return result;
  }

  private boolean contains(String value, TreeNode node) {
    if (node != null) {
      int c = value.compareTo(node.value);
      if (c == 0) {
        return true;
      } else if (c < 0) {
        return contains(value, node.left);
      } else {
        return contains(value, node.right);
      }
    }
    return false;
  }

  private void add(String value, TreeNode node) {
    int c = value.compareTo(node.value);
    if (c == 0) {
      node.value = value;
    } else if (c < 0) {
      if (node.hasLeftChild()) {
        add(value, node.left);
      } else {
        node.left = addTreeNode(value);
      }
    } else {
      if (node.hasRightChild()) {
        add(value, node.right);
      } else {
        node.right = addTreeNode(value);
      }
    }
  }

  private TreeNode addTreeNode(String value) {
    size++;
    return new TreeNode(value);
  }

  private class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private String value;

    public TreeNode(String value) {
      this.value = value;
    }

    public boolean hasLeftChild() {
      return left != null;
    }

    public boolean hasRightChild() {
      return right != null;
    }

    public int countChildren() {
      int result = 0;
      if (hasLeftChild()) {
        result++;
      }
      if (hasRightChild()) {
        result++;
      }
      return result;
    }
  }
}
