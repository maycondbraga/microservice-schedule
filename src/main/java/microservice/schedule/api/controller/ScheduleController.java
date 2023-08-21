package microservice.schedule.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import microservice.schedule.api.dtos.request.ScheduleRequest;
import microservice.schedule.api.dtos.response.ScheduleResponse;
import microservice.schedule.api.mapper.ScheduleMapper;
import microservice.schedule.domain.entities.ScheduleModel;
import microservice.schedule.domain.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService _scheduleService;
    private final ScheduleMapper _mapper;

    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> getAll() {
        List<ScheduleResponse> scheduleResponseList = _mapper.toScheduleResponseList(_scheduleService.getAll());
        return ResponseEntity.status(HttpStatus.OK).body(scheduleResponseList);
    }

    @GetMapping("/{idSchedule}")
    public ResponseEntity<ScheduleResponse> getById(@PathVariable Long idSchedule) {
        Optional<ScheduleModel> optSchedule = _scheduleService.getById(idSchedule);

        if (optSchedule.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.OK).body(_mapper.toScheduleResponse(optSchedule.get()));
    }

    @PostMapping
    public ResponseEntity<ScheduleResponse> save(@Valid @RequestBody ScheduleRequest schedule) {
        ScheduleModel scheduleSaved = _scheduleService.save(_mapper.toSchedule(schedule));
        return ResponseEntity.status(HttpStatus.CREATED).body(_mapper.toScheduleResponse(scheduleSaved));
    }
}
