package uk.ac.rhul.cs2800;

/**
 * This class takes a postfix expression and uses a numStack to calculate the result.
 * 
 * @author Michael Panlilio
 */
public class RhulRevPolishCalc {
  private RhulNumStack numstack = new RhulNumStack();

  /**
   * This method puts the user's expression into an array and iterates through each element and
   * pushes each float value into the numStack until an operator is encountered and pops twice to
   * perform the arithmetic dependent on what operator has been encountered.
   * 
   * @param input the postfix expression that the user has input
   * @return returns the last float value in the stack which is the evaluated result.
   * @throws BadTypeException if the type value is incorrect from the specialised stack.
   * @throws NumberFormatException if the converted string is incorrect format
   */
  public float evaluate(String input) throws BadTypeException, NumberFormatException {
    String[] values = input.split(" ");
    for (int i = 0; i < values.length; i++) {
      float right;
      float left;
      switch (values[i]) {
        case "+":
          right = numstack.pop();
          left = numstack.pop();
          numstack.push(left + right);
          break;
        case "*":
          right = numstack.pop();
          left = numstack.pop();
          numstack.push(left * right);
          break;
        case "-":
          right = numstack.pop();
          left = numstack.pop();
          numstack.push(left - right);
          break;
        case "/":
          right = numstack.pop();
          left = numstack.pop();
          numstack.push(left / right);
          break;
        default:
          numstack.push(Float.parseFloat(values[i]));
      }
    }
    return numstack.pop();
  }
}
