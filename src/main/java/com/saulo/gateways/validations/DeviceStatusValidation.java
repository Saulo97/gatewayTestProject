package com.saulo.gateways.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DeviceStatusValidator.class)
public @interface DeviceStatusValidation {
    public String message() default "El elemento status debe ser uno de los siguientes valores: ONLINE, OFFLINE";

    Class<?> [] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

