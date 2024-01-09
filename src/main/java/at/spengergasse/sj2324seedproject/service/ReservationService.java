package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.domain.Reservation;
import at.spengergasse.sj2324seedproject.persistence.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;


    public List<Reservation> fetchAll(){

        return reservationRepository.findAll();
    }

    public Reservation getReservation(Long reservationId) {
        return reservationRepository.findAllById(reservationId); //TODO change to uniqueID
    }

}
