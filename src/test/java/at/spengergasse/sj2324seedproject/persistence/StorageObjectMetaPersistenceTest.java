package at.spengergasse.sj2324seedproject.persistence;

import at.spengergasse.sj2324seedproject.domain.StorageObjectMeta;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StorageObjectMetaPersistenceTest{

    @Autowired
    private StorageObjectMetaPersistence repository;

    @Test

    void ensure_saveing_storageObject_into_DB(){
        //given
        StorageObjectMeta storageObjectMeta = FixtureFactory.give_me_a_storageObject1();


        //when
        var saved = repository.saveAndFlush(storageObjectMeta);

        //then
        assertThat(saved.getId()).isSameAs(storageObjectMeta.getId());
        assertThat(repository.findById(storageObjectMeta.getId())).isNotNull();
    }
}