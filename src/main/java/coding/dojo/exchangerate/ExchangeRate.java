package coding.dojo.exchangerate;

import java.math.BigDecimal;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record ExchangeRate(String base, Map<String, BigDecimal> rates) {

    @JsonIgnore
    public BigDecimal getRate(String currency) {
        return rates.get(currency);
    }
}
