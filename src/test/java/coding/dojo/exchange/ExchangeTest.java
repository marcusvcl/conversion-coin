package coding.dojo.exchange;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.jupiter.api.Test;

import coding.dojo.coin.Coin;
import coding.dojo.exchangerate.ExchangeRate;

public class ExchangeTest {

    @Test
    void givenABaseCoinAndATargetCurrencyAndRateShouldCreateAnExchange() {
        Coin baseCoin = Coin.of(BigDecimal.valueOf(123.45), "USD");
        ExchangeRate rates = getRates();
        Exchange exchange = Exchange.of(baseCoin, "BRL", rates);
        assert exchange.baseCoin().equals(baseCoin);
        assert exchange.targetCoin().value().amount().equals(BigDecimal.valueOf(123.45));
    }

    private ExchangeRate getRates() {
        return new ExchangeRate("USD", Map.of("BRL", BigDecimal.ONE));
    }
}
