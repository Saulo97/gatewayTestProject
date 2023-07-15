package com.saulo.gateways.dto;

import lombok.ToString;

import java.util.Date;
@ToString
public class DeviceDTO {
    public Long id;
    public Long uid;
    public String vendor;
    public Date createdDate;
    public String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setStatus(String status) {
        this.status = status;
    }
}
