package com.badwallet.badwallet_api.proxy;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentProxy {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String URL =
            "http://localhost:8081/api/payments/";

    public Object currentFactures(String walletCode){

        return restTemplate.getForObject(
                URL + walletCode + "/current",
                Object.class
        );

    }

}