package coding.dojo.coin;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.jupiter.api.Test;

public class CoinTest {
    @Test
    void givenAValueAndACurrencyShouldCreateACoin() {
        Coin c = Coin.of(BigDecimal.valueOf(123.45), "USD");
        assert c.value().amount().equals(BigDecimal.valueOf(123.45));
        assert c.currency().equals(Currency.getInstance("USD"));
    }

    @Test
    void givenAInvalidCurrencyShouldThrowException() {
        assertThrows(CoinException.class, () -> Coin.of(BigDecimal.valueOf(123.45), "XYZ"));
    }

    @Test
    void shouldReturnTheFormmatedValueWhenCallAmount() {
        Coin c = Coin.of(BigDecimal.valueOf(123.45), "USD");
        assert c.amount().equals("US$123.45");
    }

}
