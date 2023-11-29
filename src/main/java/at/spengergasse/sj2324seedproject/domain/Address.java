package at.spengergasse.sj2324seedproject.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

// implemented by MM
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Embeddable
public class Address {

    private String street;
    private int number;
    private String addressAddition;
    private int zipcode;
    private String city;






}
