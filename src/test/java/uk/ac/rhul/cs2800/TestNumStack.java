package uk.ac.rhul.cs2800;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {
  private RhulNumStack rns;

  @BeforeEach
  public void setup() {
    rns = new RhulNumStack();
  }

  @Test
  // Test 1, Testing size of stack
  // Size is not a new variable anymore, the size variable and method is used from RhulStack
  void testSize() {
    assertEquals(rns.size(), 0, "Testing stack to see that it has size zero");
  }

  @Test
  // Test 2, Testing to see if NumStack pushes float successfully and increases size
  // As this is testing a NumStack class, it can now push normal floats without classing it as a
  // RhulEntry
  void testPush() {
    rns.push(10.987f);
    assertEquals(rns.size(), 1, "Push increases size of the empty stack");
  }

  @Test
  // Test 3, Testing to pop an empty stack, should throw an exception
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> rns.pop(), "Unable to pop from an empty stack");
  }

  @Test
  // Test 4, Testing to push multiple floats then popping until it's empty so that an exception is
  // thrown
  // As this is testing a NumStack class, it can now push normal floats without classing it as a
  // RhulEntry
  // Changing test -> Now throws BadTypeException has it .pop() only pops floats
  void testPushPop() throws BadTypeException {
    rns.push(1.0f);
    rns.push(23.3f);
    rns.push(1.0f);
    assertEquals(rns.size(), 3, "Testing stack to see that it has size three");
    assertEquals(rns.pop(), 1.0f);
    assertEquals(rns.size(), 2, "Testing stack to see that it has size two");
    assertEquals(rns.pop(), 23.3f);
    assertEquals(rns.pop(), 1.0f);
    assertThrows(EmptyStackException.class, () -> rns.pop(), "Unable to pop from an empty stack");
  }

  @Test
  // Test 5, Testing if the boolean returns true if the stack is empty.
  void testEmptyStack() {
    assertEquals(rns.isEmpty(), true, "Testing stack to see that it's empty");
  }

  @Test
  // Test 6, Testing if the boolean returns the correct value dependent if the stack is empty or not
  // As this is testing a NumStack class, it can now push normal floats without classing it as a
  // RhulEntry
  // Changing test -> Now throws BadTypeException has it .pop() only pops floats
  void testEmptyStack2() throws BadTypeException {
    rns.push(5.67f);
    assertEquals(rns.isEmpty(), false, "Testing stack to see that it's not empty");
    assertEquals(rns.pop(), 5.67f);
    assertEquals(rns.isEmpty(), true, "Testing stack to see that it's empty");
  }
}

