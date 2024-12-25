package at.spengergasse.sj2324seedproject.domain;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)


@Entity
@Table(name = "storage_objects")
public class StorageObject extends AbstractPersistable<Long>{

    @OneToMany
    private List<User> storedAtUsers;

    @ManyToOne(fetch = FetchType.LAZY,
               cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fk_storage_object_meta",
                foreignKey = @ForeignKey(name = "fk_storageObejctMeta_2_storageObject"))
    private StorageObjectMeta storageObjectMeta;

    @OneToMany(fetch = FetchType.LAZY,
               cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<StorageObjectHistory> storageObjectHistories;

    @ManyToOne(fetch = FetchType.LAZY,
               cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fk_storages",
                foreignKey = @ForeignKey(name = "fk_storage_2_storageObject"))
    private Storage storedStorage;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @JoinColumn(name = "fk_reservation",
                foreignKey = @ForeignKey(name = "fk_storageObject_2_reservation"))
    @OneToOne(fetch = FetchType.LAZY,
              cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Reservation reservation;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "mac_address")
    @NotBlank
    private String macAddress;

    @Column(name = "remark")
    @NotBlank
    private String remark;

    @Column(name = "project_device")
    private Boolean projectDevice;


    @Column(name = "stored_at_customer")
    private Customer storedAtCustomer;

    @Column(name = "uuid-key_field")
    private String apiKeyID;

}

