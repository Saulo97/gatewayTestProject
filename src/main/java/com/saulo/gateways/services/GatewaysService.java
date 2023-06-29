package com.saulo.gateways.services;

import com.saulo.gateways.custom_exceptions.GatewayNotFoundException;
import com.saulo.gateways.dto.GatewayDTO;
import com.saulo.gateways.models.Gateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GatewaysService {
    public List<GatewayDTO> getAllGateways();
    public GatewayDTO getGatewayById(Long id) throws GatewayNotFoundException;
    public GatewayDTO createGateway(Gateway gateway);
    public GatewayDTO deleteGatewayById(Long id) throws GatewayNotFoundException;
    //public GatewayDTO getGatewayByDeviceId(Long id);
}
