package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.domain.StorageObject;
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
}
