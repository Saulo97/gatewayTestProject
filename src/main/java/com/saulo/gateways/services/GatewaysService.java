package com.saulo.gateways.services;

import com.saulo.gateways.dto.GatewayDTO;
import com.saulo.gateways.models.Gateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GatewaysService {
    public List<GatewayDTO> getAllGateways();
    public GatewayDTO getGatewayById(Long id);
    public GatewayDTO createGateway(Gateway gateway);
    public GatewayDTO deleteGatewayById(Long id);
    //public GatewayDTO getGatewayByDeviceId(Long id);
}
