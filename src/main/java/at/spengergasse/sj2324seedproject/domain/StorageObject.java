package at.spengergasse.sj2324seedproject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class StorageObject extends AbstractPersistable<Long>{
    @Column(name = "producer")
    private Producer          producer;
    @Column(name = "storage_object_meta")
    private StorageObjectMeta storageObjectMeta;
    @Column(name = "serial_number")
    private String            serialNumber;
    @Column(name = "mac_address")

    private String            macAddress;
    @Column(name = "remark")
    private String            remark;

    @Column(name = "project_device")
    private boolean projectDevice;
    @Column(name = "status")
    private Status  status;
    @Column(name = "storage")
    private Storage storage;

    @Column(name = "reservation")
    private Reservation reservation;
    @Column(name = "stored_at_customer")
    private Customer    storedAtCustomer;
    @Column(name = "stored_at_user")
    private User        storedAtUser;
}
