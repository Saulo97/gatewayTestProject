package com.saulo.gateways.dto;

import lombok.ToString;

import java.util.List;
@ToString
public class GatewayDTO {
    public Long id;
    public String serialNumber;
    public String name;
    public String ipv4;
    public List<DeviceDTO> devices;

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

    public List<DeviceDTO> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceDTO> devices) {
        this.devices = devices;
    }
}
