package com.example.postcodeapi.model;

public record ResponseError(
        int code,
        String message
) {
}
