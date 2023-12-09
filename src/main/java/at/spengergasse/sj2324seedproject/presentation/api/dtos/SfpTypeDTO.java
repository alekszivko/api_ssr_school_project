package at.spengergasse.sj2324seedproject.presentation.api.dtos;

import at.spengergasse.sj2324seedproject.domain.SfpType;

public record SfpTypeDTO(String typeValue){
  public SfpTypeDTO(SfpType sfpTypus){
      this(sfpTypus.getLongVersion());
  }
}
