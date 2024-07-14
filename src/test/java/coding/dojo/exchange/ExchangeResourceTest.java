package coding.dojo.exchange;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import coding.dojo.exchangerate.ExchangeRate;
import coding.dojo.exchangerate.ExchangeRateUseCase;

@ExtendWith(MockitoExtension.class)
public class ExchangeResourceTest {

    @Mock
    ExchangeRateUseCase exchangeRateUseCase;

    @BeforeEach
    public void setup() {
        Mockito.when(exchangeRateUseCase.getRateForUSD())
                .thenReturn(new ExchangeRate("USD", Map.of("BRL", BigDecimal.ONE)));
    }

    @Test
    void givenAExchangeRequestShouldConvertACoinToAnother() {
        ExchangeRequest request = new ExchangeRequest("USD", BigDecimal.TEN, "BRL");
        ExchangeResource resource = new ExchangeResource(this.exchangeRateUseCase);
        ExchangeResponse response = resource.convert(request);
        assert response.baseCoin().value().amount().compareTo(BigDecimal.TEN) == 0;
        assert response.targetCoin().value().amount().compareTo(BigDecimal.TEN) == 0;
    }
}
