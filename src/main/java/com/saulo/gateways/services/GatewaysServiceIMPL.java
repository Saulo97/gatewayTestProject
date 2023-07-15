package com.saulo.gateways.services;

import com.saulo.gateways.custom_exceptions.GatewayNotFoundException;
import com.saulo.gateways.dto.GatewayDTO;
import com.saulo.gateways.models.Device;
import com.saulo.gateways.models.Gateway;
import com.saulo.gateways.repositories.GatewaysRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GatewaysServiceIMPL implements GatewaysService{
    @Autowired
    GatewaysRepository gatewaysRepository;
    @Override
    public List<GatewayDTO> getAllGateways() {
        List<Gateway> gatewayList = gatewaysRepository.findAll();
        return gatewayList.stream().map(gateway -> gateway.maptoDTO()).toList();
    }
    @Override
    public GatewayDTO getGatewayById(Long id) throws GatewayNotFoundException {
        Gateway gateway = gatewaysRepository.findById(id).orElseThrow(()->new GatewayNotFoundException("Gateway Not Found"));
        return gateway.maptoDTO();
    }
    @Override
    public GatewayDTO createGateway(Gateway gateway) {
        List<Device> emptyList=new ArrayList<Device>();
        gateway.setDevices(emptyList);
        Gateway newGateway = gatewaysRepository.save(gateway);
        return newGateway.maptoDTO();
    }
    @Override
    public GatewayDTO deleteGatewayById(Long id) throws GatewayNotFoundException {
        Gateway targetGateway = gatewaysRepository.findById(id).orElseThrow(()->new GatewayNotFoundException("Gateway Not Found"));
        gatewaysRepository.deleteById(id);
        return targetGateway.maptoDTO();
    }
}
