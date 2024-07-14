package coding.dojo.exchangerate;

import static org.mockito.ArgumentMatchers.any;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExchangeRateServiceTest {

    @Mock
    ExchangeRateWebClient webClient;

    @BeforeEach
    public void setup() {
        Mockito.when(webClient.getRatesForUSD(any()))
                .thenReturn(new ExchangeRate("USD", Map.of("BRL", BigDecimal.ONE)));
    }

    @Test
    void shouldGetRatesFromWebClient() {
        ExchangeRateService service = new ExchangeRateService(this.webClient);
        ExchangeRate exchangeRate = service.getRateForUSD();
        assert exchangeRate.base().equals("USD");
        assert exchangeRate.rates().get("BRL").equals(BigDecimal.ONE);
    }
}
