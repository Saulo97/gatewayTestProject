package com.saulo.gateways.repositories;

import com.saulo.gateways.models.Device;
import com.saulo.gateways.models.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevicesRepository extends JpaRepository<Device, Long> {
    List<Device> findDevicesByGatewayId(Long id);
}
