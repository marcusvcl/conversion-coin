package coding.dojo.error;

import org.junit.jupiter.api.Test;

public class ErrorResponseTest {

    @Test
    void givenAErrorIdAndErrorMessageShouldCreateAnError() {
        ErrorMessage errorMessage = new ErrorMessage("errorMessage");
        ErrorResponse error = new ErrorResponse("errorId", errorMessage);
        assert error.errorId().equals("errorId");
        assert error.error().equals(errorMessage);
    }

    @Test
    void givenAErrorMessageShouldCreateAnError() {
        ErrorMessage errorMessage = new ErrorMessage("errorMessage");
        ErrorResponse error = new ErrorResponse(errorMessage);
        assert error.error().equals(errorMessage);
    }
}
