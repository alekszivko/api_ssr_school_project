package at.spengergasse.sj2324seedproject.foundation;

import at.spengergasse.sj2324seedproject.exceptions.IdLengthTooShortException;
import java.security.SecureRandom;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Component;

//SRC/DOCS: https://de.wikipedia.org/wiki/ISO/IEC_7064#Algorithmus_f%C3%BCr_hybride_Systeme


@NoArgsConstructor
@Log4j2

@Component
public class IdGenerator extends AbstractPersistable<Long> {

  private static final char[] ALPHABET =
      "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();
  private static final SecureRandom RANDOM = new SecureRandom();
  private static final int BASE = 58;
  private static final int MOD = BASE + 1;


  public String getRandomID(int lengthID, String prefix) {
    Guard.ensureNotNull(prefix, "Prefix");
    Guard.ensureMatchesBase58(prefix);

    if ((lengthID - 1 - prefix.length()) < 5) {
      throw new IdLengthTooShortException(
          "LengthID minus prefix must be at least 4 characters long!");
    }

    char[] randomString = new char[lengthID - 1 - prefix.length()];

    for (int i = 0; i < lengthID - 2; i++) {
      randomString[i] = ALPHABET[RANDOM.nextInt(ALPHABET.length)];
    }

    return prefix + calcChecksum(randomString) + String.valueOf(randomString);
  }

  public char calcChecksum(char[] randomString) {

    int product = MOD - String.valueOf(randomString).chars()
        .mapToObj(c -> (char) c)
        .map(c -> String.valueOf(ALPHABET).indexOf(c))
        .reduce(BASE, (carry, next)
            -> (((convertZeroToBase((carry + next) % BASE) * 2) % (MOD))));

    if (product == BASE) {
      product = 0;
    }

    return ALPHABET[product];
  }

  public boolean isValid(String id) {
    String checkedId = Guard.ensureMatchesBase58(id);

    log.info("Comparing checksum of ID {} with calculated checksum", checkedId.charAt(1));

    return checkedId.charAt(1) == calcChecksum(checkedId.substring(2).toCharArray());
  }

  private int convertZeroToBase(int sum) {
    return sum == 0 ? BASE : sum;
  }

}
