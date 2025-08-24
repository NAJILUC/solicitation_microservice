package co.com.pragma.r2dbc.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "status")
@Getter
@Setter
public class StatusEntity {
    @Id
    @Column
    private Long id;

    private String name;
    private String description;
}
