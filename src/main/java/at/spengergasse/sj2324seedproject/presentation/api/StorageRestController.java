package at.spengergasse.sj2324seedproject.presentation.api;

import at.spengergasse.sj2324seedproject.domain.Storage;
import at.spengergasse.sj2324seedproject.exceptions.DataQualityException;
import at.spengergasse.sj2324seedproject.persistence.StorageRepository;
import at.spengergasse.sj2324seedproject.presentation.api.dtos.StorageDTO;
import at.spengergasse.sj2324seedproject.service.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j

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

    @ExceptionHandler(DataQualityException.class)
    public HttpEntity<Void> handleDataQualityException(DataQualityException dqEx) {
        log.warn("An DataQualityException occured because of: {}", dqEx.getMessage());
        return ResponseEntity.internalServerError().build();
    }
}
