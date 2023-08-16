package microservice.schedule.api.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacientResponse {
    private Long idPacient;
    private String firstName;
    private String lastName;
    private String cpf;
    private String email;
}
