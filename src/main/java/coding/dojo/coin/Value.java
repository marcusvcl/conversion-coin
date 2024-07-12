package coding.dojo.coin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public record Value(BigDecimal amount) {

    public Value {
        Objects.requireNonNull(amount);
        validateValue(amount);
    }

    private void validateValue(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0)
            throw new CoinException("Value must be greater than zero");
    }

    public static Value of(BigDecimal amount) {
        return new Value(amount);
    }

    public BigDecimal amount() {
        return this.amount.setScale(2, RoundingMode.HALF_UP);
    }
}
