package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.domain.Customer;
import at.spengergasse.sj2324seedproject.domain.Reservation;
import at.spengergasse.sj2324seedproject.foundation.ApiKeyGenerator;
import at.spengergasse.sj2324seedproject.persistence.UserRepository;
import at.spengergasse.sj2324seedproject.persistence.reservations.ReservationRepository;
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
  private final ApiKeyGenerator idGenerator;
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
        .reservationId(idGenerator.getRandomKey(10))
        .reservedFor(Customer.builder().connectionNo(connectionNo).build()).build();
//        .reservationDescription(description).build();

    return reservationRepository.save(reservation);
  }

  public Optional<Reservation> getReservationByReservationID(String reservationID) {
    return reservationRepository.getReservationByReservationId(reservationID);
  }


}
