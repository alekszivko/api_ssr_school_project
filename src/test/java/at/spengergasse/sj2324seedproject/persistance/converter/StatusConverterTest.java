package at.spengergasse.sj2324seedproject.persistance.converter;

import at.spengergasse.sj2324seedproject.domain.Status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatusConverterTest {

    private StatusConverter converter;

    @BeforeEach
    void
    setup() {
        converter = new StatusConverter();
    }
    @Test

    void ensureConvertToDatabaseColumn() {

        //expect
        assertThat(converter.convertToDatabaseColumn(Status.PROJECT)).isEqualTo("P");
        assertThat(converter.convertToDatabaseColumn(Status.CUSTOMER)).isEqualTo("C");
        assertThat(converter.convertToDatabaseColumn(Status.MISSING)).isEqualTo("M");
        assertThat(converter.convertToDatabaseColumn(Status.RESERVED)).isEqualTo("R");
        assertThat(converter.convertToDatabaseColumn(null)).isNull();

    }

    @Test

    void ensureConvertToEntityAttributeWorksForValidValues(){

        //expect
        assertThat(converter.convertToEntityAttribute("P")).isEqualTo(Status.PROJECT);
        assertThat(converter.convertToEntityAttribute("C")).isEqualTo(Status.CUSTOMER);
        assertThat(converter.convertToEntityAttribute("M")).isEqualTo(Status.MISSING);
        assertThat(converter.convertToEntityAttribute("R")).isEqualTo(Status.RESERVED);
        assertThat(converter.convertToDatabaseColumn(null)).isNull();

    }


    void ensureConvertToEntityAttributeThrowsAnExceptionForInalidValues(){

        //expect
       var iaEx =  assertThrows(IllegalArgumentException.class, () -> {
           converter.convertToEntityAttribute("X");
               });
        assertThat(iaEx).hasMessage("Unknown value 'X' for Status");

    }
}