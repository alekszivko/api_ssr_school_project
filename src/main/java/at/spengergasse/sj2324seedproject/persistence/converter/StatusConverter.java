package at.spengergasse.sj2324seedproject.persistence.converter;

import at.spengergasse.sj2324seedproject.domain.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter <Status, String>{
    @Override
    public String convertToDatabaseColumn(Status status) {
        return Optional.ofNullable(status)
                .map(s -> switch (s){
                    case MISSING -> "M";
                    case PROJECT -> "P";
                    case CUSTOMER -> "C";
                    case RESERVED -> "R";

                }).orElse(null);
    }

    @Override
    public Status convertToEntityAttribute(String dbValue) {
        return Optional.ofNullable(dbValue)
                .map(v -> switch (v){
                    case "M" -> Status.MISSING ;
                    case "P" -> Status.PROJECT;
                    case "C" -> Status.CUSTOMER;
                    case "R" -> Status.RESERVED;
                    default -> throw new IllegalArgumentException("Unknown value '%s' for Status".formatted(dbValue));
                }).orElse(null);
    }


}
