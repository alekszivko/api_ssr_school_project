package at.spengergasse.sj2324seedproject.persistence;

import at.spengergasse.sj2324seedproject.domain.StorageObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryStorageObject extends JpaRepository<StorageObject, Long>{
}
