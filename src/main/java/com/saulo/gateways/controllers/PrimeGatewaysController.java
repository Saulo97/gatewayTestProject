package com.saulo.gateways.controllers;
import com.saulo.gateways.HandlerException;
import com.saulo.gateways.custom_exceptions.GatewayNotFoundException;
import com.saulo.gateways.dto.GatewayDTO;
import com.saulo.gateways.models.Gateway;
import com.saulo.gateways.services.GatewaysService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import lombok.Data;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;


import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Data
@Named
@ViewScoped
public class PrimeGatewaysController implements Serializable {
    private List<GatewayDTO> gatewayList;
    private Gateway selectedGateway;
    private GatewayDTO gatewayDTO;
    private HandlerException exceptiones;
    private static final Logger logger= LoggerFactory.getLogger(PrimeGatewaysController.class);
    @Autowired
    GatewaysService gatewaysService;

    @PostConstruct
    public void init(){
        getAllGateways();
    }

    private void getAllGateways() {
        gatewayList = gatewaysService.getAllGateways();
    }

    public void openNew() {
        selectedGateway = new Gateway();
    }

    public void saveGateway() {
        try{
            gatewaysService.createGateway(selectedGateway);
            getAllGateways();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Gateway Añadido"));
            PrimeFaces.current().executeScript("PF('addGatewayDialog').hide()");
            PrimeFaces.current().ajax().update("form-gateways:messages", "form-gateways:dt-gateways");
        }catch (Exception e){
            logger.info(e.getMessage());
        }


    }

    public void deleteGateway() throws GatewayNotFoundException {
        Long id = gatewayDTO.getId();
        gatewaysService.deleteGatewayById(id);
        getAllGateways();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Gateway Eliminada"));
        PrimeFaces.current().ajax().update("form-gateways:messages", "form-gateways:dt-gateways");
        selectedGateway=null;
    }
}
