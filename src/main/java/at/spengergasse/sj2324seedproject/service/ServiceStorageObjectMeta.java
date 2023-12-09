package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.domain.StorageObjectMeta;
import at.spengergasse.sj2324seedproject.persistence.RepositoryStorageObjectMeta;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class ServiceStorageObjectMeta{

    @Autowired
    private RepositoryStorageObjectMeta repositoryStorageObjectMeta;


    public StorageObjectMeta saveStorageMeta(StorageObjectMeta storageObjectMeta){

        return repositoryStorageObjectMeta.save(storageObjectMeta);
    }

    public List<StorageObjectMeta> fetchStoMeta(Optional<String> nameParam){
        List<StorageObjectMeta> storageObjectMetaList = new ArrayList<>();

        if(nameParam.isPresent()){
            List<StorageObjectMeta> stoMetaList = repositoryStorageObjectMeta.findAll();
            for(StorageObjectMeta stm : stoMetaList){
                String tempName = nameParam.get().toUpperCase();
                String stmUpper = stm.getName().toUpperCase();
                if(stmUpper.contains(tempName)){
                    storageObjectMetaList.add(stm);
                }
            }
            
            if(storageObjectMetaList.isEmpty()){
                return repositoryStorageObjectMeta.findAll();
            }
            return storageObjectMetaList;
        }
        return repositoryStorageObjectMeta.findAll();
    }
}
