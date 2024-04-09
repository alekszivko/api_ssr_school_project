package at.spengergasse.sj2324seedproject.presentation.api.dtos;

import at.spengergasse.sj2324seedproject.domain.Profile;

public record ProfileDTO(String username, String firstName, String lastName) {

  ProfileDTO(Profile profile) {
    this(profile.getUsername(), profile.getFirstName(), profile.getLastName());
  }

}
