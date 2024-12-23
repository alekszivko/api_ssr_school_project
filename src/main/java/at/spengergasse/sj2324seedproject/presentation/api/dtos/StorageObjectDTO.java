package at.spengergasse.sj2324seedproject.presentation.api.dtos;

import at.spengergasse.sj2324seedproject.domain.Customer;
import at.spengergasse.sj2324seedproject.domain.StorageObject;

public record StorageObjectDTO(String serialNumber,
                               String macAddress,
                               String remark,
                               boolean projectDevice,
                               Customer storedAtCustomer,
                               StorageObjectMetaDTO storageObjectMeta,
                               String status){
    public StorageObjectDTO(StorageObject storageObject){
        this(storageObject.getSerialNumber(),
            storageObject.getMacAddress(),
            storageObject.getRemark(),
            storageObject.getProjectDevice(),
            storageObject.getStoredAtCustomer(),
            new StorageObjectMetaDTO(
                storageObject.getStorageObjectMeta()),
            storageObject.getStatus()
                                                                                                                                     .name());
    }
}
