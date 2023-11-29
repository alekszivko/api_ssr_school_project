package at.spengergasse.sj2324seedproject.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

public class StorageObject {


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Storage storage;


    private Status status;

}
