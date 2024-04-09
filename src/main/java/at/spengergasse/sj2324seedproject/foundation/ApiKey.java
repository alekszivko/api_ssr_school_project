package at.spengergasse.sj2324seedproject.foundation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ApiKeyValidator.class)

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiKey {


  String message() default "ApiKey must be at least 4 characters long!";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
