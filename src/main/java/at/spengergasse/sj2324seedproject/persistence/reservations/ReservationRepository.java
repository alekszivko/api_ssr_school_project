package at.spengergasse.sj2324seedproject.persistence.reservations;

import at.spengergasse.sj2324seedproject.domain.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>,
    CustomReservationRepository {

  boolean existsByReservationId(String resID);

  List<Reservation> getReservationsByReservedBy_UserId(String userId);

  Optional<Reservation> getReservationByReservationId(String reservationId);

  List<Reservation> getReservationsByCompleted(Boolean completed);

  void deleteByReservationId(String reservationId);

}
