package com.saulo.gateways.controllers;

import com.saulo.gateways.models.Device;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Gateways")
public class GatewaysController {
    @PostMapping
    @RequestMapping(value = "/getAllGateways", method = RequestMethod.POST)
    public ResponseEntity<Device> devolverGateways(@Valid @RequestBody Device devices){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(devices);
    }
}
