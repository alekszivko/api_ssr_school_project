package at.spengergasse.sj2324seedproject.presentation.www.storageObjects;

public record CreateStorageObjectForm(String randomKey,
                                      String storage,
                                      String serialNr,
                                      String mac,
                                      String remark,
                                      String projectDev,
                                      String storedAtCu){
    public static CreateStorageObjectForm create(){
        return new CreateStorageObjectForm("",
                                           "",
                                           "",
                                           "",
                                           "",
                                           "",
                                           "");
    }
}
