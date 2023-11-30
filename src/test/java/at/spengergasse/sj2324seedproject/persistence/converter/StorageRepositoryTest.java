package at.spengergasse.sj2324seedproject.persistence.converter;

import at.spengergasse.sj2324seedproject.domain.Address;
import at.spengergasse.sj2324seedproject.domain.Storage;
import at.spengergasse.sj2324seedproject.foundation.DateTimeFactory;
import at.spengergasse.sj2324seedproject.persistance.StorageRepository;
import org.assertj.core.api.Assumptions;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// FUNKTIONIERT NOCH NICHT!!! MM 28:11:2023
@DataJpaTest
class StorageRepositoryTest {

    @Autowired
    private StorageRepository repository;

    private DateTimeFactory dtf = new DateTimeFactory();

    @Test
    void ensureSaveAndReReadWorks(){

        //given /arrange
         Storage storage = Storage.builder()
                 .name("Martins Storage")
                 .address(Address.builder().street("teststr").number(5).zipcode(1190).city("Vienna").build())
                 .build();

        // when
        Assumptions.assumeThat(repository).isNotNull();

        var saved = repository.saveAndFlush(storage);


        // then /assert
        assertThat(saved).isNotNull().isSameAs(storage);
        assertThat(saved.getId()).isNotNull();


    }


}