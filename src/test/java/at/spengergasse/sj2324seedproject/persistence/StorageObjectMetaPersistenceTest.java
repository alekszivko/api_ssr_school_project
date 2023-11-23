package at.spengergasse.sj2324seedproject.persistence;

import at.spengergasse.sj2324seedproject.TestSj2324SeedprojectApplication;
import at.spengergasse.sj2324seedproject.databaseOrcl.DatabaseORCL;
import at.spengergasse.sj2324seedproject.domain.StorageObjectMeta;
import at.spengergasse.sj2324seedproject.exceptions.ExceptionOrcl;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StorageObjectMetaPersistenceTest{

    @Autowired
    private StorageObjectMetaPersistence repository;

    @Test

    public void ensure_saveing_storageObject_into_DB(){

        //given
        StorageObjectMeta storageObjectMeta = FixtureFactory.give_me_a_storageObject1();


        //when
        var saved = repository.saveAndFlush(storageObjectMeta);

        //then
        assertThat(saved.getId()).isSameAs(storageObjectMeta.getId());
        assertThat(repository.findById(storageObjectMeta.getId())).isNotNull();
    }

//    @Test
//    public void test1() throws ExceptionOrcl{
//        try{
//            DatabaseORCL db = new DatabaseORCL();
//            db.startOrcl();
//        }catch(ExceptionOrcl e){
//            throw new ExceptionOrcl("fail", e);
//        }
//    }
}