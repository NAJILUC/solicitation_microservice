package co.com.pragma.api.dto.request.solicitations;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateSolicitationRequest {

    @NotNull
    @DecimalMin(value = "1", message = "Amount must be greater or equal to 1")
    private Double amount;
    @NotNull
    private Long term;
    @NotNull
    private Long creditTypeId;
    @NotBlank
    @Pattern(regexp = "^[0-9]+$")
    private String applicantDocument;
    @Email
    private String email;
}
