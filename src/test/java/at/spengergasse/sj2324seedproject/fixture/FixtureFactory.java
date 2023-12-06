package at.spengergasse.sj2324seedproject.fixture;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import at.spengergasse.sj2324seedproject.domain.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FixtureFactory{


    ///////////////////////////////////// Producer

    public static Producer give_me_a_producer1(){
        return Producer.builder()
                       .storageObjectMeta(give_me_a_storageObjectMeta1())
                       .shortname("shortname1")
                       .name("name1")
                       .build();
    }
    public static Producer give_me_a_producer2(){
        return Producer.builder()
                       .shortname("shortname2")
                       .name("name2")
                       .build();
    }

    ///////////////////////////////////// StorageObjectMeta

    public static StorageObjectMeta give_me_a_storageObjectMeta1(){
        return StorageObjectMeta.builder()
                       .storageobject(give_me_a_storageObject1())
                       .name("meta name1")
                       .type(Type.IP_PHONE)
                       .osVersion("version1")
                       .consumablesPerBox(2)
                       .sfpType(SfpType.MM)
                       .wavelength("1550nm")
                       .interfacespeed("100-Mbps")
                       .build();
    }
    public static StorageObjectMeta give_me_a_storageObjectMeta2(){
        return StorageObjectMeta.builder()
                       .producer(give_me_a_List_of_producer())
                       .storageobject(give_me_a_storageObject1())
                       .name("meta name2")
                       .type(Type.IP_PHONE)
                       .osVersion("version2")
                       .consumablesPerBox(2)
                       .sfpType(SfpType.MM)
                       .wavelength("1310nm")
                       .interfacespeed("1000-Mbps")
                       .build();
    }
    public static List<Producer> give_me_a_List_of_producer(){
                List<Producer> producersListe = new ArrayList<>();
                 producersListe.add(give_me_a_producer1());
                 producersListe.add(give_me_a_producer2());
                return producersListe;
            }



    ///////////////////////////////////// StorageObject

    public static StorageObject give_me_a_storageObject1(){
        return StorageObject.builder()
                       .serialNumber("abcd1234")
                       .macAddress(ConstantsDomain.DEFAULT_MAC)
                       .remark("this is a remark1")
                       .projectDevice(true)
                       .storedAtCustomer(Customer.builder()
                                                 .connectionNo(123456)
                                                 .build())
                       .build();
    }

    public static StorageObject give_me_a_storageObject2(){
        return StorageObject.builder()
                       .serialNumber("abcd1234")
                       .macAddress(ConstantsDomain.DEFAULT_MAC)
                       .remark("this is a remark2")
                       .projectDevice(true)
                       .storedAtCustomer(Customer.builder()
                                                 .connectionNo(654321).build())
                       .build();
    }





















//    public static StorageObjectMeta give_me_a_storageObject1(){
//
//      return  StorageObjectMeta.builder().producer(give_me_a_List_of_producer())
//                .type(Type.IP_PHONE)
//                .name("name des StorageObjects1")
//                .osVersion("beste1")
//                .consumablesPerBox(2)
//                .wavelength("ganzklein1")
//                .interfacespeed("schnellste1")
//                .build();
//    }
//    public static StorageObjectMeta give_me_a_storageObject2(){
//
//      return  StorageObjectMeta.builder().producer(give_me_a_List_of_producer())
//                .type(Type.ROUTER)
//                .name("name des StorageObjects2")
//                .osVersion("beste32")
//                .consumablesPerBox(2)
//                .wavelength("ganzklein2")
//                .interfacespeed("schnellste2")
//                .build();
//    }
//    public static StorageObjectMeta give_me_a_storageObject3(){
//
//      return  StorageObjectMeta.builder().producer(give_me_a_List_of_producer())
//                .type(Type.SFP)
//                .name("name des StorageObjects3")
//                .osVersion("beste3")
//                .consumablesPerBox(2)
//                .wavelength("ganzklein3")
//                .interfacespeed("schnellste3")
//                .build();
//    }
//
//    public static StorageObject give_me_a_storageObject4(){
//        return StorageObject.builder()
//
//                       .build();
//    }
//
//
//
//    public static Producer  give_me_a_producer1(){
//        return Producer.builder().shortname("kurzer Name1")
//                       .name("langer name1")
//                       .build();
//    }
//    public static Producer  give_me_a_producer2(){
//        return Producer.builder().shortname("kurzer Name2")
//                       .name("langer name2")
//                       .build();
//    }
//    public static Producer  give_me_a_producer3(){
//        return Producer.builder().shortname("kurzer Name3")
//                       .name("langer name3")
//                       .build();
//    }
//
//    public static List<Producer> give_me_a_List_of_producer(){
//        List<Producer> producersListe = new ArrayList<>();
//         producersListe.add(give_me_a_producer1());
//         producersListe.add(give_me_a_producer2());
//         producersListe.add(give_me_a_producer3());
//
//
//        return producersListe;
//    }
//
//    public static List<StorageObjectMeta> give_me_a_storageObjectMete_List(){
//        List<StorageObjectMeta> storageObjectMetaList = new ArrayList<>();
//        storageObjectMetaList.add(give_me_a_storageObject1());
//        storageObjectMetaList.add(give_me_a_storageObject2());
//        storageObjectMetaList.add(give_me_a_storageObject3());
//        return storageObjectMetaList;
//    }


}
