package com.example.postcodeapi.service;

import com.example.postcodeapi.model.Postcode;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class JSONHandling {

    public static Postcode jsonParse (JSONObject pcResponse) {

        JSONObject result = pcResponse.getJSONObject("result");
        Postcode postcodeData = new Postcode(
                result.getString("postcode"),
                result.getDouble("latitude"),
                result.getDouble("longitude")
        );

        return postcodeData;
    }

}
