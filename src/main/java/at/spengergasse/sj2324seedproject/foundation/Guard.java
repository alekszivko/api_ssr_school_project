package at.spengergasse.sj2324seedproject.foundation;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Guard {

  public static final Predicate<? super Object> isNull = (arg) -> arg == null;
  public static final Predicate<? super Object> isNotNull = isNull.negate();

  public static <T> T isNotNull(T object, String name) {
    if (object == null) {
      throw new IllegalArgumentException("'%s' must not be null!".formatted(name));
    }
    return object;
  }

  public static <T> T isNotNull(T object) {
    return isNotNull(object, "argument");
  }

  public static <T> T ensureNotNull(T argument) {
    return ensureNotNull(argument, "argument");
  }

  public static <T> T ensureNotNull(T argument, String argumentName) {
    if (argument == null) {
      throw new IllegalArgumentException("'%s' must not be null".formatted(argumentName));
    }

    return argument;
  }

  public static String ensureMatchesPattern(String argument, String pattern) {
    return ensureMatchesPattern(argument, pattern, "argument");
  }

  public static String ensureMatchesPattern(String argument, String pattern, String argumentName) {
    Pattern compiledPattern = Pattern.compile(pattern);
    Matcher m = compiledPattern.matcher(argument);
    if (!m.matches()) {
      throw new IllegalArgumentException(
          "'%s' must match pattern '%s'".formatted(argumentName, pattern));
    }

    return argument;
  }

  public static String ensureMatchesBase58(String argument) {
    return ensureMatchesPattern(argument, "[A-HJ-NP-Za-km-z1-9]*", "argument");
  }

  public static Long ensurePositiveValue(Long val){
    if(val < 0){
      throw new IllegalArgumentException("Given number '%s' is negativ".formatted(val));
    }
    return val;
  }

  public static boolean isPositive(Long val){
    if(ensurePositiveValue(val) != null){
      return true;
    }else{
      return false;
    }
  }
}