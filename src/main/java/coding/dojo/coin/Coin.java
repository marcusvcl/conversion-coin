package coding.dojo.coin;

import java.math.BigDecimal;
import java.util.Currency;

import com.fasterxml.jackson.annotation.JsonGetter;

import coding.dojo.commons.CurrencyFormatter;

public record Coin(Value value, Currency currency) {

    @JsonGetter("value")
    public String amount() {
        return CurrencyFormatter.format(currency, value.amount());
    }

    public static Coin of(BigDecimal montant, String currencyCode) {
        Currency currency = getCurrency(currencyCode);
        return new Coin(Value.of(montant), currency);
    }

    private static Currency getCurrency(String currencyCode) {
        try {
            return Currency.getInstance(currencyCode);
        } catch (Exception e) {
            throw new CoinException(String.format("The currency code %s is invalid!", currencyCode));
        }
    }
}