package at.spengergasse.sj2324seedproject.domain;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "storage_object")
public class StorageObject extends AbstractPersistable<Long>{

    /*
    Relations
     */

//    @JoinColumn(name = "fk_stored_at_user", foreignKey = @ForeignKey(name = "fk_storageObject_2_user"))
//    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OneToMany
    private List<User> storedAtUser = new ArrayList<>();

    @OneToMany(mappedBy = "storageobject", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<StorageObjectMeta> storageObjectMeta = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fk_storage", foreignKey = @ForeignKey(name = "fk_storage_object_2_storage"))
    private Storage storage;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;


    @JoinColumn(name = "fk_reservation", foreignKey = @ForeignKey(name = "fk_storageObject_2_reservation"))
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Reservation reservation;

    /*
    Attributes
     */
    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "mac_address")
    @NotBlank
    private String macAddress;

    @Column(name = "remark")
    @NotBlank
    private String remark = ConstantsDomain.DEFAULT_VALUE;

    @Column(name = "project_device")
    private boolean projectDevice;


    @Column(name = "stored_at_customer")
    @Embedded
    private Customer storedAtCustomer;

}

