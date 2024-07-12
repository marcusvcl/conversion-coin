package coding.dojo.exchange;

import coding.dojo.coin.Coin;

public record ExchangeResponse(Coin baseCoin, Coin targetCoin) {
    public static ExchangeResponse from(Exchange exchange) {
        return new ExchangeResponse(exchange.baseCoin(), exchange.targetCoin());
    }
}
