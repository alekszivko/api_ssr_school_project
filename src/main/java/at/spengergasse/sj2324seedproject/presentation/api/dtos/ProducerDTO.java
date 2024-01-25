package at.spengergasse.sj2324seedproject.presentation.api.dtos;

import at.spengergasse.sj2324seedproject.domain.Producer;
import lombok.Builder;

@Builder
public record ProducerDTO(String shortname, String name){
    public ProducerDTO(Producer producer){
        this(producer.getShortname(), producer.getName());
    }
}
