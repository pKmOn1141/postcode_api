package com.example.postcodeapi.controller;

import com.example.postcodeapi.model.ResponseError;
import com.example.postcodeapi.service.InputValidation;
import com.example.postcodeapi.service.JSONHandling;
import com.example.postcodeapi.service.PostcodeLookup;
import com.example.postcodeapi.service.ResponseHandling;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostcodeController {

    private final PostcodeLookup postcodeLookup;

    public PostcodeController(PostcodeLookup postcodeLookup) {
        this.postcodeLookup = postcodeLookup;
    }

    @GetMapping("/postcodes/{postcode}")
    public ResponseEntity<?> getPostcodeResponse(@PathVariable String postcode) {

        if (!InputValidation.isPostcodeValid(postcode)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseError(400, "Invalid postcode format."));
        }

        ResponseEntity<String> pcResponse = postcodeLookup.pcLookup(postcode);

        return ResponseHandling.isResponseValid(pcResponse, postcode);
    }
}
