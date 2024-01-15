package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {
  private RhulStack rs;

  @BeforeEach
  public void setup() {
    rs = new RhulStack();
  }

  @Test
  // Test 1, Testing size of stack
  void testSize() {
    assertEquals(rs.size(), 0, "Testing stack to see that it has size zero");
  }

  @Test
  // Test 2, Testing to see if stack pushes value successfully and increases size
  // Changed test format for the stack to push entries instead of pushing only integers
  // Method rs.push() can now push types inside the RhulEntry class
  void testPush() {
    rs.push(new RhulEntry(10));
    assertEquals(rs.size(), 1, "Push increases size of the empty stack.");
  }

  @Test
  // Test 3, Testing to pop an empty stack, should throw an exception
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> rs.pop(), "Unable to pop from an empty stack");
  }

  @Test
  // Test 4, Testing to push stack then pop
  // Changed test format for the stack to push entries instead of pushing only integers
  // Method rs.push() can now push types inside the RhulEntry class
  void testPushPop() {
    rs.push(new RhulEntry(10));
    assertEquals(rs.pop(), (new RhulEntry(10)), "Pushing 10 then popping it should return 10");
    assertEquals(rs.size(), 0,
        "Pushing 10 then popping it should return an empty stack with size 0");
    assertThrows(EmptyStackException.class, () -> rs.pop(),
        "Testing pushing 10 then popping twice should throw an exception");
  }

  @Test
  // Test 5, Testing to push multiple times and pop, should successfully increase and decrease to
  // the correct size
  void testPush2() {
    rs.push(new RhulEntry(10));
    rs.push(new RhulEntry(RhulSymbol.DIVIDE));
    rs.push(new RhulEntry(RhulType.NUMBER));
    assertEquals(rs.size(), 3, "Push 3 times increases size of stack correctly.");
    assertEquals(rs.pop(), (new RhulEntry(RhulType.NUMBER)),
        "Push 3 times then popping should return the third thing pushed.");
    assertEquals(rs.size(), 2, "Push 3 times then popping should give a stack with a size of 2.");
  }

  @Test
  // Test 6, Testing to top an empty stack, should throw an exception
  void testEmptyTop() {
    assertThrows(EmptyStackException.class, () -> rs.top(), "Unable to top from an empty stack");
  }

  @Test
  // Test 7, Testing to push 3 simple values and successfully top the correct value
  void testTop() {
    rs.push(new RhulEntry(10.987f));
    rs.push(new RhulEntry(RhulSymbol.MINUS));
    rs.push(new RhulEntry("Test"));
    assertEquals(rs.size(), 3);
    assertEquals(rs.top(), (new RhulEntry("Test")),
        "Pushing 3 times then topping should return 'Test'");
  }

  @Test
  // Test 8, Testing to push multiple times then top should successfully top the correct value in
  // the stack
  // Changed test format for the stack to push entries instead of pushing only integers
  // Method rs.push() can now push types inside the RhulEntry class
  void testPushTop() {
    for (int elements = 0; elements < 10; elements++) {
      rs.push((new RhulEntry(elements + 5)));
    }
    assertEquals(rs.size(), 10, "Pushing should increase the size");
    assertEquals(rs.top(), (new RhulEntry(14)), "Top should top the highest value in the stack.");
  }

  @Test
  // Test 9, Testing to push a very large amount of values.
  void testPushLots() {
    for (int elements = 0; elements < 100000; elements++) {
      rs.push((new RhulEntry(elements)));
    }
    assertEquals(rs.size(), 100000, "Pushing should increase the size");
    assertEquals(rs.top(), (new RhulEntry(99999)),
        "Top should top the highest value in the stack.");
  }

  @Test
  // Test 9, Testing to push, pop, and top a stack.
  void testPushPopTop() {
    rs.push(new RhulEntry(135.79f));
    rs.push(new RhulEntry(RhulSymbol.PLUS));
    rs.push(new RhulEntry(2468));
    rs.push(new RhulEntry("Equals"));
    rs.push(new RhulEntry(RhulType.INVALID));
    assertEquals(rs.size, 5, "Pushing 5 times should give size 5");
    assertEquals(rs.top(), (new RhulEntry(RhulType.INVALID)),
        "Pushing 5 times then topping should return 23");
    assertEquals(rs.pop(), (new RhulEntry(RhulType.INVALID)),
        "Pushing 5 times then popping should return the 5th thing pushed");
    assertEquals(rs.pop(), (new RhulEntry("Equals")),
        "Pushing 5 times then popping should return the 4th thing pushed");
    assertEquals(rs.pop(), (new RhulEntry(2468)),
        "Pushing 5 times then popping should return the 3rd thing pushed");
    assertEquals(rs.size, 2, "Pushing 5 times then popping 3 times should give size 2");
    assertEquals(rs.top(), (new RhulEntry(RhulSymbol.PLUS)),
        "Pushing 5 times then popping 3 times then topping should return RhulSymbol.PLUS");
  }

}