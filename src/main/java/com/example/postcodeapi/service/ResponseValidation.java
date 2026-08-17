package com.example.postcodeapi.service;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseValidation {

    public static boolean isResponseValid (ResponseEntity<String> pcResponse) {

        int status = pcResponse.getStatusCode().value();

        if (status == 200) {
            return true;
        }
        return false;
    }

}
