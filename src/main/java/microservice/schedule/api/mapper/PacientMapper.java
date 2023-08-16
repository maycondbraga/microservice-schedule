package microservice.schedule.api.mapper;

import lombok.RequiredArgsConstructor;
import microservice.schedule.api.dtos.request.PacientRequest;
import microservice.schedule.api.dtos.response.PacientResponse;
import microservice.schedule.domain.entities.PacientModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PacientMapper {

    private final ModelMapper _mapper;

    public PacientModel toPacientModel(PacientRequest request){
        return _mapper.map(request, PacientModel.class);
    }

    public PacientResponse toPacientResponse(PacientModel pacient){
        return _mapper.map(pacient, PacientResponse.class);
    }

    public List<PacientResponse> toPacientResponseList(List<PacientModel> pacientList){
        return pacientList.stream()
                .map(this::toPacientResponse)
                .collect(Collectors.toList());
    }
}
