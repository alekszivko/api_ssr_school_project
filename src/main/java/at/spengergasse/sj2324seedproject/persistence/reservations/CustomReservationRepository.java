package at.spengergasse.sj2324seedproject.persistence.reservations;

import at.spengergasse.sj2324seedproject.domain.User;
import at.spengergasse.sj2324seedproject.persistence.reservations.ReservationProjections.ReservationUser;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CustomReservationRepository {

  List<ReservationUser> reservationsByDateAndOrUser(Optional<User> user,
      LocalDateTime localDateTime);
}
