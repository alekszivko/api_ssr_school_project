package at.spengergasse.sj2324seedproject.presentation.api.dtos;

import at.spengergasse.sj2324seedproject.domain.Address;

public record AddressDTO(String street, Integer number, String addressAddition, Integer zipcode, String city ) {
    public AddressDTO(Address address){
        this(address.getStreet(), address.getNumber(), address.getAddressAddition(), address.getZipcode(), address.getCity());
    }
}
