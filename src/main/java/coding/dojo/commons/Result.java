package coding.dojo.commons;

public class Result<S, F> {

    private final S success;
    private final F failure;

    private Result(S success, F failure) {
        this.success = success;
        this.failure = failure;
    }

    public static <S, F> Result<S, F> success(S success) {
        return new Result<>(success, null);
    }

    public static <S, F> Result<S, F> failure(F failure) {
        return new Result<>(null, failure);
    }

    public boolean isSuccess() {
        return success != null;
    }

    public boolean isFailure() {
        return failure != null;
    }

    public S success() {
        return this.success;
    }

    public F failure() {
        return this.failure;
    }
}
