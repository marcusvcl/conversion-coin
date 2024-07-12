package coding.dojo.error;

import java.util.List;
import java.util.UUID;

public record ErrorResponse(String errorId, List<ErrorMessage> errors) {
    public ErrorResponse(String errorId, ErrorMessage error) {
        this(errorId, List.of(error));
    }

    public ErrorResponse(ErrorMessage error) {
        this(UUID.randomUUID().toString(), List.of(error));
    }

    public void addErrorMessage(ErrorMessage error) {
        this.errors.add(error);
    }
}
