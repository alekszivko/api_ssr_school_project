package at.spengergasse.sj2324seedproject.persistence;

import at.spengergasse.sj2324seedproject.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;
//
//
//    @Test
//    void ensureSaveAndReadworks() {
//        Reservation reservation = Reservation.builder()
//                .reservdBy(User.builder()
//                        .email("alex@alex.de")
//                        .isActivated(true)
//                        .role(Role.ORDERFULLFILLMENT)
//                        .createdAt(LocalDateTime.now())
//                        .password("cleartext")
//                        .lastLogin(LocalDateTime.now())
//                        .profile(Profile.builder()
//                                .phone("+4369912345678")
//                                .username("xela")
//                                .lastName("ziv")
//                                .firstName("alex")
//                                .build())
//                        .build())
//                .reservationDescription("Testdescription")
//                .lastModified(LocalDateTime.now())
//                .reservdAt(LocalDateTime.now())
//                .reservedFor(Customer.builder().connectionNo(1231201310).build())
//                .completed(false)
//                .build();
//
//        var saved = reservationRepository.save(reservation);
//
//        assertThat(saved).isNotNull();
//        assertThat(saved).isEqualTo(reservation);
////        assertThat(saved.getReservdBy()).isNotNull();
//        assertThat(saved.getReservedFor()).isNotNull();
//    }
}