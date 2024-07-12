package coding.dojo.exchangerate;

import java.math.BigDecimal;
import java.util.Map;

public record ExchangeRate(String base, Map<String, BigDecimal> rates) {
}
