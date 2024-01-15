package uk.ac.rhul.cs2800;

/**
 * This class is a custom Exception to be thrown when a Bad Type occurs, this extends Exception.
 * 
 * @author Michael Panlilio
 */
public class BadTypeException extends Exception {
  private static final long serialVersionUID = 1L;
  String message;

  /**
   * Default constructor that creates BadTypeException.
   * 
   * @param str the message displayed when BadTypeException is thrown.
   */
  BadTypeException(String str) {
    message = str;
  }

  /**
   * This returns the string representation of what ExceptionType has occurred along with reason.
   * 
   * @return BadTypeException occurring with displayed reason.
   */
  public String toString() {
    return ("Bad Type Exception Occured: " + message);
  }
}
