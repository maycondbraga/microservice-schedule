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

        boolean cpfJaCadastrado = false;
        Optional<PacientModel> optPacient = _pacientRepository.findByCpf(pacient.getCpf());

        if(optPacient.isPresent() && !optPacient.get().getIdPacient().equals(pacient.getIdPacient())){
            cpfJaCadastrado = true;
        }

        if(cpfJaCadastrado){
            throw new BusinessException("Cpf already exists");
        }

        return _pacientRepository.save(pacient);
    }

    public PacientModel update(Long idPacient, PacientModel pacient){
        Optional<PacientModel> optPacient = this.getById(idPacient);

        if(optPacient.isEmpty()){
            throw new BusinessException("Pacient not exists");
        }

        pacient.setIdPacient(idPacient);
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
}
