package at.spengergasse.sj2324seedproject.presentation.www.storages;

import at.spengergasse.sj2324seedproject.domain.Storage;

public record EditStorageForm(Long id, String name, String street, Integer number,
                              String addressAddition, Integer zipcode, String city) {

  public static EditStorageForm create(Storage storage) {
    return new EditStorageForm(storage.getId(), storage.getName(), storage.getAddress().getStreet(),
        storage.getAddress().getNumber(), storage.getAddress().getAddressAddition(),
        storage.getAddress().getZipcode(), storage.getAddress().getCity());

  }
}
