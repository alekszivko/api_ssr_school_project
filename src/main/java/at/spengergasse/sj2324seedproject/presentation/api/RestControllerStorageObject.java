//package at.spengergasse.sj2324seedproject.presentation.api;
//
//import at.spengergasse.sj2324seedproject.domain.StorageObject;
//import at.spengergasse.sj2324seedproject.persistence.PersistenceStorageObject;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api/storageObject")
//public class RestControllerStorageObject{
//
//    private final PersistenceStorageObject persistenceStorageObject;
//
//    @GetMapping
//    public List<StorageObject> storageObjectList(){
//        return persistenceStorageObject.findAll();
//    }
//
//}
