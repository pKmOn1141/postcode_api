package com.example.postcodeapi.controller;

import com.example.postcodeapi.model.Postcode;
import com.example.postcodeapi.service.PostcodeLookup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostcodeController {

    private final PostcodeLookup postcodeLookup;

    public PostcodeController(PostcodeLookup postcodeLookup) {
        this.postcodeLookup = postcodeLookup;
    }

    @GetMapping("/postcode")
    public String getPostcode(@RequestParam(value="postcode", defaultValue="SW1A1AA") String postcode) {
        return postcodeLookup.pcLookup(postcode);
    }

}
