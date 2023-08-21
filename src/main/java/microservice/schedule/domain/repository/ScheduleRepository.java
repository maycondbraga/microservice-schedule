package microservice.schedule.domain.repository;

import microservice.schedule.domain.entities.ScheduleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleModel, Long> {
    Optional<ScheduleModel> findByDateScheduling(LocalDateTime dateScheduling);
}
