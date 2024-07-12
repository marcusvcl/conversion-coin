package coding.dojo.coin;

import coding.dojo.error.ErrorMessage;
import coding.dojo.error.ErrorResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class CoinErrorMapper implements ExceptionMapper<CoinException> {

    @Override
    public Response toResponse(CoinException exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(errorMessage);
        log.error("errorId[{}]", errorResponse.errorId());
        return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
    }
}