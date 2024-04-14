package at.spengergasse.sj2324seedproject.presentation.api;


import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import at.spengergasse.sj2324seedproject.domain.StorageObject;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import at.spengergasse.sj2324seedproject.service.ServiceStorageObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestControllerStorageObject.class)
class RestControllerStorageObjectTest{

    @Autowired
    private MockMvc              mockMvc;
    @MockBean
    private ServiceStorageObject serviceStorageObject;

    @BeforeEach
    void setup(){
        assumeThat(mockMvc).isNotNull();
        assumeThat(serviceStorageObject).isNotNull();
    }

    @Test
    void ensureGetApiStorageObjectsWorks() throws Exception{
        //given, when
        StorageObject storageObject = FixtureFactory.give_me_a_storageObject1();

        //then, expect
        var request = get(ConstantsDomain.URI_BASE_STORAGEOBJECT+ConstantsDomain.URI_BASE_STORAGEOBJECT_MAC, storageObject.getMacAddress()).accept(MediaType.APPLICATION_JSON);
        when(serviceStorageObject.findStorageObjectMac(Optional.empty())).thenReturn(storageObject);
        mockMvc.perform(request)
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$[0].serialNumber").value("abcd1234"))
               .andExpect(jsonPath("$[0].macAddress").value("ff-ff-ff-ff-ff-ff"))
               .andExpect(jsonPath("$[0].remark").value("this is a remark1"))
               .andExpect(jsonPath("$[0].projectDevice").value("true"))
               .andExpect(jsonPath("$[0][0].connectionNo").value("123456"))
               //               .andExpect(jsonPath("$[0].storaedAtCustomer").value("abcd1234"))
               .andDo(print());


    }
}