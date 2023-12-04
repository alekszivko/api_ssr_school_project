package at.spengergasse.sj2324seedproject.persistence.converter;

//import at.spengergasse.sj2324seedproject.domain.SfpType;
import at.spengergasse.sj2324seedproject.domain.Type;
//import at.spengergasse.sj2324seedproject.persistance.converter.SfpTypeConverter;
//import at.spengergasse.sj2324seedproject.persistance.converter.TypeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TypeConverterTest {

    private TypeConverter converter;

    @BeforeEach
    void
    setup() {
        converter = new TypeConverter();
    }

    @Test
    void ensureConvertToDatabaseColumn() {

        //expect
        assertThat(converter.convertToDatabaseColumn(Type.IP_PHONE)).isEqualTo("I_P");
        assertThat(converter.convertToDatabaseColumn(Type.ROUTER)).isEqualTo("Ro");
        assertThat(converter.convertToDatabaseColumn(Type.SWITCH)).isEqualTo("Sw");
        assertThat(converter.convertToDatabaseColumn(Type.SFP)).isEqualTo("Sfp");
        assertThat(converter.convertToDatabaseColumn(Type.CONSUMABLES)).isEqualTo("Co");
        assertThat(converter.convertToDatabaseColumn(null)).isNull();

    }

    @Test

    void ensureConvertToEntityAttributeWorksForValidValues(){

        //expect
        assertThat(converter.convertToEntityAttribute("I_P")).isEqualTo(Type.IP_PHONE);
        assertThat(converter.convertToEntityAttribute("Ro")).isEqualTo(Type.ROUTER);
        assertThat(converter.convertToEntityAttribute("Sw")).isEqualTo(Type.SWITCH);
        assertThat(converter.convertToEntityAttribute("Sfp")).isEqualTo(Type.SFP);
        assertThat(converter.convertToEntityAttribute("Co")).isEqualTo(Type.CONSUMABLES);
        assertThat(converter.convertToDatabaseColumn(null)).isNull();

    }


    void ensureConvertToEntityAttributeThrowsAnExceptionForInalidValues(){

        //expect
        var iaEx =  assertThrows(IllegalArgumentException.class, () -> {
            converter.convertToEntityAttribute("X");
        });
        assertThat(iaEx).hasMessage("Unknown value 'X' for Type");

    }
}