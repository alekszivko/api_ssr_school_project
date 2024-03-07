package at.spengergasse.sj2324seedproject.presentation.api;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import at.spengergasse.sj2324seedproject.domain.Producer;
import at.spengergasse.sj2324seedproject.exceptions.ExceptionProducer;
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
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.lang.reflect.Array.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
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
    void ensureGetProducerWithNoIdReturnsNoContent() throws Exception{
        //given

        var prod = FixtureFactory.give_me_a_producer1();
        when(serviceProducer.findProducerByStringID("2")).thenReturn(prod);
        //when
        var request = get(ConstantsDomain.URL_BASE_PRODUCER).accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(status().isNoContent())
                .andDo(print());

        //then
//        verify(repositoryProducer, times(1)).findAll();
        verify(repositoryProducer ).findAll();
    }

}