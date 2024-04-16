package at.spengergasse.sj2324seedproject.presentation.www.storage;

import at.spengergasse.sj2324seedproject.domain.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class CreateStorageForm {

    @NotBlank
    String name;
    Address address;

}
