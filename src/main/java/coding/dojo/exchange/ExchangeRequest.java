package coding.dojo.exchange;

import java.math.BigDecimal;

public record ExchangeRequest(String baseCurrency, BigDecimal amount, String targetCurrency) {

}
