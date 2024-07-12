package coding.dojo.commons;

import java.util.function.Supplier;

public class Try {

    public static <S, F> Result<S, F> of(Supplier<S> success, F failure) {
        try {
            return Result.success(success.get());
        } catch (Exception e) {
            return Result.failure(failure);
        }
    }

}
