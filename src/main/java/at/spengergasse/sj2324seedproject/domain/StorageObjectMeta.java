package at.spengergasse.sj2324seedproject.domain;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "storage_object_metas")
public class StorageObjectMeta extends AbstractPersistable<Long>{

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    public List<StorageObject> storageobject;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "fk_producer", foreignKey = @ForeignKey(name = "fk_producer_2_storageObejctMeta"))
    private Producer producer;


    @Column(name = "storage_object_type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @NotBlank
    @Column(name = "storage_object_name")
    private String name;

    @NotBlank
    @Column(name = "os_version")
    private String osVersion;

    @Min(0)
    @Column(name = "consumables_per_box")
    private Integer consumablesPerBox;

    @Enumerated(EnumType.STRING)
    @Column(name = "sfp_type")
    private SfpType sfpType;

    @NotBlank
    @Column(name = "wave_length")
    private String wavelength;

    @NotBlank
    @Column(name = "interface_speed")
    private String interfacespeed;


}
