package at.spengergasse.sj2324seedproject.presentation.www.reservations;

import at.spengergasse.sj2324seedproject.domain.Customer;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateReservationForm {

  @NotBlank
  Customer reservedFor;
  String reservationDescription;
  boolean completed;

}