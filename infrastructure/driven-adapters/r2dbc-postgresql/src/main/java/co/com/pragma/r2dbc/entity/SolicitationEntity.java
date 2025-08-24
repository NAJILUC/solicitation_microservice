package co.com.pragma.r2dbc.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
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

    private Long creditTypeId;
    private Long statusId;
}
