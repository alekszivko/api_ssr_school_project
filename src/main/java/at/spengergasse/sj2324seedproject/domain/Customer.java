package at.spengergasse.sj2324seedproject.domain;

import jakarta.persistence.Embeddable;
import lombok.Builder;

@Builder
@Embeddable
public record Customer(String connectionNo) {

}
