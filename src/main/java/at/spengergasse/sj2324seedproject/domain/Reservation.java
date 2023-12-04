package at.spengergasse.sj2324seedproject.domain;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;
@Entity
public class Reservation extends AbstractPersistable<Long>{
=======
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class Reservation extends AbstractPersistable<Long>{

    private static final int DESCRIPTION_LENGTH = 350;

    @PastOrPresent
    private LocalDateTime reservdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserved_by", foreignKey = @ForeignKey(name = "fk_user"))
    @NotNull
    private User reservdBy;

    @Embedded
    @NotNull
    private Customer reservedFor;

    @Length(max = DESCRIPTION_LENGTH)
    private String  reservationDescription;
    private boolean completed;

    @PastOrPresent
    private LocalDateTime lastModified;

>>>>>>> groupOf4Classes
}

