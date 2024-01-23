package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.domain.Customer;
import at.spengergasse.sj2324seedproject.domain.Reservation;
import at.spengergasse.sj2324seedproject.foundation.IdGenerator;
import at.spengergasse.sj2324seedproject.persistence.ReservationRepository;
import at.spengergasse.sj2324seedproject.persistence.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
public class ReservationService {

  private final ReservationRepository reservationRepository;
  private final IdGenerator idGenerator;
  private final UserRepository userRepository;


  public List<Reservation> fetchReservations(Optional<Boolean> completed) {
    return completed.map(reservationRepository::getReservationsByCompleted)
        .orElseGet(reservationRepository::findAll);


  }

  public List<Reservation> getReservationByUserID(String userId) {
    return reservationRepository.getReservationsByReservedBy_UserId(userId);
  }

  @Transactional
  public Reservation createReservation(String description, String connectionNo) {
    Reservation reservation = Reservation.builder()
        .reservationId(idGenerator.getRandomID(10, "R"))
        .reservedFor(Customer.builder().connectionNo(connectionNo).build())
        .reservationDescription(description).build();

    return reservationRepository.save(reservation);
  }

  public Optional<Reservation> getReservationByReservationID(String reservationID) {
    return reservationRepository.getReservationByReservationId(reservationID);
  }


}
