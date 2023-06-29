package com.saulo.gateways.controllers;

import com.saulo.gateways.custom_exceptions.GatewayNotFoundException;
import com.saulo.gateways.dto.GatewayDTO;
import com.saulo.gateways.models.Gateway;
import com.saulo.gateways.services.GatewaysService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Gateways")
public class GatewaysController {
    @Autowired
    GatewaysService gatewaysService;
    @GetMapping
    @RequestMapping(value = "/getAllGateways", method = RequestMethod.GET)
    public ResponseEntity<List<GatewayDTO>> getAllGateways(){
        List<GatewayDTO> gatewaysResultList = gatewaysService.getAllGateways();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(gatewaysResultList);
    }

    @PostMapping
    @RequestMapping(value = "/createGateway", method = RequestMethod.POST)
    public ResponseEntity<GatewayDTO> createGateway(@Valid @RequestBody Gateway gateway){
        GatewayDTO savedGateway = gatewaysService.createGateway(gateway);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(savedGateway);
    }

    @GetMapping
    @RequestMapping(value = "/getGateway/{id}", method = RequestMethod.GET)
    public ResponseEntity<GatewayDTO> getGatewayById(@PathVariable Long id) throws GatewayNotFoundException {
        GatewayDTO foundGateway = gatewaysService.getGatewayById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(foundGateway);
    }

    @DeleteMapping
    @RequestMapping(value = "/deleteGateway/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<GatewayDTO> deleteGatewayById(@PathVariable Long id) throws GatewayNotFoundException {
        GatewayDTO deletedGateway = gatewaysService.deleteGatewayById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(deletedGateway);
    }


}
