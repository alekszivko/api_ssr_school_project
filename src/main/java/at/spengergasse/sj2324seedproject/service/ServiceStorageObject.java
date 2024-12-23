package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import at.spengergasse.sj2324seedproject.domain.Customer;
import at.spengergasse.sj2324seedproject.domain.Storage;
import at.spengergasse.sj2324seedproject.domain.StorageObject;
import at.spengergasse.sj2324seedproject.foundation.ApiKeyGenerator;
import at.spengergasse.sj2324seedproject.persistence.RepositoryStorageObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class ServiceStorageObject{

    private final RepositoryStorageObject repositoryStorageObject;
    private final ApiKeyGenerator         apiKeyGenerator;

    @Transactional(readOnly = true)
    public List<StorageObject> findAll(){
        return repositoryStorageObject.findAll();
    }

    @Transactional(readOnly = true)
    public List<StorageObject> fetchStorageObjectsList(){
        return repositoryStorageObject.findAll();
    }

    @Transactional(readOnly = true)
    public Stream<StorageObject> fetchStorageObjectsStream(Optional<String> searchParam){
        return repositoryStorageObject.findAll()
                                      .stream();
    }

    @Transactional(readOnly = true)
    public Optional<StorageObject> findStorageObjectByMac(Optional<String> macAddress){
        return Optional.ofNullable(repositoryStorageObject.findStorageObjectByMacAddress(macAddress));
    }

    public StorageObject findStorageObjectMac(Optional<String> mac){

        return repositoryStorageObject.findByMacAddressContaining(mac);
    }

    public void createStorageObject(String randomKey,
                                    String storage,
                                    String serial,
                                    String mac,
                                    String remark,
                                    String project,
                                    String storedAtCu){
        apiKeyGenerator.getRandomKey(16);
        System.out.println(randomKey+" ###############################################################################################");
        StorageObject storageObject = StorageObject.builder()
                                                   .apiKeyID(randomKey = apiKeyGenerator.getRandomKey(16))
                                                   .storedStorage(storage.isEmpty() ? Storage.builder()
                                                                                             .name("Empty")
                                                                                             .build() : Storage.builder()
                                                                                                               .name(storage)
                                                                                                               .build())
                                                   .serialNumber(serial.isEmpty() ? "Empty" : serial)
                                                   .macAddress(mac.isEmpty() ? "Empty" : mac)
                                                   .remark(mac.isEmpty() ? "Empty" : remark)
                                                   .projectDevice(!project.isEmpty() ? true : false)
                                                   .storedAtCustomer(Customer.builder()
                                                                             .connectionNo(storedAtCu.isEmpty() ? "No Customer" : storedAtCu)
                                                                             .build())
                                                   .build();
        repositoryStorageObject.save(storageObject);
    }


    public void delete(String key){
       /* Example<StorageObject> stooExamp = Example.of(StorageObject.builder()
                                                                   .apiKeyID(key)
                                                                   .build());
        Optional<StorageObject> one = repositoryStorageObject.findOne(stooExamp);

        if(one.isPresent()){
            repositoryStorageObject.deleteById(one.get().getId());
        }*/
        repositoryStorageObject.deleteStorageObjectByApiKeyID(key);
    }

    @Transactional(readOnly = true)
    public Optional<StorageObject> getStorageObjectByKey(String key){
        return repositoryStorageObject.findStorageObjectByApiKeyID(key);
    }

    public StorageObject updateStorageObject(String apiKey,
                                    String storage,
                                    String serialNr,
                                    String mac,
                                    String remark,
                                    String projectDev,
                                    String storedAtCu){
      return  repositoryStorageObject.findStorageObjectByApiKeyID(apiKey)
                               .map(sto -> {
                                   sto.setApiKeyID(apiKey);
                                   sto.setStoredStorage(Storage.builder()
                                                               .name(storage)
                                                               .build());
                                   sto.setSerialNumber(serialNr);
                                   sto.setMacAddress(mac);
                                   sto.setRemark(remark);
                                   sto.setProjectDevice(!projectDev.isEmpty());
                                   sto.setStoredAtCustomer(Customer.builder().connectionNo(storedAtCu).build());
                               return sto;
                               }).orElseThrow(() -> new IllegalArgumentException("StorageObject with key %s doesnt exist in DB".formatted(apiKey)));
/*        repositoryStorageObject.save(StorageObject.builder()
                                                  .apiKeyID(apiKey)
                                                  .storedStorage(Storage.builder()
                                                                        .name(storage)
                                                                        .build())
                                                  .serialNumber(serialNr)
                                                  .macAddress(mac)
                                                  .remark(remark)
                                                  .projectDevice(!projectDev.isEmpty())
                                                  .storedAtCustomer(Customer.builder()
                                                                            .connectionNo(storedAtCu.isEmpty() ? "No Customer" : storedAtCu)
                                                                            .build())
                                                  .build());*/
    }

    public Stream<StorageObject> searchFind(String search){
        search = ConstantsDomain.P+search.toString()+ConstantsDomain.P;
        List<StorageObject> storageObjects = repositoryStorageObject.searchStoo(search.toString());
        return storageObjects.stream();
    }
}
