package at.spengergasse.sj2324seedproject.presentation.www.storages;

import at.spengergasse.sj2324seedproject.domain.Storage;
import at.spengergasse.sj2324seedproject.service.StorageService;
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
@RequestMapping(StorageController.BASE_URL)
public class StorageController {

  protected static final String BASE_URL = "/storages";
  private final StorageService storageService;

  @GetMapping
  public String getStorages(Model model) {
    List<Storage> storages = storageService.fetchStorage(Optional.empty());
    model.addAttribute("storages", storages);

    return "storages/list";
  }


  @GetMapping("/new")
  public ModelAndView showNewStorageForm() {
    var mav = new ModelAndView();
    mav.addObject("form", CreateStorageForm.create());
    mav.setViewName("create");
    return mav;
  }

  @PostMapping("/new")
  public String handleNewStorageFormSubmission(
      @Valid @ModelAttribute(name = "form") CreateStorageForm form,
      BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "storages/new";
    }

    storageService.createStorage(form.name(), form.street(), form.number(),
        form.addressAddition(), form.zipcode(), form.city());
    return "redirect:/storages";
  }


  @GetMapping("/edit/{id}")
  public String editStorage(@PathVariable Long id, Model model) {
    return storageService.getStorageById(
                                 id).map(EditStorageForm::create).map(form -> model.addAttribute("form", form)).map(_ ->
                                                                                                                            "storages/edit")
                         .orElse("redirect:reservations");
  }
  @PostMapping("/edit/{id}")
  public String handleNewStorageFormSubmission(@PathVariable Long id,
      @Valid @ModelAttribute(name = "form") EditStorageForm form,
      BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "redirect:/storage/{id}";
    }

    storageService.updateStorage(form.id(), form.name(), form.addressAddition(), form.street(),
        form.number(), form.zipcode(), form.city());

    return "redirect:/storages";
  }

  @GetMapping("/delete/{id}")
  public String deleteStorage(@PathVariable Long id) {
    storageService.removeStorage(id);
    return "redirect:/storages";
  }


}