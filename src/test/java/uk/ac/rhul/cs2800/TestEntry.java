package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class TestEntry {
  private RhulEntry re;
  private RhulEntry re1;

  @Test
  // Test 1, Testing if an exception is thrown when calling the incorrect type
  public void testGetStringException() {
    re = new RhulEntry(0.1234f);
    assertThrows(BadTypeException.class, () -> re.getSymbol(),
        "Calling 'getSymbol()' throws an exception as a float was taken as an entry");
  }

  @Test
  // Test 2, Testing to see if the value of a String is returned
  public void testGetString() throws BadTypeException {
    re = new RhulEntry("asda");
    assertEquals(re.getString(), "asda",
        "Calling getString() returns the correct value as the String 'asda' was taken as an entry");
  }

  @Test
  // Test 3, Testing to see if the value of enum 'RhulSymbol' is returned
  public void testGetSymbol() throws BadTypeException {
    re = new RhulEntry(RhulSymbol.TIMES);
    assertEquals(re.getSymbol(), RhulSymbol.TIMES,
        "Calling getType() returns the correct value as RhulSymbol.TIMES was taken as an entry");
  }

  @Test
  // Test 4, Testing to see if the value of a Float is returned
  public void testGetValue() throws BadTypeException {
    re = new RhulEntry(10.987f);
    assertEquals(re.getValue(), 10.987f,
        "Calling getValue() returns the correct value as 10.987f was taken as an entry");
  }

  @Test
  // Test 5, Testing to see if the value of enum 'RhulType' is returned
  public void testGetType() {
    re = new RhulEntry(RhulType.INVALID);
    assertEquals(re.getType(), RhulType.INVALID,
        "Calling getType() returns the correct value as RhulType.INVALID was taken as an entry");
  }

  @Test
  // Test 6, Testing to see that both entries should be equal together
  public void testEqualsString() {
    re = new RhulEntry("Correct");
    re1 = new RhulEntry("Correct");
    assertEquals((re.equals(re1)), true, ("Calling .equals() returns true"));
  }

  @Test
  // Test 7, Testing to see that both entries should NOT be equal together
  public void testEqualsString2() {
    re = new RhulEntry("SuPEr");
    re1 = new RhulEntry(RhulType.INVALID);
    assertEquals((re.equals(re1)), false, ("Calling .equals() returns false"));
  }

  @Test
  // Test 8, Testing to see that both entries should be equal together
  public void testEqualsFloat() {
    re = new RhulEntry(0.12345f);
    re1 = new RhulEntry(0.12345f);
    assertEquals((re.equals(re1)), true, ("Calling .equals() returns true"));
  }

  @Test
  // Test 9, Testing to see getSymbol() can call the correct value along with both entries being
  // equal together
  public void testEqualsAndGetSymbol() throws BadTypeException {
    re = new RhulEntry(RhulSymbol.LEFT_BRACKET);
    re1 = new RhulEntry(RhulSymbol.LEFT_BRACKET);
    assertEquals(re.getSymbol(), RhulSymbol.LEFT_BRACKET,
        "alling getType() returns the correct value as RhulSymbol.LEFT_BRACKET was taken as an entry");
    assertEquals((re.equals(re1)), true, ("Calling .equals() returns true"));
  }

  @Test
  // Test 10, Testing to see that the hashCode values of both entries should be equal together
  public void testHashCode() {
    re = new RhulEntry(RhulType.NUMBER);
    re1 = new RhulEntry(RhulType.NUMBER);
    assertEquals(re.hashCode() == re1.hashCode(), true, "Calling .hashCode() returns true");
  }

  @Test
  // Test 11, Testing to see that both String Entries should be equal together along with their
  // equivalent hashCode.
  public void testAll() throws BadTypeException {
    re = new RhulEntry("SE_Coursework1");
    re1 = new RhulEntry("SE_Coursework1");
    assertEquals(re1.getString(), "SE_Coursework1",
        "Calling getString() returns the correct value as the String 'SE_Coursework1' was taken as an entry");
    assertEquals((re.equals(re1)), true, ("Calling .equals() returns true"));
    assertEquals(re.hashCode() == re1.hashCode(), true, "Calling .hashCode() returns true");
  }


}
