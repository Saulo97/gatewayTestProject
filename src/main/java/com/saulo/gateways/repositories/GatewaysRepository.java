package com.saulo.gateways.repositories;

import com.saulo.gateways.models.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewaysRepository extends JpaRepository<Gateway, Long>{
}
