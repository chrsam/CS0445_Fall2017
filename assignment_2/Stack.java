public interface Stack<T> {

  /** Removes and returns this stack's top entry.
   *  @return The object at the top of the stack.
   *  @throws EmptyStackException if the stack is empty before the operation
   */
  public T pop();

  /** Retreives this stack's top entry.
   *  @return The object at the top of the stack.
   *  @throws EmptyStackException if the stack is empty.
   */
  public T peek();

  /** Adds a new entry to the top of this stack.
   * @param thing An object to be added to the stack.
   */
  public void push(T thing);

  /** Detects whether or not the stack is empty.
   * @return True if the stack is empty.
   */
  public boolean isEmpty();
}
