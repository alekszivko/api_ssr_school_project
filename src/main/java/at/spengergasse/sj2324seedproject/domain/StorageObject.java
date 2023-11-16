package at.spengergasse.sj2324seedproject.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "storage_object")
@Entity
public class StorageObject extends AbstractPersistable<Long>{

    /*
    Relations
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_object_meta", foreignKey = @ForeignKey(name = "StorageObject_2_StorageObejctMeta"))
    private StorageObjectMeta storageObjectMeta;

//
//    @Column(name = "storage")
//    private Storage storage;
//
//    @Column(name = "status")
//    private Status  status;
//    /*
//    Attributes
//     */
//    @Column(name = "serial_number")
//    private String            serialNumber;
//    @Column(name = "mac_address")
//
//    private String            macAddress;
//    @Column(name = "remark")
//    private String            remark;
//
//    @Column(name = "project_device")
//    private boolean projectDevice;
//
//    @Column(name = "reservation")
//    private Reservation reservation;
//    @Column(name = "stored_at_customer")
//    private Customer    storedAtCustomer;
//    @Column(name = "stored_at_user")
//    private User        storedAtUser;
}
