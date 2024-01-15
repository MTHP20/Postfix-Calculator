package uk.ac.rhul.cs2800;

/**
 * This class implements an entry that can take several variable types and be used within a stack.
 * 
 * @author Michael Panlilio
 */
public class RhulEntry {
  float number;
  Float newNum = (float) this.number;
  String str;
  RhulSymbol other;
  RhulType type;

  /**
   * A default constructor that takes a 'float' value as entry.
   * 
   * @param number the 'float' value in an entry.
   */
  public RhulEntry(float number) {
    this.number = number;
  }

  /**
   * A default constructor that takes a 'String' value as entry.
   * 
   * @param str the 'String' value in an entry.
   */
  public RhulEntry(String str) {
    this.str = str;
  }

  /**
   * A default constructor that takes a 'RhulType' enum value as entry.
   * 
   * @param type the 'RhulType' enum value in an entry.
   */
  public RhulEntry(RhulType type) {
    this.type = type;
  }

  /**
   * A default constructor that takes a 'RhulSymbol' enum value as entry.
   * 
   * @param other the 'RhulType' enum value in an entry.
   */
  public RhulEntry(RhulSymbol other) {
    this.other = other;
  }

  /**
   * This returns the string representation of the entry value depending on its' type.
   * 
   * @return stringResult the entry value depending on its' type.
   */
  public String toString() {
    String stringResult = "";
    if (this.str instanceof String) {
      stringResult = this.str;
    } else if (this.other instanceof RhulSymbol) {
      stringResult = String.valueOf(this.other);
    } else if (this.type instanceof RhulType) {
      stringResult = String.valueOf(this.type);
    } else if (newNum instanceof Float) {
      stringResult = String.valueOf(this.number);
    }
    return stringResult;
  }


  /**
   * Getter method called to return the 'String' value if the entry is a String type.
   * 
   * @param str the String value of an entry.
   * @return the String value.
   * @throws BadTypeException if entry is an incorrect type from String.
   */
  public String getString() throws BadTypeException {
    if (!(this.str instanceof String)) {
      throw new BadTypeException("This is an incorrect type");
    }
    return this.str;
  }

  /**
   * Getter method called to return the 'float' value if the entry is a float type.
   * 
   * @param number the float value of an entry.
   * @return the float value.
   * @throws BadTypeException if entry is an incorrect type from float.
   */
  public float getValue() throws BadTypeException {
    if (!(newNum instanceof Float)) {
      throw new BadTypeException("This is an incorrect type");
    }
    return this.number;
  }

  /**
   * Getter method called to return the 'RhulType' value if the entry is a 'RhulType' enum type.
   * 
   * @param type the RhulType enum value of an entry.
   * @return the RhulType enum value.
   */
  public RhulType getType() {
    return this.type;
  }

  /**
   * Getter method called to return the 'RhulSymbol' value if the entry is a 'RhulSymbol' enum type.
   * 
   * @param other the RhulSymbol enum value of an entry.
   * @return the RhulSymbol enum value.
   * @throws BadTypeException if entry is an incorrect type from RhulSymbol.
   */
  public RhulSymbol getSymbol() throws BadTypeException {
    if (!(this.other instanceof RhulSymbol)) {
      throw new BadTypeException("This is an incorrect type");
    }
    return this.other;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof RhulEntry)) {
      return false;
    }
    RhulEntry other = (RhulEntry) o;
    return (this.number == other.number) && (this.str == other.str) && (this.other == other.other)
        && (this.type == other.type);
  }

  @Override
  public int hashCode() {
    int hashResult = 1;
    if (this.str instanceof String) {
      hashResult = (int) this.str.hashCode();
    } else if (this.other instanceof RhulSymbol) {
      hashResult = (int) this.other.hashCode();
    } else if (this.type instanceof RhulType) {
      hashResult = (int) this.type.hashCode();
    } else if (newNum instanceof Float) {
      hashResult = (int) newNum.hashCode();
    }
    return hashResult;
  }



}
