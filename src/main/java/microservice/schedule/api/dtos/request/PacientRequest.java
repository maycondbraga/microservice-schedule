package microservice.schedule.api.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacientRequest {
    private String firstName;
    private String lastName;
    private String cpf;
    private String email;
}
