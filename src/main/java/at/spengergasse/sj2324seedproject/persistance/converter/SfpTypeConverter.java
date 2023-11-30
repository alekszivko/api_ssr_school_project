package at.spengergasse.sj2324seedproject.persistance.converter;

import at.spengergasse.sj2324seedproject.domain.SfpType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class SfpTypeConverter implements AttributeConverter<SfpType, String> {

    @Override
    public String convertToDatabaseColumn(SfpType sfpType) {
        return Optional.ofNullable(sfpType)
                .map(s -> switch (s){
                    case SM -> "S";
                    case MM -> "M";
                    case WDM-> "W";


                }).orElse(null);
    }



    @Override
    public SfpType convertToEntityAttribute(String dbValue) {
        return Optional.ofNullable(dbValue)
                .map(v -> switch (v){
                    case "S" -> SfpType.SM;
                    case "M" -> SfpType.MM;
                    case "W" -> SfpType.WDM;
                    default -> throw new IllegalArgumentException("Unknown value '%s' for SFP-Type".formatted(dbValue));
                }).orElse(null);
    }

}
