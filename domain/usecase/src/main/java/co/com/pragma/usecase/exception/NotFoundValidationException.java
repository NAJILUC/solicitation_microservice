package co.com.pragma.usecase.exception;

import co.com.pragma.usecase.errorcodes.ErrorCodeEnum;
import co.com.pragma.usecase.utils.FieldValidationError;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotFoundValidationException extends RuntimeException {
    private final List<FieldValidationError> errors;

    public NotFoundValidationException(List<ErrorCodeEnum> errors) {
        super("Validation failed");
        this.errors = errors.stream()
                .map(FieldValidationError::new)
                .toList();
    }

}
