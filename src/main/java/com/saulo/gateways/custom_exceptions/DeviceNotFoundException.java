package com.saulo.gateways.custom_exceptions;

public class DeviceNotFoundException extends Exception {
    public DeviceNotFoundException(String message){
        super(message);
    }
}
