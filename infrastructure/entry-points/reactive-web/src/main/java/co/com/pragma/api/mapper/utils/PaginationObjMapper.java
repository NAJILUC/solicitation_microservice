package co.com.pragma.api.mapper.utils;


import co.com.pragma.model.utils.PaginationObj;

public class PaginationObjMapper {

    public static PaginationObj toObj(int page, int size, String column, String order) {
        if (page < 0) page = 0;
        if(size < 0) size = 0;
        order = order.equalsIgnoreCase("ASC") ? "ASC" : "DESC";

        return PaginationObj.builder()
                .page(page)
                .size(size)
                .column(column)
                .order(order)
                .build();
    }
}
