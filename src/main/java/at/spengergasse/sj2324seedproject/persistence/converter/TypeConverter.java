package at.spengergasse.sj2324seedproject.persistence.converter;


import at.spengergasse.sj2324seedproject.domain.Type;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<Type, String> {
    @Override
    public String convertToDatabaseColumn(Type type) {
        return Optional.ofNullable(type)
                .map(s -> switch (s){
                    case IP_PHONE -> "I_P";
                    case ROUTER -> "Ro";
                    case SWITCH -> "Sw";
                    case SFP -> "Sfp";
                    case CONSUMABLES -> "Co";

                }).orElse(null);
    }

    @Override
    public Type convertToEntityAttribute(String dbValue) {
        return Optional.ofNullable(dbValue)
                .map(v -> switch (v){
                    case "I_P" -> Type.IP_PHONE;
                    case "Ro" -> Type.ROUTER;
                    case "Sw" -> Type.SWITCH;
                    case "Sfp" -> Type.SFP;
                    case "Co" -> Type.CONSUMABLES;
                    default -> throw new IllegalArgumentException("Unknown value '%s' for Type".formatted(dbValue));
                }).orElse(null);
    }
}
