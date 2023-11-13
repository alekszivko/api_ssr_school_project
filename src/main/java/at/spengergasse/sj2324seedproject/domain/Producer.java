package at.spengergasse.sj2324seedproject.domain;


import at.spengergasse.sj2324seedproject.constants.Constants;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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



    @OneToMany(mappedBy = "producer", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<StorageObjectMeta> storageObjectMeta;


    /*
     Attributes
      */
    @Column(name = "shortname", length = Constants.SHORT_NAME_LENGTH)
    @NotBlank
    private String shortname;

    @NotBlank
    @Column(name = "producer_name", length = Constants.LONG_NAME_LENGTH)
    private String name;



/*    @Override
    public int compareTo(AbstractPersistable abstractPersistable){
        if(abstractPersistable == null ){
            return 1;
        }
        if(!(abstractPersistable instanceof Producer producer)){
            return 1;
        }
        return getId().compareTo(producer.getId());
    }*/
}
