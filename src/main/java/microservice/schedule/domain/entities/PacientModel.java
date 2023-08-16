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
    private Long IdPacient;

    @Column(name = "DS_FIRST_NAME")
    private String FirstName;

    @Column(name = "DS_LAST_NAME")
    private String LastName;

    @Column(name = "DS_CPF")
    private String Cpf;

    @Column(name = "DS_EMAIL")
    private String Email;
}
