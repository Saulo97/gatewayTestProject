package com.saulo.gateways.validations;

public class DeviceNotFoundException extends Exception {
    public DeviceNotFoundException(String message){
        super(message);
    }
}
