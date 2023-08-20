package microservice.schedule.api.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacientRequest {

    @NotBlank(message = "Pacient firstname is required")
    private String firstName;

    @NotBlank(message = "Pacient lastname is required")
    private String lastName;

    @NotBlank(message = "Pacient cpf is required")
    private String cpf;

    private String email;
}
