package at.spengergasse.sj2324seedproject.presentation.api.dtos;


import lombok.Builder;

@Builder
public record CustomerDTO(String id, String firstName, String lastName, String email,
                          String phoneNumber,
                          String address, String city, String zipCode, String country,
                          String dateOfBirth) {

}
