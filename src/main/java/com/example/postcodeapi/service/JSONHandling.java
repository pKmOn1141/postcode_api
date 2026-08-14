package com.example.postcodeapi.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class JSONHandling {

    public static JSONObject jsonParse (JSONObject pcResponse) {

        JSONObject result = pcResponse.getJSONObject("result");
        JSONObject latLong = new JSONObject();

        latLong.put("lat", result.getDouble("latitude"));
        latLong.put("long", result.getDouble("longitude"));

        return latLong;
    }

}
