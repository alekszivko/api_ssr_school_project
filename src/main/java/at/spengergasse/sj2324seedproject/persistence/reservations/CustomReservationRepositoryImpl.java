package at.spengergasse.sj2324seedproject.persistence.reservations;

import at.spengergasse.sj2324seedproject.domain.QReservation;
import at.spengergasse.sj2324seedproject.domain.Reservation;
import at.spengergasse.sj2324seedproject.domain.User;
import at.spengergasse.sj2324seedproject.persistence.reservations.ReservationProjections.ReservationUser;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;


public class CustomReservationRepositoryImpl extends QuerydslRepositorySupport implements
    CustomReservationRepository {

  private static final QReservation reservation = QReservation.reservation;


  public CustomReservationRepositoryImpl() {
    super(Reservation.class);
  }

  @Override
  public List<ReservationUser> reservationsByDateAndOrUser(
      Optional<User> user,
      @NotBlank LocalDateTime fromDateTime) {
    return
        user.map(c -> from(reservation).where(
                    reservation.reservedBy.in(user.get()).and(reservation.reservdAt.after(fromDateTime)))
                .fetch().stream().map(
                    res -> new ReservationUser(res.getReservationId(), res.getReservdAt(),
                        res.getReservedFor(), res.getReservationDescription())).toList())
            .orElse(from(reservation).where(
                reservation.reservdAt.after(fromDateTime)).fetch().stream().map(
                res -> new ReservationUser(res.getReservationId(), res.getReservdAt(),
                    res.getReservedFor(), res.getReservationDescription())).toList());
  }
}
