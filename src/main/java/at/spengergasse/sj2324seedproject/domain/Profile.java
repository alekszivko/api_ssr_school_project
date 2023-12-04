package at.spengergasse.sj2324seedproject.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    private static final int USERNAME_LENGTH = 10;
    private static final int FIRSTNAME_LENGTH = 15;
    private static final int LASTNAME_LENGTH = 15;
    private static final int PHONE_LENGTH = 13;

    @Length(max = USERNAME_LENGTH)
    private String username;

    @Length(max = FIRSTNAME_LENGTH)
    private String firstName;

    @Length(max = LASTNAME_LENGTH)
    private String lastName;

    @Pattern(regexp = "^[\\+][(]?[0-9]{3}[)]?[.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
    @Length(max = PHONE_LENGTH)
    private String phone;
}

