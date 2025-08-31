package co.com.pragma.usecase.errorcodes;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {


    //    Credit Type
    C01CRTY01("Credit type was not found", ErrorEnum.NOT_FOUND_EXCEPTION.getValue(), "Id"),

    //    Status
    C01STAT01("Status type was not found", ErrorEnum.NOT_FOUND_EXCEPTION.getValue(), "Id"),

    ;

    private final String code;

    private final String message;
    private final String description;
    private final String field;

    ErrorCodeEnum(String message, String description,  String field) {
        this.code = this.name();
        this.message = message;
        this.description = description;
        this.field = field;
    }
}
