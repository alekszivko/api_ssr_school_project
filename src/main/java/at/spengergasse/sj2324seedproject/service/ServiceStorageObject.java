package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.domain.Customer;
import at.spengergasse.sj2324seedproject.domain.Storage;
import at.spengergasse.sj2324seedproject.domain.StorageObject;
import at.spengergasse.sj2324seedproject.foundation.ApiKeyGenerator;
import at.spengergasse.sj2324seedproject.persistence.RepositoryStorageObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ServiceStorageObject{

    @Autowired
    private final RepositoryStorageObject repositoryStorageObject;
    @Autowired
    private final ApiKeyGenerator         apiKeyGenerator;

    public List<StorageObject> findAll(){
        return repositoryStorageObject.findAll();
    }

    public List<StorageObject> fetchStorageObjectsList(){
        return repositoryStorageObject.findAll();
    }

    public Stream<StorageObject> fetchStorageObjectsStream(Optional<String> searchParam){
        return repositoryStorageObject.findAll()
                                      .stream();
    }

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
        randomKey = apiKeyGenerator.getRandomKey(16);
        System.out.println(randomKey+"###############################################################################################");
        StorageObject storageObject = StorageObject.builder()
                                                   .apiKeyID(randomKey)
                                                   .storedStorage(storage.isEmpty() ? Storage.builder().name("Empty").build() : Storage.builder().name(storage).build())
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
}
