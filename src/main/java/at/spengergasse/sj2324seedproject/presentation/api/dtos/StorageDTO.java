package at.spengergasse.sj2324seedproject.presentation.api.dtos;

import at.spengergasse.sj2324seedproject.domain.Storage;

public record StorageDTO(String name,
                         AddressDTO address){
    public StorageDTO(Storage storage){
        this(storage.getName(), new AddressDTO(storage.getAddress()));
    }
}
