package at.spengergasse.sj2324seedproject.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "storage_object_meta")
@Entity
public class StorageObjectMeta extends AbstractPersistable<Long>{

    /*
    Relations
     */

    @Valid

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "FK_producer", foreignKey = @ForeignKey(name = "FK_producer_2_storageObjectMeta"))
    private Producer producer;


    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    /*
    Attributes
     */
    @NotBlank
    @Column(name = "object_name")
    private String name;

    @NotBlank
    @Column(name = "os_version")
    private String osVersion;

    @Min(0)
    @Column(name = "consumables_per_box")
    private Integer consumablesPerBox;

    //    @Column
    //    private IpPhoneType phoneType;

    @NotBlank
    @Column(name = "wave_length")
    private String wavelength;

    @NotBlank
    @Column(name = "interface_speed")
    private String interfacespeed;


    public Producer getProducer(){
        return producer;
    }

    public void setProducer(Producer producer){
        this.producer = producer;
    }
}
