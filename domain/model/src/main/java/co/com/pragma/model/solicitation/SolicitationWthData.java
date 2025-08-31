package co.com.pragma.model.solicitation;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SolicitationWthData {

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
