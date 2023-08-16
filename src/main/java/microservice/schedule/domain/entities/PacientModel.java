package microservice.schedule.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_PACIENT")
public class PacientModel {

    @Id
    @Column(name = "ID_PACIENT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPacient;

    @Column(name = "DS_FIRST_NAME")
    private String firstName;

    @Column(name = "DS_LAST_NAME")
    private String lastName;

    @Column(name = "DS_CPF")
    private String cpf;

    @Column(name = "DS_EMAIL")
    private String email;
}
