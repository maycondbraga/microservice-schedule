package microservice.schedule.domain.service;

import lombok.RequiredArgsConstructor;
import microservice.schedule.domain.entities.PacientModel;
import microservice.schedule.domain.repository.PacientRepository;
import microservice.schedule.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PacientService {

    private final PacientRepository _pacientRepository;

    public PacientModel save(PacientModel pacient) throws BusinessException {
        isValidForSave(pacient);
        return _pacientRepository.save(pacient);
    }

    public PacientModel update(Long idPacient, PacientModel pacient) throws BusinessException {
        pacient.setIdPacient(idPacient);
        isValidForUpdate(pacient);
        return save(pacient);
    }

    public List<PacientModel> getAll(){
        return _pacientRepository.findAll();
    }

    public Optional<PacientModel> getById(Long idPacient){
        return _pacientRepository.findById(idPacient);
    }

    public void delete(Long idPacient){
        _pacientRepository.deleteById(idPacient);
    }

    //region Private Methods
    private void isValidForUpdate(PacientModel pacient){
        Optional<PacientModel> optPacient = this.getById(pacient.getIdPacient());

        if(optPacient.isEmpty())
            throw new BusinessException("Pacient not exists");

        isValidForSave(pacient);
    }

    private void isValidForSave(PacientModel pacient){
        Optional<PacientModel> optValidCpf = _pacientRepository.findByCpf(pacient.getCpf());

        if(optValidCpf.isPresent() && !optValidCpf.get().getIdPacient().equals(pacient.getIdPacient()))
            throw new BusinessException("Cpf already exists");

        Optional<PacientModel> optValidEmail = _pacientRepository.findByEmail(pacient.getEmail());

        if(optValidEmail.isPresent() && !optValidEmail.get().getIdPacient().equals(pacient.getIdPacient()))
            throw new BusinessException("Email already exists");
    }
    //endregion Private Methods
}
