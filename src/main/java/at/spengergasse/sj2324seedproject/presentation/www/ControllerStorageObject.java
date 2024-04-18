package at.spengergasse.sj2324seedproject.presentation.www;

import at.spengergasse.sj2324seedproject.domain.StorageObject;
import at.spengergasse.sj2324seedproject.service.ServiceStorageObject;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/storageObjects")
public class ControllerStorageObject{

    @Autowired
    private final ServiceStorageObject serviceStorageObject;

    @GetMapping
    public String getStorageObject(Model model){
        List<StorageObject> storageObjects = serviceStorageObject.fetchStorageObjectsList();
        model.addAttribute("storageObjects", storageObjects);
        return "storageObject/list";
    }

    @GetMapping("/new")
    public ModelAndView showNewForm(Model model){
        var modelAndView = new ModelAndView();
        modelAndView.addObject("form", new CreateStorageObjectForm());
        modelAndView.setViewName("storageObject/new");
        return modelAndView;
    }

    @PostMapping("/new")
    public String handleNewFormSubmisson(Model model, @Valid CreateStorageObjectForm createStorageObjectForm){
        model.addAttribute("form", new CreateStorageObjectForm());
        return "storageObject/new";
    }
}


