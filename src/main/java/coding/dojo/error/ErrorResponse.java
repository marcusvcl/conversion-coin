package coding.dojo.error;

import java.util.UUID;

public record ErrorResponse(String errorId, ErrorMessage error) {
    public ErrorResponse(ErrorMessage error) {
        this(UUID.randomUUID().toString(), error);
    }
}
