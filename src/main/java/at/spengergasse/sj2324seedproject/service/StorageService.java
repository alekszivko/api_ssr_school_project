package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.domain.Storage;
import at.spengergasse.sj2324seedproject.persistence.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@Service

public class StorageService {

    private final StorageRepository repository;

    public List<Storage> fetchStorage(Optional<String> namePart){
        return namePart.map(repository::findAllByNameContainingIgnoreCase)
                .orElseGet(repository::findAll);
    }
}
