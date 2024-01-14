//package at.spengergasse.sj2324seedproject.service;
//
//import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
//import at.spengergasse.sj2324seedproject.domain.Customer;
//import at.spengergasse.sj2324seedproject.domain.StorageObject;
//import at.spengergasse.sj2324seedproject.persistence.PersistenceStorageObject;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class ServiceInit{
//
//    private final PersistenceStorageObject persistenceStorageObject;
//
//    @PostConstruct
//    public void init(){
//         StorageObject sto1 =  StorageObject.builder()
//                           .serialNumber("abcd1234")
//                           .macAddress(ConstantsDomain.DEFAULT_MAC)
//                           .remark("this is a remark1")
//                           .projectDevice(true)
//                           .storedAtCustomer(Customer.builder()
//                                                     .connectionNo(123456)
//                                                     .build())
//                           .build();
//
//        StorageObject sto2 = StorageObje.builder()
//                           .serialNumber("abcd1234")
//                           .macAddress(ConstantsDomain.DEFAULT_MAC)
//                           .remark("this is a remark2")ct
//                           .projectDevice(true)
//                           .storedAtCustomer(Customer.builder()
//                                                     .connectionNo(654321).build())
//                           .build();
//
//        persistenceStorageObject.save(sto1);
//    }
//}
