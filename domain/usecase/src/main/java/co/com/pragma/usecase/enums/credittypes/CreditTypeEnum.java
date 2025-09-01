package co.com.pragma.usecase.enums.credittypes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CreditTypeEnum {
    VEHICULAR(1L, "Vehicular"),
    REAL_ESTATE(2L, "Inmobiliario");

    private final Long id;
    private final String name;


    public static String getNameById(Long id) {
        for (CreditTypeEnum status : values()) {
            if (status.getId().equals(id)) {
                return status.getName();
            }
        }
        return null;
    }
}