package com.saulo.gateways.services;

import com.saulo.gateways.dto.DeviceDTO;
import com.saulo.gateways.models.Device;
import com.saulo.gateways.validations.DeviceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DevicesService {
    public List<DeviceDTO> getAllDevices();
    public DeviceDTO getDeiceById(Long id) throws DeviceNotFoundException;
    public DeviceDTO createDevice(Device device);
    public void deleteDeviceById(Long id);
    public List<DeviceDTO> getDevicesByGatewayId(Long id);
}
