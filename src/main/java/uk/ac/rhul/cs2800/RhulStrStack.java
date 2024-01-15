package uk.ac.rhul.cs2800;

/**
 * This class facades from RhulStack to only stack String values.
 * 
 * @author Michael Panlilio
 */
public class RhulStrStack {
  private RhulStack strStack = new RhulStack();
  // Declared a RhulStack object so that entries with floats can be used

  public Integer size() {
    return strStack.size();
  }

  public void push(String str) {
    strStack.push(new RhulEntry(str));
  }

  public String pop() throws BadTypeException {
    return strStack.pop().getString();
  }

  /**
   * Called to return the boolean if the stack is empty.
   * 
   * @return returns the boolean of true if the stack is empty and vice versa.
   */
  public boolean isEmpty() {
    if (strStack.size == 0) {
      return true;
    } else {
      return false;
    }
  }

}
