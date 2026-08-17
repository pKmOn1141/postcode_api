package com.example.postcodeapi.controller;

import com.example.postcodeapi.model.Postcode;
import com.example.postcodeapi.service.JSONHandling;
import com.example.postcodeapi.service.PostcodeLookup;
import com.example.postcodeapi.service.ResponseValidation;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostcodeController {

    private final PostcodeLookup postcodeLookup;

    public PostcodeController(PostcodeLookup postcodeLookup) {
        this.postcodeLookup = postcodeLookup;
    }

    @GetMapping("/postcodes")
    public String getPostcodeResponse(@RequestParam(value="postcode", defaultValue="SW1A1AA") String postcode) {

        ResponseEntity<String> pcResponse = postcodeLookup.pcLookup(postcode);
        JSONObject response = new JSONObject(pcResponse.getBody());
        boolean status = ResponseValidation.isResponseValid(pcResponse);

        if (status) {
            JSONObject latLong = JSONHandling.jsonParse(response);
            return latLong.toString();
        }
        else {
            return response.toString();
        }
    }

}
