package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;


/**
 * This class implements a stack to store the collection of entries.
 * 
 * @author Michael Panlilio
 */
public class RhulStack {
  /**
   * The ArrayList that takes 'RhulEntry' objects.
   */
  public List<RhulEntry> entries = new ArrayList<RhulEntry>();
  int size = 0;

  /**
   * Called to return the size of the stack.
   * 
   * @return returns the calculated size as an integer.
   */
  public int size() {
    return size;
  }

  /**
   * Called to push an element into the stack and increasing size.
   * 
   * @param i RhulEntry object that is being pushed
   */
  public void push(RhulEntry i) {
    entries.add(i);
    size++;
  }

  /**
   * Called to remove an element from the stack and decreasing size.
   * 
   * @return the stack with the most recent element removed.
   * @throws EmptyStackException if there are no elements in stack therefore it's empty.
   * 
   */
  public RhulEntry pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    size--;
    return entries.remove(size);
  }

  /**
   * Called to return the highest element from the stack.
   * 
   * @return the element that is the highest in the stack.
   * @throws EmptyStackException if there are no elements in stack therefore it's empty.
   */
  public RhulEntry top() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    int topEntry = size - 1;
    return entries.get(topEntry);
  }

}
