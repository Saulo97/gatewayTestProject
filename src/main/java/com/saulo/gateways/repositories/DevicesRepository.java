package com.saulo.gateways.repositories;

import com.saulo.gateways.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicesRepository extends JpaRepository<Device, Long> {
}
