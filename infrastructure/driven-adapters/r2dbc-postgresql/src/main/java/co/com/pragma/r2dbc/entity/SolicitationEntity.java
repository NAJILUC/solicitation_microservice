package co.com.pragma.r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "solicitations")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolicitationEntity {
    @Id
    @Column
    private Long id;

    private Double amount;
    private Integer term;
    private String email;
    private String applicantDocument;

    private Long creditTypeId;
    private Long statusId;
}
