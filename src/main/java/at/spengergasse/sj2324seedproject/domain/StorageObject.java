package at.spengergasse.sj2324seedproject.domain;

import jakarta.persistence.*;

public class StorageObject {


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(foreignKey =@ForeignKey(name = "FK_StorageObject_2_Storage"))
    private Storage storage;


    private Status status;

}
