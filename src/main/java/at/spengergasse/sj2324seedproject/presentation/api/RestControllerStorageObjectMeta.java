package at.spengergasse.sj2324seedproject.presentation.api;

import at.spengergasse.sj2324seedproject.domain.StorageObjectMeta;
import at.spengergasse.sj2324seedproject.presentation.api.dtos.StorageObjectMetaDTO;
import at.spengergasse.sj2324seedproject.service.ServiceStorageObjectMeta;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/storageObjectMeta")
public class RestControllerStorageObjectMeta{

    private final ServiceStorageObjectMeta serviceStorageObjectMeta;

    @GetMapping
    public List<StorageObjectMetaDTO> fetchStorageObjectMeta(@RequestParam Optional<String> nameParam){
        List<StorageObjectMetaDTO> result                = new ArrayList<>();
        List<StorageObjectMeta>    persStorageObjectMeta = serviceStorageObjectMeta.fetchStoMeta(nameParam);
        for(StorageObjectMeta stm: persStorageObjectMeta){
            StorageObjectMetaDTO stmDTO = new StorageObjectMetaDTO(stm);
            result.add(stmDTO);
        }

        return result;
    }
}
