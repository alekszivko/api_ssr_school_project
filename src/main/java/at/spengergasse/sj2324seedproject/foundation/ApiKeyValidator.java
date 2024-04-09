package at.spengergasse.sj2324seedproject.foundation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ApiKeyValidator implements ConstraintValidator<ApiKey, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
   /* Pattern compiledPattern = Pattern.compile("[A-HJ-NP-Za-km-z1-9]*");
    Matcher m = compiledPattern.matcher(value);

    m.matches() ?  */

    return ApiKeyGenerator.isValid(value);
  }
}
