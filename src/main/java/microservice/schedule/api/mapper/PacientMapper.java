package microservice.schedule.api.mapper;

import microservice.schedule.api.dtos.request.PacientRequest;
import microservice.schedule.api.dtos.response.PacientResponse;
import microservice.schedule.domain.entities.PacientModel;

import java.util.ArrayList;
import java.util.List;

public class PacientMapper {
    public static PacientModel toPacientModel(PacientRequest request){
        PacientModel pacient = new PacientModel();
        pacient.setIdPacient(request.getIdPacient());
        pacient.setFirstName(request.getFirstName());
        pacient.setLastName(request.getLastName());
        pacient.setEmail(request.getEmail());
        pacient.setCpf(request.getCpf());
        return pacient;
    }

    public static PacientResponse toPacientResponse(PacientModel pacient){
        PacientResponse response = new PacientResponse();
        response.setIdPacient(pacient.getIdPacient());
        response.setFirstName(pacient.getFirstName());
        response.setLastName(pacient.getLastName());
        response.setEmail(pacient.getEmail());
        response.setCpf(pacient.getCpf());
        return response;
    }

    public static List<PacientResponse> toPacientResponseList(List<PacientModel> pacientList){
        List<PacientResponse> responses = new ArrayList<>();
        for (PacientModel pacient : pacientList){
            responses.add(toPacientResponse(pacient));
        }
        return responses;
    }
}
