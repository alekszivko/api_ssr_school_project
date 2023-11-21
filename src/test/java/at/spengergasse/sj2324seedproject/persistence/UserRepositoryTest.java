package at.spengergasse.sj2324seedproject.persistence;

import at.spengergasse.sj2324seedproject.domain.Customer;
import at.spengergasse.sj2324seedproject.domain.Profile;
import at.spengergasse.sj2324seedproject.domain.Role;
import at.spengergasse.sj2324seedproject.domain.User;
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
        User user = User.builder()
                .email("alex@alex.de")
                .password("testpassword")
                .role(Role.ORDERFULLFILLMENT)
                .createdAt(LocalDateTime.now())
                .lastLogin(LocalDateTime.now())
                .isActivated(true)
                .profile(Profile.builder()
                        .firstName("Alex")
                        .lastName("Alex")
                        .build())
                .build();

        //When
        var saved = userRepository.save(user);

        //Then
        assertThat(saved).isNotNull().isSameAs(user);
        assertThat(saved.getId()).isNotNull().isPositive();
        assertThat(saved.getProfile()).isNotNull();
    }
}