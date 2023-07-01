package com.saulo.gateways.models;

import com.saulo.gateways.dto.DeviceDTO;
import com.saulo.gateways.dto.GatewayDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gateways")
public class Gateway {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @NotBlank(message = "Serial Number:Este campo no debe estar vacio")
    @NotEmpty(message = "Serial Number:Este campo no debe ser null")
    public String serialNumber;
    @NotBlank(message = "Name:Este campo no debe estar vacio")
    @NotEmpty(message = "Name:Este campo no debe ser null")
    public String name;
    @NotBlank(message = "IP:Este campo no debe estar vacio")
    @NotEmpty(message = "IP:Este campo no debe ser null")
    @Pattern(regexp = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])",message = "IP:El valor proporcionado no es un ipv4")
    public String ipv4;
    @OneToMany(mappedBy = "gateway", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public List<Device> devices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIPv4() {
        return ipv4;
    }

    public void setIPv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public GatewayDTO maptoDTO(){
        GatewayDTO gatewayDTO = new GatewayDTO();
        gatewayDTO.setId(this.getId());
        gatewayDTO.setName(this.getName());
        gatewayDTO.setIPv4(this.getIPv4());
        gatewayDTO.setSerialNumber(this.getSerialNumber());
        List<Device> deviceList = this.getDevices();
        List<DeviceDTO> deviceDTOList = new ArrayList<>();
        deviceList.forEach(device->{
            deviceDTOList.add(device.mapToDTO());
        });
        gatewayDTO.setDevices(deviceDTOList);
        return  gatewayDTO;
    }
}
