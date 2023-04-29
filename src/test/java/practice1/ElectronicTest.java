package practice1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ElectronicTest {
    static Electronic electronic;
    static Electronics electronics;

    @BeforeAll
    static void setUp() {
        electronic = new Electronic(
                "SM-1000",
                Company.SAMSUNG,
                LocalDate.of(2023, 04, 17),
                new AuthMethod[]{AuthMethod.PIN, AuthMethod.PATTERN});
        electronics = Electronics.getInstance();
        electronics.setElectronicList(new Electronic[]{electronic});
    }

    @Test
    void createProductNo() {
        Long productNo = electronic.getProductNo();
        assertThat(productNo).isEqualTo(2304170001L);
    }

    @Test
    void findExistentProductNo() {
        Electronic found = electronics.findByProductNo(2304170001L);
        assertThat(found.getProductNo()).isEqualTo(2304170001L);
    }

    @Test
    void findNonexistentProductNo() {
        assertThatThrownBy(() -> {electronics.findByProductNo(2311132L);})
                .isInstanceOf(IllegalArgumentException.class);
    }
}