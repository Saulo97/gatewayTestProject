package com.saulo.gateways.controllers;

import com.saulo.gateways.custom_exceptions.DeviceNotFoundException;
import com.saulo.gateways.custom_exceptions.GatewayNotFoundException;
import com.saulo.gateways.dto.DeviceDTO;
import com.saulo.gateways.models.Device;
import com.saulo.gateways.repositories.DevicesRepository;
import com.saulo.gateways.services.DevicesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Gateways")
public class DeviceController {
    @Autowired
    DevicesService devicesService;

    @GetMapping
    @RequestMapping(value = "/getAllDevices", method = RequestMethod.GET)
    public ResponseEntity<List<DeviceDTO>> getAllDevices(){
        List<DeviceDTO> devicesList = devicesService.getAllDevices();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(devicesList);
    }

    @PostMapping
    @RequestMapping(value = "/addDeviceToGateway/{id}", method = RequestMethod.POST)
    public ResponseEntity<DeviceDTO> addNewDevice(@PathVariable Long id, @Valid @RequestBody Device device) throws GatewayNotFoundException {
        DeviceDTO newDevice = devicesService.createDevice(device, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDevice);
    }

    @GetMapping
    @RequestMapping(value = "/getDevice/{id}", method = RequestMethod.GET)
    public ResponseEntity<DeviceDTO> getDevice(@PathVariable Long id) throws DeviceNotFoundException {
        DeviceDTO foundDevice = devicesService.getDeiceById(id);
        return ResponseEntity.ok(foundDevice);
    }

    @DeleteMapping
    @RequestMapping(value = "/deleteDevice/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DeviceDTO> deleteDeviceByID(@PathVariable Long id) throws DeviceNotFoundException {
        DeviceDTO deletedDevice = devicesService.deleteDeviceById(id);
        return ResponseEntity.ok(deletedDevice);
    }

}
