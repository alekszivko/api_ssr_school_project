package at.spengergasse.sj2324seedproject.presentation.api.reservations;

public record CreateReservationCommand(
    String customerConnectionNo,
    String reservationDescription
) {

}