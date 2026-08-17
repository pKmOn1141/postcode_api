package com.example.postcodeapi.service;

import com.example.postcodeapi.model.Postcode;
import com.example.postcodeapi.model.ResponseError;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseHandling {

    public static ResponseEntity<?> isResponseValid (ResponseEntity<String> pcResponse, String postcode) {

        int status;

        if (InputValidation.isPostcodeValid(postcode)) {
            status = pcResponse.getStatusCode().value();
        }
        else {
            status = 400;
        }

        switch (status) {
            // Successful
            case 200:
                JSONObject response = new JSONObject(pcResponse.getBody());
                Postcode pcData = JSONHandling.jsonParse(response);
                return ResponseEntity.ok(pcData);
            // Not found
            case 404:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseError(404, "Postcode not found."));
            // Invalid format
            case 400:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseError(400, "Invalid postcode format."));
            default:
                return ResponseEntity.status(status).body(new ResponseError(status, "Error"));
        }
    }

}
