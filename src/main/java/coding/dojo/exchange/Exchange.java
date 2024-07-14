package coding.dojo.exchange;

import java.math.BigDecimal;
import java.math.RoundingMode;

import coding.dojo.coin.Coin;
import coding.dojo.exchangerate.ExchangeRate;

public record Exchange(Coin baseCoin, Coin targetCoin, ExchangeRate exchangeRates) {
    public static Exchange of(Coin baseCoin, String targetCurrency, ExchangeRate exchangeRates) {
        BigDecimal baseAmount = baseCoin.value().amount();
        BigDecimal rate = switch (exchangeRates.base()) {
            case String b when b == targetCurrency -> exchangeRates.rates().get(baseCoin.currency().getCurrencyCode());
            default -> exchangeRates.rates().get(targetCurrency);
        };
        BigDecimal targetAmount = baseAmount.divide(rate, 2, RoundingMode.HALF_UP);
        Coin targetCoin = Coin.of(targetAmount, targetCurrency);
        return new Exchange(baseCoin, targetCoin, exchangeRates);
    }
}
