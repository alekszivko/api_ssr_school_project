package at.spengergasse.sj2324seedproject.service.MockitoTestEnv;

import at.spengergasse.sj2324seedproject.domain.Producer;
import at.spengergasse.sj2324seedproject.domain.StorageObject;
import at.spengergasse.sj2324seedproject.domain.StorageObjectMeta;
import at.spengergasse.sj2324seedproject.domain.Type;
import at.spengergasse.sj2324seedproject.service.ServiceProducer;
import at.spengergasse.sj2324seedproject.service.ServiceStorageObject;
import at.spengergasse.sj2324seedproject.service.ServiceStorageObjectMeta;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Mockito_1{

    //////////////////////////////////////Test Start///////////////////////////////////////////
    ServiceProducer      serviceProducer      = org.mockito.Mockito.mock(ServiceProducer.class);
    ServiceStorageObject serviceStorageObject = mock(ServiceStorageObject.class);
    @Mock
    ServiceStorageObjectMeta serviceStorageObjectMeta1;

    @Before
    public void setUp(){

        assertNotNull(serviceProducer);
        assertNotNull(serviceStorageObject);
        assertNotNull(serviceStorageObjectMeta1);
    }

    @Test
    void test1() throws Exception{
        Producer producer = Producer.builder()
                                    .name("Producer")
                                    .shortname("PR")
                                    .build();
        StorageObject storageObject = StorageObject.builder()
                                                   .macAddress("ff-ff-ff-ff-ff-ff")
                                                   .serialNumber("123456")
                                                   .remark("Its a remark!!")
                                                   .build();
        StorageObjectMeta storageObjectMeta = StorageObjectMeta.builder()
                                                               .name("Meta 1")
                                                               .type(Type.SWITCH)
                                                               .osVersion("12.1.3")
                                                               .build();

        when(serviceProducer.findProducerByStringID(anyString())).thenReturn(producer);

        assertNotNull(serviceProducer.findProducerByStringID("!"));
    }

    //////////////////////////////////////Test End ///////////////////////////////////////////


}
