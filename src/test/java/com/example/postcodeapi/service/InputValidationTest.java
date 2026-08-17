package com.example.postcodeapi.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {

    @Test
    void TrueForValidPostcodeWithSpace() {
        assertTrue(InputValidation.isPostcodeValid("SW1A 1AA"));
    }

    @Test
    void TrueForValidPostcodeWithoutSpace() {
        assertTrue(InputValidation.isPostcodeValid("SW1A1AA"));
    }

    @Test
    void TrueForValidLowercasePostcode() {
        assertTrue(InputValidation.isPostcodeValid("sw1a 1aa"));
    }

    @Test
    void TrueForValidPostcodeWithLeadingAndTrailingSpace() {
        assertTrue(InputValidation.isPostcodeValid("    SW1A 1AA    "));
    }

    @Test
    void FalseForInvalidPostcode() {
        assertFalse(InputValidation.isPostcodeValid("INVALID"));
    }

    @Test
    void FalseForInvalidPostcodeWithNumbers() {
        assertFalse(InputValidation.isPostcodeValid("12345"));
    }

    @Test
    void FalseForEmptyPostcode() {
        assertFalse(InputValidation.isPostcodeValid(""));
    }
}