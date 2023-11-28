package at.spengergasse.sj2324seedproject.persistence.converter;

import at.spengergasse.sj2324seedproject.domain.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;



class RoleConverterTest {

    private RoleConverter converter;

    @BeforeEach
    void setUp() {
        converter = new RoleConverter();
    }

    @Test
    void ensureConvertToDatabaseColumnWorks() {
        //Expect
        assertEquals("O", converter.convertToDatabaseColumn(Role.ORDERFULLFILLMENT));
        assertEquals("M", converter.convertToDatabaseColumn(Role.MANAGEMENT));
        assertEquals("S", converter.convertToDatabaseColumn(Role.STORAGEADMIN));
        assertEquals("F", converter.convertToDatabaseColumn(Role.FIELDSERVICETECHNICIAN));
        assertEquals("P", converter.convertToDatabaseColumn(Role.PROJECTMANAGER));
        assertThat(converter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    void ensureConvertToEntityAttributeWorks() {
        //Expect
        assertEquals(Role.ORDERFULLFILLMENT, converter.convertToEntityAttribute("O"));
        assertEquals(Role.MANAGEMENT, converter.convertToEntityAttribute("M"));
        assertEquals(Role.STORAGEADMIN, converter.convertToEntityAttribute("S"));
        assertEquals(Role.FIELDSERVICETECHNICIAN, converter.convertToEntityAttribute("F"));
        assertEquals(Role.PROJECTMANAGER, converter.convertToEntityAttribute("P"));
        assertThat(converter.convertToEntityAttribute(null)).isNull();
    }
}