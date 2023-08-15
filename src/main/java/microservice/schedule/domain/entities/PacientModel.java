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

    public Long getIdPacient() {
        return IdPacient;
    }

    public void setIdPacient(Long idPacient) {
        IdPacient = idPacient;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
