package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.domain.StorageObjectMeta;
import at.spengergasse.sj2324seedproject.persistence.PersistenceStorageObjectMeta;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class ServiceStorageObjectMeta{

    @Autowired
    private PersistenceStorageObjectMeta repository;


    public StorageObjectMeta saveStorageMeta(StorageObjectMeta storageObjectMeta){
        return repository.save(storageObjectMeta);
    }

}
