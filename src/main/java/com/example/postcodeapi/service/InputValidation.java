package com.example.postcodeapi.service;

public class InputValidation {

    private static final String postcodeRegex = "^(?:GIR ?0AA|(?:[A-PR-UWYZ][0-9][0-9A-HJKSTUW]?|[A-PR-UWYZ][A-HK-Y][0-9][0-9ABEHMNPRVWXY]?) ?[0-9][ABD-HJLNP-UW-Z]{2})$";

    public static boolean isPostcodeValid(String postcode) {
        postcode = postcode.trim().toUpperCase();
        return postcode.matches(postcodeRegex);
    }

}
