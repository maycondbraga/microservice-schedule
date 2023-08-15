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
    private Long IdSchedule;

    @Column(name = "DS_DESCRIPTION")
    private String Description;

    @Column(name = "DT_SCHEDULING")
    private LocalDateTime DateScheduling;

    @Column(name = "DT_SCHEDULE_CREATED")
    private LocalDateTime DateScheduleCreated;

    @ManyToOne
    private PacientModel Pacient;
}