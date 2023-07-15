package com.saulo.gateways.controllers;

import com.saulo.gateways.custom_exceptions.DeviceNotFoundException;
import com.saulo.gateways.custom_exceptions.GatewayNotFoundException;
import com.saulo.gateways.dto.DeviceDTO;
import com.saulo.gateways.dto.GatewayDTO;
import com.saulo.gateways.models.Device;
import com.saulo.gateways.services.DevicesServiceIMPL;
import com.saulo.gateways.services.GatewaysServiceIMPL;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Named
@ViewScoped/*
@RequestScoped*/
public class PrimeGatewayDetailsController implements Serializable{
    private String gatewayId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("gatewayId");
    private static final Logger logger = LoggerFactory.getLogger(PrimeGatewayDetailsController.class);
    private GatewayDTO gatewayDTO;
    private List<DeviceDTO> devices;
    private DeviceDTO selectedDevice;
    private Device newDevice;
    @Autowired
    GatewaysServiceIMPL gatewaysService;
    @Autowired
    DevicesServiceIMPL devicesService;

    @PostConstruct
    public void init() throws GatewayNotFoundException {
        getGatewayDetails();
    }
    public void openNewDevice(){
        newDevice = new Device();
    }
    private void getGatewayDetails() throws GatewayNotFoundException {
        gatewayDTO = gatewaysService.getGatewayById(Long.valueOf(gatewayId));
        devices = gatewayDTO.getDevices();
    }
    public void deleteDevice() throws DeviceNotFoundException, GatewayNotFoundException {
        Long id = selectedDevice.getId();
        devicesService.deleteDeviceById(id);
        getGatewayDetails();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Device Eliminada"));
        PrimeFaces.current().ajax().update("form-devices:messages", "form-devices:dt-devices");
        selectedDevice=null;
    }

    public void addDeviceToGateway(){
        try{
            DeviceDTO result= devicesService.createDevice(newDevice, Long.valueOf(gatewayId));
            devices.add(result);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Device Añadido"));
            PrimeFaces.current().executeScript("PF('addDeviceDialog').hide()");
            PrimeFaces.current().ajax().update("form-devices:messages", "form-devices:dt-devices");
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR",e.getMessage()));
            PrimeFaces.current().ajax().update("form-devices:messages", "form-devices:dt-devices");
        }

    }

}

