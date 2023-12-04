package at.spengergasse.sj2324seedproject.persistence.converter;

import at.spengergasse.sj2324seedproject.domain.SfpType;
//import at.spengergasse.sj2324seedproject.domain.Status;
//import at.spengergasse.sj2324seedproject.persistance.converter.SfpTypeConverter;
//import at.spengergasse.sj2324seedproject.persistance.converter.StatusConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SfpTypeConverterTest {

    private SfpTypeConverter converter;


    @BeforeEach
    void
    setup() {
        converter = new SfpTypeConverter();
    }

    @Test
    void ensureConvertToDatabaseColumn() {

        //expect
        assertThat(converter.convertToDatabaseColumn(SfpType.SM)).isEqualTo("S");
        assertThat(converter.convertToDatabaseColumn(SfpType.MM)).isEqualTo("M");
        assertThat(converter.convertToDatabaseColumn(SfpType.WDM)).isEqualTo("W");
        assertThat(converter.convertToDatabaseColumn(null)).isNull();

    }

    @Test

    void ensureConvertToEntityAttributeWorksForValidValues(){

        //expect
        assertThat(converter.convertToEntityAttribute("S")).isEqualTo(SfpType.SM);
        assertThat(converter.convertToEntityAttribute("M")).isEqualTo(SfpType.MM);
        assertThat(converter.convertToEntityAttribute("W")).isEqualTo(SfpType.WDM);
        assertThat(converter.convertToDatabaseColumn(null)).isNull();

    }


    void ensureConvertToEntityAttributeThrowsAnExceptionForInalidValues(){

        //expect
        var iaEx =  assertThrows(IllegalArgumentException.class, () -> {
            converter.convertToEntityAttribute("X");
        });
        assertThat(iaEx).hasMessage("Unknown value 'X' for SFP-Type");

    }


}