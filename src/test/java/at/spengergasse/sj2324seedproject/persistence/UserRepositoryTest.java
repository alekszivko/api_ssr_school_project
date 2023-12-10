package at.spengergasse.sj2324seedproject.persistence;

import at.spengergasse.sj2324seedproject.domain.Customer;
import at.spengergasse.sj2324seedproject.domain.Profile;
import at.spengergasse.sj2324seedproject.domain.Role;
import at.spengergasse.sj2324seedproject.domain.User;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void ensureSaveAndReadWorks() {
        //Given
        User userGiven = FixtureFactory.userFixture();

        //When
        var saved = userRepository.save(userGiven);

        //Then
        assertThat(saved).isNotNull().isSameAs(userGiven);
        assertThat(saved.getId()).isNotNull().isPositive();
        assertThat(saved.getProfile()).isNotNull();
        assertThat(userGiven.getProfile()).isEqualTo(saved.getProfile());
    }
}