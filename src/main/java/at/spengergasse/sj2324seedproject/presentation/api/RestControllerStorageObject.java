package at.spengergasse.sj2324seedproject.presentation.api;

import at.spengergasse.sj2324seedproject.domain.StorageObject;
import at.spengergasse.sj2324seedproject.persistence.RepositoryStorageObject;
import at.spengergasse.sj2324seedproject.presentation.api.dtos.StorageObjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/storageObject")
public class RestControllerStorageObject{

    private final RepositoryStorageObject repositoryStorageObject;

    @GetMapping
    public List<StorageObjectDTO> storageObjectList(){
        return repositoryStorageObject.findAll().stream().map(StorageObjectDTO::new).toList();
    }



}
