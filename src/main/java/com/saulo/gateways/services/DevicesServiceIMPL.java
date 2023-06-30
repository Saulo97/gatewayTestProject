package com.saulo.gateways.services;

import com.saulo.gateways.custom_exceptions.GatewayNotFoundException;
import com.saulo.gateways.dto.DeviceDTO;
import com.saulo.gateways.models.Device;
import com.saulo.gateways.models.Gateway;
import com.saulo.gateways.repositories.DevicesRepository;
import com.saulo.gateways.custom_exceptions.DeviceNotFoundException;
import com.saulo.gateways.repositories.GatewaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DevicesServiceIMPL implements DevicesService{
    @Autowired
    DevicesRepository devicesRepository;
    @Autowired
    GatewaysRepository gatewaysRepository;
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
    public DeviceDTO createDevice(Device device, Long id) throws GatewayNotFoundException {
        Gateway gatewayTarget = gatewaysRepository.findById(id).orElseThrow(()-> new GatewayNotFoundException("The selected gateway does not exist"));
        if(gatewayTarget.getDevices().size()>=10){
            throw new GatewayNotFoundException("The selected gateway already has the maximum number of allowed devices");
        }else{
            device.setGateway(gatewayTarget);
            device.setCreatedDate(new Date(System.currentTimeMillis()));
            Device newDevice = devicesRepository.save(device);
            gatewaysRepository.save(gatewayTarget);
            return newDevice.mapToDTO();
        }
    }

    @Override
    public DeviceDTO deleteDeviceById(Long id) throws DeviceNotFoundException {
        Device targetDevice = devicesRepository.findById(id).orElseThrow(()-> new DeviceNotFoundException("Device Not Found"));
        devicesRepository.deleteById(id);
        return targetDevice.mapToDTO();
    }

    @Override
    public List<DeviceDTO> getDevicesByGatewayId(Long id) {
        List<Device> deviceList = devicesRepository.findDevicesByGatewayId(id);
        return deviceList.stream().map(device -> device.mapToDTO()).toList();
    }
}
