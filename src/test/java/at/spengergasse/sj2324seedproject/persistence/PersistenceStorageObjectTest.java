package at.spengergasse.sj2324seedproject.persistence;

import at.spengergasse.sj2324seedproject.domain.StorageObject;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
public class PersistenceStorageObjectTest{

    @Autowired
    private PersistenceStorageObject repository;

    @Test
    void ensure_save_storageOBject_into_DB(){

        //given
        StorageObject storageObject  = FixtureFactory.give_me_a_storageObject1();
        StorageObject storageObject2 = FixtureFactory.give_me_a_storageObject2();

        //when
        var saved  = repository.saveAndFlush(storageObject);
        var saved2 = repository.save(storageObject);


        //then
        //        assertThat(repository.findById(saved.getId()).get()).isSameAs(storageObject);
//        System.out.println(repository.findById(storageObject2.getId()));
        assertThat(repository.findById(Objects.requireNonNull(saved2.getId())).get()).isSameAs(storageObject);
    }

}
