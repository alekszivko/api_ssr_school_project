package at.spengergasse.sj2324seedproject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
public class StorageObjectMeta extends AbstractPersistable<Long>{

    @Column(name = "type")
    private Type type;


    @Column(name = "object_name")
    private String name;

    @Column(name = "os_version")
    private String osVersion;

    @Column(name = "consumables_per_box")
    private Integer consumablesPerBox;

//    @Column
//    private IpPhoneType phoneType;

    @Column(name = "wave_length")
    private String wavelength;

    @Column(name = "interface_speed")
    private String interfacespeed;
}
