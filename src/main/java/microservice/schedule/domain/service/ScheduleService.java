package microservice.schedule.domain.service;

import lombok.RequiredArgsConstructor;
import microservice.schedule.domain.entities.PacientModel;
import microservice.schedule.domain.entities.ScheduleModel;
import microservice.schedule.domain.repository.ScheduleRepository;
import microservice.schedule.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository _scheduleRepository;
    private final PacientService _pacientService;

    public ScheduleModel save(ScheduleModel schedule) throws BusinessException {
        Optional<PacientModel> optPacient = _pacientService.getById(schedule.getPacient().getIdPacient());

        if (optPacient.isEmpty())
            throw new BusinessException("Pacient is invalid");

        Optional<ScheduleModel> optSchedule = _scheduleRepository.findByDateScheduling(schedule.getDateScheduling());

        if (optSchedule.isPresent())
            throw new BusinessException("There is already an appointment for this time");

        schedule.setPacient(optPacient.get());
        schedule.setDateScheduleCreated(LocalDateTime.now());

        return _scheduleRepository.save(schedule);
    }

    public List<ScheduleModel> getAll() {
        return _scheduleRepository.findAll();
    }

    public Optional<ScheduleModel> getById(Long idSchedule) {
        return _scheduleRepository.findById(idSchedule);
    }
}
