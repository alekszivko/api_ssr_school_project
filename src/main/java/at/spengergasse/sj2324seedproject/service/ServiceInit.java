package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import at.spengergasse.sj2324seedproject.domain.Customer;
import at.spengergasse.sj2324seedproject.domain.Producer;
import at.spengergasse.sj2324seedproject.domain.StorageObject;
import at.spengergasse.sj2324seedproject.persistence.RepositoryProducer;
import at.spengergasse.sj2324seedproject.persistence.RepositoryStorageObject;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServiceInit{

    private final RepositoryStorageObject repositoryStorageObject;
    private final RepositoryProducer      repositoryProducer;

    @PostConstruct
    public void init(){
        StorageObject sto1 = StorageObject.builder()
                                     .serialNumber("aaaaaaa")
                                     .macAddress(ConstantsDomain.DEFAULT_MAC)
                                     .remark("this is a remark1")
                                     .projectDevice(true)
                                     .storedAtCustomer(Customer.builder()
                                                               .connectionNo("123456")
                                                               .build())
                                     .build();

        StorageObject sto2 = StorageObject.builder()
                                     .serialNumber("bbbbbbbe")
                                     .macAddress(ConstantsDomain.DEFAULT_MAC)
                                     .remark("this is a remark2")
                                     .projectDevice(true)
                                     .storedAtCustomer(Customer.builder()
                                                               .connectionNo("654321").build())
                                     .build();

        repositoryStorageObject.saveAll(List.of(sto1, sto2));

        Producer producer1 = Producer.builder()
                                     .name("producer1")
                                     .shortname("p1")
                                     .build();

        Producer producer2 = Producer.builder()
                                     .name("producer2")
                                     .shortname("p2")
                                     .build();

        repositoryProducer.saveAll(List.of(producer1, producer2));

    }


}
