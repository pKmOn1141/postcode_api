package com.example.postcodeapi.service;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PostcodeLookup {

    @Autowired
    private WebClient webClient;

    public JSONObject pcLookup(String postcode) {

        String response = webClient.get().uri("postcodes/{postcode}", postcode).retrieve().bodyToMono(String.class).block();

        return new JSONObject(response);
    }
}
