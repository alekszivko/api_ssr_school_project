package at.spengergasse.sj2324seedproject.persistence;

import at.spengergasse.sj2324seedproject.domain.StorageObjectMeta;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.utility.TestcontainersConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestcontainersConfiguration.class)
public class PersistenceStorageObjectMetaTest{

    @Autowired
    private PersistenceStorageObjectMeta repository;

    //    @Autowired
    //    private ServiceStorageObjectMeta serviceRepo;

    @Test
    void ensure_save_storageObjectMeta_into_DB(){

        //given
        StorageObjectMeta storageObjectMeta = FixtureFactory.give_me_a_storageObjectMeta1();


        //when
        var saved = repository.saveAndFlush(storageObjectMeta);

        //then
        assertThat(repository.findById(saved.getId()).get()).isSameAs(storageObjectMeta);
        //        assertThat(repository.findById(Objects.requireNonNull(storageObjectMeta.getId()))).isNotNull();
        //        assertThat(repository.findById(storageObjectMeta.getId()).get()).isSameAs(storageObjectMeta);
    }


}