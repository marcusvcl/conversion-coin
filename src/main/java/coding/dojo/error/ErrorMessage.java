package coding.dojo.error;

import com.fasterxml.jackson.annotation.JsonInclude;

public record ErrorMessage(@JsonInclude(JsonInclude.Include.NON_NULL) String path, String message) {
    public ErrorMessage(String message) {
        this(null, message);
    }
}
