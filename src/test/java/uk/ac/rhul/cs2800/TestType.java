package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestType {

  @Test
  // Test 1, Testing to see that the enum value is equivalent to its' String
  void testtoString() {
    assertTrue(RhulType.SYMBOL.toString().equals("SYMBOL"));
  }
}
