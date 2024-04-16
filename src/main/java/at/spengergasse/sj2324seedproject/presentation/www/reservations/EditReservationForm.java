package at.spengergasse.sj2324seedproject.presentation.www.reservations;

import at.spengergasse.sj2324seedproject.domain.Reservation;

public record EditReservationForm(String reservationId, String description, String connectionNo,
                                  boolean completed) {

  public static EditReservationForm create(Reservation reservation) {
    return new EditReservationForm(reservation.getReservationId(),
        reservation.getReservationDescription(),
        reservation.getReservedFor().connectionNo(),
        reservation.isCompleted());
  }

}
