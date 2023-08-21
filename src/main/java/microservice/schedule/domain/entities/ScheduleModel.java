package microservice.schedule.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TB_SCHEDULE")
public class ScheduleModel {

    @Id
    @Column(name = "ID_SCHEDULE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSchedule;

    @Column(name = "DS_DESCRIPTION")
    private String description;

    @Column(name = "DT_SCHEDULING")
    private LocalDateTime dateScheduling;

    @Column(name = "DT_SCHEDULE_CREATED")
    private LocalDateTime dateScheduleCreated;

    @ManyToOne
    @Column(name = "ID_PACIENT")
    private PacientModel pacient;
}