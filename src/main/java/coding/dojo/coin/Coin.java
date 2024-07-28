package coding.dojo.coin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

import com.fasterxml.jackson.annotation.JsonGetter;

import coding.dojo.commons.CurrencyFormatter;
import coding.dojo.commons.Result;
import coding.dojo.commons.Try;

public record Coin(Value value, Currency currency) {

    @JsonGetter("value")
    public String amount() {
        return CurrencyFormatter.format(currency, value.amount());
    }

    public static Coin of(BigDecimal montant, String currencyCode) {
        Currency currency = getCurrency(currencyCode);
        return new Coin(Value.of(montant.setScale(2, RoundingMode.HALF_UP)), currency);
    }

    private static Currency getCurrency(String currencyCode) {
        Result<Currency, String> result = Try.of(() -> Currency.getInstance(currencyCode),
                "currencyCode not found");
        if (result.isSuccess())
            return result.getSuccess();
        throw new CoinException(result.getFailure());
    }

    public String getCurrencyCode() {
        return currency.getCurrencyCode();
    }
}
