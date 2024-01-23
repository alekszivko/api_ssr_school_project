package at.spengergasse.sj2324seedproject.service;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import at.spengergasse.sj2324seedproject.domain.Reservation;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import at.spengergasse.sj2324seedproject.foundation.IdGenerator;
import at.spengergasse.sj2324seedproject.persistence.ReservationRepository;
import at.spengergasse.sj2324seedproject.persistence.UserRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

  private ReservationService reservationService;

  private @Mock ReservationRepository reservationRepository;
  private @Mock UserRepository userRepository;
  private @Mock IdGenerator idGenerator;

  @BeforeEach
  void setup() {
    assumeThat(reservationRepository).isNotNull();
    assumeThat(idGenerator).isNotNull();
    assumeThat(userRepository).isNotNull();
    this.reservationService = new ReservationService(reservationRepository, idGenerator,
        userRepository);
  }

  @Test
  void ensureFetchReservationWithoutParamCallsFindAll() {
    //Given

    Optional<Boolean> isCompleted = Optional.empty();

    var reservation = FixtureFactory.reservationFixture();

    when(reservationRepository.findAll()).thenReturn(List.of(reservation));

    //When

    var result = reservationService.fetchReservations(isCompleted);

    //Then
    verify(reservationRepository, times(1)).findAll();

  }

  @Test
  void ensureGetReservationsByUserIdWorks() {
    //given
    String userId = "23sdf";
    var reservation = FixtureFactory.reservationFixture();
    when(reservationRepository.getReservationsByReservedBy_UserId(userId))
        .thenReturn(List.of(reservation));

    //when
    var result = reservationService.getReservationByUserID(userId);
    //then
    assertThat(result).containsExactly(reservation);
    verify(reservationRepository, times(1)).getReservationsByReservedBy_UserId(userId);
  }

  @Test
  void ensureGetReservationByReservationIdWorks() {
    //given
    Reservation reservation = FixtureFactory.reservationFixture();
    when(reservationRepository.getReservationByReservationId(
        reservation.getReservationId())).thenReturn(Optional.of(reservation));

    //when
    var result = reservationService.getReservationByReservationID(reservation.getReservationId());

    //then

    assertThat(result).contains(reservation);
    assertThat(result).contains(reservation);
  }

  @Test
  void ensureFetchReservationsWorks() {
    //given
    var reservation = FixtureFactory.reservationFixture();
    when(reservationRepository.findAll()).thenReturn(List.of(reservation));
    //when
    var result = reservationService.fetchReservations(Optional.empty());
    //then
    assertThat(result).containsExactly(reservation);
    verify(reservationRepository, times(1)).findAll();
  }
}