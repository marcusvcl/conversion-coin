package coding.dojo.commons;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyFormatter {
    public static String format(Currency currency, BigDecimal amount) {
        String currencyCode = currency.getCurrencyCode();
        Locale currencyLocale = CurrencyToLocale.getLocaleFromCurrencyCode(currencyCode);
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currencyLocale);
        currencyFormatter.setCurrency(currency);
        return currencyFormatter.format(amount);
    }
}
