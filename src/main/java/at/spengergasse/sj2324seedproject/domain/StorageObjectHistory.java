package at.spengergasse.sj2324seedproject.domain;
//Implemented by MM

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name ="storageObjectHistory")

public class StorageObjectHistory extends AbstractPersistable<Long> {

    private StorageObject storageObject;
    private @PastOrPresent @NotNull LocalDateTime untilDateTime;
    private Status status;
    private Storage storage;
    private Reservation reservation;





}
