package at.spengergasse.sj2324seedproject.persistence;

import at.spengergasse.sj2324seedproject.domain.Customer;
import at.spengergasse.sj2324seedproject.domain.Reservation;
import at.spengergasse.sj2324seedproject.domain.User;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import at.spengergasse.sj2324seedproject.persistence.reservations.ReservationProjections.ReservationUser;
import at.spengergasse.sj2324seedproject.persistence.reservations.ReservationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@Import(TestcontainersConfiguration.class)
class ReservationRepositoryTest {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private ReservationRepository reservationRepository;


  @Test
  void ensureSaveAndReadWorks() {
    //Given
    User userGiven = FixtureFactory.userFixture();
    var userSaved = userRepository.save(userGiven);
    Reservation reservationGiven = FixtureFactory.reservationFixture(userSaved);

    //When
    var reservationSaved = reservationRepository.save(reservationGiven);

    //Then
    assertThat(reservationSaved).isNotNull();
    assertThat(reservationSaved).isEqualTo(reservationGiven);
    assertThat(reservationSaved.getReservedBy()).isNotNull();
    assertThat(reservationSaved.getReservedFor()).isNotNull();
  }

  @Test
  void ensureReservationIDExistsWorks() {
    //Given
    Reservation reservation = FixtureFactory.reservationFixture(FixtureFactory.userFixture());
    reservation.setReservedFor(Customer.builder().connectionNo("1234919").build());
    //When
    reservationRepository.save(reservation);
    //Then
    assertThat(
            reservationRepository.existsByReservationId(
                    reservation.getReservationId())).isTrue();
    assertThat(
            reservationRepository.existsByReservationId("12312312312312")).isFalse();
  }

  @Test
  void ensureGetReservationByReservedBy_IdWorks() {
    //Given
    User userGiven = FixtureFactory.userFixture();
    Reservation reservationGiven = FixtureFactory.reservationFixture(userGiven);
    String userID = reservationRepository.save(reservationGiven).getReservedBy().getUserId();
    //When
    var reservationSaved = reservationRepository.save(reservationGiven);
    //Then
    org.assertj.core.api.Assertions.assertThat(reservationRepository.getReservationsByReservedBy_UserId(userID)).isNotNull();
    org.assertj.core.api.Assertions.assertThat(reservationRepository.getReservationsByReservedBy_UserId(userID)).contains(
            reservationSaved);
  }

  @Test
  void ensureGetReservationByReservationIdWorks() {
    //Given
    Reservation reservationGiven = FixtureFactory.reservationFixture(FixtureFactory.userFixture());
    var reservationID = reservationRepository.save(reservationGiven).getReservationId();
    //When
    var reservationSaved = reservationRepository.save(reservationGiven);
    //Then
    assertThat(reservationRepository.getReservationByReservationId(reservationID)).isNotNull();
    assertThat(reservationRepository.getReservationByReservationId(reservationID))
            .isEqualTo(Optional.of(reservationGiven));
  }

  @Test
  void ensureGetReservationsByCompletedWorks() {
    //Given

    Reservation reservationGiven = FixtureFactory.reservationFixture();

    //When

    var reservationSaved = reservationRepository.save(reservationGiven);

    //Then

    assertThat(reservationSaved).isNotNull();
    assertThat(reservationSaved.isCompleted()).isEqualTo(reservationGiven.isCompleted());
  }

  @Test
  void ensureReservationsByDateAndOrUserWorks() {
    Reservation reservation = FixtureFactory.reservationFixture();
    reservationRepository.saveAndFlush(reservation);
    reservationRepository.reservationsByDateAndOrUser(Optional.of(reservation.getReservedBy()),
                                                      LocalDateTime.now().minusDays(20));

  }

  @Test
  void ensureResrvationsByDateAndOrUserWorksWithDateOnly() {
    //Given
    Reservation reservation2 = FixtureFactory.reservationFixture();
    reservation2.setReservedAt(LocalDateTime.now().minusDays(100));

    var savedReservation = reservationRepository.saveAndFlush(FixtureFactory.reservationFixture());
    ReservationUser reservationUser = new ReservationUser(savedReservation.getReservationId(),
                                                          savedReservation.getReservedAt(), savedReservation.getReservedFor(),
                                                          savedReservation.getReservationDescription());
    var savedReservation2 = reservationRepository.saveAndFlush(reservation2);
    ReservationUser reservationUser2 = new ReservationUser(savedReservation2.getReservationId(),
                                                           savedReservation2.getReservedAt(), savedReservation2.getReservedFor(),
                                                           savedReservation2.getReservationDescription());

    //When

    var reservations = reservationRepository.reservationsByDateAndOrUser(Optional.empty(),
                                                                         LocalDateTime.now().minusDays(20));

    //Then

    Assertions.assertTrue(reservations.contains(reservationUser));
    Assertions.assertFalse(reservations.contains(reservationUser2));

  }
}