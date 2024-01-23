package at.spengergasse.sj2324seedproject.presentation.api;

import jakarta.persistence.PersistenceException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ApiMarker.class)
public class GlobalRestControllerAdvice {

  @ExceptionHandler(PersistenceException.class)
  public HttpEntity<ProblemDetail> handlePersistenceException(PersistenceException peX) {
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, peX.getMessage());
    problemDetail.setTitle("Persistence Error");
    return ResponseEntity.status(status).body(problemDetail);
  }

}
