package microservice.schedule.api.controller;

import lombok.RequiredArgsConstructor;
import microservice.schedule.domain.entities.PacientModel;
import microservice.schedule.domain.service.PacientService;
import microservice.schedule.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pacient")
public class PacientController {

    private final PacientService _pacientService;

    @PostMapping
    public ResponseEntity<PacientModel> save(@RequestBody PacientModel pacient) throws BusinessException {
        PacientModel pacientSaved = _pacientService.save(pacient);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacientSaved);
    }

    @GetMapping
    public ResponseEntity<List<PacientModel>> getAll(){
        List<PacientModel> allPacients = _pacientService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(allPacients);
    }
}
