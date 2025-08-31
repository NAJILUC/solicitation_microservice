package co.com.pragma.usecase.enums.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    CREATED(1L, "created", "Creada"),
    PENDING(2L, "pending", "Pendiente de revision");

    private final Long id;
    private final String name;
    private final String description;

}