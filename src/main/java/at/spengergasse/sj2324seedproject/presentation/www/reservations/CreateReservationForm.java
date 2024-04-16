package at.spengergasse.sj2324seedproject.presentation.www.reservations;

public record CreateReservationForm(String connectionNo, String reservationDescription) {

  public static CreateReservationForm create() {
    return new CreateReservationForm("", "");
  }

  ;
}