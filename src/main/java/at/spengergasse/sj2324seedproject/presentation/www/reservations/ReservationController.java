package at.spengergasse.sj2324seedproject.presentation.www.reservations;

import at.spengergasse.sj2324seedproject.presentation.api.reservations.ReservationDTO;
import at.spengergasse.sj2324seedproject.service.ReservationService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor

@Controller
@RequestMapping(ReservationController.BASE_URL)
public class ReservationController {

  protected static final String BASE_URL = "/reservations";
  private final ReservationService reservationService;

  @GetMapping
  public String getReservations(Model model) {
    List<ReservationDTO> reservations =
        reservationService.fetchReservations(Optional.empty()).stream().map(ReservationDTO::new)
            .toList();

    model.addAttribute("reservations", reservations);

    return "reservations/list";
  }

  @GetMapping("/edit/{id}")
  public String editReservation(@PathVariable String id, Model model) {
    return reservationService.getReservationByReservationID(
            id).map(EditReservationForm::create).map(form -> model.addAttribute("form", form)).map(_ ->
            "reservations/edit")
        .orElse("redirect:reservations");

  }

  @GetMapping("/delete/{id}")
  public String deleteReservation(@PathVariable String id) {
    reservationService.removeReservation(id);
    return "redirect:/reservations";
  }

  @GetMapping("/new")
  public ModelAndView showNewReservationForm() {
    var mav = new ModelAndView();
    mav.addObject("form", new CreateReservationForm());
    mav.setViewName("reservations/new");
    return mav;
  }

  @PostMapping("/edit/{id}")
  public String handleNewReservationFormSubmission(@PathVariable String id,
      @Valid @ModelAttribute(name = "form") EditReservationForm form,
      BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "reservations/new";
    }

    reservationService.updateReservation(id, form.description(),
        form.connectionNo());

    return "redirect:/reservations";
  }

}
