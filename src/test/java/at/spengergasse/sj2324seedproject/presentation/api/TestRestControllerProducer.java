package at.spengergasse.sj2324seedproject.presentation.api;

import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import at.spengergasse.sj2324seedproject.persistence.RepositoryProducer;
import at.spengergasse.sj2324seedproject.service.ServiceProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
        var prod = FixtureFactory.producerFixture();
        when(repositoryProducer.findAll()).thenReturn(List.of(prod));
        //when
        var result = serviceProducer.fetchProducer(searchCriteria);

        //then
        verify(repositoryProducer ).findAll();

    }

    @Test
    void ensureGetMappingWorksAndCheckResponse(){
        //given
        Optional<String> searchCriteria = Optional.empty();
        var prod = FixtureFactory.producerFixture();
        when(repositoryProducer.findAll()).thenReturn(List.of(prod));
        //when
        var result = serviceProducer.fetchProducer(searchCriteria);

        //then
        verify(repositoryProducer ).findAll();
    }
}