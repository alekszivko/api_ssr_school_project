package at.spengergasse.sj2324seedproject.presentation.api.reservations;

import at.spengergasse.sj2324seedproject.domain.Reservation;
import at.spengergasse.sj2324seedproject.service.ReservationService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping(ReservationRestController.BASE_URL)
public class ReservationRestController {

  protected static final String BASE_URL = "/api/reservations";
  private final ReservationService reservationService;

  @GetMapping
  public ResponseEntity<List<ReservationDTO>> fetchReservations(
      @RequestParam Optional<Boolean> completed) {

    List<Reservation> reservations = reservationService.fetchReservations(completed);

    return (!reservations.isEmpty())
        ? ResponseEntity.ok().body(reservations.stream().map(ReservationDTO::new).toList())
        : ResponseEntity.noContent().build();
  }

  @PostMapping
  public ResponseEntity<ReservationDTO> createReservation(
      @RequestBody @Valid CreateReservationCommand createReservationCmd) {
    Reservation reservation = reservationService.createReservation(
        createReservationCmd.reservationDescription(),
        createReservationCmd.customerConnectionNo());

    URI location = URI.create("%s/%s".formatted(BASE_URL, reservation.getReservationId()));

    return ResponseEntity.created(location).body(new ReservationDTO(reservation));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ReservationDTO> getReservation(@PathVariable String id) {
    return reservationService.getReservationByReservationID(id)
        .map(ReservationDTO::new)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

}
