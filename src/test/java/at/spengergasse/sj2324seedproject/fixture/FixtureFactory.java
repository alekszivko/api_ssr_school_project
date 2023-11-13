package at.spengergasse.sj2324seedproject.fixture;

import at.spengergasse.sj2324seedproject.domain.Producer;
import at.spengergasse.sj2324seedproject.domain.StorageObjectMeta;
import at.spengergasse.sj2324seedproject.domain.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FixtureFactory{

    public static StorageObjectMeta give_me_a_storageObject1(){

      return  StorageObjectMeta.builder().producer(give_me_a_producer1())
                .type(Type.IP_PHONE)
                .name("name des StorageObjects1")
                .osVersion("beste1")
                .consumablesPerBox(2)
                .wavelength("ganzklein1")
                .interfacespeed("schnellste1")
                .build();
    }
    public static StorageObjectMeta give_me_a_storageObject2(){

      return  StorageObjectMeta.builder().producer(give_me_a_producer2())
                .type(Type.ROUTER)
                .name("name des StorageObjects2")
                .osVersion("beste32")
                .consumablesPerBox(2)
                .wavelength("ganzklein2")
                .interfacespeed("schnellste2")
                .build();
    }
    public static StorageObjectMeta give_me_a_storageObject3(){

      return  StorageObjectMeta.builder().producer(give_me_a_producer3())
                .type(Type.SFP)
                .name("name des StorageObjects3")
                .osVersion("beste3")
                .consumablesPerBox(2)
                .wavelength("ganzklein3")
                .interfacespeed("schnellste3")
                .build();
    }



    public static Producer  give_me_a_producer1(){
        return Producer.builder().shortname("kurzer Name1")
                       .name("langer name1")
                       .build();
    }
    public static Producer  give_me_a_producer2(){
        return Producer.builder().shortname("kurzer Name2")
                       .name("langer name2")
                       .build();
    }
    public static Producer  give_me_a_producer3(){
        return Producer.builder().shortname("kurzer Name3")
                       .name("langer name3")
                       .build();
    }

    public static List<StorageObjectMeta> give_me_a_storageObjectMete_List(){
        List<StorageObjectMeta> storageObjectMetaList = new ArrayList<>();
        storageObjectMetaList.add(give_me_a_storageObject1());
        storageObjectMetaList.add(give_me_a_storageObject2());
        storageObjectMetaList.add(give_me_a_storageObject3());
        return storageObjectMetaList;
    }


}
