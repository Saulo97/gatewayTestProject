package com.saulo.gateways.services;

import com.saulo.gateways.dto.GatewayDTO;
import com.saulo.gateways.models.Gateway;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GatewaysServiceIMPL implements GatewaysService{
    @Override
    public List<GatewayDTO> getAllGateways() {
        return null;
    }

    @Override
    public GatewayDTO getGatewayById(Long id) {
        return null;
    }

    @Override
    public GatewayDTO createGateway(Gateway gateway) {
        return null;
    }

    @Override
    public GatewayDTO deleteGatewayById(Long id) {
        return null;
    }
}
