package co.com.pragma.api.dto.response.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GenericPagResponse <T>{
    private List<T> content;
    private int page;
    private int size;
    private long totalItems;
    private int totalPages;
}
