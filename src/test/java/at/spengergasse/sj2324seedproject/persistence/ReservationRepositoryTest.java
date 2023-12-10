package at.spengergasse.sj2324seedproject.persistence;

import at.spengergasse.sj2324seedproject.domain.*;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.utility.TestcontainersConfiguration;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Import(TestcontainersConfiguration.class)
class ReservationRepositoryTest{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReservationRepository reservationRepository;


    @Test
    void ensureSaveAndReadworks() {
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
}