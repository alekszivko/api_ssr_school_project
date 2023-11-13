package at.spengergasse.sj2324seedproject.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Producer extends AbstractPersistable<Long>{



    @Column(name = "shortname")
    private String shortname;

    @Column(name = "name")
    private String name;

}
