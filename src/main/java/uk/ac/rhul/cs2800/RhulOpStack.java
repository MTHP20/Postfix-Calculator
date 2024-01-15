package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * This class facades from RhulStack to only stack enum RhulSymbol values.
 * 
 * @author Michael Panlilio
 */
public class RhulOpStack {
  private RhulStack opStack = new RhulStack();
  // Declared a RhulStack object so that entries with RhulSymbol values can be used

  /**
   * Called to return the size of the stack.
   * 
   * @return returns the calculated size as an integer.
   */
  public Integer size() {
    return opStack.size();
  }

  /**
   * Called to push element of RhulSymbol into the stack.
   * 
   * @param other RhulEntry RhulSymbol that is being pushed
   */
  public void push(RhulSymbol other) {
    opStack.push(new RhulEntry(other));
  }

  /**
   * Called to remove the 'RhulSymbol value' element from the stack and decreasing size.
   * 
   * @return the stack with the most recent 'RhulSymbol value' element removed in String format.
   * @throws EmptyStackException if there are no elements in stack therefore it's empty.
   * 
   */
  public String pop() {
    return opStack.pop().toString();
  }

  /**
   * Called to return the highest RhulSymbol value element from the stack.
   * 
   * @return the RhulSymbol value that is the highest in the stack.
   * @throws EmptyStackException if there are no elements in stack therefore it's empty.
   */
  public RhulSymbol top() throws BadTypeException {
    return opStack.top().getSymbol();
  }

  /**
   * Called to return the boolean if the stack is empty.
   * 
   * @return returns the boolean of true if the stack is empty and vice versa.
   */
  public boolean isEmpty() {
    if (opStack.size == 0) {
      return true;
    } else {
      return false;
    }
  }



}
