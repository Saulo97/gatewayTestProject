package com.saulo.gateways.services;

import com.saulo.gateways.dto.DeviceDTO;
import com.saulo.gateways.models.Device;
import com.saulo.gateways.repositories.DevicesRepository;
import com.saulo.gateways.validations.DeviceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevicesServiceIMPL implements DevicesService{
    @Autowired
    DevicesRepository devicesRepository;
    @Override
    public List<DeviceDTO> getAllDevices() {
        List<Device> deviceList = devicesRepository.findAll();
        return deviceList.stream().map(device -> device.mapToDTO()).toList();
    }

    @Override
    public DeviceDTO getDeiceById(Long id) throws DeviceNotFoundException {
        Device device = devicesRepository.findById(id).orElseThrow(()-> new DeviceNotFoundException("Device Not Found"));
        return device.mapToDTO();
    }

    @Override
    public DeviceDTO createDevice(Device device) {
        Device newDevice = devicesRepository.save(device);
        return newDevice.mapToDTO();
    }

    @Override
    public void deleteDeviceById(Long id) {
        devicesRepository.deleteById(id);
        return;
    }

    @Override
    public List<DeviceDTO> getDevicesByGatewayId(Long id) {
        List<Device> deviceList = devicesRepository.findDevicesByGatewayId(id);
        return deviceList.stream().map(device -> device.mapToDTO()).toList();
    }
}
