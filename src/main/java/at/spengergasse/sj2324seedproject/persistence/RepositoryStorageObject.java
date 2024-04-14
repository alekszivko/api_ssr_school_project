package at.spengergasse.sj2324seedproject.persistence;

import at.spengergasse.sj2324seedproject.domain.StorageObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryStorageObject extends JpaRepository<StorageObject, Long>{
    StorageObject findAllByMacAddress(String mac);

    StorageObject findStorageObjectByMacAddress(Optional<String> mac);

    StorageObject findByMacAddressContaining(Optional<String> mac);
}
