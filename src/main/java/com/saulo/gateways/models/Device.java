package com.saulo.gateways.models;

import com.saulo.gateways.dto.DeviceDTO;
import com.saulo.gateways.validations.DeviceStatusValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@NotBlank(message = "Este campo no debe estar vacio")
    //@NotEmpty(message = "Este campo no debe ser null")
    @NotNull(message = "Este campo no debe ser nulo")
    private Long uid;
    @NotBlank(message = "Este campo no debe estar vacio")
    @NotEmpty(message = "Este campo no debe ser null")
    private String vendor;
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @DeviceStatusValidation
    @NotBlank(message = "Este campo no debe estar vacio")
    @NotEmpty(message = "Este campo no debe ser null")
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gateway_id")
    private Gateway gateway;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getUID() {
        return uid;
    }

    public void setUID(Long uid) {
        this.uid = uid;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String  status) {
        this.status = status;
    }

    public Gateway getGateway() {
        return gateway;
    }

    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }

    public DeviceDTO mapToDTO(){
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setId(this.getId());
        deviceDTO.setUID(this.getUID());
        deviceDTO.setVendor(this.getVendor());
        deviceDTO.setCreatedDate(this.getCreatedDate());
        deviceDTO.setStatus(this.getStatus());
        return deviceDTO;
    }
}
