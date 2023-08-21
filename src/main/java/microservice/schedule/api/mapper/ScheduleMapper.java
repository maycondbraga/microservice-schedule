package microservice.schedule.api.mapper;

import lombok.RequiredArgsConstructor;
import microservice.schedule.api.dtos.request.ScheduleRequest;
import microservice.schedule.api.dtos.response.ScheduleResponse;
import microservice.schedule.domain.entities.ScheduleModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ScheduleMapper {

    private final ModelMapper _mapper;

    public ScheduleModel toSchedule(ScheduleRequest scheduleRequest) {
        return _mapper.map(scheduleRequest, ScheduleModel.class);
    }

    public ScheduleResponse toScheduleResponse(ScheduleModel schedule) {
        return _mapper.map(schedule, ScheduleResponse.class);
    }

    public List<ScheduleResponse> toScheduleResponseList(List<ScheduleModel> scheduleList) {
        return scheduleList.stream()
                .map(this::toScheduleResponse)
                .collect(Collectors.toList());
    }
}
