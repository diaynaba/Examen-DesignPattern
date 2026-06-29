package com.badwallet.badwallet_api.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayFacturesRequest {

    private String phoneNumber;

    private String walletCode;

}