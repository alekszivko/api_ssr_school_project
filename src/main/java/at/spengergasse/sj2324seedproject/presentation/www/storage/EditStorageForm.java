package at.spengergasse.sj2324seedproject.presentation.www.storage;

import at.spengergasse.sj2324seedproject.domain.Address;
import at.spengergasse.sj2324seedproject.domain.Storage;

public record EditStorageForm(String name, Address address)
{
    public static EditStorageForm create (Storage storage){
        return new EditStorageForm(storage.getName(),storage.getAddress());

    }
}
