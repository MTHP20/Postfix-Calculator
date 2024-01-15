package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {
  private RhulOpStack ros;

  @BeforeEach
  public void setup() {
    ros = new RhulOpStack();
  }

  @Test
  // Test 1, Testing size of stack
  // Size is not a new variable anymore, the size variable and method is used from RhulStack
  void testSize() {
    assertEquals(ros.size(), 0, "Testing stack to see that it has size zero");
  }

  @Test
  // Test 2, Testing to see if NumStack pushes symbols successfully and increases size
  // As this is testing an OpStack class, it can now push normal RhulSymbol's without classing it as
  // a RhulEntry
  void testPush() {
    ros.push(RhulSymbol.TIMES);
    assertEquals(ros.size(), 1, "Push increases size of the empty stack");
  }

  @Test
  // Test 3, Testing to pop an empty stack, should throw an exception
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> ros.pop(), "Unable to pop from an empty stack");
  }

  @Test
  // Test 4, Testing to push multiple symbols then popping until it's empty so that an exception is
  // thrown
  // As this is testing an OpStack class, it can now push normal RhulSymbol's without classing it as
  // a RhulEntry
  void testPushPop() throws BadTypeException {
    ros.push(RhulSymbol.LEFT_BRACKET);
    ros.push(RhulSymbol.PLUS);
    assertEquals(ros.size(), 2, "Testing stack to see that it has size three");
    assertEquals(ros.pop(), "+");
    assertEquals(ros.size(), 1, "Testing stack to see that it has size two");
    assertEquals(ros.pop(), "(");
    assertThrows(EmptyStackException.class, () -> ros.pop(), "Unable to pop from an empty stack");
  }

  @Test
  // Test 5, Testing if the boolean returns true if the stack is empty.
  // As this is testing an OpStack class, it can now push normal RhulSymbol's without classing it as
  // a RhulEntry
  void testEmptyStack() {
    ros.push(RhulSymbol.RIGHT_BRACKET);
    assertEquals(ros.isEmpty(), false, "Testing stack to see that it's empty");
  }

  @Test
  // Test 6, Testing if the boolean returns the correct value dependent if the stack is empty or not
  // As this is testing an OpStack class, it can now push normal RhulSymbol's without classing it as
  // a RhulEntry
  void testEmptyStack2() throws BadTypeException {
    ros.push(RhulSymbol.INVALID);
    assertEquals(ros.isEmpty(), false, "Testing stack to see that it's not empty");
    assertEquals(ros.pop(), "!");
    assertEquals(ros.isEmpty(), true, "Testing stack to see that it's empty");
  }

  @Test
  // Test 7, Testing to see if OpStack tops the correct value in the stack
  void testTop() throws BadTypeException {
    ros.push(RhulSymbol.RIGHT_BRACKET);
    ros.push(RhulSymbol.PLUS);
    ros.push(RhulSymbol.INVALID);
    ros.push(RhulSymbol.DIVIDE);
    assertEquals(ros.size(), 4, "Testing stack to see that it has size four");
    assertEquals(ros.pop(), "/");
    assertEquals(ros.top(), "!", "Testing stack to see that it returns '!' as the top element");
  }


}
