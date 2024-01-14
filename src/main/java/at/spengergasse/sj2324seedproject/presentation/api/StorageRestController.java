package at.spengergasse.sj2324seedproject.presentation.api;

import at.spengergasse.sj2324seedproject.domain.Storage;
import at.spengergasse.sj2324seedproject.persistence.StorageRepository;
import at.spengergasse.sj2324seedproject.presentation.api.dtos.StorageDTO;
import at.spengergasse.sj2324seedproject.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/storage")

public class StorageRestController {

    private final StorageService storageService;

@GetMapping
    public List<StorageDTO> fetchStorage(@RequestParam Optional<String> namePart){
        return storageService.fetchStorage(namePart)
                .stream()
                .map(StorageDTO::new)
                .toList();
    }
}
