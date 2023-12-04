package at.spengergasse.sj2324seedproject.persistence.converter;

import at.spengergasse.sj2324seedproject.domain.Role;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {
    @Override
    public String convertToDatabaseColumn(Role role) {
        return Optional.ofNullable(role)
                .map(ro -> switch(ro) {
                    case MANAGEMENT -> "M";
                    case STORAGEADMIN -> "S";
                    case FIELDSERVICETECHNICIAN -> "F";
                    case ORDERFULLFILLMENT -> "O";
                    case PROJECTMANAGER -> "P";
                }).orElse(null);
    }

    @Override
    public Role convertToEntityAttribute(String dbValue) {
        return Optional.ofNullable(dbValue)
                .map(ro -> switch (ro) {
                    case "M" -> Role.MANAGEMENT;
                    case "S" -> Role.STORAGEADMIN;
                    case "F" -> Role.FIELDSERVICETECHNICIAN;
                    case "O" -> Role.ORDERFULLFILLMENT;
                    case "P" -> Role.PROJECTMANAGER;
                    default -> throw new IllegalArgumentException("Unknown value %s for Role");
                }).orElse(null);
    }
}
