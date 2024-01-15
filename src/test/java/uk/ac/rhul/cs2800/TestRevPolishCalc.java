package uk.ac.rhul.cs2800;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
  private RhulRevPolishCalc rpc;

  @BeforeEach
  public void setup() {
    rpc = new RhulRevPolishCalc();
  }

  @Test
  // Test 1, Testing if Reverse Polish Calculator evaluates to 0;
  public void test() throws BadTypeException {
    assertEquals(rpc.evaluate("0"), 0.f, "Testing that evaluating 0 gives 0.0");
  }

  @Test
  // Test 2, Testing if Reverse Polish Calculator evaluates to 11 (using +);
  public void testPlus() throws BadTypeException {
    assertEquals(rpc.evaluate("5 6 +"), 11.0f, "Testing that evaluating 5 6 + gives 11.0");
  }

  @Test
  // Test 3, Testing if Reverse Polish Calculator evaluates to 5 (using /);
  public void testDivision() throws BadTypeException {
    assertEquals(rpc.evaluate("100 20 /"), 5.0f, "Testing that evaluating 100 20 / gives 5.0");
  }

  @Test
  // Test 4, Testing if Reverse Polish Calculator evaluates to 34 using multiple and different types
  // of operators.
  public void testComplex() throws BadTypeException {
    assertEquals(rpc.evaluate("2 4 8 * +"), 34.0f, "Testing that evaluating 2 4 8 * + gives 34.0");
  }

  @Test
  // Test 5, Testing if Reverse Polish Calculator evaluates to 11 using multiple and different types
  // of operators.
  // Now that an algorithm is implemented for all operators, more complex expressions can be
  // calculated.
  public void testComplexTwo() throws BadTypeException {
    assertEquals(rpc.evaluate("3 4 * 2 5 * + 2 /"), 11.0f,
        "Testing that evaluating 3 4 * 2 5 * + 2 / gives 11.0");
  }

  @Test
  // Test 6, Testing if Reverse Polish Calculator evaluates to 63 using multiple and different types
  // of operators.
  // Now that an algorithm is implemented for all operators, more complex expressions can be
  // calculated.
  public void testComplexThree() throws BadTypeException {
    assertEquals(rpc.evaluate("5 6 7 + * 2 -"), 63.0f,
        "Testing that evaluating 5 6 7 + * 2 - gives 63.0");
  }


}
