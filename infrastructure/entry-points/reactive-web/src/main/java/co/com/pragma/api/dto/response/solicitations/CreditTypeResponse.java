package co.com.pragma.api.dto.response.solicitations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditTypeResponse {

    private Long id;
    private String name;
    private Double minAmount;
    private Double maxAmount;
    private Double interestRate;
    private Boolean automaticValidation;
}
