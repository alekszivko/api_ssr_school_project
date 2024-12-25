package at.spengergasse.sj2324seedproject.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)


@Entity
@Table(name = "app_user")
public class User extends AbstractPersistable<Long> {

  private static final int EMAIL_MAX_LENGTH = 320;
  private static final String DATE_TIME_FORMAT = "dd-mm-yyyy HH:mm:ss";


  private String userId;

  @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
  @Length(max = EMAIL_MAX_LENGTH)
  private String email;
  private String password;

  @Enumerated(value = EnumType.STRING)
  //@Length(max = 1)
  private Role role;

  @DateTimeFormat(pattern = DATE_TIME_FORMAT)
  private LocalDateTime createdAt;
  @DateTimeFormat(pattern = DATE_TIME_FORMAT)
  private LocalDateTime lastLogin;

  private boolean isActivated;

  @Embedded
  @Valid
  private Profile profile;


}
