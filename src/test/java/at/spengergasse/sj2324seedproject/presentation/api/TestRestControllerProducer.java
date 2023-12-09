package at.spengergasse.sj2324seedproject.presentation.api;

import at.spengergasse.sj2324seedproject.service.ServiceProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RestControllerProducer.class)
class TestRestControllerProducer{

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServiceProducer serviceProducer;

}