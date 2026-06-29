package com.badwallet.badwallet_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayFacturesRequest {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String serviceName;

    @NotEmpty
    private List<String> factureReferences;

}