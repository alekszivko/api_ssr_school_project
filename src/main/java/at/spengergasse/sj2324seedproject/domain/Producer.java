package at.spengergasse.sj2324seedproject.domain;


import at.spengergasse.sj2324seedproject.constants.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.*;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "producer")
@Entity
public class Producer extends AbstractPersistable<Long>{

    /*
    Relations
     */

    @JoinColumn(name = "fk_storageObjectMeta", foreignKey = @ForeignKey(name = "fk_storageObjectMeta_2_producer"))
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private StorageObjectMeta storageObjectMeta;


    /*
     Attributes
      */

    @Column(name = "shortname", length = ConstantsDomain.DEFAULT_LENGTH)
    @NotBlank
    private String shortname = ConstantsDomain.DEFAULT_VALUE;

    @NotBlank
    @Column(name = "producer_name", length =  ConstantsDomain.DEFAULT_LENGTH)
    private String name = ConstantsDomain.DEFAULT_VALUE;



}
