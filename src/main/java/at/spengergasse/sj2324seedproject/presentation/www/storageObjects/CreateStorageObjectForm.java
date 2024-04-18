package at.spengergasse.sj2324seedproject.presentation.www.storageObject;

public record CreateStorageObjectForm(String serialNr,
                                      String mac,
                                      String remark,
                                      String projectDev,
                                      String storedAtCu){
    public static CreateStorageObjectForm create(){
        return new CreateStorageObjectForm("","","","","");
    }
}
