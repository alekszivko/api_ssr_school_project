package at.spengergasse.sj2324seedproject.presentation.www;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateStorageObjectForm{
    private String serialNr;
    private String mac;
    private String remark;
    private String projectDev;
    private String storedAtCu;
}
