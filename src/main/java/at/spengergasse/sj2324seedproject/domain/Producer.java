package at.spengergasse.sj2324seedproject.domain;


import at.spengergasse.sj2324seedproject.constants.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "producers")
@Entity
public class Producer extends AbstractPersistable<Long>{

    /*
    Relations
     */

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<StorageObjectMeta> storageObjectMeta;


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
