package at.spengergasse.sj2324seedproject.foundation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import at.spengergasse.sj2324seedproject.exceptions.IdLengthTooShortException;
import org.junit.jupiter.api.Test;


class IdGeneratorTest {

  private final IdGenerator idGenerator = new IdGenerator();

  @Test
  void ensureKeyLengthMinusPrefixIsLessThanFiveThrowsException() {
    var exception = assertThrows(IdLengthTooShortException.class,
        () -> idGenerator.getRandomID(4, "R"));

    assertThat(exception)
        .hasMessageContaining("LengthID minus prefix must be at least 4 characters long!");
  }

  @Test
  void ensureThatNullPrefixThrowsException() {
    var exception = assertThrows(IllegalArgumentException.class,
        () -> idGenerator.getRandomID(10, null));

    assertThat(exception)
        .hasMessageContaining("'Prefix' must not be null");
  }

  @Test
  void ensureKeyLengthIsAsExpected() {
    //Given
    int expectedLength = 8;
    String prefix = "R";

    //When
    String id = idGenerator.getRandomID(expectedLength, prefix);

    //Then
    assertEquals(expectedLength, id.length());
    assertEquals(prefix, String.valueOf(id.charAt(0)));
  }

  @Test
  void ensureValidKeyIsValid() {
    //Given
    String id = idGenerator.getRandomID(10, "R");

    //When
    boolean isValid = idGenerator.isValid(id);

    //Then
    assertTrue(isValid);
  }

  @Test
  void ensureChecksumCalculatesSameValueForSameKey() {
    //Given
    var id = idGenerator.getRandomID(10, "R");
    //When
    var checksumChar = idGenerator.calcChecksum(id.substring(2).toCharArray());
    //Then
    assertEquals(checksumChar, id.charAt(1));
  }

  @Test
  void ensureInvalidIdIsInvalid() {
    //Given
    var id = "R1a2b3c4d5e6f7g8h9i";
    //When
    boolean isValid = idGenerator.isValid(id);
    //Then
    assertFalse(isValid);
  }

  @Test
  void ensureIdWithNotAllowedCharsThrowsException() {
    //Given
    String id = "34&";
    //When
    var exception = assertThrows(IllegalArgumentException.class,
        () -> idGenerator.isValid(id));
    //Then
    assertThat(exception)
        .hasMessageContaining("'argument' must match pattern '[A-HJ-NP-Za-km-z1-9]*'");
  }

  @Test
  void ensureIDsWithInvalidCharsThrowException() {
    //Given
    String id = "2323$$*";
    //When
    var exception = assertThrows(IllegalArgumentException.class,
        () -> idGenerator.isValid(id));
    //Then
    assertThat(exception)
        .hasMessageContaining("'argument' must match pattern '[A-HJ-NP-Za-km-z1-9]*'");
  }
}