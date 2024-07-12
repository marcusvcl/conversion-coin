package coding.dojo.commons;

import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CurrencyToLocale {
    private static final Map<String, Locale> localeMap = new HashMap<>();

    static {
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                Currency currency = Currency.getInstance(locale);
                if (currency != null)
                    localeMap.put(currency.getCurrencyCode(), locale);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
    }

    public static Locale getLocaleFromCurrencyCode(String currencyCode) {
        return localeMap.get(currencyCode);
    }
}
