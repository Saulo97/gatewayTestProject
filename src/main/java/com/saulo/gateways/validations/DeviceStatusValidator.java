package com.saulo.gateways.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class DeviceStatusValidator implements ConstraintValidator<DeviceStatusValidation, String > {
    @Override
    public boolean isValid(String  deviceStatus, ConstraintValidatorContext constraintValidatorContext) {
        List<String > devicesStatusList = Arrays.asList("ONLINE", "OFFLINE");
        return devicesStatusList.contains(deviceStatus);
    }
}
