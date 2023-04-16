package practice1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


class ElectronicTest {
    Electronic electronic;

    @BeforeEach
    void setUp() {
        electronic = new Electronic(
                "SM-1000",
                CompanyName.SAMSUNG,
                LocalDate.of(2023, 04, 17),
                new AuthMethod[]{AuthMethod.PIN, AuthMethod.PATTERN});
    }

    @Test
    void createProductNo() {
        Long productNo = electronic.getProductNo();
        assertThat(productNo).isEqualTo(2304170001L);
    }
}