package coding.dojo.exchange;

import java.math.BigDecimal;
import java.math.RoundingMode;

import coding.dojo.coin.Coin;
import coding.dojo.exchangerate.ExchangeRate;

public record Exchange(Coin baseCoin, Coin targetCoin, ExchangeRate exchangeRates) {

    public static Exchange of(Coin baseCoin, String targetCurrency, ExchangeRate exchangeRates) {
        BigDecimal baseAmount = baseCoin.value().amount();
        Coin targetCoin = switch (exchangeRates.base()) {
            case String b when b.equals(targetCurrency) -> // if the targetCurrency is USD
                convertToUSD(exchangeRates, baseAmount, baseCoin.getCurrencyCode());
            case String b when b.equals(baseCoin.getCurrencyCode()) -> // if the baseCurrency is USD
                convertFromUSD(exchangeRates, baseAmount, targetCurrency);
            default -> convertCoin(exchangeRates, baseAmount, baseCoin.getCurrencyCode(), targetCurrency);
        };
        return new Exchange(baseCoin, targetCoin, exchangeRates);
    }

    private static Coin convertFromUSD(ExchangeRate rates, BigDecimal value, String currency) {
        BigDecimal rate = rates.rates().get(currency);
        BigDecimal convertedAmount = value.multiply(rate);
        return Coin.of(convertedAmount, currency);
    }

    private static Coin convertToUSD(ExchangeRate exchangeRates, BigDecimal value, String currency) {
        BigDecimal rate = exchangeRates.rates().get(currency);
        BigDecimal convertedAmount = value.divide(rate, 2, RoundingMode.HALF_UP);
        return Coin.of(convertedAmount, currency);
    }

    private static Coin convertCoin(ExchangeRate exchangeRate, BigDecimal valeu, String baseCurrency,
            String targetCurrency) {
        BigDecimal baseCurrencyRate = exchangeRate.getRate(baseCurrency);
        BigDecimal targetCurrencyRate = exchangeRate.getRate(targetCurrency);
        BigDecimal convertedAmount = valeu.multiply(targetCurrencyRate).divide(baseCurrencyRate, 2,
                RoundingMode.HALF_UP);
        return Coin.of(convertedAmount, targetCurrency);
    }
}
