package at.spengergasse.sj2324seedproject.presentation.www.storage;

import at.spengergasse.sj2324seedproject.domain.Storage;
import at.spengergasse.sj2324seedproject.foundation.ApiKeyGenerator;

import at.spengergasse.sj2324seedproject.presentation.www.reservations.EditReservationForm;
import at.spengergasse.sj2324seedproject.service.StorageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@Controller
@RequestMapping(StorageController.BASE_URL)
public class StorageController {

    protected static final String BASE_URL = "/storages";
    private final StorageService storageService;
    private final ApiKeyGenerator apiKeyGenerator;

    @GetMapping
    public String getStorages(Model model) {
        List<Storage> storages = storageService.fetchStorage(Optional.empty());
        model.addAttribute("storages", storages);

        return "storages/list";
    }



    @GetMapping("/new")
    public ModelAndView showNewStorageForm() {
        var mav = new ModelAndView();
        mav.addObject("form", new CreateStorageForm());
        mav.setViewName("storages/new");
        return mav;
    }


}