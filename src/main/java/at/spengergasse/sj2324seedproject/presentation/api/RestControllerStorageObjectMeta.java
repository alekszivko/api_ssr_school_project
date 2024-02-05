package at.spengergasse.sj2324seedproject.presentation.api;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import at.spengergasse.sj2324seedproject.presentation.api.dtos.StorageObjectMetaDTO;
import at.spengergasse.sj2324seedproject.service.ServiceStorageObjectMeta;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(ConstantsDomain.URL_BASE_STO_META)
public class RestControllerStorageObjectMeta{

    @Autowired
    private final ServiceStorageObjectMeta serviceStorageObjectMeta;


    @GetMapping
    public HttpEntity<List<StorageObjectMetaDTO>> fetchStorageObjectMeta(
            @RequestParam
            Optional<String> nameParam){
        return Optional.of(serviceStorageObjectMeta.fetchStoMeta(nameParam))
                       .filter(storageObjectMetas -> !storageObjectMetas.isEmpty())
                       .map(sto -> sto.stream()
                                      .map(StorageObjectMetaDTO::new)
                                      .toList())
                       .map(storageObjectMetaDTOS -> ResponseEntity.ok(storageObjectMetaDTOS))
                       .orElse(ResponseEntity.noContent()
                                             .build());
        /*
                       .filter(sto -> sto.getName()
                                         .contains(nameParam.get()))
                       .map(sto2 -> sto2.stream()
                                        .map(StorageObjectMetaDTO::new)
                                        .toList())
                       .map(storageObjectDTO -> ResponseEntity::ok (storageObjectMeta))
                                       .orElseGet(ResponseEntity.noContent()
                                                                .build());*/
        //        List<StorageObjectMetaDTO> result                = new ArrayList<>();
        //        List<StorageObjectMeta>    persStorageObjectMeta = serviceStorageObjectMeta.fetchStoMeta(nameParam);
        //        for(StorageObjectMeta stm: persStorageObjectMeta){
        //            StorageObjectMetaDTO stmDTO = new StorageObjectMetaDTO(stm);
        //            result.add(stmDTO);
        //        }
        //
        //        return result;
    }
}
