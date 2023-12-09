package at.spengergasse.sj2324seedproject.persistence;

import at.spengergasse.sj2324seedproject.domain.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryProducer extends JpaRepository<Producer, Long>{
    List<Producer> findProducerByName(Optional<String> namePart);
    List<Producer> findProducerByNameContainsIgnoreCase(Optional<String> name);

    List<Producer> findByName(Optional<String> nameParam);
    Producer findOneProducerByName(Optional<String> name);
    //    List<Producer> findAllByNameContainsIgnoreCase(String name);
}
