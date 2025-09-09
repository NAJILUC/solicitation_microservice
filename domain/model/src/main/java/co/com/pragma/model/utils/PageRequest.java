package co.com.pragma.model.utils;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class PageRequest {
    private final int page;
    private final int size;
    private final String sortColumn;
    private final String sortOrder;
}
