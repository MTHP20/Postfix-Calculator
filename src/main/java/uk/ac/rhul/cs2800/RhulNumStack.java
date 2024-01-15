package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * This class facades from RhulStack to only stack float values.
 * 
 * @author Michael Panlilio
 */
public class RhulNumStack {
  private RhulStack numStack = new RhulStack();
  // Declared a RhulStack object so that entries with floats can be used

  /**
   * Called to return the size of the stack.
   * 
   * @return returns the calculated size as an integer.
   */
  public Integer size() {
    return numStack.size();
  }

  /**
   * Called to push element of float type into the stack.
   * 
   * @param f RhulEntry float that is being pushed
   */
  public void push(float f) {
    numStack.push(new RhulEntry(f));
  }

  /**
   * Called to remove the 'float value' element from the stack and decreasing size.
   * 
   * @return the stack with the most recent float value removed.
   * @throws EmptyStackException if there are no elements in stack therefore it's empty.
   * 
   */
  public float pop() throws BadTypeException {
    return numStack.pop().getValue();
  }

  /**
   * Called to return the boolean if the stack is empty.
   * 
   * @return returns the boolean of true if the stack is empty and vice versa.
   */
  public boolean isEmpty() {
    if (numStack.size == 0) {
      return true;
    } else {
      return false;
    }
  }



}
