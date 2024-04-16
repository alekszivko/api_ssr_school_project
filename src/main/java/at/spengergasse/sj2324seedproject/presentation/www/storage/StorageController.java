package at.spengergasse.sj2324seedproject.presentation.www.storage;

import at.spengergasse.sj2324seedproject.domain.Storage;
import at.spengergasse.sj2324seedproject.foundation.ApiKeyGenerator;
import at.spengergasse.sj2324seedproject.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}