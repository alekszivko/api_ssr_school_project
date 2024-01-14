package at.spengergasse.sj2324seedproject.persistence;


import at.spengergasse.sj2324seedproject.domain.Storage;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;



@DataJpaTest
class StorageRepositoryTest {

    @Autowired
    private StorageRepository storageRepository;



    @Test
    void ensureSaveAndReReadWorks(){

        //Given
         Storage storageGiven = FixtureFactory.storageFixture();


        //When
        var saved = storageRepository.save(storageGiven);


        //Then
        assertThat(saved).isNotNull().isSameAs(storageGiven);
        assertThat(saved.getId()).isNotNull();
        assertThat(storageGiven.getAddress()).isEqualTo((saved.getAddress()));

    }


}