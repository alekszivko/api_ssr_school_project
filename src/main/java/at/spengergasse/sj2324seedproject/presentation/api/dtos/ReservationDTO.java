//package at.spengergasse.sj2324seedproject.presentation.api.dtos;
//
//import at.spengergasse.sj2324seedproject.domain.Reservation;
//
//import java.time.LocalDateTime;
//
//public record ReservationDTO(LocalDateTime reservedAt, UserDTO reservedBy, CustomerDTO reservedFor, boolean completed, LocalDateTime lastModified){
//    public ReservationDTO(Reservation reservation){
//        this(reservation.getReservdAt(), new UserDTO( reservation.getReservdBy()), new CustomerDTO(reservation.getReservedFor()), reservation.isCompleted(), reservation.getLastModified());
//    }
//}
