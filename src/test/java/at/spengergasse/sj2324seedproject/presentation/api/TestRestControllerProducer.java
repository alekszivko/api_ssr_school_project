package at.spengergasse.sj2324seedproject.presentation.api;

import at.spengergasse.sj2324seedproject.domain.Producer;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import at.spengergasse.sj2324seedproject.persistence.RepositoryProducer;
import at.spengergasse.sj2324seedproject.service.ServiceProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static java.lang.reflect.Array.get;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.Mockito.*;

@WebMvcTest(RestControllerProducer.class)
@ExtendWith(MockitoExtension.class)
class TestRestControllerProducer{

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServiceProducer serviceProducer;
    @MockBean
    private RepositoryProducer repositoryProducer;

    @BeforeEach
    void setup(){
        assumeThat(repositoryProducer).isNotNull();
        serviceProducer = new ServiceProducer(repositoryProducer);
    }

    @Test
    void ensureGetMappingWorks(){
        //given
        Optional<String> searchCriteria = Optional.empty();
        var prod = FixtureFactory.give_me_a_producer1();
        when(repositoryProducer.findAll()).thenReturn(List.of(prod));
        //when
        var result = serviceProducer.fetchProducer(searchCriteria);

        //then
//        verify(repositoryProducer, times(1)).findAll();
        verify(repositoryProducer ).findAll();

    }

    @Test
    void ensureGetMappingWorksAndCheckResponse(){
        //given
        Optional<String> searchCriteria = Optional.empty();
        var prod = FixtureFactory.give_me_a_producer1();
        when(repositoryProducer.findAll()).thenReturn(List.of(prod));
        //when
        var result = serviceProducer.fetchProducer(searchCriteria);

        //then
//        verify(repositoryProducer, times(1)).findAll();
        verify(repositoryProducer ).findAll();
    }

    @Test
    void ensure(){
        //given
        String searchCriteria = FixtureFactory.give_me_a_producer1().getName();
        var prod = FixtureFactory.give_me_a_producer1();
        when(serviceProducer.fetchProducer(Optional.of(prod.getName()))).thenReturn(List.of(prod));
        //when
//        var request = get //TODO

        //then
//        verify(repositoryProducer, times(1)).findAll();
        verify(repositoryProducer ).findAll();
    }

}