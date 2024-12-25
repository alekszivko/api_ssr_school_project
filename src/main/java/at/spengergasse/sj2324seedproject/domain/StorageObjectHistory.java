package at.spengergasse.sj2324seedproject.domain;
//Implemented by MM

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)


@Entity
@Table(name ="storageObjectHistory")
public class StorageObjectHistory extends AbstractPersistable<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_storageObject", foreignKey = @ForeignKey(name = "fk_storageObejct_2_storageObjectHistory"))
    private StorageObject storageObject;

    private @PastOrPresent @NotNull LocalDateTime untilDateTime;
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fk_storages_H", foreignKey = @ForeignKey(name = "fk_storage_2_storageObjectHistory"))
    private Storage storage;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fk_reservierungen", foreignKey = @ForeignKey(name = "fk_reservierung_2_storageObjectHistory"))
    private Reservation reservation;







}
