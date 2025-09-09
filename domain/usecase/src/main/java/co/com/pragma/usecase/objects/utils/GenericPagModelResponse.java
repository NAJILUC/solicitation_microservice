package co.com.pragma.usecase.objects.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GenericPagModelResponse<T>{
    private List<T> content;
    private int page;
    private int size;
    private long totalItems;
    private int totalPages;

    public GenericPagModelResponse(List<T> content, int page, int size, long totalItems) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalItems = totalItems;
        this.totalPages = (int) Math.ceil((double) totalItems / size);
    }
}
