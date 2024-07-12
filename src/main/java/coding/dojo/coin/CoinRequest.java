package coding.dojo.coin;

import java.math.BigDecimal;

import io.smallrye.common.constraint.NotNull;

public record CoinRequest(@NotNull BigDecimal montant, @NotNull String currencyCode) {
}
