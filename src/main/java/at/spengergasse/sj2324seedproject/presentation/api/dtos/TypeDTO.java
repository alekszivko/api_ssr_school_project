package at.spengergasse.sj2324seedproject.presentation.api.dtos;

import at.spengergasse.sj2324seedproject.domain.Type;

public record TypeDTO(String typeValue){
    public TypeDTO(Type type){
        this(type.getLongVersion());
    }
}
