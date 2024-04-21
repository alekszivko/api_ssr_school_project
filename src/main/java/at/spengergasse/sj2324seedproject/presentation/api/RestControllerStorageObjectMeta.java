package at.spengergasse.sj2324seedproject.presentation.api;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import at.spengergasse.sj2324seedproject.domain.StorageObjectMeta;
import at.spengergasse.sj2324seedproject.exceptions.StorageObjectMetaAlreadyExistsException;
import at.spengergasse.sj2324seedproject.presentation.api.commands.CommandStorageObjectMeta;
import at.spengergasse.sj2324seedproject.presentation.api.dtos.StorageObjectDTO;
import at.spengergasse.sj2324seedproject.presentation.api.dtos.StorageObjectMetaDTO;
import at.spengergasse.sj2324seedproject.service.ServiceStorageObjectMeta;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngineResult;
import java.net.URI;
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

    @GetMapping(ConstantsDomain.URL_BASE_STO_META_NAME)
    public ResponseEntity<StorageObjectMetaDTO> fetchStorageObjectMeta(String name){
        if(name == null){
            throw new NullPointerException("Given String is null!!!");
        }

        StorageObjectMeta storageObjectMeta = serviceStorageObjectMeta.findStorageObjectMeta(name);


        URI         location        = URI.create(ConstantsDomain.URL_BASE_STO_META+ConstantsDomain.URL_BASE_STO_META_NAME);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        responseHeaders.set("Test Header 1",
                            HttpHeaders.ACCEPT);


        if(storageObjectMeta == null){
            //            headers.set();
            responseHeaders.set("Test Header 2",
                                HttpHeaders.IF_NONE_MATCH);
            ResponseEntity<StorageObjectMetaDTO> entity = new ResponseEntity<>(responseHeaders,
                                                                               HttpStatus.NO_CONTENT);
            return entity;
        }

        StorageObjectMetaDTO storageObjectMetaDTO = new StorageObjectMetaDTO(storageObjectMeta);


        ResponseEntity<StorageObjectMetaDTO> entity = new ResponseEntity<>(storageObjectMetaDTO,
                                                                           responseHeaders,
                                                                           HttpStatus.OK);
        return entity;
    }

    @PostMapping
    public ResponseEntity<StorageObjectMetaDTO> createStoMeta(
            @RequestBody
            @Valid CommandStorageObjectMeta cmdMeta){
        StorageObjectMeta storageMeta = serviceStorageObjectMeta.saveStorageMeta(cmdMeta.type(),
                                                                                 cmdMeta.name(),
                                                                                 cmdMeta.osVersion(),
                                                                                 cmdMeta.consumablesPerBox(),
                                                                                 cmdMeta.sfpType(),
                                                                                 cmdMeta.waveLength(),
                                                                                 cmdMeta.interfaceSpeed());

        URI uri = URI.create("%s, %s".formatted(ConstantsDomain.URL_BASE_STO_META,
                                                storageMeta.getId()));

        return ResponseEntity.created(uri)
                             .body(new StorageObjectMetaDTO(storageMeta));
    }

    @ExceptionHandler(StorageObjectMetaAlreadyExistsException.class) //sobald dieser Excep.Handl. mehrmals gebraucht wird, rausziehen damit es mehrmals genutzt werden kann.
    public HttpEntity<ProblemDetail> StoMetaAlreadyExistsException(StorageObjectMetaAlreadyExistsException meta){

        HttpStatus status = HttpStatus.CONFLICT;
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status,
                                                                       meta.getMessage());
        problemDetail.setTitle("MetaData");
        problemDetail.setProperty("StorageObjectMeta",
                                  meta.getStackTrace());
        return ResponseEntity.status(status)
                             .body(problemDetail);
    }
}
