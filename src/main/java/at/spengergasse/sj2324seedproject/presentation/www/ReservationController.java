package at.spengergasse.sj2324seedproject.presentation.www;

import at.spengergasse.sj2324seedproject.domain.Reservation;
import at.spengergasse.sj2324seedproject.foundation.ApiKeyGenerator;
import at.spengergasse.sj2324seedproject.service.ReservationService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor

@Controller
@RequestMapping(ReservationController.BASE_URL)
public class ReservationController {

  protected static final String BASE_URL = "/reservations";
  private final ReservationService reservationService;
  private final ApiKeyGenerator apiKeyGenerator;

  @GetMapping
  public String getReservations(Model model) {
    List<Reservation> reservations = reservationService.fetchReservations(Optional.empty());
    model.addAttribute("reservations", reservations);

    return "reservations/list";
  }

}
