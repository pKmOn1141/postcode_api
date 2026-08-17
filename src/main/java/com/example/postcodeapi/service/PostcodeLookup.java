package com.example.postcodeapi.service;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PostcodeLookup {

    @Autowired
    private WebClient webClient;

    public ResponseEntity<String> pcLookup(String postcode) {

        return webClient.get().uri("postcodes/{postcode}", postcode).exchangeToMono(response -> response.toEntity(String.class)).block();
    }
}
