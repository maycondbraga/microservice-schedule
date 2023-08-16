package microservice.schedule.domain.repository;

import microservice.schedule.domain.entities.PacientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacientRepository extends JpaRepository<PacientModel, Long> {

    Optional<PacientModel> findByCpf(String cpf);

    Optional<PacientModel> findByEmail(String email);
}
