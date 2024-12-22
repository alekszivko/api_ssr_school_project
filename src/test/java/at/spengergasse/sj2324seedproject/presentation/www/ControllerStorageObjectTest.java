package at.spengergasse.sj2324seedproject.presentation.www;

import at.spengergasse.sj2324seedproject.domain.StorageObject;
import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
import at.spengergasse.sj2324seedproject.presentation.www.storageObjects.ControllerStorageObject;
import at.spengergasse.sj2324seedproject.service.ServiceStorageObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ControllerStorageObject.class)
class ControllerStorageObjectTest{

    @Autowired
    private MockMvc              mockMvc;
    @MockBean
    private ServiceStorageObject serviceStorageObject;

    @Test
    void ensureGetStorageObjectReturnsProperView() throws Exception{
        List<StorageObject> storageObjectList = List.of(FixtureFactory.storageObjectFixture(),
                                                        FixtureFactory.storageObjectFixture());

        when(serviceStorageObject.fetchStorageObjectsList()).thenReturn(storageObjectList);
        mockMvc.perform(get("/storageObjects"))
               .andExpect(status().isOk())
               .andExpect(model().attribute("storageObjects",
                                            storageObjectList))
               .andExpect(view().name("storageObjects/list"))
               .andDo(print());
    }


}