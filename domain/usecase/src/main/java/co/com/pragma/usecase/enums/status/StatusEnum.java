package co.com.pragma.usecase.enums.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {
    CREATED(1L, "created", "Creada"),
    PENDING(2L, "pending", "Pendiente de revision"),
    REJECTED(3L, "rejected", "Rechazadas"),
    MANUAL_REVISION(4L, "manual revision", "Revision manual");

    private final Long id;
    private final String name;
    private final String description;


    public static String getDescriptionById(Long id) {
        for (StatusEnum status : values()) {
            if (status.getId().equals(id)) {
                return status.getDescription();
            }
        }
        return null;
    }
}