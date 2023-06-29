package com.saulo.gateways.custom_exceptions;

public class GatewayNotFoundException extends Exception {
    public GatewayNotFoundException(String message){
        super(message);
    }
}
