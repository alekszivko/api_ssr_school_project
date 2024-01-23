package at.spengergasse.sj2324seedproject.presentation.api.reservations;

import at.spengergasse.sj2324seedproject.domain.Customer;
import at.spengergasse.sj2324seedproject.domain.Reservation;
import java.time.LocalDateTime;

public record ReservationDTO(
    String reservationId,
    LocalDateTime reservedAt,
    Customer reservedFor,
    String reservationDescription,
    boolean completed,
    LocalDateTime lastModified) {

  public ReservationDTO(Reservation reservation) {
    this(reservation.getReservationId(), reservation.getReservdAt(),
        reservation.getReservedFor(), reservation.getReservationDescription(),
        reservation.isCompleted(), reservation.getLastModified());
  }


}
