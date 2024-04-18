package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import at.spengergasse.sj2324seedproject.domain.*;
import at.spengergasse.sj2324seedproject.foundation.ApiKeyGenerator;
import at.spengergasse.sj2324seedproject.persistence.RepositoryProducer;
import at.spengergasse.sj2324seedproject.persistence.RepositoryStorageObject;
import at.spengergasse.sj2324seedproject.persistence.RepositoryStorageObjectMeta;
import at.spengergasse.sj2324seedproject.persistence.StorageRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceInit{
    @Autowired
    private final RepositoryProducer          repositoryProducer;
    @Autowired
    private final RepositoryStorageObject     repositoryStorageObject;
    @Autowired
    private final RepositoryStorageObjectMeta repositoryStorageObjectMeta;
    @Autowired
    private final StorageRepository           storageRepository;
    @Autowired
    private final ApiKeyGenerator             keyGen;


    @PostConstruct
    public void init(){

        Producer prod1 = Producer.builder()
                                 .shortname("MS")
                                 .name("Micro Soft")
                                 .build();
        Producer prod2 = Producer.builder()
                                 .shortname("IBM")
                                 .name("Internationale Bekleidungs Maschinenhersteller")
                                 .build();

        //        repositoryProducer.saveAll(List.of(prod1, prod2));

        StorageObjectMeta storageObjectMeta = StorageObjectMeta.builder()
                                                               .name("meta name1")
                                                               .type(Type.IP_PHONE)
                                                               .osVersion("version1")
                                                               .consumablesPerBox(2)
                                                               .sfpType(SfpType.MM)
                                                               .wavelength("1550nm")
                                                               .interfacespeed("100-Mbps")
                                                               .build();

        StorageObjectMeta storageObjectMeta2 = StorageObjectMeta.builder()
                                                                .name("Megnetischetoschtoschiba")
                                                                .type(Type.ROUTER)
                                                                .osVersion("nicht ganz so new")
                                                                .consumablesPerBox(3)
                                                                .sfpType(SfpType.MM)
                                                                .wavelength("233")
                                                                .interfacespeed("schnell")
                                                                .build();


        Address address1 = Address.builder()
                                  .street("Kreuzgasse")
                                  .number(55)
                                  .addressAddition("EG")
                                  .zipcode(1180)
                                  .city("Wien")
                                  .build();

        Storage storage1 = Storage.builder()
                                  .name("Hauptlager DCE4")
                                  .address(address1)
                                  .build();


        StorageObject sto1 = StorageObject.builder()
                                          //                                          .storedStorage(storage1)
                                          .apiKeyID(keyGen.getRandomKey(16))
                                          .storedStorage(storage1)
                                          .serialNumber("aaaaaaa")
                                          .macAddress(ConstantsDomain.DEFAULT_MAC_GROUP)
                                          .remark("this is a remark1")
                                          .projectDevice(true)
                                          .storedAtCustomer(Customer.builder()
                                                                    .connectionNo("123456")
                                                                    .build())
                                          .status(Status.CUSTOMER)
                                          .build();

        StorageObject sto2 = StorageObject.builder()
                                          //                                          .storedStorage(storage1)
                                          .apiKeyID(keyGen.getRandomKey(16))
                                          .storedStorage(storage1)
                                          .serialNumber("bbbbbbbe")
                                          .macAddress(ConstantsDomain.DEFAULT_MAC)
                                          .remark("this is a remark2")
                                          .projectDevice(true)
                                          .storedAtCustomer(Customer.builder()
                                                                    .connectionNo("654321")
                                                                    .build())
                                          .status(Status.PROJECT)
                                          .build();

        //        List<StorageObjectMeta> stM = new ArrayList<>();
        storageObjectMeta.setProducer(prod1);
        //        prod1.setStorageObjectMeta(List.of(storageObjectMeta));
        storageObjectMeta2.setProducer(prod2);
        //        prod2.setStorageObjectMeta(List.of(storageObjectMeta2));

        sto2.setStorageObjectMeta(storageObjectMeta);
        sto1.setStorageObjectMeta(storageObjectMeta2);

        repositoryStorageObject.saveAll(List.of(sto1,
                                                sto2));


        //        repositoryStorageObjectMeta.saveAll(List.of(storageObjectMeta, storageObjectMeta2));


        //        repositoryProducer.save(prod1);
        //        repositoryProducer.save(prod2);
        // TestMainApplication kracht

        //        Address address1 = Address.builder()
        //                .street("Kreuzgasse")
        //                .number(50)
        //                .addressAddition("UG")
        //                .zipcode(1180)
        //                .city("Wien")
        //                .build();
        //
        //        Storage storage1 = Storage.builder()
        //                .name("Hauptlager")
        //                .address(address1)
        //                .build();
        //
        //        storageRepository.save(storage1);

    }

}
