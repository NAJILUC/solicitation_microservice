package co.com.pragma.usecase.objects.solicitations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolicitationFilterObj {

    private Long creditTypeId;
    private Long statusId;

}
