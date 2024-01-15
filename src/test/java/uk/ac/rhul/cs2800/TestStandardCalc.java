package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {
  private RhulStandardCalc rsc;

  @BeforeEach
  public void setup() {
    rsc = new RhulStandardCalc();
  }

  @Test
  // Test 1, Testing if Standard Calculator evaluates to 5
  public void test() throws BadTypeException {
    assertEquals(rsc.evaluate("5"), 5.0f, "Testing that evaluating 5 gives 5.0");
  }

  @Test
  // Test 2, Testing if Standard Calculator evaluates to 17
  public void testPlus() throws BadTypeException {
    assertEquals(rsc.evaluate("8 + 9"), 17.0f, "Testing that evaluating 8 + 9 gives ");
  }

  @Test
  // Test 3, Testing if Standard Calculator evaluates to 22
  public void testPlus2() throws BadTypeException {
    assertEquals(rsc.evaluate("8 + 9 + 5"), 22.0f, "Testing that evaluating 8 + 9 + 5 gives 22");
  }

  @Test
  // Test 4, Testing if Standard Calculator evaluates to 10 using minus operator
  public void testMinus() throws BadTypeException {
    assertEquals(rsc.evaluate("20 - 10"), 10.0f, "Testing that evaluating 20 - 10 gives 10");
  }

  @Test
  // Test 5, Testing if Standard Calculator evaluates to 144 using times operator
  public void testTimes() throws BadTypeException {
    assertEquals(rsc.evaluate("6 * 12 * 2"), 144.0f,
        "Testing that evaluating 6 * 12 * 2 gives 144");
  }

  @Test
  // Test 6, Testing if Standard Calculator evaluates to 11 using divide operator
  public void testDivide() throws BadTypeException {
    assertEquals(rsc.evaluate("55 / 5"), 11.0f, "Testing that evaluating 55 / 5 gives 11");
  }

  @Test
  // Test 7, Testing if Standard Calculator evaluates to 63 using parentheses
  public void testParentheses() throws BadTypeException {
    assertEquals(rsc.evaluate("( 57 + 33 )"), 90.0f, "Testing that evaluating (57 + 33) gives 90");
  }

  @Test
  // Test 8, Testing if Standard Calculator evaluates to 77 using parentheses and multiple operators
  public void testParentheses2() throws BadTypeException {
    assertEquals(rsc.evaluate("( 6 + 9 ) * ( 7 + 8 )"), 225.0f,
        "Testing that evaluating (6 + 9) * (7 + 8) gives 225");
  }

  @Test
  // Test 9, Testing if Standard Calculator evaluates to 63 using multiple parentheses, operators
  // and BIDMAS.
  public void testBidmas() throws BadTypeException {
    assertEquals(rsc.evaluate("( 5 * ( 6 + 7 ) ) - 2"), 63.0f,
        "Testing that evaluating ( 5 *( 6 + 7 ) ) - 2 gives 63");
  }

  @Test
  // Test 10, Testing if Standard Calculator evaluates to 3 using BIDMAS.
  // Test 9 already passes without prioritising BIDMAS operators.
  public void testBidmasComplex() throws BadTypeException {
    assertEquals(rsc.evaluate("( 2 * 3 * 3 ) / ( 15 - 9 )"), 3.0f,
        "Testing that evaluating ( 2 * 3 * 3 ) / ( 15 - 9 ) gives 3");
  }

}
