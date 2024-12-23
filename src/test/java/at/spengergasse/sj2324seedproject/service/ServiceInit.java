//package at.spengergasse.sj2324seedproject.service;
//
//import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
//import at.spengergasse.sj2324seedproject.domain.*;
//import at.spengergasse.sj2324seedproject.fixture.FixtureFactory;
//import at.spengergasse.sj2324seedproject.persistence.RepositoryProducer;
//import at.spengergasse.sj2324seedproject.persistence.RepositoryStorageObject;
//import at.spengergasse.sj2324seedproject.persistence.RepositoryStorageObjectMeta;
//import at.spengergasse.sj2324seedproject.persistence.StorageRepository;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class ServiceInit{
//    @Autowired
//    private final RepositoryProducer          repositoryProducer;
//    @Autowired
//    private final RepositoryStorageObject     repositoryStorageObject;
//    @Autowired
//    private final RepositoryStorageObjectMeta repositoryStorageObjectMeta;
//    @Autowired
//    private final StorageRepository           storageRepository;
//
//    @PostConstruct
//    public void init(){
////        Producer prod1 = Producer.builder()
////                                 .shortname("MS")
////                                 .name("Micro Soft")
////                                 .build();
////        Producer prod2 = Producer.builder()
////                                 .shortname("IBM")
////                                 .name("Internationale Bekleidungs Maschinenhersteller")
////                                 .build();
////
////        StorageObjectMeta storageObjectMeta = StorageObjectMeta.builder()
////                                                               .name("meta name1")
////                                                               //                                                               .type(Type.IP_PHONE)
////                                                               .osVersion("version1")
////                                                               //                                                               .consumablesPerBox(2)
////                                                               //                                                               .sfpType(SfpType.MM)
////                                                               //                                                               .wavelength("1550nm")
////                                                               //                                                               .interfacespeed("100-Mbps")
////                                                               .build();
////
////        StorageObjectMeta storageObjectMeta2 = StorageObjectMeta.builder()
////                                                                .producer(prod2)
////                                                                .name("Megnetischetoschtoschiba")
////                                                                .type(Type.ROUTER)
////                                                                .osVersion("nicht ganz so new")
////                                                                .consumablesPerBox(3)
////                                                                .sfpType(SfpType.MM)
////                                                                .wavelength("233")
////                                                                .interfacespeed("schnell")
////                                                                .build();
////
////
////        StorageObject sto1 = StorageObject.builder()
////                                          .serialNumber("aaaaaaa")
////                                          .macAddress(ConstantsDomain.DEFAULT_MAC)
////                                          .remark("this is a remark1")
////                                          .projectDevice(true)
////                                          .storedAtCustomer(Customer.builder()
////                                                                    .connectionNo("123456")
////                                                                    .build())
////                                          .build();
////
////        StorageObject sto2 = StorageObject.builder()
////                                          .serialNumber("bbbbbbbe")
////                                          .macAddress(ConstantsDomain.DEFAULT_MAC)
////                                          .remark("this is a remark2")
////                                          .projectDevice(true)
////                                          .storedAtCustomer(Customer.builder()
////                                                                    .connectionNo("654321")
////                                                                    .build())
////                                          .build();
//
//
////        storageObjectMeta.setProducer(prod1);
////        storageObjectMeta2.setProducer(prod2);
////
////        sto2.setStorageObjectMeta(storageObjectMeta);
////        sto1.setStorageObjectMeta(storageObjectMeta2);
//
//        repositoryStorageObject.saveAll(List.of(FixtureFactory.give_me_a_storageObject1(), FixtureFactory.give_me_a_storageObject2()));
//
//
////        repositoryStorageObjectMeta.saveAll(List.of(storageObjectMeta, storageObjectMeta2));
//
//
//        //        repositoryProducer.save(prod1);
//        //        repositoryProducer.save(prod2);
//        // TestMainApplication kracht
//
//        //        Address address1 = Address.builder()
//        //                .street("Kreuzgasse")
//        //                .number(50)
//        //                .addressAddition("UG")
//        //                .zipcode(1180)
//        //                .city("Wien")
//        //                .build();
//        //
//        //        Storage storage1 = Storage.builder()
//        //                .name("Hauptlager")
//        //                .address(address1)
//        //                .build();
//        //
//        //        storageRepository.save(storage1);
//
//    }
//}
