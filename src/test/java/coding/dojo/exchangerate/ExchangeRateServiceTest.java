package coding.dojo.exchangerate;

import static org.mockito.ArgumentMatchers.any;

import java.math.BigDecimal;
import java.util.Map;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class ExchangeRateServiceTest {

    @Inject
    ExchangeRateService service;

    @InjectMock
    @RestClient
    ExchangeRateWebClient webClient;

    @Test
    void shouldGetRatesFromWebClient() {
        Mockito.when(webClient.getRatesForUSD(any()))
                .thenReturn(new ExchangeRate("USD", Map.of("BRL", BigDecimal.ONE)));
        ExchangeRate exchangeRate = service.getRateForUSD();
        assert exchangeRate.base().equals("USD");
        assert exchangeRate.rates().get("BRL").equals(BigDecimal.ONE);
    }
}
