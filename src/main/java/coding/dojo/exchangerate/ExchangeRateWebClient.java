package coding.dojo.exchangerate;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/latest.json")
@RegisterRestClient(configKey = "exchange-api")
public interface ExchangeRateWebClient {
    @GET
    ExchangeRate getRatesForUSD(@QueryParam("app_id") String authKey);
}
