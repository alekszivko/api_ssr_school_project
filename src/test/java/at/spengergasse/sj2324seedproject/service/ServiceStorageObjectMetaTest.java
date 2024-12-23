package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import at.spengergasse.sj2324seedproject.domain.StorageObjectMeta;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ServiceStorageObjectMeta.class)
class ServiceStorageObjectMetaTest{

    @Autowired
    private MockMvc                  mockMvc;
    @MockBean
    private ServiceStorageObjectMeta serviceStorageObjectMeta;

    @BeforeEach
    void setup(){
        assumeThat(mockMvc).isNotNull();
        assumeThat(serviceStorageObjectMeta).isNotNull();
    }

    @Test
    void ensureGetApiStorageObjectMetaWorks() throws Exception{
        //given
        StorageObjectMeta storageObjectMeta = FixtureFactory.give_me_a_storageObjectMeta3();
        when(serviceStorageObjectMeta.fetchStoMeta(any())).thenReturn(List.of(storageObjectMeta));

        //expect
        var request = get(ConstantsDomain.URL_BASE_STO_META).accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$.name").value("meta name1"))
               //               .andExpect(jsonPath("$[0].type").value(Type.IP_PHONE))
               .andExpect(jsonPath("$.osVersion").value("version1"))
               //               .andExpect(jsonPath("$[0].consumablesPerBox").value(2))
               //               .andExpect(jsonPath("$[0].osVersion").value(SfpType.MM))
               //               .andExpect(jsonPath("$[0].wavelength").value("1550nm"))
               //               .andExpect(jsonPath("$[0].interfacespeed").value("100-Mbps"))
               .andDo(print());
    }

}