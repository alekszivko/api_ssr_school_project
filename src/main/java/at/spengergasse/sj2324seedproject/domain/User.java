package at.spengergasse.sj2324seedproject.domain;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class User extends AbstractPersistable<Long>{
}
