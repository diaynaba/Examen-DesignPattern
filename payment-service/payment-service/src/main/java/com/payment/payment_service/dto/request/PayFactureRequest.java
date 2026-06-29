package com.badwallet.badwallet_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayFactureRequest {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String serviceName;

    private List<String> factureReferences;

}