package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import at.spengergasse.sj2324seedproject.domain.StorageObjectMeta;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import at.spengergasse.sj2324seedproject.persistence.RepositoryStorageObjectMeta;
import jakarta.persistence.Entity;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ServiceStorageObjectMetaTest{

    private ServiceStorageObjectMeta serviceStorageObjectMeta;
    private @Mock RepositoryStorageObjectMeta repositoryStorageObjectMeta;

    @BeforeEach
    void setup(){
        assumeThat(repositoryStorageObjectMeta).isNotNull();
        this.serviceStorageObjectMeta = new ServiceStorageObjectMeta(repositoryStorageObjectMeta);
    }

    @Test
    void ensureFetchStoMetaWorks() {
        var storageObjectMeta = FixtureFactory.storageObjectMetaFixture();
        when(repositoryStorageObjectMeta.findAll()).thenReturn(List.of(storageObjectMeta));

        var result = serviceStorageObjectMeta.fetchStoMeta(Optional.empty());

        verify(repositoryStorageObjectMeta, times(1)).findAll();
    }

    @Test
    void ensureFetchStoMetaWithoutParamCallsFindAll() throws Exception{
        //given
        StorageObjectMeta storageObjectMeta = FixtureFactory.storageObjectMetaFixture();

        Optional<String> nameParam = Optional.empty();

        when(repositoryStorageObjectMeta.findAll()).thenReturn(List.of(storageObjectMeta));
        //when
        var result = serviceStorageObjectMeta.fetchStoMeta(nameParam);
        //expect

        verify(repositoryStorageObjectMeta, times(1)).findAll();
    }

    @Test
    void ensureFetchStoMetaWithParamReturnsEqualStoMeta() {
       StorageObjectMeta equalStorageObjectMeta = FixtureFactory.storageObjectMetaFixture();
       Optional<String> nameParam = Optional.of("name");
       equalStorageObjectMeta.setName(nameParam.get());
       StorageObjectMeta unequalStorageObjectMeta = FixtureFactory.storageObjectMetaFixture();

       when(repositoryStorageObjectMeta.findAll())
           .thenReturn(List.of(equalStorageObjectMeta, unequalStorageObjectMeta));

       var result = serviceStorageObjectMeta.fetchStoMeta(nameParam);

       assertThat(result).doesNotContain(unequalStorageObjectMeta);
       assertThat(result).contains(equalStorageObjectMeta);

    }

}