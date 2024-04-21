package at.spengergasse.sj2324seedproject.presentation.www.storageObjects;

import at.spengergasse.sj2324seedproject.domain.StorageObject;

public record EditStorageObjectForm(String randomKey,
                                    String storage,
                                    String serialNr,
                                    String mac,
                                    String remark,
                                    String projectDev,
                                    String storedAtCu){
    public static EditStorageObjectForm create(StorageObject storageObject){

        return new EditStorageObjectForm(storageObject.getApiKeyID(),
                                         storageObject.getStoredStorage()
                                                      .getName(),
                                         storageObject.getSerialNumber(),
                                         storageObject.getMacAddress(),
                                         storageObject.getRemark(),
                                         storageObject.getProjectDevice()
                                                      .toString(),
                                         storageObject.getStoredAtCustomer()
                                                      .toString()
        );
    }
}
