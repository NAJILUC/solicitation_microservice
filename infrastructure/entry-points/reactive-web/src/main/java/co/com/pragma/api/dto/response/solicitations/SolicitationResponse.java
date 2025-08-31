package co.com.pragma.api.dto.response.solicitations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolicitationResponse {

    private Long id;
    private Double amount;
    private Long term;
    private String email;
    private String statusName;
    private Long statusId;
    private String creditTypeName;
    private Long creditTypeId;
    private String applicantDocument;
}
