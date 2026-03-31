package com.carbigdata.backend.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<Cpf, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return true;
        }

        String cpf = value.replaceAll("\\D", "");
        if (cpf.length() != 11 || cpf.chars().distinct().count() == 1) {
            return false;
        }

        return isValidDigit(cpf, 9) && isValidDigit(cpf, 10);
    }

    private boolean isValidDigit(String cpf, int digitIndex) {
        int sum = 0;
        int weight = digitIndex + 1;

        for (int i = 0; i < digitIndex; i++) {
            sum += (cpf.charAt(i) - '0') * (weight - i);
        }

        int remainder = sum % 11;
        int expectedDigit = remainder < 2 ? 0 : 11 - remainder;
        int actualDigit = cpf.charAt(digitIndex) - '0';

        return expectedDigit == actualDigit;
    }
}
