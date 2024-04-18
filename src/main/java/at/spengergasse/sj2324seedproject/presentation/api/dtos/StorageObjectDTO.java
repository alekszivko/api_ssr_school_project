package at.spengergasse.sj2324seedproject.presentation.api.dtos;

import at.spengergasse.sj2324seedproject.domain.Customer;
import at.spengergasse.sj2324seedproject.domain.StorageObject;

public record StorageObjectDTO(String serialNumber,
                               String macAddress,
                               String remark,
                               boolean projectDevice,
                               Customer storaedAtCustomer,
                               StorageObjectMetaDTO storageObjectMeta,
                               //                               StorageDTO storageDTO,
                               //                               UserDTO userDTO,
                               String status){
    public StorageObjectDTO(StorageObject storageObject){
        this(storageObject.getSerialNumber(), storageObject.getMacAddress(), storageObject.getRemark(), storageObject.getProjectDevice(), storageObject.getStoredAtCustomer(), new StorageObjectMetaDTO(storageObject.getStorageObjectMeta()),
                /*new StorageDTO(storageObject.getStoredStorage()),*/ /*new UserDTO(storageObject.getStoredAtUser()),*/ storageObject.getStatus()
                                                                                                                                     .name());
    }
}
