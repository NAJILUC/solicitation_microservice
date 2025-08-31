package co.com.pragma.api.mapper.solicitations;

import co.com.pragma.api.dto.response.solicitations.CreditTypeResponse;
import co.com.pragma.model.credittype.CreditType;

public class CreditTypeMapper {

    public static CreditTypeResponse toResponse(CreditType creditType) {
        return CreditTypeResponse.builder()
                .id(creditType.getId())
                .name(creditType.getName())
                .minAmount(creditType.getMinAmount())
                .maxAmount(creditType.getMaxAmount())
                .interestRate(creditType.getInterestRate())
                .automaticValidation(creditType.getAutomaticValidation())
                .build();
    }
}