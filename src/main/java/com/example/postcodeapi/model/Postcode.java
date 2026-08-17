package com.example.postcodeapi.model;

public record Postcode(
        String postcode,
        double latitude,
        double longitude) {
}
