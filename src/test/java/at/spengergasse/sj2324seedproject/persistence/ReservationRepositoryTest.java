package at.spengergasse.sj2324seedproject.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import at.spengergasse.sj2324seedproject.domain.Customer;
import at.spengergasse.sj2324seedproject.domain.Reservation;
import at.spengergasse.sj2324seedproject.domain.User;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.utility.TestcontainersConfiguration;


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
    reservation.setReservationId("R123456789");
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
    assertThat(reservationRepository.getReservationsByReservedBy_UserId(userID)).isNotNull();
    assertThat(reservationRepository.getReservationsByReservedBy_UserId(userID)).contains(
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
}