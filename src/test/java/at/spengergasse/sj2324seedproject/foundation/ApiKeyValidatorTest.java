package at.spengergasse.sj2324seedproject.foundation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ApiKeyValidatorTest {

  private ApiKeyGenerator keyGen = new ApiKeyGenerator();
  private ApiKeyValidator apiKeyValidator = new ApiKeyValidator();
  private @Mock ConstraintValidatorContext ctx;

  @ParameterizedTest
  @ValueSource(strings = {"R12345678", "R123456789", "R1234356789"})
  void ensureInvalidKeysAreValidatedAsInvalid(String apiKey) {
    assertThat(apiKeyValidator.isValid(apiKey, ctx)).isFalse();
  }

  @Test
  void ensureValidKeysAreValidatedAsValid() {
    assertThat(apiKeyValidator.isValid(keyGen.getRandomKey(5), ctx)).isTrue();
    assertThat(apiKeyValidator.isValid(keyGen.getRandomKey(7), ctx)).isTrue();
    assertThat(apiKeyValidator.isValid(keyGen.getRandomKey(111), ctx)).isTrue();
  }
}