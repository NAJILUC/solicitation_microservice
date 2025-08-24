package co.com.pragma.model.solicitation;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Solicitation {
    private Long id;
    private Double amount;
    private Integer term;
    private String email;
    private Long statusId;
    private Long creditTypeId;
}
