package microservice.schedule.api.controller;

import lombok.RequiredArgsConstructor;
import microservice.schedule.api.dtos.request.PacientRequest;
import microservice.schedule.api.dtos.response.PacientResponse;
import microservice.schedule.api.mapper.PacientMapper;
import microservice.schedule.domain.entities.PacientModel;
import microservice.schedule.domain.service.PacientService;
import microservice.schedule.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pacient")
public class PacientController {

    private final PacientService _pacientService;
    private final PacientMapper _mapper;

    @PostMapping
    public ResponseEntity<PacientResponse> save(@RequestBody PacientRequest request) throws BusinessException {
        PacientModel pacientSaved = _pacientService.save(_mapper.toPacientModel(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(_mapper.toPacientResponse(pacientSaved));
    }

    @GetMapping
    public ResponseEntity<List<PacientResponse>> getAll(){
        List<PacientResponse> pacientResponseList = _mapper.toPacientResponseList(_pacientService.getAll());
        return ResponseEntity.status(HttpStatus.OK).body(pacientResponseList);
    }

    @GetMapping("/{idPacient}")
    public ResponseEntity<PacientResponse> getById(@PathVariable Long idPacient){
        Optional<PacientModel> pacient = _pacientService.getById(idPacient);

        if(pacient.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(_mapper.toPacientResponse(pacient.get()));
    }

    @PutMapping("/{idPacient}")
    public ResponseEntity<PacientResponse> update(@PathVariable Long idPacient, @RequestBody PacientRequest request) throws BusinessException {
        PacientModel updatedPacient = _pacientService.update(idPacient, _mapper.toPacientModel(request));
        return ResponseEntity.status(HttpStatus.OK).body(_mapper.toPacientResponse(updatedPacient));
    }

    @DeleteMapping("/{idPacient}")
    public ResponseEntity<PacientModel> delete(@PathVariable Long idPacient){
        _pacientService.delete(idPacient);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
