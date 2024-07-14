package coding.dojo.exchange;

import coding.dojo.coin.Coin;
import coding.dojo.exchangerate.ExchangeRate;
import coding.dojo.exchangerate.ExchangeRateUseCase;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@Path("/exchanges")
@RequiredArgsConstructor
public class ExchangeResource {

    private final ExchangeRateUseCase exchangeRate;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ExchangeResponse convert(ExchangeRequest request) {
        ExchangeRate rates = getRates();
        Coin baseCoin = Coin.of(request.amount(), request.baseCurrency());
        Exchange exchange = Exchange.of(baseCoin, request.targetCurrency(), rates);
        return ExchangeResponse.from(exchange);
    }

    private ExchangeRate getRates() {
        return exchangeRate.getRateForUSD();
    }
}
