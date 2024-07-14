package coding.dojo.exchangerate;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class ExchangeRateService implements ExchangeRateUseCase {

    @Inject
    @RestClient
    private final ExchangeRateWebClient webClient;

    @ConfigProperty(name = "exhange-api.authKey", defaultValue = "")
    String apiKey;

    @Override
    @CacheResult(cacheName = "exchange-rates")
    public ExchangeRate getRateForUSD() {
        return webClient.getRatesForUSD(apiKey);
    }

}
