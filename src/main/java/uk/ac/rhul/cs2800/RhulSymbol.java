package uk.ac.rhul.cs2800;

/**
 * This enum represents the set of arithmetic operators including their symbol.
 * 
 * @author Michael Panlilio
 */
public enum RhulSymbol {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      "!");

  public String symbol;

  RhulSymbol(String s) {
    this.symbol = s;
  }

  /**
   * This returns the string representation of the symbol for the following arithmetic operators.
   * 
   * @return symbol.
   */
  public String toString() {
    return symbol;
  }
}
