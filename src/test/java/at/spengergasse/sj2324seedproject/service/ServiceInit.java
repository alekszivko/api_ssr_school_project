package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.domain.Producer;
import at.spengergasse.sj2324seedproject.domain.SfpType;
import at.spengergasse.sj2324seedproject.domain.StorageObjectMeta;
import at.spengergasse.sj2324seedproject.domain.Type;
import at.spengergasse.sj2324seedproject.persistence.RepositoryProducer;
import at.spengergasse.sj2324seedproject.persistence.RepositoryStorageObjectMeta;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceInit{
    @Autowired
    private final RepositoryProducer          repositoryProducer;
    @Autowired
    private final RepositoryStorageObjectMeta repositoryStorageObjectMeta;

    @PostConstruct
    public void init(){
        Producer prod1 = Producer.builder()
                                 .shortname("MS")
                                 .name("Micro Soft")
                                 .build();
                Producer prod2 =  Producer.builder()
                                         .shortname("IBM")
                                         .name("Internationale Bekleidungs Maschinenhersteller")
                                         .build();

        StorageObjectMeta storageObjectMeta = StorageObjectMeta.builder()
                                                      .producer(prod1)
                                                      .name("Wind Fenster")
                                                      .type(Type.IP_PHONE)
                                                      .osVersion("bissale new")
                                                      .consumablesPerBox(6)
                                                      .sfpType(SfpType.MM)
                                                      .wavelength("344")
                                                      .interfacespeed("bissi schnell")
                                                      .build();

        StorageObjectMeta storageObjectMeta2 = StorageObjectMeta.builder()
                                                      .producer(prod2)
                                                      .name("Megnetischetoschtoschiba")
                                                      .type(Type.ROUTER)
                                                      .osVersion("nicht ganz so new")
                                                      .consumablesPerBox(3)
                                                      .sfpType(SfpType.MM)
                                                      .wavelength("233")
                                                      .interfacespeed("schnell")
                                                      .build();


        //        repositoryProducer.save(prod1);
        //        repositoryProducer.save(prod2);
        repositoryStorageObjectMeta.save(storageObjectMeta);
        repositoryStorageObjectMeta.save(storageObjectMeta2);


    }
}
