package coding.dojo.coin;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class ValueTest {
    @Test
    void givenABigDecimalShouldCreateValue() {
        Value v = Value.of(BigDecimal.valueOf(123.45));
        assert v.amount().equals(BigDecimal.valueOf(123.45));
    }

    @Test
    void givenANullBigDecimalShouldThrowException() {
        assertThrows(NullPointerException.class, () -> Value.of(null));
    }

    @Test
    void givenANegativeBigDecimalShouldThrowException() {
        assertThrows(CoinException.class, () -> Value.of(BigDecimal.valueOf(-123.45)));
    }

    @Test
    void shouldReturnTwoScalesValue() {
        Value v = Value.of(BigDecimal.valueOf(123.453));
        assert v.amount().equals(BigDecimal.valueOf(123.45));
    }

}
