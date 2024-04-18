package at.spengergasse.sj2324seedproject.presentation.www.storageObjects;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import at.spengergasse.sj2324seedproject.domain.StorageObject;
import at.spengergasse.sj2324seedproject.foundation.ApiKeyGenerator;
import at.spengergasse.sj2324seedproject.service.ServiceStorageObject;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(ConstantsDomain.TEMPLATE_STOO_BASE)
public class ControllerStorageObject{

    @Autowired
    private final ServiceStorageObject serviceStorageObject;
    @Autowired
    private final ApiKeyGenerator apiKeyGenerator;

    @GetMapping
    public String getStorageObject(Model model){
        List<StorageObject> storageObjects = serviceStorageObject.fetchStorageObjectsList();
        String              randomKey      = apiKeyGenerator.getRandomKey(6);
        model.addAttribute("storageObjects",
                           storageObjects);

        return "storageObjects/list";
    }

    @GetMapping(ConstantsDomain.TEMPLATE_STOO_NEW)
    public ModelAndView showNewForm(){
        var miau = new ModelAndView();
        miau.addObject("form",
                       CreateStorageObjectForm.create());
        miau.setViewName("storageObjects/new");
        return miau;
    }

    @PostMapping(ConstantsDomain.TEMPLATE_STOO_NEW)
    public String handleNewFormSubmisson(@Valid
                                         @ModelAttribute(name = "form")
                                         CreateStorageObjectForm form,
                                         BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "storageObjects/new";
        }

        serviceStorageObject.createStorageObject(form.randomKey(),
                                                form.storage(),
                                                form.serialNr(),
                                                 form.mac(),
                                                 form.remark(),
                                                 form.projectDev(),
                                                 form.storedAtCu());

        // Redirect after post pattern / PRG pattern
//        List<StorageObject> storageObjects = serviceStorageObject.fetchStorageObjectsList();

        return "redirect:/storageObjects";
    }
}


