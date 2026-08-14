package com.example.postcodeapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PostcodeLookup {

    @Autowired
    private WebClient webClient;

    public String pcLookup(String postcode) {
        return webClient.get().uri("/postcodes/{postcode}", postcode).retrieve().bodyToMono(String.class).block();
    }
}
