package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {
  private RhulStrStack rss;

  @BeforeEach
  public void setup() {
    rss = new RhulStrStack();
  }

  @Test
  // Test 1, Testing size of stack
  // Size is not a new variable anymore, the size variable and method is used from RhulStack
  void testSize() {
    assertEquals(rss.size(), 0, "Testing stack to see that it has size zero");
  }

  @Test
  // Test 2, Testing to see if NumStack pushes float successfully and increases size
  // As this is testing a StrStack class, it can now push normal Strings without classing it as a
  // RhulEntry
  void testPush() {
    rss.push("testing");
    assertEquals(rss.size(), 1, "Push increases size of the empty stack");
  }

  @Test
  // Test 3, Testing to pop an empty stack, should throw an exception
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> rss.pop(), "Unable to pop from an empty stack");
  }

  @Test
  // Test 4, Testing to push multiple floats then popping until it's empty so that an exception is
  // thrown
  // As this is testing a StrStack class, it can now push normal Strings without classing it as a
  // RhulEntry
  void testPushPop() throws BadTypeException {
    rss.push("test1add");
    rss.push("test2subtract");
    rss.push("test3inVaLId");
    assertEquals(rss.size(), 3, "Testing stack to see that it has size three");
    assertEquals(rss.pop(), "test3inVaLId");
    assertEquals(rss.size(), 2, "Testing stack to see that it has size two");
    assertEquals(rss.pop(), "test2subtract");
    assertEquals(rss.pop(), "test1add");
    assertThrows(EmptyStackException.class, () -> rss.pop(), "Unable to pop from an empty stack");
  }

  @Test
  // Test 5, Testing if the boolean returns true if the stack is empty.
  void testEmptyStack() {
    assertEquals(rss.isEmpty(), true, "Testing stack to see that it's empty");
  }

  @Test
  // Test 6, Testing if the boolean returns the correct value dependent if the stack is empty or not
  // As this is testing a StrStack class, it can now push normal Strings without classing it as a
  // RhulEntry
  void testEmptyStack2() throws BadTypeException {
    rss.push("tEsTy");
    assertEquals(rss.isEmpty(), false, "Testing stack to see that it's not empty");
    assertEquals(rss.pop(), "tEsTy");
    assertEquals(rss.isEmpty(), true, "Testing stack to see that it's empty");
  }
}
