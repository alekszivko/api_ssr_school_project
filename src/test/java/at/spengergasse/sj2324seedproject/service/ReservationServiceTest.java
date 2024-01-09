package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.domain.Reservation;
import at.spengergasse.sj2324seedproject.persistence.ReservationRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assumptions.assumeThat;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    private ReservationService reservationService;

    private @Mock ReservationRepository reservationRepository;

    @BeforeEach
    void setup() {
        assumeThat(reservationRepository).isNotNull();
        reservationService = new ReservationService(reservationRepository);
    }


    @Test
    void ensureFetchReservationWithFetchAllworks() {
        //given
        Optional<String> searchCriteria = Optional.empty();
        var reservation = reservation()

    }
}