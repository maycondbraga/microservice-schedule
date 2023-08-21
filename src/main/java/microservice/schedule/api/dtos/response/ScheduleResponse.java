package microservice.schedule.api.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponse {
    private Long idSchedule;
    private String description;
    private LocalDateTime dateScheduling;
    private PacientResponse pacient;
}
