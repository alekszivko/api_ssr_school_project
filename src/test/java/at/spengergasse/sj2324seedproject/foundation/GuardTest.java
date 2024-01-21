package at.spengergasse.sj2324seedproject.foundation;

import org.junit.jupiter.api.Test;

import static at.spengergasse.sj2324seedproject.foundation.Guard.isNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GuardTest {

    @Test
    void ensureNotNullWithNonNullArgumentReturnsArgument(){
       assertThat(isNotNull("blalba")).isEqualTo("blalba");

    }

    @Test
    void ensureNotNullWithNullThrowsException(){
        var exception = assertThrows(IllegalArgumentException.class, () -> isNotNull(null));
    }

    @Test
    void ensureNotNullWithNullAndNameThrowsException(){
        var exception = assertThrows(IllegalArgumentException.class, () -> isNotNull(null,"XXX"));
        assertThat(exception).hasMessageContaining("'XXX' must not be null!");
    }

}