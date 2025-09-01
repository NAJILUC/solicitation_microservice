package co.com.pragma.model.solicitation;

import co.com.pragma.model.credittype.CreditType;
import co.com.pragma.model.status.Status;
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

    public SolicitationWthData(Solicitation solicitation, Status status, CreditType creditType) {
        this.id = solicitation.getId();
        this.amount = solicitation.getAmount();
        this.term = solicitation.getTerm();
        this.email = solicitation.getEmail();
        this.statusName = status.getDescription();
        this.statusId = status.getId();
        this.creditTypeName = creditType.getName();
        this.creditTypeId = creditType.getId();
        this.applicantDocument = solicitation.getApplicantDocument();
    }

    public SolicitationWthData(Solicitation solicitation, String statusName, String creditTypeName) {
        this.id = solicitation.getId();
        this.amount = solicitation.getAmount();
        this.term = solicitation.getTerm();
        this.email = solicitation.getEmail();
        this.statusName = statusName;
        this.statusId = solicitation.getStatusId();
        this.creditTypeName = creditTypeName;
        this.creditTypeId = solicitation.getCreditTypeId();
        this.applicantDocument = solicitation.getApplicantDocument();
    }
}
