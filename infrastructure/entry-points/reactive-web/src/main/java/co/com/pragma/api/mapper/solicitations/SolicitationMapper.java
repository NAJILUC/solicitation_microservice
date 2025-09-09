package co.com.pragma.api.mapper.solicitations;

import co.com.pragma.api.dto.request.solicitations.CreateSolicitationRequest;
import co.com.pragma.api.dto.response.solicitations.SolicitationResponse;
import co.com.pragma.model.solicitation.Solicitation;
import co.com.pragma.model.solicitation.SolicitationWthData;
import co.com.pragma.usecase.objects.solicitations.SolicitationFilterObj;

public class SolicitationMapper {

    public static Solicitation toModel(CreateSolicitationRequest dto) {
        return Solicitation.builder()
                .amount(dto.getAmount())
                .term(dto.getTerm())
                .creditTypeId(dto.getCreditTypeId())
                .applicantDocument(dto.getApplicantDocument())
                .email(dto.getEmail())
                .build();
    }

    public static SolicitationResponse toResponse(SolicitationWthData solicitation) {
        return SolicitationResponse.builder()
                .id(solicitation.getId())
                .amount(solicitation.getAmount())
                .term(solicitation.getTerm())
                .email(solicitation.getEmail())
                .statusName(solicitation.getStatusName())
                .statusId(solicitation.getStatusId())
                .creditTypeName(solicitation.getCreditTypeName())
                .creditTypeId(solicitation.getCreditTypeId())
                .applicantDocument(solicitation.getApplicantDocument())
                .build();
    }

    public static SolicitationFilterObj solicitationFilterObj(Long creditTypeId,Long statusId ){
        return SolicitationFilterObj.builder()
                .creditTypeId(creditTypeId)
                .statusId(statusId)
                .build();
    }
}
