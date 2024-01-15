package uk.ac.rhul.cs2800;

/**
 * This class takes an infix expression and uses opStack to convert it to a postfix expression and
 * therefore calculate the result by using RhulRevPolishCalc.
 * 
 * @author Michael Panlilio
 */
public class RhulStandardCalc {
  private RhulRevPolishCalc postfixConvert = new RhulRevPolishCalc();
  private RhulOpStack opStack = new RhulOpStack();

  /**
   * This method returns an integer which indicates its' priority dependent on what RhulSymbol value
   * has been encountered.
   * 
   * @param symbol RhulSymbol value taken to decide it's priority against other operators.
   * @return Returns an integer which indicates how high of a priority a RhulSymbol operator is
   *         compared to others.
   */
  static int priority(RhulSymbol symbol) {
    switch (symbol) {
      case MINUS:
        return 1;
      case PLUS:
        return 2;
      case TIMES:
        return 3;
      case DIVIDE:
        return 4;
      default:
        break;
    }
    return -1;
  }

  /**
   * This method puts the user's expression into an array and iterates through each element and
   * decides whether to directly add a digit to the result or push opStack if an operator has been
   * encountered. It also uses priority() to prioritise what operators have a higher priority than
   * others.
   * 
   * @param infix the infix expression that the user has input.
   * @return Returns the evaluated result where the result has been converted from infix to postfix.
   * @throws BadTypeException if the type value is incorrect from the specialised stack.
   * @throws NumberFormatException if the converted string is incorrect format
   */
  public float evaluate(String infix) throws NumberFormatException, BadTypeException {
    String result = new String("");
    RhulSymbol symbol = null;
    for (String token : infix.split(" ")) {
      switch (token) {
        case "+":
          symbol = RhulSymbol.PLUS;
          break;
        case "-":
          symbol = RhulSymbol.MINUS;
          break;
        case "*":
          symbol = RhulSymbol.TIMES;
          break;
        case "/":
          symbol = RhulSymbol.DIVIDE;
          break;
        case "(":
          symbol = RhulSymbol.LEFT_BRACKET;
          break;
        case ")":
          symbol = RhulSymbol.RIGHT_BRACKET;
          break;
        default:
          break;
      }

      switch (token) {
        case "+":
        case "-":
        case "*":
        case "/":
          while (!opStack.isEmpty() && priority(symbol) <= priority(opStack.top())) {
            result += opStack.top().toString() + " ";
            opStack.pop();
          }
          opStack.push(symbol);
          break;
        case "(":
          opStack.push(RhulSymbol.LEFT_BRACKET);
          break;
        case ")":
          while (!opStack.isEmpty() && opStack.top().toString() != "(") {
            result += opStack.pop();
          }
          opStack.pop();
        default:
          result += token + " ";
      }
    }
    while (!opStack.isEmpty()) {
      result += opStack.pop() + " ";
    }

    result = result.replace(")", "");
    return postfixConvert.evaluate(result);
  }

}
